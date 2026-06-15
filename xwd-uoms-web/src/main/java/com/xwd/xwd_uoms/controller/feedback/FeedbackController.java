package com.xwd.xwd_uoms.controller.feedback;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.service.feedback.FeedbackService;
import jakarta.annotation.Resource;
import jakarta.persistence.Lob;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "fb")
@RestController
@RequestMapping("/xwd_uoms/api/feedback")
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @PutMapping("/update")
    @RequirePermission(object = "feedback",operation = "update")
    public Result<?> feedbackUpdate(@RequestBody SysFeedbackEntity feedback){
        feedbackService.feedbackUpdate(feedback);
        return Result.success("反馈信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "",operation = "")
    public Result<?> feedbackAdd(@RequestBody SysFeedbackEntity feedback){
        feedbackService.feedbackAdd(feedback);
        return Result.success("反馈信息创建成功.");
    }

    @DeleteMapping("/deleted/{feedbackId}")
    @RequirePermission(object = "feedback",operation = "deleted")
    public Result<?> feedbackDeleted(@PathVariable Long feedbackId){
        feedbackService.feedbackDeleted(feedbackId);
        return Result.success("反馈信息删除成功.");
    }

    @GetMapping("/received/view/{handlerUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecFeedback(@PathVariable Long handlerUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysFeedbackEntity> page = feedbackService.showRecFeedback(handlerUserId,current,size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{feedbackUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendFeedback(@PathVariable Long feedbackUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysFeedbackEntity> page = feedbackService.showPendFeedback(feedbackUserId,current,size);
        return Result.success(page);
    }

    @GetMapping("/show/{feedbackId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showFeedback(@PathVariable Long feedbackId){
        SysFeedbackEntity feedback = feedbackService.showFeedback(feedbackId);
        return Result.success(feedback);
    }

    @PutMapping("/approve")
    @RequirePermission(object = "feedback",operation = "approve")
    public Result<?> approveFeedback(@RequestBody SysFeedbackEntity feedback){
        feedbackService.approveFeedback(feedback);
        return Result.success("反馈表审批成功.");
    }
}
