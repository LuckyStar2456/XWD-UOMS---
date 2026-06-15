import { Modal, Form, Input, message } from 'antd'
import { useSelector } from 'react-redux'
import { addApply } from '../api/apply'

export default function ApplyModal({ visible, onCancel, targetObject, operationCode, applyDesc }) {
    const [form] = Form.useForm()
    const userInfo = useSelector(state => state.user.userInfo)

    const handleOk = async () => {
        try {
            const values = await form.validateFields()
            const applyData = {
                applyUserId: userInfo.id,
                applyOperationCode: operationCode,
                targetObject,
                applyDesc: applyDesc || values.applyDesc,
                applyContent: values.applyContent || {},
                approverUserId: 3, // 这里需要动态获取审批人ID，示例写死组织主席ID=3，实际应调用接口查询
            }
            await addApply(applyData)
            message.success('申请已提交，等待审批')
            onCancel()
        } catch (error) {
            message.error('提交申请失败')
        }
    }

    return (
        <Modal title="提交申请" open={visible} onOk={handleOk} onCancel={onCancel}>
            <Form form={form} layout="vertical">
                <Form.Item name="applyDesc" label="申请理由" rules={[{ required: true }]}>
                    <Input.TextArea rows={3} />
                </Form.Item>
                <Form.Item name="applyContent" label="申请内容（JSON格式）">
                    <Input.TextArea rows={2} placeholder='{"key":"value"}' />
                </Form.Item>
            </Form>
        </Modal>
    )
}