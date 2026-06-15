package com.xwd.xwd_uoms.controller.taskfeedback;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import com.xwd.xwd_uoms.service.taskfeedback.TaskFeedbackService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.web.bind.annotation.*;

@Log(module = "tfb")
@RestController
@RequestMapping("/xwd_uoms/api/taskfeedback")
public class TaskFeedbackController {
    @Resource
    private TaskFeedbackService taskFeedbackService;

    @PutMapping("/update")
    @RequirePermission(object = "",operation = "")
    public Result<?> taskFeedbackUpdate(@RequestBody SysTaskFeedbackEntity taskFeedback){
        taskFeedbackService.taskFeedbackUpdate(taskFeedback);
        return Result.success("任务反馈信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "",operation = "")
    public Result<?> taskFeedbackAdd(@RequestBody SysTaskFeedbackEntity taskFeedback){
        taskFeedbackService.taskFeedbackAdd(taskFeedback);
        return Result.success("任务反馈成功.");
    }

    @GetMapping("/received/view/{reviewUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecTaskFeedback(@PathVariable Long reviewUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskFeedbackEntity> page = taskFeedbackService.showRecTaskFeedback(reviewUserId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{feedbackUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendTaskFeedback(@PathVariable Long feedbackUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskFeedbackEntity> page = taskFeedbackService.showPendTaskFeedback(feedbackUserId, current, size);
        return Result.success(page);
    }

    @PutMapping("/approve/{reviewUserId}")
    @RequirePermission(object = "taskFeedback",operation = "approve")
    public Result<?> approveTaskFeedback(@PathVariable Long reviewUserId , @RequestBody SysTaskFeedbackEntity taskFeedback){
        taskFeedbackService.approveTaskFeedback(reviewUserId,taskFeedback);
        return Result.success("任务反馈审批成功.");
    }

    @GetMapping("/show/{taskFeedbackId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showTaskFeedback(@PathVariable Long taskFeedbackId){
        SysTaskFeedbackEntity taskFeedback = taskFeedbackService.showTaskFeedback(taskFeedbackId);
        return Result.success(taskFeedback);
    }
}
