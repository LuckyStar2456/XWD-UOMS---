// src/pages/MyApply.jsx
import { useState, useEffect } from 'react';
import { Table, Button, Popconfirm, message, Spin } from 'antd';
import { useSelector } from 'react-redux';
import { getPendingApply, deleteApply } from '../api/apply';
import { applyStatusMap } from '../utils/statusMap';

export default function MyApply() {
    const userInfo = useSelector(state => state.user.userInfo);
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {
        setLoading(true);
        try {
            const res = await getPendingApply(userInfo.id, 1, 100);
            setData(res.data.content);
        } catch (error) {
            message.error('加载申请失败');
        } finally {
            setLoading(false);
        }
    };

    const handleDelete = async (id) => {
        await deleteApply(id);
        message.success('撤销成功');
        loadData();
    };

    const columns = [
        { title: '申请描述', dataIndex: 'applyDesc' },
        { title: '目标对象', dataIndex: 'targetObject' },
        { title: '操作', dataIndex: 'applyOperationCode' },
        { title: '状态', dataIndex: 'applyStatus', render: (val) => applyStatusMap[val] },
        { title: '审批备注', dataIndex: 'remark' },
        {
            title: '操作',
            render: (_, record) => (
                record.applyStatus === 0 && (
                    <Popconfirm title="确定撤销？" onConfirm={() => handleDelete(record.id)}>
                        <Button danger>撤销</Button>
                    </Popconfirm>
                )
            ),
        },
    ];

    return <Spin spinning={loading}><Table columns={columns} dataSource={data} rowKey="id" /></Spin>;
}