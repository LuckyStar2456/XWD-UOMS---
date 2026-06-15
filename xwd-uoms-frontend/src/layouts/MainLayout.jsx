import { useEffect, useState } from 'react';
import { Layout, Menu, Dropdown, Avatar, message, Spin, Tooltip } from 'antd';
import { 
    UserOutlined, 
    LogoutOutlined, 
    HomeOutlined, 
    SearchOutlined,
    BuildOutlined,
    FolderOpenOutlined,
    MonitorOutlined,
    HistoryOutlined,
    FileTextOutlined,
    BellOutlined,
    MessageSquareOutlined,
    CheckSquareOutlined,
    ChevronDownOutlined
} from '@ant-design/icons';
import { Outlet, useNavigate, useLocation } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { logout, setUserInfo } from '../store/userSlice';
import { logoutAPI } from '../api/auth';
import { getRefreshToken, removeTokens } from '../utils/token';
import { getUserInfo } from '../api/user';
import { getRoleName } from '../utils/roleMap';
import { menuItems as baseMenuItems } from './menuItems';

const { Header, Content, Sider } = Layout;

const menuIcons = {
    '/home': HomeOutlined,
    '/search': SearchOutlined,
    '/org-manage': BuildOutlined,
    '/dept-manage': FolderOpenOutlined,
    '/equip-manage': MonitorOutlined,
    '/borrow-record': HistoryOutlined,
    '/my-apply': FileTextOutlined,
    '/notice': BellOutlined,
    '/feedback': MessageSquareOutlined,
    '/my-tasks': CheckSquareOutlined,
};

export default function MainLayout() {
    const navigate = useNavigate();
    const location = useLocation();
    const dispatch = useDispatch();
    const userInfo = useSelector(state => state.user.userInfo);
    const [loading, setLoading] = useState(true);
    const [collapsed, setCollapsed] = useState(false);

    useEffect(() => {
        const fetchUser = async () => {
            const userId = localStorage.getItem('userId');
            if (userId && !userInfo) {
                try {
                    const res = await getUserInfo(userId);
                    dispatch(setUserInfo(res.data));
                } catch (error) {
                    console.error('获取用户信息失败', error);
                    removeTokens();
                    localStorage.removeItem('userId');
                    navigate('/login');
                }
            }
            setLoading(false);
        };
        fetchUser();
    }, [dispatch, userInfo, navigate]);

    useEffect(() => {
        const token = getRefreshToken();
        if (!token) {
            navigate('/login');
        }
    }, [navigate]);

    const handleLogout = async () => {
        const refreshToken = getRefreshToken();
        if (refreshToken) {
            await logoutAPI(refreshToken).catch(() => {});
        }
        removeTokens();
        localStorage.removeItem('userId');
        dispatch(logout());
        message.success('已退出登录');
        navigate('/login');
    };

    const userMenu = {
        items: [
            { 
                key: 'profile', 
                label: '个人资料', 
                icon: <UserOutlined />, 
                onClick: () => navigate('/profile') 
            },
            { type: 'divider' },
            { 
                key: 'logout', 
                label: '退出登录', 
                icon: <LogoutOutlined />, 
                onClick: handleLogout 
            },
        ],
    };

    const menuItems = baseMenuItems.map(item => ({
        ...item,
        icon: menuIcons[item.key] ? React.createElement(menuIcons[item.key]) : null,
    }));

    if (loading) {
        return (
            <div style={styles.loadingContainer}>
                <Spin size="large" tip="加载中..." />
            </div>
        );
    }

    const displayName = userInfo
        ? userInfo.name
        : '加载中...';

    const displayRole = userInfo
        ? getRoleName(userInfo.roleId)
        : '';

    return (
        <Layout style={styles.layout}>
            <Sider 
                width={collapsed ? 64 : 240} 
                theme="light"
                collapsible
                collapsed={collapsed}
                onCollapse={setCollapsed}
                style={styles.sider}
            >
                <div style={styles.logoContainer}>
                    {!collapsed ? (
                        <>
                            <div style={styles.logo}>
                                <BuildOutlined style={{ fontSize: 24, color: '#6366f1' }} />
                            </div>
                            <span style={styles.logoText}>高校组织管理系统</span>
                        </>
                    ) : (
                        <div style={styles.logoSmall}>
                            <BuildOutlined style={{ fontSize: 24, color: '#6366f1' }} />
                        </div>
                    )}
                </div>
                
                <Menu
                    mode="inline"
                    items={menuItems}
                    selectedKeys={[location.pathname]}
                    onClick={({ key }) => navigate(key)}
                    style={styles.menu}
                    theme="light"
                />
            </Sider>
            
            <Layout style={styles.mainLayout}>
                <Header style={styles.header}>
                    <div style={styles.headerLeft}>
                        {!collapsed && (
                            <span style={styles.pageTitle}>
                                {menuItems.find(item => item.key === location.pathname)?.label || '首页'}
                            </span>
                        )}
                    </div>
                    
                    <div style={styles.headerRight}>
                        <Dropdown menu={userMenu} placement="bottomRight">
                            <div style={styles.userMenuTrigger}>
                                <Avatar 
                                    icon={<UserOutlined />} 
                                    style={styles.avatar}
                                />
                                {!collapsed && (
                                    <>
                                        <div style={styles.userInfo}>
                                            <span style={styles.userName}>{displayName}</span>
                                            <span style={styles.userRole}>{displayRole}</span>
                                        </div>
                                        <ChevronDownOutlined style={{ fontSize: 14, color: '#64748b' }} />
                                    </>
                                )}
                            </div>
                        </Dropdown>
                    </div>
                </Header>
                
                <Content style={styles.content}>
                    <div style={styles.contentWrapper}>
                        <Outlet />
                    </div>
                </Content>
            </Layout>
        </Layout>
    );
}

