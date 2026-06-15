package com.xwd.xwd_uoms.service.notice.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysNoticeDefaultConfig;
import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import com.xwd.xwd_uoms.repository.SysNoticeRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.notice.NoticeService;
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
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private SysNoticeRepository sysNoticeRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysNoticeDefaultConfig sysNoticeDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void noticeAdd(SysNoticeEntity notice) {
        if (!verifyUtil.isExist(notice.getName())){
            throw new IllegalArgumentException("通知标题不可为空.");
        }
        if (!verifyUtil.isExist(notice.getOriginatorId()) ||
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getOriginatorId()))){
            throw new IllegalArgumentException("通知发起人不存在.");
        }
        if (!verifyUtil.isExist(notice.getMandatoryId()) ||
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getMandatoryId()))){
            throw new IllegalArgumentException("通知对象不可为空.");
        }
        notice.setIsDeleted(sysNoticeDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        notice.setCreateDate(now);
        notice.setUpdateDate(now);

        sysNoticeRepository.save(notice);
    }

    @Override
    public void noticeUpdate(SysNoticeEntity notice) {
        Long noticeId = notice.getId();
        SysNoticeEntity oldNotice = sysNoticeRepository.findSysNoticeEntityById(noticeId);
        if (!verifyUtil.isExist(oldNotice)){
            throw new IllegalArgumentException("通知不存在.");
        }
        if (!verifyUtil.isExist(notice.getName())){
            throw new IllegalArgumentException("通知标题不可为空.");
        }
        oldNotice.setName(notice.getName());
        oldNotice.setContent(notice.getContent());
        if (!Objects.equals(notice.getOriginatorId(),oldNotice.getOriginatorId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getOriginatorId()))){
            throw new IllegalArgumentException("通知发起人不存在.");
        }
        if (!Objects.equals(notice.getMandatoryId(),oldNotice.getMandatoryId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getMandatoryId()))){
            throw new IllegalArgumentException("通知接收人不存在.");
        }
        oldNotice.setOriginatorId(notice.getOriginatorId());
        oldNotice.setMandatoryId(notice.getMandatoryId());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldNotice.getCreateDate())){
            oldNotice.setCreateDate(now);
        }
        oldNotice.setUpdateDate(now);
        sysNoticeRepository.save(oldNotice);
    }

    @Override
    public Page<SysNoticeEntity> showRecNotice(Long mandatoryId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysNoticeEntity> page = sysNoticeRepository.findAllByMandatoryId(mandatoryId,pageable);
        return page;
    }

    @Override
    public Page<SysNoticeEntity> showIniNotice(Long originatorId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysNoticeEntity> page = sysNoticeRepository.findAllByOriginatorId(originatorId,pageable);
        return page;
    }

    @Override
    public void noticeDeleted(Long noticeId){
        SysNoticeEntity notice = sysNoticeRepository.findSysNoticeEntityById(noticeId);
        if (!verifyUtil.isExist(notice)){
            throw new IllegalArgumentException("通知不存在.");
        }
        notice.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        notice.setUpdateDate(now);
        sysNoticeRepository.save(notice);
    }

    @Override
    public SysNoticeEntity showNotice(Long noticeId){
        SysNoticeEntity notice = sysNoticeRepository.findSysNoticeEntityById(noticeId);
        if (!verifyUtil.isExist(notice)){
            throw new IllegalArgumentException("通知不存在.");
        }
        return notice;
    }
}
