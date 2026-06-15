package com.xwd.xwd_uoms.service.home.impl;

import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.repository.*;
import com.xwd.xwd_uoms.service.home.HomeService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysApplyRepository sysApplyRepository;

    @Resource
    private SysNoticeRepository sysNoticeRepository;

    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysEquipmentBorrowRepository sysEquipmentBorrowRepository;

    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Override
    public Page<SysApplyEntity> showUnfApply(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysApplyEntity> page = sysApplyRepository.findAllByApproverUserIdAndApplyStatus(userId, (byte) 0, pageable);
        return page;
    }

    @Override
    public Page<SysTaskEntity> showUnfTask(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskEntity> page = sysTaskRepository.findAllByMandatoryIdAndStatus(userId,(byte)0,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showUnfEquipBorrow(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByBorrowerIdAndStatus(userId,(byte)0,pageable);
        return page;
    }

    @Override
    public Page<SysFeedbackEntity> showUnfFeedBack(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysFeedbackEntity> page = sysFeedbackRepository.findAllByHandlerUserIdAndFeedbackStatus(userId,(byte)0,pageable);
        return page;
    }

    @Override
    public Page<SysNoticeEntity> showRecNotice(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysNoticeEntity> page = sysNoticeRepository.findAllByMandatoryId(userId,pageable);
        return page;
    }

    @Override
    public Page<SysUserEntity> showAdmin(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByRoleIdNot(2L,pageable);
        return page;
    }
}
