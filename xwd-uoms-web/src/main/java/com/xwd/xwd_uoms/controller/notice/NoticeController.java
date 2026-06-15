package com.xwd.xwd_uoms.controller.notice;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import com.xwd.xwd_uoms.service.apply.ApplyService;
import com.xwd.xwd_uoms.service.notice.NoticeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "notice")
@RestController
@RequestMapping("/xwd_uoms/api/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    @PostMapping("/add")
    @RequirePermission(object = "notice",operation = "add")
    public Result<?> noticeAdd(@RequestBody SysNoticeEntity notice){
        noticeService.noticeAdd(notice);
        return Result.success("通知创建成功.");
    }

    @PutMapping("/update")
    @RequirePermission(object = "notice",operation = "update")
    public Result<?> noticeUpdate(@RequestBody SysNoticeEntity notice){
        noticeService.noticeUpdate(notice);
        return Result.success("通知更新成功.");
    }

    @GetMapping("/received/view/{mandatoryId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecApply(@PathVariable Long mandatoryId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysNoticeEntity> page = noticeService.showRecNotice(mandatoryId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{originatorId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendApply(@PathVariable Long originatorId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysNoticeEntity> page = noticeService.showIniNotice(originatorId, current, size);
        return Result.success(page);
    }

    @DeleteMapping("/deleted/{noticeId}")
    @RequirePermission(object = "notice",operation = "deleted")
    public Result<?> applyDeleted(@PathVariable Long noticeId){
        noticeService.noticeDeleted(noticeId);
        return Result.success("通知撤销成功.");
    }

    @GetMapping("/show/{noticeId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showApply(@PathVariable Long noticeId){
        SysNoticeEntity notice = noticeService.showNotice(noticeId);
        return Result.success(notice);
    }
}
