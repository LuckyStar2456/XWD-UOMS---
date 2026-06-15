// src/pages/Profile.jsx
import { Form, Input, Button, message, Card, Popconfirm } from 'antd';
import { useSelector, useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { updateSelf, cancelSelf } from '../api/user';
import { getRefreshToken, removeTokens } from '../utils/token';
import { logout } from '../store/userSlice';

export default function Profile() {
    const userInfo = useSelector(state => state.user.userInfo);
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [form] = Form.useForm();

    const onFinish = async (values) => {
        await updateSelf(userInfo.id, values);
        message.success('个人信息更新成功');
    };

    const handleCancel = async () => {
        const refreshToken = getRefreshToken();
        if (refreshToken) {
            await cancelSelf(refreshToken);
        }
        removeTokens();
        dispatch(logout());
        message.success('账号已注销');
        navigate('/login');
    };

    return (
        <Card title="个人资料">
            <Form form={form} onFinish={onFinish} initialValues={userInfo} layout="vertical">
                <Form.Item name="name" label="姓名"><Input /></Form.Item>
                <Form.Item name="phone" label="手机号"><Input /></Form.Item>
                <Form.Item name="email" label="邮箱"><Input /></Form.Item>
                <Form.Item name="grade" label="年级"><Input /></Form.Item>
                <Form.Item name="password" label="新密码"><Input.Password /></Form.Item>
                <Form.Item>
                    <Button type="primary" htmlType="submit">保存修改</Button>
                    <Popconfirm title="确定注销账号？注销后无法恢复。" onConfirm={handleCancel} style={{ marginLeft: 16 }}>
                        <Button danger>注销账号</Button>
                    </Popconfirm>
                </Form.Item>
            </Form>
        </Card>
    );
}