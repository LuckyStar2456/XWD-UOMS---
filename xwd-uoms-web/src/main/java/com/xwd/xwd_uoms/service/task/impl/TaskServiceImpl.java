package com.xwd.xwd_uoms.service.task.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysTaskDefaultConfig;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import com.xwd.xwd_uoms.repository.SysTaskRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.task.TaskService;
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
public class TaskServiceImpl implements TaskService {
    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysTaskDefaultConfig sysTaskDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void taskUpdate(SysTaskEntity task) {
        Long taskId = task.getId();
        SysTaskEntity oldTask = sysTaskRepository.findSysTaskEntityById(taskId);
        if (!verifyUtil.isExist(oldTask)){
            throw new IllegalArgumentException("任务不存在.");
        }
        if (!Objects.equals(task.getOriginatorId(),oldTask.getOriginatorId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getOriginatorId()))){
            throw new IllegalArgumentException("任务发起人不存在.");
        }
        if (!Objects.equals(task.getMandatoryId(),oldTask.getMandatoryId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getMandatoryId()))){
            throw new IllegalArgumentException("任务接收人不存在.");
        }
        if (!verifyUtil.isExist(task.getName())){
            throw new IllegalArgumentException("任务标题不可为空.");
        }
        oldTask.setName(task.getName());
        oldTask.setTaskDesc(task.getTaskDesc());
        oldTask.setOriginatorId(task.getOriginatorId());
        oldTask.setMandatoryId(task.getMandatoryId());
        oldTask.setDeadline(task.getDeadline());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldTask.getCreateDate())){
            oldTask.setCreateDate(now);
        }
        oldTask.setUpdateDate(now);
    }

    @Override
    public void taskAdd(SysTaskEntity task) {
        if (!verifyUtil.isExist(task.getName())){
            throw new IllegalArgumentException("任务标题不可为空.");
        }
        if (!verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getOriginatorId()))){
            throw new IllegalArgumentException("任务发起人不存在.");
        }
        if (!verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getMandatoryId()))){
            throw new IllegalArgumentException("任务接收人不存在.");
        }
        if (!verifyUtil.isExist(task.getTaskDesc())){
            task.setTaskDesc(sysTaskDefaultConfig.getTaskDesc());
        }
        task.setIsDeleted(sysTaskDefaultConfig.getIsDeleted());
        task.setStatus(sysTaskDefaultConfig.getStatus());

        LocalDate now = LocalDate.now();
        task.setCreateDate(now);
        task.setUpdateDate(now);

        sysTaskRepository.save(task);
    }

    @Override
    public void taskDeleted(Long id) {
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(id);
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        task.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        task.setUpdateDate(now);
        sysTaskRepository.save(task);
    }

    @Override
    public Page<SysTaskEntity> showRecTask(Long mandatoryId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskEntity> page = sysTaskRepository.findAllByMandatoryId(mandatoryId,pageable);
        return page;
    }

    @Override
    public Page<SysTaskEntity> showPendTask(Long originatorId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskEntity> page = sysTaskRepository.findAllByOriginatorId(originatorId,pageable);
        return page;
    }

    @Override
    public void finiTask(SysTaskEntity task){
        LocalDate now = LocalDate.now();
        SysTaskEntity oldTask = sysTaskRepository.findSysTaskEntityById(task.getId());
        if (!verifyUtil.isExist(oldTask)){
            throw new IllegalArgumentException("任务不存在.");
        }
        if (oldTask.getStatus() == (byte)0 &&
                task.getStatus() == (byte)1){
            if (verifyUtil.isExist(oldTask.getDeadline()) && now.isAfter(oldTask.getDeadline())){
                oldTask.setStatus((byte)3);
            }else {
                oldTask.setStatus(task.getStatus());
            }
        }else if (oldTask.getStatus() == (byte)1 &&
                (task.getStatus() == (byte)2 || task.getStatus() == (byte)4)){
            oldTask.setStatus(task.getStatus());
        }else {
            throw new IllegalArgumentException("任务状态异常.");
        }
        if (!verifyUtil.isExist(oldTask.getCreateDate())){
            oldTask.setCreateDate(now);
        }
        oldTask.setUpdateDate(now);
        sysTaskRepository.save(oldTask);
    }

    @Override
    public SysTaskEntity showTask(Long taskId){
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(taskId);
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        return task;
    }
}
