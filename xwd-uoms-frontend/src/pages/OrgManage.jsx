import { useState, useEffect } from 'react';
import {
    Card, Descriptions, Button, Table, Modal, Form, Input, Space, message,
    Tabs, Spin, Popconfirm, Row, Col, Select
} from 'antd';
import { PlusOutlined, EditOutlined, DeleteOutlined, MessageOutlined, SendOutlined } from '@ant-design/icons';
import { useSelector } from 'react-redux';
import { getOrgInfo, updateOrg } from '../api/org';
import { addDept, updateDept, deleteDept } from '../api/dept';
import { addUser, updateUser, deleteUser, moveUser, getOrgAdmin } from '../api/user';
import { listOrgDept, listOrgEquip } from '../api/org';
import { listDeptUser } from '../api/dept';
import { listAllUser } from '../api/user';
import { addApply } from '../api/apply';
import { addFeedback } from '../api/feedback';
import { addTask } from '../api/task';
import { addEquip, updateEquip, deleteEquip, borrowEquip } from '../api/equip';
import { getRoleName } from '../utils/roleMap';

export default function OrgManage() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [org, setOrg] = useState(null);
    const [deptList, setDeptList] = useState([]);
    const [memberList, setMemberList] = useState([]);
    const [equipList, setEquipList] = useState([]);
    const [adminList, setAdminList] = useState([]);
    const [loading, setLoading] = useState(false);
    const [adminLoading, setAdminLoading] = useState(false);
    const [deptModalVisible, setDeptModalVisible] = useState(false);
    const [editingDept, setEditingDept] = useState(null);
    const [memberModalVisible, setMemberModalVisible] = useState(false);
    const [editingMember, setEditingMember] = useState(null);
    const [equipModalVisible, setEquipModalVisible] = useState(false);
    const [editingEquip, setEditingEquip] = useState(null);
    const [borrowModalVisible, setBorrowModalVisible] = useState(false);
    const [selectedEquip, setSelectedEquip] = useState(null);
    const [taskModalVisible, setTaskModalVisible] = useState(false);
    const [feedbackModalVisible, setFeedbackModalVisible] = useState(false);
    const [activeTab, setActiveTab] = useState('info');
    const [form] = Form.useForm();
    const [orgEditForm] = Form.useForm();

    const isAdmin = userInfo?.roleId === 1 || userInfo?.roleId === 4; // 超级管理员或组织主席

    useEffect(() => {
        if (userInfo?.orgId) {
            loadOrgData();
        }
    }, [userInfo]);

    const loadOrgData = async () => {
        setLoading(true);
        try {
            const orgRes = await getOrgInfo(userInfo.orgId);
            setOrg(orgRes.data);
            const deptRes = await listOrgDept(userInfo.orgId, 1, 100);
            setDeptList(deptRes.data.content);
            // 获取组织下成员（通过搜索所有用户并过滤）
            const allUsersRes = await listAllUser(1, 1000);
            const members = allUsersRes.data.content.filter(u => u.orgId === userInfo.orgId);
            setMemberList(members);
            const equipRes = await listOrgEquip(userInfo.orgId, 1, 100);
            setEquipList(equipRes.data.content);
            // 加载管理员列表
            await loadOrgAdmin();
        } catch (error) {
            message.error('加载组织数据失败');
        } finally {
            setLoading(false);
        }
    };

    const loadOrgAdmin = async () => {
        if (!org?.id) return;
        setAdminLoading(true);
        try {
            const res = await getOrgAdmin(org.id, 1, 100);
            setAdminList(res.data.content);
        } catch (error) {
            message.error('加载管理员列表失败');
        } finally {
            setAdminLoading(false);
        }
    };

    const handleUpdateOrg = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'org',
                applyDesc: '申请修改组织信息',
                applyContent: { id: org.id, ...values },
                approverUserId: 3,
            });
            message.info('已提交申请，等待审批');
            return;
        }
        await updateOrg({ ...org, ...values });
        message.success('组织信息更新成功');
        loadOrgData();
    };

    const handleAddDept = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'add',
                targetObject: 'dept',
                applyDesc: '申请添加部门',
                applyContent: { ...values, orgId: userInfo.orgId },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await addDept({ ...values, orgId: userInfo.orgId });
        message.success('部门添加成功');
        loadOrgData();
        setDeptModalVisible(false);
    };

    const handleUpdateDept = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'dept',
                applyDesc: '申请修改部门信息',
                applyContent: { id: editingDept.id, ...values },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await updateDept({ ...editingDept, ...values });
        message.success('部门更新成功');
        loadOrgData();
        setDeptModalVisible(false);
    };

    const handleDeleteDept = async (deptId) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'deleted',
                targetObject: 'dept',
                applyDesc: '申请删除部门',
                applyContent: { id: deptId },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await deleteDept(deptId);
        message.success('部门删除成功');
        loadOrgData();
    };

    const handleAddMember = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'add',
                targetObject: 'user',
                applyDesc: '申请添加成员',
                applyContent: { ...values, orgId: userInfo.orgId, roleId: 2 },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await addUser({ ...values, orgId: userInfo.orgId, roleId: 2 });
        message.success('成员添加成功');
        loadOrgData();
        setMemberModalVisible(false);
    };

    const handleUpdateMember = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'user',
                applyDesc: '申请修改成员信息',
                applyContent: { id: editingMember.id, ...values },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await updateUser({ id: editingMember.id, ...values });
        message.success('成员信息更新成功');
        loadOrgData();
        setMemberModalVisible(false);
    };

    const handleDeleteMember = async (userId) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'deleted',
                targetObject: 'user',
                applyDesc: '申请删除成员',
                applyContent: { id: userId },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await deleteUser(userId);
        message.success('成员删除成功');
        loadOrgData();
    };

    const handleMoveMember = async (userId, targetDeptId) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'move',
                targetObject: 'user',
                applyDesc: '申请迁移成员部门',
                applyContent: { id: userId, deptId: targetDeptId },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await moveUser({ id: userId, deptId: targetDeptId });
        message.success('成员迁移成功');
        loadOrgData();
    };

    const handleAddEquip = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'add',
                targetObject: 'equip',
                applyDesc: '申请添加设备',
                applyContent: { ...values, orgId: userInfo.orgId },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await addEquip({ ...values, orgId: userInfo.orgId });
        message.success('设备添加成功');
        loadOrgData();
        setEquipModalVisible(false);
    };

    const handleUpdateEquip = async (values) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'update',
                targetObject: 'equip',
                applyDesc: '申请修改设备信息',
                applyContent: { id: editingEquip.id, ...values },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await updateEquip({ ...editingEquip, ...values });
        message.success('设备更新成功');
        loadOrgData();
        setEquipModalVisible(false);
    };

    const handleDeleteEquip = async (equipId) => {
        if (!isAdmin) {
            await addApply({
                applyUserId: userInfo.id,
                applyOperationCode: 'deleted',
                targetObject: 'equip',
                applyDesc: '申请删除设备',
                applyContent: { id: equipId },
                approverUserId: 3,
            });
            message.info('已提交申请');
            return;
        }
        await deleteEquip(equipId);
        message.success('设备删除成功');
        loadOrgData();
    };

    const handleBorrowEquip = async (values) => {
        await borrowEquip(selectedEquip.id, values.borrowNum);
        message.success('借取申请已提交');
        setBorrowModalVisible(false);
        loadOrgData();
    };

    const handleSendFeedback = async (values) => {
        await addFeedback({
            feedbackUserId: userInfo.id,
            targetObject: 'org',
            feedbackContent: values.content,
            handlerUserId: 3,
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

    const deptColumns = [
        { title: '部门名称', dataIndex: 'name' },
        { title: '描述', dataIndex: 'deptDesc' },
        {
            title: '操作',
            render: (_, record) => (
                <Space>
                    <Button icon={<EditOutlined />} onClick={() => { setEditingDept(record); setDeptModalVisible(true); }}>编辑</Button>
                    <Popconfirm title="确定删除？" onConfirm={() => handleDeleteDept(record.id)}>
                        <Button icon={<DeleteOutlined />} danger>删除</Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    const memberColumns = [
        { title: '姓名', dataIndex: 'name' },
        { title: '账号', dataIndex: 'username' },
        { title: '部门', dataIndex: 'deptName' },
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
        { title: '状态', dataIndex: 'status', render: (val) => val === 1 ? '正常' : '停用' },
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

    const adminColumns = [
        { title: '姓名', dataIndex: 'name' },
        { title: '账号', dataIndex: 'username' },
        { title: '角色', dataIndex: 'roleId', render: (val) => getRoleName(val) },
        { title: '部门', dataIndex: 'deptName' },
    ];

    const tabItems = [
        {
            key: 'info', label: '组织信息', children: (
                <div>
                    <Descriptions column={1} bordered>
                        <Descriptions.Item label="组织名称">{org?.name}</Descriptions.Item>
                        <Descriptions.Item label="类型">{org?.type}</Descriptions.Item>
                        <Descriptions.Item label="描述">{org?.orgDesc}</Descriptions.Item>
                        <Descriptions.Item label="地址">{org?.address}</Descriptions.Item>
                        <Descriptions.Item label="电话">{org?.phone}</Descriptions.Item>
                    </Descriptions>
                    <Button icon={<EditOutlined />} onClick={() => { orgEditForm.setFieldsValue(org); Modal.confirm({ title: '编辑组织', content: <Form form={orgEditForm} onFinish={handleUpdateOrg}><Form.Item name="name" label="名称"><Input /></Form.Item><Form.Item name="orgDesc" label="描述"><Input.TextArea /></Form.Item><Form.Item name="address" label="地址"><Input /></Form.Item><Form.Item name="phone" label="电话"><Input /></Form.Item><Form.Item><Button type="primary" htmlType="submit">保存</Button></Form.Item></Form>, okButtonProps: { style: { display: 'none' } } }); }} style={{ marginTop: 16 }}>编辑组织</Button>

                    <Card title="组织管理员" style={{ marginTop: 16 }}>
                        <Spin spinning={adminLoading}>
                            <Table columns={adminColumns} dataSource={adminList} rowKey="id" pagination={false} locale={{ emptyText: '暂无管理员' }} />
                        </Spin>
                    </Card>
                </div>
            )
        },
        {
            key: 'dept', label: '部门管理', children: (
                <div>
                    <Button icon={<PlusOutlined />} onClick={() => { setEditingDept(null); setDeptModalVisible(true); }} style={{ marginBottom: 16 }}>添加部门</Button>
                    <Table columns={deptColumns} dataSource={deptList} rowKey="id" />
                </div>
            )
        },
        {
            key: 'member', label: '成员管理', children: (
                <div>
                    <Button icon={<PlusOutlined />} onClick={() => { setEditingMember(null); setMemberModalVisible(true); }} style={{ marginBottom: 16 }}>添加成员</Button>
                    <Table columns={memberColumns} dataSource={memberList} rowKey="id" />
                </div>
            )
        },
        {
            key: 'equip', label: '设备管理', children: (
                <div>
                    <Button icon={<PlusOutlined />} onClick={() => { setEditingEquip(null); setEquipModalVisible(true); }} style={{ marginBottom: 16 }}>添加设备</Button>
                    <Table columns={equipColumns} dataSource={equipList} rowKey="id" />
                </div>
            )
        },
        {
            key: 'feedback', label: '信息反馈', children: (
                <Button icon={<MessageOutlined />} onClick={() => setFeedbackModalVisible(true)}>向组织主席反馈</Button>
            )
        },
        {
            key: 'task', label: '任务发布', children: (
                <Button icon={<SendOutlined />} onClick={() => setTaskModalVisible(true)}>发布任务</Button>
            )
        },
    ];

    if (loading) return <Spin size="large" />;

    return (
        <div>
            <Tabs activeKey={activeTab} onChange={setActiveTab} items={tabItems} />

            {/* 部门模态框 */}
            <Modal title={editingDept ? '编辑部门' : '添加部门'} open={deptModalVisible} onCancel={() => setDeptModalVisible(false)} footer={null}>
                <Form onFinish={editingDept ? handleUpdateDept : handleAddDept} initialValues={editingDept || {}}>
                    <Form.Item name="name" label="部门名称" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="deptDesc" label="描述"><Input.TextArea /></Form.Item>
                    <Form.Item><Button type="primary" htmlType="submit">提交</Button></Form.Item>
                </Form>
            </Modal>

            {/* 成员模态框 */}
            <Modal title={editingMember ? '编辑成员' : '添加成员'} open={memberModalVisible} onCancel={() => setMemberModalVisible(false)} footer={null}>
                <Form onFinish={editingMember ? handleUpdateMember : handleAddMember} initialValues={editingMember || {}}>
                    <Form.Item name="username" label="账号" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="name" label="姓名" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="phone" label="电话" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="grade" label="年级"><Input /></Form.Item>
                    <Form.Item name="email" label="邮箱"><Input /></Form.Item>
                    <Form.Item name="deptName" label="部门名称"><Input /></Form.Item>
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
                    <Form.Item name="deptId" label="所属部门ID"><Input /></Form.Item>
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