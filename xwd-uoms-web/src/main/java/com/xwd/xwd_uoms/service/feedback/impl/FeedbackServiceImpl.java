package com.xwd.xwd_uoms.service.feedback.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysFeedbackDefaultConfig;
import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.repository.SysFeedbackRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.feedback.FeedbackService;
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
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysFeedbackDefaultConfig sysFeedbackDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void feedbackAdd(SysFeedbackEntity feedback){
        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(feedback)){
            throw new IllegalArgumentException("反馈表不可为空.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(feedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedback.getFeedbackUserId()) ||
                !verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("反馈人信息不存在.");
        }
        if (!verifyUtil.isExist(feedback.getTargetObject())){
            throw new IllegalArgumentException("反馈目标不可为空.");
        }
        SysUserEntity handlerUser = sysUserRepository.findSysUserEntityById(feedback.getHandlerUserId());
        if (!verifyUtil.isExist(feedback.getHandlerUserId()) ||
                !verifyUtil.isExist(handlerUser)){
            throw new IllegalArgumentException("反馈对象信息不存在.");
        }

        feedback.setFeedbackTime(now);
        feedback.setFeedbackStatus(sysFeedbackDefaultConfig.getFeedbackStatus());
        feedback.setIsDeleted(sysFeedbackDefaultConfig.getIsDeleted());
        feedback.setCreateDate(now);
        feedback.setUpdateDate(now);

        sysFeedbackRepository.save(feedback);
    }

    @Override
    public void feedbackUpdate(SysFeedbackEntity feedback){
        LocalDate now = LocalDate.now();
        SysFeedbackEntity oldFeedback = sysFeedbackRepository.findSysFeedbackEntityById(feedback.getId());
        if (!verifyUtil.isExist(oldFeedback)){
            throw new IllegalArgumentException("反馈信息不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(feedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedback.getFeedbackUserId()) ||
                !verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("反馈人信息不存在.");
        }
        if (!verifyUtil.isExist(feedback.getTargetObject())){
            throw new IllegalArgumentException("反馈目标不可为空.");
        }
        SysUserEntity handlerUser = sysUserRepository.findSysUserEntityById(feedback.getHandlerUserId());
        if (!verifyUtil.isExist(feedback.getHandlerUserId()) ||
                !verifyUtil.isExist(handlerUser)){
            throw new IllegalArgumentException("反馈对象信息不存在.");
        }
        oldFeedback.setTargetObject(feedback.getTargetObject());
        if (verifyUtil.isExist(feedback.getFeedbackContent()) &&
                !Objects.equals(feedback.getFeedbackContent(),oldFeedback.getFeedbackContent())) {
            oldFeedback.setFeedbackContent(feedback.getFeedbackContent());
            oldFeedback.setFeedbackTime(now);
        }
        if (verifyUtil.isExist(feedback.getFeedbackStatus()) &&
                !Objects.equals(oldFeedback.getFeedbackStatus(),feedback.getFeedbackStatus())){
            oldFeedback.setFeedbackStatus(feedback.getFeedbackStatus());
            oldFeedback.setHandleTime(now);
        }
        if (verifyUtil.isExist(feedback.getRemark())){
            oldFeedback.setRemark(feedback.getRemark());
        }
        if (!verifyUtil.isExist(oldFeedback.getCreateDate())){
            oldFeedback.setCreateDate(now);
        }
        oldFeedback.setUpdateDate(now);
        sysFeedbackRepository.save(oldFeedback);
    }

    @Override
    public void approveFeedback(SysFeedbackEntity feedback){
        LocalDate now = LocalDate.now();
        SysFeedbackEntity oldFeedback = sysFeedbackRepository.findSysFeedbackEntityById(feedback.getId());
        if (!verifyUtil.isExist(oldFeedback)){
            throw new IllegalArgumentException("反馈信息不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(feedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedback.getFeedbackUserId()) ||
                !verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("反馈人信息不存在.");
        }
        if (!verifyUtil.isExist(feedback.getTargetObject())){
            throw new IllegalArgumentException("反馈目标不可为空.");
        }
        SysUserEntity handlerUser = sysUserRepository.findSysUserEntityById(feedback.getHandlerUserId());
        if (!verifyUtil.isExist(feedback.getHandlerUserId()) ||
                !verifyUtil.isExist(handlerUser)){
            throw new IllegalArgumentException("反馈对象信息不存在.");
        }
        oldFeedback.setFeedbackStatus(feedback.getFeedbackStatus());
        oldFeedback.setRemark(feedback.getRemark());
        oldFeedback.setHandleTime(now);
        if (!verifyUtil.isExist(oldFeedback.getCreateDate())){
            oldFeedback.setCreateDate(now);
        }
        oldFeedback.setUpdateDate(now);
        sysFeedbackRepository.save(oldFeedback);
    }

    @Override
    public void feedbackDeleted(Long feedbackId){
        SysFeedbackEntity feedback  = sysFeedbackRepository.findSysFeedbackEntityById(feedbackId);
        if (!verifyUtil.isExist(feedback)){
            throw new IllegalArgumentException("反馈表不存在.");
        }
        feedback.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        feedback.setUpdateDate(now);

        sysFeedbackRepository.save(feedback);
    }

    @Override
    public Page<SysFeedbackEntity> showRecFeedback(Long handlerUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysFeedbackEntity> page = sysFeedbackRepository.findAllByHandlerUserId(handlerUserId,pageable);
        return page;
    }

    @Override
    public Page<SysFeedbackEntity> showPendFeedback(Long feedbackUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysFeedbackEntity> page = sysFeedbackRepository.findAllByFeedbackUserId(feedbackUserId,pageable);
        return page;
    }

    @Override
    public SysFeedbackEntity showFeedback(Long feedbackId){
        SysFeedbackEntity feedback = sysFeedbackRepository.findSysFeedbackEntityById(feedbackId);
        if (!verifyUtil.isExist(feedback)){
            throw new IllegalArgumentException("反馈表不存在.");
        }
        return feedback;
    }
}
