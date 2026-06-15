// src/pages/Feedback.jsx
import { useState, useEffect } from 'react';
import { Table, Button, Modal, Form, Input, message, Spin, Tabs, Select, Popconfirm } from 'antd';
import { useSelector } from 'react-redux';
import { getReceivedFeedback, getPendingFeedback, addFeedback, approveFeedback } from '../api/feedback';
import { listAllUser } from '../api/user';
import { feedbackStatusMap } from '../utils/statusMap';

// 辅助函数：从响应中安全提取数据列表
const extractDataList = (response) => {
    try {
        const backendData = response.data?.data;
        if (!backendData) return [];
        if (Array.isArray(backendData.content)) return backendData.content;
        if (Array.isArray(backendData)) return backendData;
        return [];
    } catch {
        return [];
    }
};

export default function Feedback() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [received, setReceived] = useState([]);
    const [sent, setSent] = useState([]);
    const [loading, setLoading] = useState(false);
    const [modalVisible, setModalVisible] = useState(false);
    const [approveModalVisible, setApproveModalVisible] = useState(false);
    const [selectedFeedback, setSelectedFeedback] = useState(null);
    const [userList, setUserList] = useState([]);
    const [form] = Form.useForm();
    const [approveForm] = Form.useForm();

    useEffect(() => {
        loadData();
        loadUsers();
    }, []);

    const loadData = async () => {
        setLoading(true);
        try {
            const [recvRes, sentRes] = await Promise.all([
                getReceivedFeedback(userInfo.id, 1, 100),
                getPendingFeedback(userInfo.id, 1, 100),
            ]);
            setReceived(extractDataList(recvRes));
            setSent(extractDataList(sentRes));
        } catch (error) {
            message.error('加载反馈失败');
        } finally {
            setLoading(false);
        }
    };

    const loadUsers = async () => {
        try {
            const res = await searchAllUser(1, 1000);
            setUserList(extractDataList(res));
        } catch (error) {
            console.error('加载用户列表失败', error);
        }
    };

    const handleAdd = async (values) => {
        await addFeedback({ ...values, feedbackUserId: userInfo.id });
        message.success('反馈提交成功');
        setModalVisible(false);
        loadData();
    };

    const handleApprove = async (values) => {
        await approveFeedback({ id: selectedFeedback.id, feedbackStatus: values.status, remark: values.remark });
        message.success('处理成功');
        setApproveModalVisible(false);
        loadData();
    };

    const sentColumns = [
        { title: '目标对象', dataIndex: 'targetObject' },
        { title: '内容', dataIndex: 'feedbackContent' },
        { title: '状态', dataIndex: 'feedbackStatus', render: (val) => feedbackStatusMap[val] },
        { title: '回复', dataIndex: 'remark' },
    ];

    const receivedColumns = [
        { title: '反馈人', dataIndex: 'feedbackUserId' },
        { title: '目标对象', dataIndex: 'targetObject' },
        { title: '内容', dataIndex: 'feedbackContent' },
        { title: '状态', dataIndex: 'feedbackStatus', render: (val) => feedbackStatusMap[val] },
        {
            title: '操作',
            render: (_, record) => (
                record.feedbackStatus === 0 && (
                    <Button onClick={() => { setSelectedFeedback(record); setApproveModalVisible(true); }}>处理</Button>
                )
            ),
        },
    ];

    const tabItems = [
        { key: 'sent', label: '我提交的反馈', children: <Table columns={sentColumns} dataSource={sent} rowKey="id" /> },
        { key: 'received', label: '待处理反馈', children: <Table columns={receivedColumns} dataSource={received} rowKey="id" /> },
    ];

    return (
        <div>
            <Button type="primary" onClick={() => setModalVisible(true)} style={{ marginBottom: 16 }}>
                提交反馈
            </Button>
            <Tabs defaultActiveKey="sent" items={tabItems} />

            {/* 提交反馈模态框 */}
            <Modal title="提交反馈" open={modalVisible} onCancel={() => setModalVisible(false)} footer={null}>
                <Form form={form} onFinish={handleAdd} layout="vertical">
                    <Form.Item name="targetObject" label="反馈对象" rules={[{ required: true }]}>
                        <Select options={[
                            { label: '组织', value: 'org' },
                            { label: '部门', value: 'dept' },
                            { label: '设备', value: 'equip' },
                            { label: '系统', value: 'system' }
                        ]} />
                    </Form.Item>
                    <Form.Item name="feedbackContent" label="反馈内容" rules={[{ required: true }]}>
                        <Input.TextArea rows={4} />
                    </Form.Item>
                    <Form.Item name="handlerUserId" label="处理人" rules={[{ required: true }]}>
                        <Select
                            showSearch
                            optionFilterProp="children"
                            options={userList.map(u => ({ label: `${u.name}(${u.username})`, value: u.id }))}
                        />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">提交</Button>
                    </Form.Item>
                </Form>
            </Modal>

            {/* 处理反馈模态框 */}
            <Modal title="处理反馈" open={approveModalVisible} onCancel={() => setApproveModalVisible(false)} footer={null}>
                <Form form={approveForm} onFinish={handleApprove} layout="vertical">
                    <Form.Item name="status" label="处理结果" rules={[{ required: true }]}>
                        <Select options={[
                            { label: '已处理', value: 1 },
                            { label: '无法解决', value: 2 }
                        ]} />
                    </Form.Item>
                    <Form.Item name="remark" label="回复内容">
                        <Input.TextArea rows={3} />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">提交</Button>
                    </Form.Item>
                </Form>
            </Modal>
        </div>
    );
}