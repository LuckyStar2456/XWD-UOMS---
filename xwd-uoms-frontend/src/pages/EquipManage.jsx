// src/pages/EquipManage.jsx
import { useState, useEffect } from 'react';
import { Table, Button, Modal, Form, Input, Space, message, Spin, Popconfirm, Tabs } from 'antd';
import { PlusOutlined, EditOutlined, DeleteOutlined } from '@ant-design/icons';
import { useSelector } from 'react-redux';
import { listOrgEquip } from '../api/org';
import { listDeptEquip } from '../api/dept';
import { addEquip, updateEquip, deleteEquip, borrowEquip } from '../api/equip';
import { addApply } from '../api/apply';

export default function EquipManage() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [equipList, setEquipList] = useState([]);
    const [loading, setLoading] = useState(false);
    const [modalVisible, setModalVisible] = useState(false);
    const [editingEquip, setEditingEquip] = useState(null);
    const [borrowModalVisible, setBorrowModalVisible] = useState(false);
    const [selectedEquip, setSelectedEquip] = useState(null);
    const [activeTab, setActiveTab] = useState('org');

    const isAdmin = userInfo?.roleId === 1 || userInfo?.roleId === 4 || userInfo?.roleId === 3;

    useEffect(() => {
        loadEquipList();
    }, [activeTab]);

    const loadEquipList = async () => {
        setLoading(true);
        try {
            let res;
            if (activeTab === 'org' && userInfo.orgId) {
                res = await listOrgEquip(userInfo.orgId, 1, 100);
            } else if (activeTab === 'dept' && userInfo.deptId) {
                res = await listDeptEquip(userInfo.deptId, 1, 100);
            }
            setEquipList(res?.data.content || []);
        } catch (error) {
            message.error('加载设备列表失败');
        } finally {
            setLoading(false);
        }
    };

    const handleAddEquip = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'add',
                targetObject: 'equip',
                applyDesc: '申请添加设备',
                applyContent: { ...values, orgId: userInfo.orgId, deptId: activeTab === 'dept' ? userInfo.deptId : null },
                approverUserId: userInfo.roleId === 2 ? 3 : 2, // 部员找部长，部长找主席
            });
            message.info('已提交申请');
            return;
        }
        await addEquip({ ...values, orgId: userInfo.orgId, deptId: activeTab === 'dept' ? userInfo.deptId : null });
        message.success('设备添加成功');
        loadEquipList();
        setModalVisible(false);
    };

    const handleUpdateEquip = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'equip',
                applyDesc: '申请修改设备信息',
                applyContent: { id: editingEquip.id, ...values },
                approverUserId: userInfo.roleId === 2 ? 3 : 2,
            });
            message.info('已提交申请');
            return;
        }
        await updateEquip({ ...editingEquip, ...values });
        message.success('设备更新成功');
        loadEquipList();
        setModalVisible(false);
    };

    const handleDeleteEquip = async (equipId) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'deleted',
                targetObject: 'equip',
                applyDesc: '申请删除设备',
                applyContent: { id: equipId },
                approverUserId: userInfo.roleId === 2 ? 3 : 2,
            });
            message.info('已提交申请');
            return;
        }
        await deleteEquip(equipId);
        message.success('设备删除成功');
        loadEquipList();
    };

    const handleBorrow = async (values) => {
        await borrowEquip(selectedEquip.id, values.borrowNum);
        message.success('借取申请已提交');
        setBorrowModalVisible(false);
        loadEquipList();
    };

    const columns = [
        { title: '设备名称', dataIndex: 'name' },
        { title: '描述', dataIndex: 'equipmentDesc' },
        { title: '总数', dataIndex: 'totalNum' },
        { title: '可用数', dataIndex: 'availableNum' },
        {
            title: '操作',
            render: (_, record) => (
                <Space>
                    <Button icon={<EditOutlined />} onClick={() => { setEditingEquip(record); setModalVisible(true); }}>编辑</Button>
                    <Button onClick={() => { setSelectedEquip(record); setBorrowModalVisible(true); }}>申请借取</Button>
                    <Popconfirm title="确定删除？" onConfirm={() => handleDeleteEquip(record.id)}>
                        <Button icon={<DeleteOutlined />} danger>删除</Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    return (
        <div>
            <Tabs activeKey={activeTab} onChange={setActiveTab} items={[
                { key: 'org', label: '组织设备' },
                { key: 'dept', label: '部门设备' },
            ]} />
            <Button icon={<PlusOutlined />} onClick={() => { setEditingEquip(null); setModalVisible(true); }} style={{ marginBottom: 16 }}>添加设备</Button>
            <Spin spinning={loading}>
                <Table columns={columns} dataSource={equipList} rowKey="id" />
            </Spin>
            {/* 复用模态框 */}
        </div>
    );
}