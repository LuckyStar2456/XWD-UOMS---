import { useState, useEffect, useCallback } from 'react';
import { Input, Select, Button, Table, Spin, Card, Tabs, Space, message, Empty } from 'antd';
import { searchOrg, listAllOrg, listOrgDept, listOrgEquip } from '../api/org';
import { searchDept, listAllDept, listDeptUser, listDeptEquip } from '../api/dept';
import { searchUser, listAllUser } from '../api/user';
import { searchEquip, listAllEquip } from '../api/equip';
import { getRoleName } from '../utils/roleMap';

const searchTypes = ['组织', '部门', '用户', '设备'];

const deptColumns = [{ title: '部门名称', dataIndex: 'name' }];
const userColumns = [
    { title: '姓名', dataIndex: 'name' },
    { title: '账号', dataIndex: 'username' },
    { title: '组织', dataIndex: 'orgName' },
    { title: '部门', dataIndex: 'deptName' },
    { title: '角色', dataIndex: 'roleId', render: (val) => getRoleName(val) },
];
const equipColumns = [
    { title: '设备名称', dataIndex: 'name' },
    { title: '总数', dataIndex: 'totalNum' },
    { title: '可用数', dataIndex: 'availableNum' },
];

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

export default function Search() {
    const [type, setType] = useState('组织');
    const [keyword, setKeyword] = useState('');
    const [loading, setLoading] = useState(false);
    const [results, setResults] = useState([]);
    const [expandedOrgId, setExpandedOrgId] = useState(null);
    const [expandedDeptId, setExpandedDeptId] = useState(null);
    const [orgDeptData, setOrgDeptData] = useState({});
    const [orgEquipData, setOrgEquipData] = useState({});
    const [deptUserData, setDeptUserData] = useState({});
    const [deptEquipData, setDeptEquipData] = useState({});

    const performSearch = useCallback(async () => {
        setLoading(true);
        try {
            let res;
            if (type === '组织') {
                res = keyword ? await searchOrg(keyword, 1, 100) : await listAllOrg(1, 100);
            } else if (type === '部门') {
                res = keyword ? await searchDept(keyword, 1, 100) : await listAllDept(1, 100);
            } else if (type === '用户') {
                res = keyword ? await searchUser(keyword, 1, 100) : await listAllUser(1, 100);
            } else {
                res = keyword ? await searchEquip(keyword, 1, 100) : await listAllEquip(1, 100);
            }
            const list = extractDataList(res);
            setResults(list);
            setExpandedOrgId(null);
            setExpandedDeptId(null);
        } catch (error) {
            message.error('搜索失败');
        } finally {
            setLoading(false);
        }
    }, [type, keyword]);

    useEffect(() => {
        performSearch();
    }, [performSearch]);

    const onTypeChange = (value) => {
        setType(value);
        setKeyword('');
    };

    const handleSearchClick = () => {
        performSearch();
    };

    const loadOrgDept = async (orgId) => {
        if (orgDeptData[orgId]) return;
        try {
            const res = await listOrgDept(orgId, 1, 100);
            setOrgDeptData(prev => ({ ...prev, [orgId]: extractDataList(res) }));
        } catch {
            setOrgDeptData(prev => ({ ...prev, [orgId]: [] }));
        }
    };

    const loadOrgEquip = async (orgId) => {
        if (orgEquipData[orgId]) return;
        try {
            const res = await listOrgEquip(orgId, 1, 100);
            setOrgEquipData(prev => ({ ...prev, [orgId]: extractDataList(res) }));
        } catch {
            setOrgEquipData(prev => ({ ...prev, [orgId]: [] }));
        }
    };

    const loadDeptUser = async (deptId) => {
        if (deptUserData[deptId]) return;
        try {
            const res = await listDeptUser(deptId, 1, 100);
            setDeptUserData(prev => ({ ...prev, [deptId]: extractDataList(res) }));
        } catch {
            setDeptUserData(prev => ({ ...prev, [deptId]: [] }));
        }
    };

    const loadDeptEquip = async (deptId) => {
        if (deptEquipData[deptId]) return;
        try {
            const res = await listDeptEquip(deptId, 1, 100);
            setDeptEquipData(prev => ({ ...prev, [deptId]: extractDataList(res) }));
        } catch {
            setDeptEquipData(prev => ({ ...prev, [deptId]: [] }));
        }
    };

    const MemberListByOrg = ({ orgName, orgType }) => {
        const [users, setUsers] = useState([]);
        const [loadingUsers, setLoadingUsers] = useState(false);

        useEffect(() => {
            const fetchUsers = async () => {
                setLoadingUsers(true);
                try {
                    const res = await searchAllUser(1, 100);
                    const allUsers = extractDataList(res);
                    // 根据组织名称和类型精确匹配（注意去除前后空格）
                    const filtered = allUsers.filter(u =>
                        u.orgName?.trim() === orgName?.trim() && u.orgType?.trim() === orgType?.trim()
                    );
                    setUsers(filtered);
                } catch {
                    message.error('加载成员失败');
                } finally {
                    setLoadingUsers(false);
                }
            };
            if (orgName && orgType) {
                fetchUsers();
            }
        }, [orgName, orgType]);

        if (loadingUsers) return <Spin />;
        return <Table columns={userColumns} dataSource={users} rowKey="id" pagination={false} />;
    };

    const renderOrgDetail = (org) => {
        const isExpanded = expandedOrgId === org.id;
        return (
            <div style={{ marginTop: 12 }}>
                <Button
                    type="link"
                    onClick={() => {
                        if (isExpanded) {
                            setExpandedOrgId(null);
                        } else {
                            setExpandedOrgId(org.id);
                            void loadOrgDept(org.id);
                            void loadOrgEquip(org.id);
                        }
                    }}
                >
                    {isExpanded ? '收起' : '展开查看部门/设备/成员'}
                </Button>
                {isExpanded && (
                    <Tabs
                        items={[
                            {
                                key: 'dept',
                                label: '部门',
                                children: <Table columns={deptColumns} dataSource={orgDeptData[org.id] || []} rowKey="id" pagination={false} />,
                            },
                            {
                                key: 'equip',
                                label: '设备',
                                children: <Table columns={equipColumns} dataSource={orgEquipData[org.id] || []} rowKey="id" pagination={false} />,
                            },
                            {
                                key: 'member',
                                label: '成员',
                                children: <MemberListByOrg orgName={org.name} orgType={org.type} />,
                            },
                        ]}
                    />
                )}
            </div>
        );
    };

    const renderDeptDetail = (dept) => {
        const isExpanded = expandedDeptId === dept.id;
        return (
            <div style={{ marginTop: 12 }}>
                <Button
                    type="link"
                    onClick={() => {
                        if (isExpanded) {
                            setExpandedDeptId(null);
                        } else {
                            setExpandedDeptId(dept.id);
                            void loadDeptUser(dept.id);
                            void loadDeptEquip(dept.id);
                        }
                    }}
                >
                    {isExpanded ? '收起' : '展开查看成员/设备'}
                </Button>
                {isExpanded && (
                    <Tabs
                        items={[
                            {
                                key: 'member',
                                label: '成员',
                                children: <Table columns={userColumns} dataSource={deptUserData[dept.id] || []} rowKey="id" pagination={false} />,
                            },
                            {
                                key: 'equip',
                                label: '设备',
                                children: <Table columns={equipColumns} dataSource={deptEquipData[dept.id] || []} rowKey="id" pagination={false} />,
                            },
                        ]}
                    />
                )}
            </div>
        );
    };

    if (!loading && results.length === 0) {
        return (
            <div>
                <Space style={{ marginBottom: 16 }}>
                    <Select value={type} onChange={onTypeChange} options={searchTypes.map(t => ({ label: t, value: t }))} style={{ width: 100 }} />
                    <Input.Search
                        placeholder="请输入关键词"
                        value={keyword}
                        onChange={e => setKeyword(e.target.value)}
                        onSearch={handleSearchClick}
                        style={{ width: 300 }}
                    />
                    <Button type="primary" onClick={handleSearchClick}>搜索</Button>
                </Space>
                <Empty description="暂无数据" />
            </div>
        );
    }

    return (
        <div>
            <Space style={{ marginBottom: 16 }}>
                <Select value={type} onChange={onTypeChange} options={searchTypes.map(t => ({ label: t, value: t }))} style={{ width: 100 }} />
                <Input.Search
                    placeholder="请输入关键词"
                    value={keyword}
                    onChange={e => setKeyword(e.target.value)}
                    onSearch={handleSearchClick}
                    style={{ width: 300 }}
                />
                <Button type="primary" onClick={handleSearchClick}>搜索</Button>
            </Space>
            <Spin spinning={loading}>
                {results.map(item => (
                    <Card key={item.id} style={{ marginBottom: 16 }}>
                        <div><strong>{type === '用户' ? item.name : item.name}</strong></div>
                        {type === '组织' && renderOrgDetail(item)}
                        {type === '部门' && renderDeptDetail(item)}
                        {type === '用户' && (
                            <div>
                                <div>账号：{item.username}</div>
                                <div>角色：{getRoleName(item.roleId)}</div>
                                <div>组织：{item.orgName || '无'}</div>
                                <div>部门：{item.deptName || '无'}</div>
                            </div>
                        )}
                        {type === '设备' && (
                            <div>
                                <div>总数：{item.totalNum}</div>
                                <div>可用数：{item.availableNum}</div>
                            </div>
                        )}
                    </Card>
                ))}
            </Spin>
        </div>
    );
}