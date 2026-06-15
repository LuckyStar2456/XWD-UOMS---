import { useEffect, useState } from 'react';
import { Card, Row, Col, Table, Spin, Empty, Statistic } from 'antd';
import { 
    FileTextOutlined, 
    CheckSquareOutlined, 
    PackageOutlined, 
    MessageSquareOutlined,
    BellOutlined,
    ArrowRightOutlined
} from '@ant-design/icons';
import { getUnfApply, getUnfTask, getUnfBorrow, getUnfFeedback, getNotice, getStats } from '../api/home';
import { useSelector } from 'react-redux';
import { applyStatusMap, borrowStatusMap, taskStatusMap, feedbackStatusMap } from '../utils/statusMap';

const applyColumns = [
    { title: '申请描述', dataIndex: 'applyDesc', ellipsis: true },
    { title: '状态', dataIndex: 'applyStatus', render: (val) => applyStatusMap[val] || '未知' },
    { 
        title: '操作', 
        render: () => (
            <span style={{ color: '#6366f1', cursor: 'pointer', fontSize: 14 }}>
                查看详情 <ArrowRightOutlined style={{ fontSize: 12 }} />
            </span>
        ) 
    },
];
const taskColumns = [
    { title: '任务名称', dataIndex: 'name', ellipsis: true },
    { title: '状态', dataIndex: 'status', render: (val) => taskStatusMap[val] || '未知' },
    { 
        title: '操作', 
        render: () => (
            <span style={{ color: '#6366f1', cursor: 'pointer', fontSize: 14 }}>
                查看详情 <ArrowRightOutlined style={{ fontSize: 12 }} />
            </span>
        ) 
    },
];
const borrowColumns = [
    { title: '设备ID', dataIndex: 'equipmentId' },
    { title: '借取数量', dataIndex: 'borrowNum' },
    { title: '状态', dataIndex: 'status', render: (val) => borrowStatusMap[val] || '未知' },
];
const feedbackColumns = [
    { title: '反馈内容', dataIndex: 'feedbackContent', ellipsis: true },
    { title: '状态', dataIndex: 'feedbackStatus', render: (val) => feedbackStatusMap[val] || '未知' },
    { 
        title: '操作', 
        render: () => (
            <span style={{ color: '#6366f1', cursor: 'pointer', fontSize: 14 }}>
                查看详情 <ArrowRightOutlined style={{ fontSize: 12 }} />
            </span>
        ) 
    },
];
const noticeColumns = [
    { title: '标题', dataIndex: 'name', ellipsis: true },
    { title: '内容', dataIndex: 'content', ellipsis: true },
];

