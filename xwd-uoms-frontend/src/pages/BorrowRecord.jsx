// src/pages/BorrowRecord.jsx
import { useState, useEffect } from 'react';
import { Table, Button, Space, message, Spin, Tabs, Modal, Form, Input, Select } from 'antd';
import { useSelector } from 'react-redux';
import { getOrgBorrow, getDeptBorrow, getUserBorrow, approveBorrow, updateBorrow } from '../api/borrow';
import { borrowStatusMap } from '../utils/statusMap';

export default function BorrowRecord() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(false);
    const [activeTab, setActiveTab] = useState('org');
    const [approveModalVisible, setApproveModalVisible] = useState(false);
    const [selectedRecord, setSelectedRecord] = useState(null);
    const [form] = Form.useForm();

    useEffect(() => {
        loadRecords();
    }, [activeTab]);

    const loadRecords = async () => {
        setLoading(true);
        try {
            let res;
            if (activeTab === 'org' && userInfo.orgId) {
                res = await getOrgBorrow(userInfo.orgId, 1, 100);
            } else if (activeTab === 'dept' && userInfo.deptId) {
                res = await getDeptBorrow(userInfo.deptId, 1, 100);
            } else {
                res = await getUserBorrow(userInfo.id, 1, 100);
            }
            setData(res.data.data?.content || []);
        } catch (error) {
            message.error('加载记录失败');
        } finally {
            setLoading(false);
        }
    };

    const handleApprove = async (values) => {
        await approveBorrow(userInfo.id, { id: selectedRecord.id, status: values.status, remark: values.remark });
        message.success('审批成功');
        setApproveModalVisible(false);
        loadRecords();
    };

    const handleReturn = async (record) => {
        await approveBorrow(userInfo.id, { id: record.id, status: 3 });
        message.success('归还成功');
        loadRecords();
    };

    const columns = [
        { title: '设备ID', dataIndex: 'equipmentId' },
        { title: '借取数量', dataIndex: 'borrowNum' },
        { title: '借取人', dataIndex: 'borrowerId' },
        { title: '借取时间', dataIndex: 'borrowTime' },
        { title: '状态', dataIndex: 'status', render: (val) => borrowStatusMap[val] },
        {
            title: '操作',
            render: (_, record) => {
                if (record.status === 0 && (userInfo.roleId === 1 || userInfo.roleId === 4 || userInfo.roleId === 3)) {
                    return <Button onClick={() => { setSelectedRecord(record); setApproveModalVisible(true); }}>审批</Button>;
                }
                if (record.status === 2 && record.borrowerId === userInfo.id) {
                    return <Button onClick={() => handleReturn(record)}>归还</Button>;
                }
                return null;
            },
        },
    ];

    const tabItems = [
        { key: 'org', label: '组织借还记录' },
        { key: 'dept', label: '部门借还记录' },
        { key: 'personal', label: '个人借还记录' },
    ];

    return (
        <div>
            <Tabs activeKey={activeTab} onChange={setActiveTab} items={tabItems} />
            <Spin spinning={loading}>
                <Table columns={columns} dataSource={data} rowKey="id" />
            </Spin>
            <Modal title="审批借取申请" open={approveModalVisible} onCancel={() => setApproveModalVisible(false)} footer={null}>
                <Form form={form} onFinish={handleApprove}>
                    <Form.Item name="status" label="审批结果" rules={[{ required: true }]}>
                        <Select options={[{ label: '同意借取', value: 2 }, { label: '拒绝借取', value: 1 }]} />
                    </Form.Item>
                    <Form.Item name="remark" label="备注">
                        <Input.TextArea />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">提交</Button>
                    </Form.Item>
                </Form>
            </Modal>
        </div>
    );
}