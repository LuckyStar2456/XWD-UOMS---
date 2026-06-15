package com.xwd.xwd_uoms.service.apply.impl;

import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.*;
import com.xwd.xwd_uoms.service.apply.ApplyService;
import com.xwd.xwd_uoms.service.dept.DeptService;
import com.xwd.xwd_uoms.service.equip.EquipService;
import com.xwd.xwd_uoms.service.feedback.FeedbackService;
import com.xwd.xwd_uoms.service.notice.NoticeService;
import com.xwd.xwd_uoms.service.org.OrgService;
import com.xwd.xwd_uoms.service.task.TaskService;
import com.xwd.xwd_uoms.service.taskfeedback.TaskFeedbackService;
import com.xwd.xwd_uoms.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class ApplyServiceImpl implements ApplyService {
    @Resource
    private ConvertUtil convertUtil;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private SysApplyRepository sysApplyRepository;

    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysNoticeRepository sysNoticeRepository;

    @Resource
    private SysTaskFeedbackRepository sysTaskFeedbackRepository;

    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Resource
    private UserService userService;

    @Resource
    private OrgService orgService;

    @Resource
    private DeptService deptService;

    @Resource
    private EquipService equipService;

    @Resource
    private NoticeService noticeService;

    @Resource
    private TaskService taskService;

    @Resource
    private FeedbackService feedbackService;

    @Resource
    private TaskFeedbackService taskFeedbackService;

    @Override
    public void createApply(SysApplyEntity apply) {
        String type = apply.getTargetObject();
        Long approveUserRoleId = sysUserRepository.findRoleIdById(apply.getApproverUserId());
        if (!verifyUtil.isExist(approveUserRoleId) ||
                !verifyUtil.hasPerm(approveUserRoleId,type,apply.getApplyOperationCode())){
            throw new IllegalArgumentException("目标审批用户无权审批此操作.");
        }
        switch (type){
            case "user":{
                SysUserDTO user = convertUtil.mapSOToUserDTO(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")) {
                    Long userId = user.getId();
                    if (!verifyUtil.isExist(userId) || !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(userId))) {
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "org":{
                SysOrganizationEntity org = convertUtil.mapSOToOrgEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long orgId = org.getId();
                    if (!verifyUtil.isExist(orgId) || !verifyUtil.isExist(sysOrganizationRepository.findSysOrganizationEntityById(orgId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "dept":{
                SysDepartmentEntity dept = convertUtil.mapSOToDeptEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long deptId = dept.getId();
                    if (!verifyUtil.isExist(deptId) || !verifyUtil.isExist(sysDepartmentRepository.findSysDepartmentEntityById(deptId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "equip":{
                SysEquipmentEntity equip = convertUtil.mapSOToEquipEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long equipId = equip.getId();
                    if (!verifyUtil.isExist(equipId) || !verifyUtil.isExist(sysEquipmentRepository.findSysEquipmentEntityById(equipId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "task": {
                SysTaskEntity task = convertUtil.mapSOToTaskEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long taskId = task.getId();
                    if (!verifyUtil.isExist(taskId) || !verifyUtil.isExist(sysTaskRepository.findSysTaskEntityById(taskId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "notice": {
                SysNoticeEntity notice = convertUtil.mapSOToNoticeEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long noticeId = notice.getId();
                    if (!verifyUtil.isExist(noticeId) || !verifyUtil.isExist(sysNoticeRepository.findSysNoticeEntityById(noticeId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "feedback": {
                SysFeedbackEntity feedback = convertUtil.mapSOToFeedbackEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long feedbackId = feedback.getId();
                    if (!verifyUtil.isExist(feedbackId) || !verifyUtil.isExist(sysFeedbackRepository.findSysFeedbackById(feedbackId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "taskFeedback": {
                SysTaskFeedbackEntity taskFeedback = convertUtil.mapSOToTaskFeedbackEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long taskFeedbackId = taskFeedback.getId();
                    if (!verifyUtil.isExist(taskFeedbackId) || !verifyUtil.isExist(sysTaskFeedbackRepository.findSysTaskFeedbackById(taskFeedbackId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } default :{
                throw new IllegalArgumentException("申请目标类型不存在.");
            }
        }
    }

    @Override
    public Page<SysApplyEntity> showPendApply(Long applyUserId,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysApplyEntity> page = sysApplyRepository.findAllByApplyUserId(applyUserId,pageable);
        return page;
    }

    @Override
    public Page<SysApplyEntity> showRecApply(Long approveUserId,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysApplyEntity> page = sysApplyRepository.findAllByApplyUserId(approveUserId,pageable);
        return page;
    }

    @Override
    public void approveApply(Long approveUserId, SysApplyEntity apply) throws Exception {
        if (Objects.equals(apply.getApplyStatus(),(byte)1)) {
            if (!verifyUtil.isExist(apply)) {
                throw new IllegalArgumentException("申请表不存在.");
            }
            if (!Objects.equals(apply.getApproverUserId(), approveUserId)) {
                throw new IllegalArgumentException("审批人不匹配.");
            }
            String type = apply.getTargetObject();
            switch (type) {
                case "user": {
                    SysUserDTO user = convertUtil.mapSOToUserDTO(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("add")) {
                        userService.userAdd(user);
                    } else if (apply.getApplyOperationCode().equals("update")){
                        userService.userUpdate(user);
                    } else if (apply.getApplyOperationCode().equals("deleted")){
                        userService.userDelete(user.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "org": {
                    SysOrganizationEntity org = convertUtil.mapSOToOrgEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        orgService.orgUpdate(org);
                    } else if(apply.getApplyOperationCode().equals("add")){
                        orgService.orgAdd(org);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        orgService.orgDeleted(org.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "dept": {
                    SysDepartmentEntity dept = convertUtil.mapSOToDeptEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        deptService.deptUpdate(dept);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        deptService.deptAdd(dept);
                    } else if (apply.getApplyOperationCode().equals("deleted")){
                        deptService.deptDeleted(dept.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "equip": {
                    SysEquipmentEntity equip = convertUtil.mapSOToEquipEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        equipService.equipUpdate(equip);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        equipService.equipAdd(equip);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        equipService.equipDeleted(equip.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "task": {
                    SysTaskEntity task = convertUtil.mapSOToTaskEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        taskService.taskUpdate(task);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        taskService.taskAdd(task);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        taskService.taskDeleted(task.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "notice": {
                    SysNoticeEntity notice = convertUtil.mapSOToNoticeEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        noticeService.noticeUpdate(notice);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        noticeService.noticeAdd(notice);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        noticeService.noticeDeleted(notice.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "feedback": {
                    SysFeedbackEntity feedback = convertUtil.mapSOToFeedbackEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        feedbackService.feedbackUpdate(feedback);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        feedbackService.feedbackAdd(feedback);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        feedbackService.feedbackDeleted(feedback.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "taskFeedback": {
                    SysTaskFeedbackEntity taskFeedback = convertUtil.mapSOToTaskFeedbackEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        taskFeedbackService.taskFeedbackUpdate(taskFeedback);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        taskFeedbackService.taskFeedbackAdd(taskFeedback);
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                default: {
                    throw new IllegalArgumentException("目标代码不存在.");
                }
            }
        }
        sysApplyRepository.save(apply);
    }

    @Override
    public void deletedApply(Long applyId){
        SysApplyEntity apply = sysApplyRepository.findSysApplyEntityById(applyId);
        if (!verifyUtil.isExist(apply)){
            throw new IllegalArgumentException("申请表不存在.");
        }

        apply.setIsDeleted((byte)1);
        LocalDate now = LocalDate.now();
        apply.setUpdateDate(now);
        sysApplyRepository.save(apply);
    }

    @Override
    public SysApplyEntity showApply(Long applyId){
        SysApplyEntity apply = sysApplyRepository.findSysApplyEntityById(applyId);
        if (!verifyUtil.isExist(apply)){
            throw new IllegalArgumentException("申请表不存在.");
        }
        return apply;
    }
}
