package com.xwd.xwd_uoms.service.taskfeedback.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysTaskFeedbackDefaultConfig;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.repository.SysTaskFeedbackRepository;
import com.xwd.xwd_uoms.repository.SysTaskRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.task.TaskService;
import com.xwd.xwd_uoms.service.taskfeedback.TaskFeedbackService;
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
public class TaskFeedbackServiceImpl implements TaskFeedbackService {
    @Resource
    private SysTaskFeedbackRepository sysTaskFeedbackRepository;

    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysTaskFeedbackDefaultConfig sysTaskFeedbackDefaultConfig;

    @Resource
    private TaskService taskService;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void taskFeedbackUpdate(SysTaskFeedbackEntity taskFeedback){
        SysTaskFeedbackEntity oldTaskFeedback = sysTaskFeedbackRepository.findSysTaskFeedbackEntityById(taskFeedback.getId());
        if (!verifyUtil.isExist(oldTaskFeedback)){
            throw new IllegalArgumentException("任务反馈表不存在.");
        }
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(taskFeedback.getTaskId());
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(taskFeedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("提交用户不存在.");
        }
        SysUserEntity reviewUser = sysUserRepository.findSysUserEntityById(taskFeedback.getReviewUserId());
        if (!verifyUtil.isExist(reviewUser)){
            throw new IllegalArgumentException("验收用户不存在.");
        }
        if (!Objects.equals(taskFeedback.getReviewUserId(),task.getOriginatorId())){
            throw new IllegalArgumentException("验收用户与任务发起人不匹配.");
        }
        if (!verifyUtil.isExist(oldTaskFeedback.getReviewStatus())){
            oldTaskFeedback.setReviewStatus(sysTaskFeedbackDefaultConfig.getReviewStatus());
        }

        oldTaskFeedback.setTaskId(taskFeedback.getTaskId());
        oldTaskFeedback.setFeedbackUserId(taskFeedback.getFeedbackUserId());
        oldTaskFeedback.setReviewUserId(taskFeedback.getReviewUserId());
        if (verifyUtil.isExist(taskFeedback.getFeedbackContent())){
            oldTaskFeedback.setFeedbackContent(taskFeedback.getFeedbackContent());
        }

        LocalDate now = LocalDate.now();
        oldTaskFeedback.setFeedbackTime(now);

        if (!verifyUtil.isExist(oldTaskFeedback.getCreateDate())){
            oldTaskFeedback.setCreateDate(now);
        }
        oldTaskFeedback.setUpdateDate(now);
        taskService.finiTask(task);
        sysTaskFeedbackRepository.save(oldTaskFeedback);
    }

    @Override
    public void taskFeedbackAdd(SysTaskFeedbackEntity taskFeedback){
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(taskFeedback.getTaskId());
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(taskFeedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("提交用户不存在.");
        }
        SysUserEntity reviewUser = sysUserRepository.findSysUserEntityById(taskFeedback.getReviewUserId());
        if (!verifyUtil.isExist(reviewUser)){
            throw new IllegalArgumentException("验收用户不存在.");
        }
        if (!Objects.equals(taskFeedback.getReviewUserId(),task.getOriginatorId())){
            throw new IllegalArgumentException("验收用户与任务发起人不匹配.");
        }
        taskFeedback.setReviewStatus(sysTaskFeedbackDefaultConfig.getReviewStatus());

        LocalDate now = LocalDate.now();
        taskFeedback.setFeedbackTime(now);
        taskFeedback.setCreateDate(now);
        taskFeedback.setUpdateDate(now);
        taskService.finiTask(task);

        sysTaskFeedbackRepository.save(taskFeedback);
    }

    @Override
    public Page<SysTaskFeedbackEntity> showRecTaskFeedback(Long reviewUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskFeedbackEntity> page = sysTaskFeedbackRepository.findAllByReviewUserId(reviewUserId,pageable);
        return page;
    }

    @Override
    public Page<SysTaskFeedbackEntity> showPendTaskFeedback(Long feedbackUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskFeedbackEntity> page = sysTaskFeedbackRepository.findAllByFeedbackUserId(feedbackUserId,pageable);
        return page;
    }

    @Override
    public void approveTaskFeedback(Long reviewUserId, SysTaskFeedbackEntity taskFeedback){
        LocalDate now = LocalDate.now();
        SysUserEntity reviewUser = sysUserRepository.findSysUserEntityById(reviewUserId);
        if (!verifyUtil.isExist(reviewUser) ||
                !Objects.equals(reviewUserId,taskFeedback.getReviewUserId())){
            throw new IllegalArgumentException("验收用户错误.");
        }
        SysTaskFeedbackEntity oldTaskFeedback = sysTaskFeedbackRepository.findSysTaskFeedbackEntityById(taskFeedback.getId());
        if (!verifyUtil.isExist(oldTaskFeedback)){
            throw new IllegalArgumentException("任务反馈不存在.");
        }
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(oldTaskFeedback.getTaskId());
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        if (taskFeedback.getReviewStatus() == (byte)2){
            task.setStatus((byte)4);
            oldTaskFeedback.setReviewStatus(taskFeedback.getReviewStatus());
        }else if (taskFeedback.getReviewStatus() == (byte)1){
            task.setStatus((byte)2);
            oldTaskFeedback.setReviewStatus(taskFeedback.getReviewStatus());
        }else {
            throw new IllegalArgumentException("验收结果异常.");
        }
        oldTaskFeedback.setReviewContent(taskFeedback.getFeedbackContent());

        oldTaskFeedback.setReviewTime(now);
        taskService.finiTask(task);
        if (!verifyUtil.isExist(oldTaskFeedback.getCreateDate())){
            oldTaskFeedback.setCreateDate(now);
        }
        oldTaskFeedback.setUpdateDate(now);
        sysTaskFeedbackRepository.save(oldTaskFeedback);
    }

    @Override
    public SysTaskFeedbackEntity showTaskFeedback(Long taskFeedbackId){
        SysTaskFeedbackEntity taskFeedback = sysTaskFeedbackRepository.findSysTaskFeedbackEntityById(taskFeedbackId);
        if (!verifyUtil.isExist(taskFeedback)){
            throw new IllegalArgumentException("任务反馈表不存在.");
        }
        return taskFeedback;
    }
}
