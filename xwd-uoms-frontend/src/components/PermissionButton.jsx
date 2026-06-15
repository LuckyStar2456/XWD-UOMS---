import { Button, message } from 'antd'
import { useState } from 'react'
import { useSelector } from 'react-redux'
import ApplyModal from './ApplyModal'

export default function PermissionButton({ requiredRoleIds, targetObject, operationCode, applyDesc, onPermissionGranted, children, ...buttonProps }) {
    const userRoleId = useSelector(state => state.user.userInfo?.roleId)
    const [applyVisible, setApplyVisible] = useState(false)

    const hasPermission = requiredRoleIds.includes(userRoleId)

    const handleClick = () => {
        if (hasPermission) {
            onPermissionGranted?.()
        } else {
            setApplyVisible(true)
        }
    }

    return (
        <>
            <Button {...buttonProps} onClick={handleClick}>
                {children}
            </Button>
            <ApplyModal
                visible={applyVisible}
                onCancel={() => setApplyVisible(false)}
                targetObject={targetObject}
                operationCode={operationCode}
                applyDesc={applyDesc}
            />
        </>
    )
}