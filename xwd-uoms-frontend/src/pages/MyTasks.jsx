// src/pages/MyTasks.jsx
import { useState, useEffect } from 'react';
import { Table, Button, Modal, Form, Input, message, Spin, Tabs, Select, Popconfirm } from 'antd';
import { useSelector } from 'react-redux';
import { getReceivedTask, getPendingTask, approveTask } from '../api/task';
import { addTaskFeedback } from '../api/taskfeedback';
import { taskStatusMap, reviewStatusMap } from '../utils/statusMap';

// 辅助函数：安全提取数据列表
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

export default function MyTasks() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [received, setReceived] = useState([]);
    const [sent, setSent] = useState([]);
    const [loading, setLoading] = useState(false);
    const [feedbackModalVisible, setFeedbackModalVisible] = useState(false);
    const [selectedTask, setSelectedTask] = useState(null);
    const [approveModalVisible, setApproveModalVisible] = useState(false);
    const [feedbackForm] = Form.useForm();
    const [approveForm] = Form.useForm();

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {
        setLoading(true);
        try {
            const [recvRes, sentRes] = await Promise.all([
                getReceivedTask(userInfo.id, 1, 100),
                getPendingTask(userInfo.id, 1, 100),
            ]);
            setReceived(extractDataList(recvRes));
            setSent(extractDataList(sentRes));
        } catch (error) {
            message.error('加载任务失败');
        } finally {
            setLoading(false);
        }
    };

    const handleSubmitFeedback = async (values) => {
        await addTaskFeedback({
            taskId: selectedTask.id,
            feedbackUserId: userInfo.id,
            feedbackContent: values.content,
            reviewUserId: selectedTask.originatorId,
        });
        message.success('任务反馈已提交');
        setFeedbackModalVisible(false);
        loadData();
    };

    const handleApproveTask = async (values) => {
        await approveTask({ id: selectedTask.id, status: values.status });
        message.success('任务审批成功');
        setApproveModalVisible(false);
        loadData();
    };

    const receivedColumns = [
        { title: '任务名称', dataIndex: 'name' },
        { title: '描述', dataIndex: 'taskDesc' },
        { title: '截止日期', dataIndex: 'deadline' },
        { title: '状态', dataIndex: 'status', render: (val) => taskStatusMap[val] },
        {
            title: '操作',
            render: (_, record) => (
                (record.status === 0 || record.status === 1) && (
                    <Button onClick={() => { setSelectedTask(record); setFeedbackModalVisible(true); }}>提交反馈</Button>
                )
            ),
        },
    ];

    const sentColumns = [
        { title: '任务名称', dataIndex: 'name' },
        { title: '执行人', dataIndex: 'mandatoryId' },
        { title: '状态', dataIndex: 'status', render: (val) => taskStatusMap[val] },
        {
            title: '操作',
            render: (_, record) => (
                record.status === 1 && (
                    <Button onClick={() => { setSelectedTask(record); setApproveModalVisible(true); }}>审批反馈</Button>
                )
            ),
        },
    ];

    const tabItems = [
        { key: 'received', label: '分配给我的任务', children: <Table columns={receivedColumns} dataSource={received} rowKey="id" /> },
        { key: 'sent', label: '我发布的任务', children: <Table columns={sentColumns} dataSource={sent} rowKey="id" /> },
    ];

    return (
        <div>
            <Tabs defaultActiveKey="received" items={tabItems} />
            {/* 提交反馈模态框 */}
            <Modal title="提交任务反馈" open={feedbackModalVisible} onCancel={() => setFeedbackModalVisible(false)} footer={null}>
                <Form form={feedbackForm} onFinish={handleSubmitFeedback} layout="vertical">
                    <Form.Item name="content" label="反馈内容" rules={[{ required: true }]}>
                        <Input.TextArea rows={4} />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">提交</Button>
                    </Form.Item>
                </Form>
            </Modal>
            {/* 审批任务模态框 */}
            <Modal title="审批任务" open={approveModalVisible} onCancel={() => setApproveModalVisible(false)} footer={null}>
                <Form form={approveForm} onFinish={handleApproveTask} layout="vertical">
                    <Form.Item name="status" label="审批结果" rules={[{ required: true }]}>
                        <Select options={[
                            { label: '通过', value: 2 },
                            { label: '驳回', value: 4 }
                        ]} />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">提交</Button>
                    </Form.Item>
                </Form>
            </Modal>
        </div>
    );
}