package com.itmuch.mycontentcenter.controller.content;

import com.itmuch.mycontentcenter.auth.CheckAuthorization;
import com.itmuch.mycontentcenter.domain.dto.content.ShareAuditDTO;
import com.itmuch.mycontentcenter.domain.entity.content.Share;
import com.itmuch.mycontentcenter.service.content.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareAdminController {
    private final ShareService shareService;
    @PutMapping("/audit/{id}")
    @CheckAuthorization("admin")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDTO auditDTO) {
        // TODO 认证、授权
        return this.shareService.auditById(id, auditDTO);
    }

}