export default function Home() {
    const userId = useSelector(state => state.user.userInfo?.id);
    const [loading, setLoading] = useState(true);
    const [data, setData] = useState({ 
        apply: [], 
        task: [], 
        borrow: [], 
        feedback: [], 
        notice: [] 
    });
    const [stats, setStats] = useState({
        applyCount: 0,
        taskCount: 0,
        borrowCount: 0,
        feedbackCount: 0,
    });

    useEffect(() => {
        if (!userId) return;
        const fetchData = async () => {
            setLoading(true);
            try {
                const [applyRes, taskRes, borrowRes, feedbackRes, noticeRes, statsRes] = await Promise.all([
                    getUnfApply(userId, 1, 5),
                    getUnfTask(userId, 1, 5),
                    getUnfBorrow(userId, 1, 5),
                    getUnfFeedback(userId, 1, 5),
                    getNotice(userId, 1, 5),
                    getStats(userId),
                ]);
                setData({
                    apply: applyRes.data.content,
                    task: taskRes.data.content,
                    borrow: borrowRes.data.content,
                    feedback: feedbackRes.data.content,
                    notice: noticeRes.data.content,
                });
                setStats({
                    applyCount: statsRes.data.applyCount || 0,
                    taskCount: statsRes.data.taskCount || 0,
                    borrowCount: statsRes.data.borrowCount || 0,
                    feedbackCount: statsRes.data.feedbackCount || 0,
                });
            } catch (error) {
                console.error(error);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, [userId]);

    if (loading) return <Spin size="large" />;

    const statCards = [
        { 
            title: '待审批申请', 
            value: stats.applyCount, 
            icon: FileTextOutlined, 
            color: '#6366f1',
            bgColor: 'rgba(99, 102, 241, 0.1)',
        },
        { 
            title: '待处理任务', 
            value: stats.taskCount, 
            icon: CheckSquareOutlined, 
            color: '#10b981',
            bgColor: 'rgba(16, 185, 129, 0.1)',
        },
        { 
            title: '待审批借取', 
            value: stats.borrowCount, 
            icon: PackageOutlined, 
            color: '#f59e0b',
            bgColor: 'rgba(245, 158, 11, 0.1)',
        },
        { 
            title: '待处理反馈', 
            value: stats.feedbackCount, 
            icon: MessageSquareOutlined, 
            color: '#ec4899',
            bgColor: 'rgba(236, 72, 153, 0.1)',
        },
    ];

    return (
        <div style={styles.container}>
            <Row gutter={[16, 16]} style={{ marginBottom: 24 }}>
                {statCards.map((stat, index) => (
                    <Col span={6} key={index}>
                        <Card style={styles.statCard} bordered={false}>
                            <div style={{ display: 'flex', alignItems: 'center', gap: 16 }}>
                                <div style={{ ...styles.statIcon, background: stat.bgColor }}>
                                    <stat.icon style={{ fontSize: 24, color: stat.color }} />
                                </div>
                                <div>
                                    <Statistic 
                                        title={stat.title} 
                                        value={stat.value} 
                                        valueStyle={{ color: stat.color, fontWeight: 600, fontSize: 28 }}
                                        titleStyle={{ color: '#64748b', fontSize: 14, marginTop: 4 }}
                                    />
                                </div>
                            </div>
                        </Card>
                    </Col>
                ))}
            </Row>

            <Row gutter={[16, 16]}>
                <Col span={12}>
                    <Card 
                        title="待审批申请" 
                        style={styles.card}
                        titleStyle={styles.cardTitle}
                        extra={
                            <span style={styles.cardExtra}>
                                查看全部 <ArrowRightOutlined style={{ fontSize: 12 }} />
                            </span>
                        }
                    >
                        <Table 
                            columns={applyColumns} 
                            dataSource={data.apply} 
                            pagination={false} 
                            rowKey="id" 
                            locale={{ emptyText: <Empty description="暂无数据" /> }}
                            style={styles.table}
                        />
                    </Card>
                </Col>
                
                <Col span={12}>
                    <Card 
                        title="待处理任务" 
                        style={styles.card}
                        titleStyle={styles.cardTitle}
                        extra={
                            <span style={styles.cardExtra}>
                                查看全部 <ArrowRightOutlined style={{ fontSize: 12 }} />
                            </span>
                        }
                    >
                        <Table 
                            columns={taskColumns} 
                            dataSource={data.task} 
                            pagination={false} 
                            rowKey="id"
                            locale={{ emptyText: <Empty description="暂无数据" /> }}
                            style={styles.table}
                        />
                    </Card>
                </Col>
                
                <Col span={12}>
                    <Card 
                        title="待审批借取" 
                        style={styles.card}
                        titleStyle={styles.cardTitle}
                        extra={
                            <span style={styles.cardExtra}>
                                查看全部 <ArrowRightOutlined style={{ fontSize: 12 }} />
                            </span>
                        }
                    >
                        <Table 
                            columns={borrowColumns} 
                            dataSource={data.borrow} 
                            pagination={false} 
                            rowKey="id"
                            locale={{ emptyText: <Empty description="暂无数据" /> }}
                            style={styles.table}
                        />
                    </Card>
                </Col>
                
                <Col span={12}>
                    <Card 
                        title="待处理反馈" 
                        style={styles.card}
                        titleStyle={styles.cardTitle}
                        extra={
                            <span style={styles.cardExtra}>
                                查看全部 <ArrowRightOutlined style={{ fontSize: 12 }} />
                            </span>
                        }
                    >
                        <Table 
                            columns={feedbackColumns} 
                            dataSource={data.feedback} 
                            pagination={false} 
                            rowKey="id"
                            locale={{ emptyText: <Empty description="暂无数据" /> }}
                            style={styles.table}
                        />
                    </Card>
                </Col>
                
                <Col span={24}>
                    <Card 
                        title="最新通知" 
                        style={{ ...styles.card, marginTop: 0 }}
                        titleStyle={styles.cardTitle}
                        extra={
                            <span style={styles.cardExtra}>
                                查看全部 <ArrowRightOutlined style={{ fontSize: 12 }} />
                            </span>
                        }
                    >
                        <Table 
                            columns={noticeColumns} 
                            dataSource={data.notice} 
                            pagination={false} 
                            rowKey="id"
                            locale={{ emptyText: <Empty description="暂无数据" /> }}
                            style={styles.table}
                        />
                    </Card>
                </Col>
            </Row>
        </div>
    );
}

const styles = {
    container: {
        animation: 'fadeIn 0.5s ease-out',
    },
    statCard: {
        borderRadius: 12,
        boxShadow: '0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)',
        transition: 'transform 0.2s ease, box-shadow 0.2s ease',
        '&:hover': {
            transform: 'translateY(-4px)',
            boxShadow: '0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05)',
        },
    },
    statIcon: {
        width: 56,
        height: 56,
        borderRadius: 14,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
    },
    card: {
        borderRadius: 12,
        boxShadow: '0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)',
        transition: 'transform 0.2s ease, box-shadow 0.2s ease',
        '&:hover': {
            transform: 'translateY(-2px)',
            boxShadow: '0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05)',
        },
    },
    cardTitle: {
        fontSize: 16,
        fontWeight: 600,
        color: '#1e293b',
    },
    cardExtra: {
        color: '#6366f1',
        fontSize: 13,
        cursor: 'pointer',
        transition: 'color 0.2s ease',
        '&:hover': {
            color: '#8b5cf6',
        },
    },
    table: {
        marginTop: 8,
    },
};
