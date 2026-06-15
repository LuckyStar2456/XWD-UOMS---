import { useState } from 'react';
import { Form, Input, Button, message, Card } from 'antd';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { UserOutlined, LockOutlined, EyeOutlined, EyeInvisibleOutlined } from '@ant-design/icons';
import { loginAPI } from '../api/auth';
import { setTokens } from '../utils/token';
import { setUserInfo } from '../store/userSlice';

export default function Login() {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const [showPassword, setShowPassword] = useState(false);
    const [loading, setLoading] = useState(false);

    const onFinish = async (values) => {
        setLoading(true);
        try {
            const res = await loginAPI(values);
            const { accessToken, refreshToken, userInfo } = res.data.data;
            setTokens(accessToken, refreshToken);
            localStorage.setItem('userId', userInfo.id);
            dispatch(setUserInfo(userInfo));
            message.success('登录成功');
            navigate('/home');
        } catch (error) {
            console.error('登录错误:', error);
            message.error(error.response?.data?.msg || '登录失败');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div style={styles.container}>
            <div style={styles.bgDecoration}></div>
            <div style={styles.cardContainer}>
                <Card style={styles.card} bordered={false}>
                    <div style={styles.logoSection}>
                        <div style={styles.logo}>
                            <UserOutlined style={{ fontSize: 32, color: '#6366f1' }} />
                        </div>
                        <h1 style={styles.title}>高校组织信息管理系统</h1>
                        <p style={styles.subtitle}>高效管理，智能协作</p>
                    </div>
                    
                    <Form 
                        onFinish={onFinish} 
                        style={styles.form}
                        size="large"
                    >
                        <Form.Item 
                            name="username" 
                            rules={[
                                { required: true, message: '请输入用户名' },
                                { min: 3, message: '用户名至少3个字符' }
                            ]}
                        >
                            <Input 
                                placeholder="用户名" 
                                prefix={<UserOutlined style={{ color: '#94a3b8' }} />}
                                style={styles.input}
                            />
                        </Form.Item>
                        
                        <Form.Item 
                            name="password" 
                            rules={[
                                { required: true, message: '请输入密码' },
                                { min: 6, message: '密码至少6个字符' }
                            ]}
                        >
                            <Input.Password
                                placeholder="密码"
                                prefix={<LockOutlined style={{ color: '#94a3b8' }} />}
                                iconRender={(visible) => (
                                    visible ? <EyeInvisibleOutlined /> : <EyeOutlined />
                                )}
                                style={styles.input}
                            />
                        </Form.Item>
                        
                        <Form.Item>
                            <Button 
                                type="primary" 
                                htmlType="submit" 
                                block
                                loading={loading}
                                style={styles.button}
                            >
                                登录
                            </Button>
                        </Form.Item>
                    </Form>
                    
                    <div style={styles.footer}>
                        <p style={styles.copyright}>© 2024 向往科技</p>
                    </div>
                </Card>
            </div>
        </div>
    );
}

const styles = {
    container: {
        minHeight: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        background: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)',
        position: 'relative',
        overflow: 'hidden',
    },
    bgDecoration: {
        position: 'absolute',
        width: '600px',
        height: '600px',
        background: 'radial-gradient(circle, rgba(255,255,255,0.1) 0%, transparent 70%)',
        borderRadius: '50%',
        top: '-100px',
        right: '-100px',
    },
    cardContainer: {
        zIndex: 1,
        animation: 'fadeInUp 0.6s ease-out',
    },
    card: {
        width: '400px',
        borderRadius: '16px',
        boxShadow: '0 20px 60px rgba(0, 0, 0, 0.3)',
        padding: '32px',
        backgroundColor: 'rgba(255, 255, 255, 0.95)',
        backdropFilter: 'blur(10px)',
    },
    logoSection: {
        textAlign: 'center',
        marginBottom: '32px',
    },
    logo: {
        width: '80px',
        height: '80px',
        margin: '0 auto 16px',
        borderRadius: '50%',
        background: 'linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%)',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        boxShadow: '0 8px 32px rgba(99, 102, 241, 0.4)',
    },
    title: {
        fontSize: '24px',
        fontWeight: 600,
        color: '#1e293b',
        margin: '0 0 8px',
    },
    subtitle: {
        fontSize: '14px',
        color: '#64748b',
        margin: 0,
    },
    form: {
        marginBottom: '16px',
    },
    input: {
        borderRadius: '8px',
        height: '44px',
        borderColor: '#e2e8f0',
        '&:focus': {
            borderColor: '#6366f1',
            boxShadow: '0 0 0 3px rgba(99, 102, 241, 0.1)',
        },
    },
    button: {
        height: '44px',
        borderRadius: '8px',
        background: 'linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%)',
        border: 'none',
        fontSize: '16px',
        fontWeight: 500,
        transition: 'all 0.3s ease',
        '&:hover': {
            transform: 'translateY(-2px)',
            boxShadow: '0 8px 20px rgba(99, 102, 241, 0.4)',
        },
    },
    footer: {
        textAlign: 'center',
        paddingTop: '16px',
        borderTop: '1px solid #e2e8f0',
    },
    copyright: {
        fontSize: '12px',
        color: '#94a3b8',
        margin: 0,
    },
};