const styles = {
    layout: {
        minHeight: '100vh',
        background: '#f1f5f9',
    },
    loadingContainer: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        minHeight: '100vh',
        background: '#f1f5f9',
    },
    sider: {
        background: '#ffffff',
        borderRight: '1px solid #e2e8f0',
        position: 'fixed',
        left: 0,
        top: 0,
        bottom: 0,
        zIndex: 100,
    },
    logoContainer: {
        display: 'flex',
        alignItems: 'center',
        padding: '16px 20px',
        borderBottom: '1px solid #e2e8f0',
        gap: 12,
    },
    logo: {
        width: 40,
        height: 40,
        borderRadius: 12,
        background: 'linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%)',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        boxShadow: '0 4px 12px rgba(99, 102, 241, 0.3)',
    },
    logoSmall: {
        width: 40,
        height: 40,
        borderRadius: 12,
        background: 'linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%)',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        boxShadow: '0 4px 12px rgba(99, 102, 241, 0.3)',
        margin: '0 auto',
    },
    logoText: {
        fontSize: 16,
        fontWeight: 600,
        color: '#1e293b',
        flex: 1,
    },
    menu: {
        border: 'none',
        marginTop: 16,
    },
    mainLayout: {
        marginLeft: 240,
        transition: 'margin-left 0.3s ease',
    },
    header: {
        background: '#ffffff',
        padding: '0 24px',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        borderBottom: '1px solid #e2e8f0',
        height: 64,
        boxShadow: '0 1px 3px rgba(0, 0, 0, 0.05)',
    },
    headerLeft: {
        display: 'flex',
        alignItems: 'center',
    },
    pageTitle: {
        fontSize: 18,
        fontWeight: 600,
        color: '#1e293b',
    },
    headerRight: {
        display: 'flex',
        alignItems: 'center',
        gap: 16,
    },
    userMenuTrigger: {
        display: 'flex',
        alignItems: 'center',
        gap: 12,
        padding: '8px 12px',
        borderRadius: 8,
        cursor: 'pointer',
        transition: 'all 0.2s ease',
        '&:hover': {
            background: '#f1f5f9',
        },
    },
    avatar: {
        width: 36,
        height: 36,
        background: 'linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%)',
        border: '2px solid #ffffff',
        boxShadow: '0 2px 8px rgba(99, 102, 241, 0.3)',
    },
    userInfo: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'flex-end',
    },
    userName: {
        fontSize: 14,
        fontWeight: 500,
        color: '#1e293b',
    },
    userRole: {
        fontSize: 12,
        color: '#64748b',
    },
    content: {
        margin: 24,
        minHeight: 'calc(100vh - 112px)',
    },
    contentWrapper: {
        background: '#ffffff',
        borderRadius: 12,
        padding: 24,
        boxShadow: '0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)',
    },
};
