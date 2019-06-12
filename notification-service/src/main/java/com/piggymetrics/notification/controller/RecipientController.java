package com.piggymetrics.notification.controller;

import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-06-08 19:18
 **/

@RestController
@RequestMapping("/recipients")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    // 获取当前通知设置
    @RequestMapping(path = "/current", method = RequestMethod.GET)
    public Object getCurrentNotificationsSettings(Principal principal) {
        return recipientService.findByAccountName(principal.getName());
    }

    // 保存当前通知设置
    @RequestMapping(path = "/current", method = RequestMethod.PUT)
    public Object saveCurrentNotiqficationsSettings(Principal principal, @Valid @RequestBody Recipient recipient) {
        return recipientService.save(principal.getName(), recipient);
    }
}
