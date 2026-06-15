package com.xwd.xwd_uoms.controller.task;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import com.xwd.xwd_uoms.service.task.TaskService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.web.bind.annotation.*;

@Log(module = "task")
@RestController
@RequestMapping("/xwd_uoms/api/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @PutMapping("/update")
    @RequirePermission(object = "task",operation = "update")
    public Result<?> taskUpdate(@RequestBody SysTaskEntity task){
        taskService.taskUpdate(task);
        return Result.success("任务更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "task",operation = "add")
    public Result<?> taskAdd(@RequestBody SysTaskEntity task){
        taskService.taskAdd(task);
        return Result.success("任务创建成功.");
    }

    @DeleteMapping("/deleted/{taskId}")
    @RequirePermission(object = "task",operation = "deleted")
    public Result<?> taskDeleted(@PathVariable Long taskId){
        taskService.taskDeleted(taskId);
        return Result.success("任务删除成功.");
    }

    @PutMapping("/approve")
    @RequirePermission(object = "task",operation = "approve")
    public Result<?> approveTask(@RequestBody SysTaskEntity task){
        taskService.finiTask(task);
        return Result.success("任务审批成功.");
    }

    @GetMapping("/received/{mandatoryId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecTask(@PathVariable Long mandatoryId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskEntity> page = taskService.showRecTask(mandatoryId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/{originatorId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendTask(@PathVariable Long originatorId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskEntity> page = taskService.showPendTask(originatorId, current, size);
        return Result.success(page);
    }

    @GetMapping("/show/{taskId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showTask(@PathVariable Long taskId){
        SysTaskEntity task = taskService.showTask(taskId);
        return Result.success(task);
    }
}
