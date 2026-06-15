// src/pages/Notice.jsx
import { useState, useEffect, useRef, useCallback } from 'react';
import { Table, Button, Modal, Form, Input, message, Spin, Tabs, Select, Popconfirm, Alert, Space, Progress, TreeSelect } from 'antd';
import { useSelector } from 'react-redux';
import { getReceivedNotice, getPendingNotice, addNotice, updateNotice, deleteNotice } from '../api/notice';
import { listAllUser } from '../api/user';
import { listAllOrg, listOrgDept } from '../api/org';

const getContent = (response) => {
    try {
        const data = response?.data?.data;
        if (data?.content) return data.content;
        if (Array.isArray(data)) return data;
        return [];
    } catch {
        return [];
    }
};

const buildTreeData = (orgs, deptsMap) => {
    return orgs.map(org => ({
        title: org.name,
        value: `org_${org.id}`,
        key: `org_${org.id}`,
        children: (deptsMap[org.id] || []).map(dept => ({
            title: dept.name,
            value: `dept_${dept.id}`,
            key: `dept_${dept.id}`,
        })),
    }));
};

export default function Notice() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [received, setReceived] = useState([]);
    const [sent, setSent] = useState([]);
    const [loading, setLoading] = useState(false);
    const [modalVisible, setModalVisible] = useState(false);
    const [editing, setEditing] = useState(null);
    const [allUsers, setAllUsers] = useState([]);
    const [orgs, setOrgs] = useState([]);
    const [deptsMap, setDeptsMap] = useState({});
    const [activeTab, setActiveTab] = useState('received');
    const [form] = Form.useForm();
    const [isBatch, setIsBatch] = useState(false);
    const [selectedUserIds, setSelectedUserIds] = useState([]);
    const [sending, setSending] = useState(false);
    const [sendProgress, setSendProgress] = useState(0);
    const [treeData, setTreeData] = useState([]);
    const [treeLoading, setTreeLoading] = useState(false);
    const [usersLoading, setUsersLoading] = useState(false);

    const isMounted = useRef(true);
    const loadedRef = useRef(false);

    const canPublish = userInfo?.roleId === 1 || userInfo?.roleId === 4 || userInfo?.roleId === 3;

    const loadData = useCallback(async () => {
        if (!userInfo?.id) return;
        setLoading(true);
        try {
            const [recvRes, sentRes] = await Promise.all([
                getReceivedNotice(userInfo.id, 1, 100),
                getPendingNotice(userInfo.id, 1, 100),
            ]);
            if (isMounted.current) {
                setReceived(getContent(recvRes));
                setSent(getContent(sentRes));
            }
        } catch (err) {
            console.error('loadData error:', err);
            if (isMounted.current) message.error('加载通知失败');
        } finally {
            if (isMounted.current) setLoading(false);
        }
    }, [userInfo?.id]);

    const loadAllUsers = useCallback(async () => {
        if (!userInfo?.id) return;
        setUsersLoading(true);
        try {
            const res = await searchAllUser(1, 1000);
            if (isMounted.current) {
                const users = getContent(res);
                console.log(`[loadAllUsers] 成功加载 ${users.length} 个用户`);
                setAllUsers(users);
            }
        } catch (err) {
            console.error('[loadAllUsers] 失败:', err);
            if (isMounted.current) message.error('加载用户列表失败');
        } finally {
            if (isMounted.current) setUsersLoading(false);
        }
    }, [userInfo?.id]);

    const loadOrgsAndDepts = useCallback(async () => {
        if (!userInfo?.id) return;
        setTreeLoading(true);
        try {
            const orgRes = await searchAllOrg(1, 1000);
            const allOrgs = getContent(orgRes);
            console.log(`[loadOrgsAndDepts] 加载组织成功，数量: ${allOrgs.length}`);
            if (!isMounted.current) return;
            setOrgs(allOrgs);

            if (allOrgs.length === 0) {
                setTreeData([]);
                return;
            }

            const deptPromises = allOrgs.map(org => getOrgDept(org.id, 1, 1000));
            const deptResults = await Promise.allSettled(deptPromises);
            const deptMap = {};
            allOrgs.forEach((org, idx) => {
                const result = deptResults[idx];
                if (result.status === 'fulfilled') {
                    deptMap[org.id] = getContent(result.value);
                    console.log(`[loadOrgsAndDepts] 组织 ${org.id} 加载部门成功，数量: ${deptMap[org.id].length}`);
                } else {
                    console.warn(`[loadOrgsAndDepts] 组织 ${org.id} 加载部门失败:`, result.reason);
                    deptMap[org.id] = [];
                }
            });
            setDeptsMap(deptMap);

            let filteredOrgs = allOrgs;
            if (userInfo?.roleId !== 1 && userInfo?.orgId) {
                filteredOrgs = allOrgs.filter(o => o.id === userInfo.orgId);
            }
            const tree = buildTreeData(filteredOrgs, deptMap);
            setTreeData(tree);
        } catch (err) {
            console.error('[loadOrgsAndDepts] 整体失败:', err);
            if (isMounted.current) message.error('加载组织部门数据失败');
        } finally {
            if (isMounted.current) setTreeLoading(false);
        }
    }, [userInfo?.id, userInfo?.roleId, userInfo?.orgId]);

    useEffect(() => {
        if (userInfo?.id && !loadedRef.current) {
            loadedRef.current = true;
            const init = async () => {
                await Promise.all([loadData(), loadAllUsers(), loadOrgsAndDepts()]);
            };
            init();
        }
        return () => {
            isMounted.current = false;
        };
    }, [userInfo?.id, loadData, loadAllUsers, loadOrgsAndDepts]);

    const handleAdd = async (values) => {
        await addNotice({ ...values, originatorId: userInfo.id });
        message.success('通知发送成功');
        setModalVisible(false);
        await loadData();
    };

    const handleUpdate = async (values) => {
        await updateNotice({ ...editing, ...values });
        message.success('通知更新成功');
        setModalVisible(false);
        await loadData();
    };

    const handleDelete = async (id) => {
        await deleteNotice(id);
        message.success('撤销成功');
        await loadData();
    };

    const getUsersBySelection = (selectedNodes) => {
        const userIds = new Set();
        for (const node of selectedNodes) {
            if (node.startsWith('org_')) {
                const orgId = parseInt(node.split('_')[1], 10);
                allUsers.forEach(u => {
                    if (u.orgId === orgId) userIds.add(u.id);
                });
            } else if (node.startsWith('dept_')) {
                const deptId = parseInt(node.split('_')[1], 10);
                allUsers.forEach(u => {
                    if (u.deptId === deptId) userIds.add(u.id);
                });
            }
        }
        return Array.from(userIds);
    };

    const handleTreeSelect = (selectedKeys) => {
        const users = getUsersBySelection(selectedKeys);
        setSelectedUserIds(users);
    };

    const handleBatchSend = async (values) => {
        if (selectedUserIds.length === 0) {
            message.warning('请至少选择一个接收人');
            return;
        }
        setSending(true);
        setSendProgress(0);
        let successCount = 0;
        let failCount = 0;
        for (let i = 0; i < selectedUserIds.length; i++) {
            const userId = selectedUserIds[i];
            try {
                await addNotice({
                    name: values.name,
                    content: values.content,
                    originatorId: userInfo.id,
                    mandatoryId: userId,
                });
                successCount++;
            } catch (err) {
                console.error(`发送给用户 ${userId} 失败:`, err);
                failCount++;
            }
            setSendProgress(Math.floor(((i + 1) / selectedUserIds.length) * 100));
        }
        message.success(`发送完成：成功 ${successCount} 条，失败 ${failCount} 条`);
        setSending(false);
        setModalVisible(false);
        await loadData();
    };

    const columns = [
        { title: '标题', dataIndex: 'name' },
        { title: '内容', dataIndex: 'content' },
        { title: '发送时间', dataIndex: 'createDate' },
        {
            title: '操作',
            render: (_, record) => (
                <Space>
                    <Button onClick={() => { setEditing(record); setModalVisible(true); setIsBatch(false); form.setFieldsValue(record); }}>编辑</Button>
                    <Popconfirm title="确定撤销？" onConfirm={() => handleDelete(record.id)}>
                        <Button danger>撤销</Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    const receivedColumns = [
        { title: '标题', dataIndex: 'name' },
        { title: '内容', dataIndex: 'content' },
        { title: '发送人', dataIndex: 'originatorId' },
        { title: '发送时间', dataIndex: 'createDate' },
    ];

    const tabItems = [
        { key: 'received', label: '收到的通知', children: <Table columns={receivedColumns} dataSource={received} rowKey="id" /> },
        { key: 'sent', label: '发出的通知', children: <Table columns={columns} dataSource={sent} rowKey="id" /> },
    ];

    return (
        <div>
            {canPublish ? (
                <Space style={{ marginBottom: 16 }}>
                    <Button type="primary" onClick={() => { setEditing(null); setIsBatch(false); setModalVisible(true); form.resetFields(); }}>
                        发布通知
                    </Button>
                    <Button onClick={() => { setEditing(null); setIsBatch(true); setModalVisible(true); form.resetFields(); setSelectedUserIds([]); }}>
                        批量发送
                    </Button>
                </Space>
            ) : (
                <Alert message="您没有权限发布通知" type="warning" showIcon style={{ marginBottom: 16 }} />
            )}
            <Tabs activeKey={activeTab} onChange={setActiveTab} items={tabItems} />
            <Modal
                title={editing ? '编辑通知' : (isBatch ? '批量发送通知' : '发布通知')}
                open={modalVisible}
                onCancel={() => setModalVisible(false)}
                footer={null}
                width={750}
            >
                {isBatch ? (
                    <Form form={form} onFinish={handleBatchSend} layout="vertical">
                        <Form.Item name="name" label="通知标题" rules={[{ required: true }]}>
                            <Input />
                        </Form.Item>
                        <Form.Item name="content" label="通知内容" rules={[{ required: true }]}>
                            <Input.TextArea rows={4} />
                        </Form.Item>
                        <Form.Item label="选择接收范围（组织/部门）">
                            <Spin spinning={treeLoading}>
                                {treeData.length === 0 && !treeLoading ? (
                                    <Alert
                                        message="暂无组织数据，您可以直接在下方的成员列表中选择接收人"
                                        type="info"
                                        showIcon
                                    />
                                ) : (
                                    <TreeSelect
                                        treeData={treeData}
                                        treeCheckable
                                        showCheckedStrategy={TreeSelect.SHOW_CHILD}
                                        placeholder="请选择组织或部门（选中后自动添加所有成员）"
                                        onChange={handleTreeSelect}
                                        style={{ width: '100%' }}
                                        treeDefaultExpandAll
                                    />
                                )}
                            </Spin>
                        </Form.Item>
                        <Form.Item label={`已选中的成员（共 ${selectedUserIds.length} 人）`}>
                            <Spin spinning={usersLoading}>
                                <Select
                                    mode="multiple"
                                    placeholder="请选择接收人（可搜索）"
                                    options={allUsers.map(u => ({ label: `${u.name}(${u.username})`, value: u.id }))}
                                    value={selectedUserIds}
                                    onChange={setSelectedUserIds}
                                    showSearch
                                    filterOption={(input, option) => option.label.toLowerCase().includes(input.toLowerCase())}
                                    style={{ width: '100%' }}
                                    loading={usersLoading}
                                    notFoundContent={usersLoading ? '加载中...' : (allUsers.length === 0 ? '暂无用户数据' : undefined)}
                                />
                            </Spin>
                        </Form.Item>
                        {sending && <Progress percent={sendProgress} status="active" />}
                        <Form.Item>
                            <Button type="primary" htmlType="submit" loading={sending}>发送</Button>
                        </Form.Item>
                    </Form>
                ) : (
                    <Form form={form} onFinish={editing ? handleUpdate : handleAdd} layout="vertical">
                        <Form.Item name="name" label="标题" rules={[{ required: true }]}>
                            <Input />
                        </Form.Item>
                        <Form.Item name="content" label="内容">
                            <Input.TextArea rows={4} />
                        </Form.Item>
                        {!editing && (
                            <Form.Item name="mandatoryId" label="接收人" rules={[{ required: true }]}>
                                <Select
                                    showSearch
                                    optionFilterProp="children"
                                    options={allUsers.map(u => ({ label: `${u.name}(${u.username})`, value: u.id }))}
                                    loading={usersLoading}
                                    placeholder="请选择接收人"
                                    notFoundContent={usersLoading ? '加载中...' : (allUsers.length === 0 ? '暂无用户数据' : undefined)}
                                />
                            </Form.Item>
                        )}
                        <Form.Item>
                            <Button type="primary" htmlType="submit">发送</Button>
                        </Form.Item>
                    </Form>
                )}
            </Modal>
        </div>
    );
}