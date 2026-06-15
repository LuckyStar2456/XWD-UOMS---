// src/pages/DeptManage.jsx
import { useState, useEffect } from 'react';
import { Card, Table, Button, Modal, Form, Input, Space, message, Spin, Popconfirm, Tabs, Descriptions } from 'antd';
import { PlusOutlined, EditOutlined, DeleteOutlined, MessageOutlined, SendOutlined } from '@ant-design/icons';
import { useSelector } from 'react-redux';
import { getDeptInfo, updateDept, deleteDept } from '../api/dept';
import { addUser, updateUser, deleteUser, moveUser } from '../api/user';
import { listDeptUser, listDeptEquip } from '../api/dept';
import { addEquip, updateEquip, deleteEquip, borrowEquip } from '../api/equip';
import { addApply } from '../api/apply';
import { addFeedback } from '../api/feedback';
import { addTask } from '../api/task';
import { getRoleName } from '../utils/roleMap';

export default function DeptManage() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [dept, setDept] = useState(null);
    const [memberList, setMemberList] = useState([]);
    const [equipList, setEquipList] = useState([]);
    const [loading, setLoading] = useState(false);
    const [memberModalVisible, setMemberModalVisible] = useState(false);
    const [editingMember, setEditingMember] = useState(null);
    const [equipModalVisible, setEquipModalVisible] = useState(false);
    const [editingEquip, setEditingEquip] = useState(null);
    const [borrowModalVisible, setBorrowModalVisible] = useState(false);
    const [selectedEquip, setSelectedEquip] = useState(null);
    const [taskModalVisible, setTaskModalVisible] = useState(false);
    const [feedbackModalVisible, setFeedbackModalVisible] = useState(false);
    const [activeTab, setActiveTab] = useState('info');

    const isDeptLeader = userInfo?.roleId === 3 || userInfo?.roleId === 1; // 部门部长或超级管理员

    useEffect(() => {
        if (userInfo?.deptId) {
            loadDeptData();
        }
    }, [userInfo]);

    const loadDeptData = async () => {
        setLoading(true);
        try {
            const deptRes = await getDeptInfo(userInfo.deptId);
            setDept(deptRes.data.data);
            const memberRes = await listDeptUser(userInfo.deptId, 1, 100);
            setMemberList(memberRes.data.data?.content || []);
            const equipRes = await listDeptEquip(userInfo.deptId, 1, 100);
            setEquipList(equipRes.data.data?.content || []);
        } catch (error) {
            message.error('加载部门数据失败');
        } finally {
            setLoading(false);
        }
    };

    const handleUpdateDept = async (values) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'dept',
                applyDesc: '申请修改部门信息',
                applyContent: { id: dept.id, ...values },
                approverUserId: 3, // 组织主席ID
            });
            message.info('已提交申请');
            return;
        }
        await updateDept({ ...dept, ...values });
        message.success('部门信息更新成功');
        loadDeptData();
    };

    const handleAddMember = async (values) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'add',
                targetObject: 'user',
                applyDesc: '申请添加部员',
                applyContent: { ...values, orgId: userInfo.orgId, deptId: userInfo.deptId, roleId: 2 },
                approverUserId: 2, // 部门部长ID，示例硬编码
            });
            message.info('已提交申请');
            return;
        }
        await addUser({ ...values, orgId: userInfo.orgId, deptId: userInfo.deptId, roleId: 2 });
        message.success('部员添加成功');
        loadDeptData();
        setMemberModalVisible(false);
    };

    const handleUpdateMember = async (values) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'user',
                applyDesc: '申请修改部员信息',
                applyContent: { id: editingMember.id, ...values },
                approverUserId: 2,
            });
            message.info('已提交申请');
            return;
        }
        await updateUser({ id: editingMember.id, ...values });
        message.success('部员信息更新成功');
        loadDeptData();
        setMemberModalVisible(false);
    };

    const handleDeleteMember = async (userId) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'deleted',
                targetObject: 'user',
                applyDesc: '申请删除部员',
                applyContent: { id: userId },
                approverUserId: 2,
            });
            message.info('已提交申请');
            return;
        }
        await deleteUser(userId);
        message.success('部员删除成功');
        loadDeptData();
    };

    const handleAddEquip = async (values) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'add',
                targetObject: 'equip',
                applyDesc: '申请添加部门设备',
                applyContent: { ...values, orgId: userInfo.orgId, deptId: userInfo.deptId },
                approverUserId: 2,
            });
            message.info('已提交申请');
            return;
        }
        await addEquip({ ...values, orgId: userInfo.orgId, deptId: userInfo.deptId });
        message.success('设备添加成功');
        loadDeptData();
        setEquipModalVisible(false);
    };

    const handleUpdateEquip = async (values) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'equip',
                applyDesc: '申请修改设备信息',
                applyContent: { id: editingEquip.id, ...values },
                approverUserId: 2,
            });
            message.info('已提交申请');
            return;
        }
        await updateEquip({ ...editingEquip, ...values });
        message.success('设备更新成功');
        loadDeptData();
        setEquipModalVisible(false);
    };

    const handleDeleteEquip = async (equipId) => {
        if (!isDeptLeader) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'deleted',
                targetObject: 'equip',
                applyDesc: '申请删除设备',
                applyContent: { id: equipId },
                approverUserId: 2,
            });
            message.info('已提交申请');
            return;
        }
        await deleteEquip(equipId);
        message.success('设备删除成功');
        loadDeptData();
    };

    const handleBorrowEquip = async (values) => {
        await borrowEquip(selectedEquip.id, values.borrowNum);
        message.success('借取申请已提交');
        setBorrowModalVisible(false);
    };

    const handleSendFeedback = async (values) => {
        await addFeedback({
            feedbackUserId: userInfo.id,
            targetObject: 'dept',
            feedbackContent: values.content,
            handlerUserId: 2, // 部门部长ID
        });
        message.success('反馈已提交');
        setFeedbackModalVisible(false);
    };

    const handlePublishTask = async (values) => {
        await addTask({
            name: values.name,
            taskDesc: values.desc,
            originatorId: userInfo.id,
            mandatoryId: values.targetUserId,
            deadline: values.deadline,
        });
        message.success('任务发布成功');
        setTaskModalVisible(false);
    };

    const memberColumns = [
        { title: '姓名', dataIndex: 'name' },
        { title: '账号', dataIndex: 'username' },
        { title: '角色', dataIndex: 'roleId', render: (val) => getRoleName(val) },
        {
            title: '操作',
            render: (_, record) => (
                <Space>
                    <Button icon={<EditOutlined />} onClick={() => { setEditingMember(record); setMemberModalVisible(true); }}>编辑</Button>
                    <Popconfirm title="确定删除？" onConfirm={() => handleDeleteMember(record.id)}>
                        <Button icon={<DeleteOutlined />} danger>删除</Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    const equipColumns = [
        { title: '设备名称', dataIndex: 'name' },
        { title: '总数', dataIndex: 'totalNum' },
        { title: '可用数', dataIndex: 'availableNum' },
        {
            title: '操作',
            render: (_, record) => (
                <Space>
                    <Button icon={<EditOutlined />} onClick={() => { setEditingEquip(record); setEquipModalVisible(true); }}>编辑</Button>
                    <Button onClick={() => { setSelectedEquip(record); setBorrowModalVisible(true); }}>申请借取</Button>
                    <Popconfirm title="确定删除？" onConfirm={() => handleDeleteEquip(record.id)}>
                        <Button icon={<DeleteOutlined />} danger>删除</Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    const tabItems = [
        {
            key: 'info',
            label: '部门信息',
            children: (
                <div>
                    <Descriptions column={1} bordered>
                        <Descriptions.Item label="部门名称">{dept?.name}</Descriptions.Item>
                        <Descriptions.Item label="描述">{dept?.deptDesc}</Descriptions.Item>
                    </Descriptions>
                    <Button icon={<EditOutlined />} onClick={() => {}}>编辑部门</Button>
                </div>
            ),
        },
        {
            key: 'member',
            label: '部员管理',
            children: (
                <div>
                    <Button icon={<PlusOutlined />} onClick={() => { setEditingMember(null); setMemberModalVisible(true); }}>添加部员</Button>
                    <Table columns={memberColumns} dataSource={memberList} rowKey="id" style={{ marginTop: 16 }} />
                </div>
            ),
        },
        {
            key: 'equip',
            label: '设备管理',
            children: (
                <div>
                    <Button icon={<PlusOutlined />} onClick={() => { setEditingEquip(null); setEquipModalVisible(true); }}>添加设备</Button>
                    <Table columns={equipColumns} dataSource={equipList} rowKey="id" style={{ marginTop: 16 }} />
                </div>
            ),
        },
        {
            key: 'feedback',
            label: '信息反馈',
            children: <Button onClick={() => setFeedbackModalVisible(true)}>向部门部长反馈</Button>,
        },
        {
            key: 'task',
            label: '任务发布',
            children: <Button onClick={() => setTaskModalVisible(true)}>发布任务至部门成员</Button>,
        },
    ];

    if (loading) return <Spin size="large" />;

    return (
        <div>
            <Tabs activeKey={activeTab} onChange={setActiveTab} items={tabItems} />

            {/* 成员模态框 */}
            <Modal title={editingMember ? '编辑部员' : '添加部员'} open={memberModalVisible} onCancel={() => setMemberModalVisible(false)} footer={null}>
                <Form onFinish={editingMember ? handleUpdateMember : handleAddMember} initialValues={editingMember || {}}>
                    <Form.Item name="username" label="账号" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="name" label="姓名" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="phone" label="电话" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="grade" label="年级"><Input /></Form.Item>
                    <Form.Item name="email" label="邮箱"><Input /></Form.Item>
                    <Form.Item><Button type="primary" htmlType="submit">提交</Button></Form.Item>
                </Form>
            </Modal>

            {/* 设备模态框 */}
            <Modal title={editingEquip ? '编辑设备' : '添加设备'} open={equipModalVisible} onCancel={() => setEquipModalVisible(false)} footer={null}>
                <Form onFinish={editingEquip ? handleUpdateEquip : handleAddEquip} initialValues={editingEquip || {}}>
                    <Form.Item name="name" label="设备名称" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="equipmentDesc" label="描述"><Input.TextArea /></Form.Item>
                    <Form.Item name="totalNum" label="总数" rules={[{ required: true }]}><Input type="number" /></Form.Item>
                    <Form.Item name="availableNum" label="可用数" rules={[{ required: true }]}><Input type="number" /></Form.Item>
                    <Form.Item><Button type="primary" htmlType="submit">提交</Button></Form.Item>
                </Form>
            </Modal>

            {/* 借取模态框 */}
            <Modal title="申请借取设备" open={borrowModalVisible} onCancel={() => setBorrowModalVisible(false)} footer={null}>
                <Form onFinish={handleBorrowEquip}>
                    <Form.Item name="borrowNum" label="借取数量" rules={[{ required: true }]}><Input type="number" /></Form.Item>
                    <Form.Item><Button type="primary" htmlType="submit">提交申请</Button></Form.Item>
                </Form>
            </Modal>

            {/* 反馈模态框 */}
            <Modal title="信息反馈" open={feedbackModalVisible} onCancel={() => setFeedbackModalVisible(false)} footer={null}>
                <Form onFinish={handleSendFeedback}>
                    <Form.Item name="content" label="反馈内容" rules={[{ required: true }]}><Input.TextArea rows={4} /></Form.Item>
                    <Form.Item><Button type="primary" htmlType="submit">提交反馈</Button></Form.Item>
                </Form>
            </Modal>

            {/* 任务发布模态框 */}
            <Modal title="发布任务" open={taskModalVisible} onCancel={() => setTaskModalVisible(false)} footer={null}>
                <Form onFinish={handlePublishTask}>
                    <Form.Item name="name" label="任务标题" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="desc" label="任务描述"><Input.TextArea /></Form.Item>
                    <Form.Item name="targetUserId" label="执行人ID" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="deadline" label="截止日期"><Input type="date" /></Form.Item>
                    <Form.Item><Button type="primary" htmlType="submit">发布</Button></Form.Item>
                </Form>
            </Modal>
        </div>
    );
}