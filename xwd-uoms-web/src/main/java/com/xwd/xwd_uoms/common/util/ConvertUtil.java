package com.xwd.xwd_uoms.common.util;

import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class ConvertUtil {
    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    public SysUserDTO userToDTO(SysUserEntity user){
        SysUserDTO userDTO = new SysUserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setGrade(user.getGrade());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setUsername(user.getUsername());
        userDTO.setRoleId(user.getRoleId());
        String deptName = sysDepartmentRepository.findNameById(user.getDeptId());
        if (verifyUtil.isExist(deptName)){
            userDTO.setDeptName(deptName);
        }
        String orgName = sysOrganizationRepository.findNameById(user.getOrgId());
        String orgType = sysOrganizationRepository.findTypeById(user.getOrgId());
        if (verifyUtil.isExist(orgName) && verifyUtil.isExist(orgType)){
            userDTO.setOrgName(orgName);
            userDTO.setOrgType(orgType);
        }
        return userDTO;
    }

    public SysUserDTO mapSOToUserDTO(Map<String,Object> map){
        SysUserDTO user = new SysUserDTO();
        LocalDate now = LocalDate.now();
        try {
            user.setId((Long) map.get("id"));
            user.setOrgName((String) map.get("orgName"));
            user.setDeptName((String) map.get("deptName"));
            user.setName((String) map.get("name"));
            user.setGrade((String) map.get("grade"));
            user.setEmail((String) map.get("email"));
            user.setPhone((String) map.get("phone"));
            user.setUsername((String) map.get("username"));
            user.setPassword((String) map.get("password"));
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return user;
    }

    public SysOrganizationEntity mapSOToOrgEntity(Map<String,Object> map){
        SysOrganizationEntity org = new SysOrganizationEntity();
        LocalDate now = LocalDate.now();
        try {
            org.setId((Long) map.get("id"));
            org.setName((String) map.get("name"));
            org.setType((String) map.get("type"));
            org.setOrgDesc((String) map.get("orgDesc"));
            org.setAddress((String) map.get("address"));
            org.setPhone((String) map.get("phone"));
            org.setStatus((byte) map.get("status"));
            org.setIsDeleted((byte) map.get("isDeleted"));
            org.setCreateDate((LocalDate) map.get("createDate"));
            org.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return org;
    }

    public SysDepartmentEntity mapSOToDeptEntity(Map<String,Object> map){
        SysDepartmentEntity dept = new SysDepartmentEntity();
        LocalDate now = LocalDate.now();
        try {
            dept.setId((Long) map.get("id"));
            dept.setOrgId((Long) map.get("orgId"));
            dept.setName((String) map.get("name"));
            dept.setDeptDesc((String) map.get("deptDesc"));
            dept.setStatus((byte) map.get("status"));
            dept.setIsDeleted((byte) map.get("isDeleted"));
            dept.setCreateDate((LocalDate) map.get("createDate"));
            dept.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return dept;
    }

    public SysEquipmentEntity mapSOToEquipEntity(Map<String,Object> map){
        SysEquipmentEntity equip = new SysEquipmentEntity();
        LocalDate now = LocalDate.now();
        try {
            equip.setId((Long) map.get("id"));
            equip.setOrgId((Long) map.get("orgId"));
            equip.setDeptId((Long) map.get("deptId"));
            equip.setTotalNum((Integer) map.get("totalNum"));
            equip.setAvailableNum((Integer) map.get("availableNum"));
            equip.setName((String) map.get("name"));
            equip.setEquipmentDesc((String) map.get("equipDesc"));
            equip.setStatus((byte) map.get("status"));
            equip.setIsDeleted((byte) map.get("isDeleted"));
            equip.setCreateDate((LocalDate) map.get("createDate"));
            equip.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return equip;
    }

    public SysNoticeEntity mapSOToNoticeEntity(Map<String,Object> map){
        SysNoticeEntity notice = new SysNoticeEntity();
        LocalDate now = LocalDate.now();
        try {
            notice.setId((Long) map.get("id"));
            notice.setMandatoryId((Long) map.get("mandatoryId"));
            notice.setOriginatorId((Long) map.get("originatorId"));
            notice.setContent((String) map.get("content"));
            notice.setName((String) map.get("name"));
            notice.setIsDeleted((byte) map.get("isDeleted"));
            notice.setCreateDate((LocalDate) map.get("createDate"));
            notice.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return notice;
    }

    public SysTaskEntity mapSOToTaskEntity(Map<String,Object> map){
        SysTaskEntity task = new SysTaskEntity();
        LocalDate now = LocalDate.now();
        try {
            task.setId((Long) map.get("id"));
            task.setMandatoryId((Long) map.get("mandatoryId"));
            task.setOriginatorId((Long) map.get("originatorId"));
            task.setTaskDesc((String) map.get("taskDesc"));
            task.setName((String) map.get("name"));
            task.setStatus((byte) map.get("status"));
            task.setIsDeleted((byte) map.get("isDeleted"));
            task.setDeadline((LocalDate) map.get("deadline"));
            task.setCreateDate((LocalDate) map.get("createDate"));
            task.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return task;
    }

    public SysFeedbackEntity mapSOToFeedbackEntity(Map<String, Object> map) {
        SysFeedbackEntity feedback = new SysFeedbackEntity();
        LocalDate now = LocalDate.now();
        try {
            feedback.setId((Long) map.get("id"));
            feedback.setFeedbackUserId((Long) map.get("feedbackUserId"));
            feedback.setHandlerUserId((Long) map.get("handlerUserId"));
            feedback.setTargetObject((String) map.get("targetObject"));
            feedback.setFeedbackContent((String) map.get("feedbackContent"));
            feedback.setRemark((String) map.get("remark"));
            feedback.setFeedbackStatus((byte) map.get("feedbackStatus"));
            feedback.setIsDeleted((byte) map.get("isDeleted"));
            feedback.setFeedbackTime((LocalDate) map.get("feedbackTime"));
            feedback.setHandleTime((LocalDate) map.get("handleTime"));
            feedback.setCreateDate((LocalDate) map.get("createDate"));
            feedback.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return feedback;
    }

    public SysTaskFeedbackEntity mapSOToTaskFeedbackEntity(Map<String, Object> map) {
        SysTaskFeedbackEntity taskFeedback = new SysTaskFeedbackEntity();
        LocalDate now = LocalDate.now();
        try {
            taskFeedback.setId((Long) map.get("id"));
            taskFeedback.setTaskId((Long) map.get("taskId"));
            taskFeedback.setFeedbackUserId((Long) map.get("feedbackUserId"));
            taskFeedback.setReviewUserId((Long) map.get("reviewUserId"));
            taskFeedback.setFeedbackContent((String) map.get("feedbackContent"));
            taskFeedback.setReviewContent((String) map.get("reviewContent"));
            taskFeedback.setReviewStatus((byte) map.get("reviewStatus"));
            taskFeedback.setFeedbackTime((LocalDate) map.get("feedbackTime"));
            taskFeedback.setReviewTime((LocalDate) map.get("reviewTime"));
            taskFeedback.setCreateDate((LocalDate) map.get("createDate"));
            taskFeedback.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return taskFeedback;
    }
}
