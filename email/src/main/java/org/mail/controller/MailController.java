package org.mail.controller;

import freemarker.template.TemplateException;
import org.mail.entity.Mail;
import org.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("send")
    public Map<String, Object> send(String to, String subject, String text) throws MessagingException {
        mailService.send(to, subject, text);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        return map;
    }

    @PostMapping("send_attachments")
    public Map<String, Object> sendAttachments(String to, String subject, String text) throws MessagingException {
        mailService.sendAttachments(to, subject, text);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        return map;
    }

    @PostMapping("send_template")
    public Map<String, Object> sendTemplate(Mail mail) throws MessagingException, IOException, TemplateException {
        mailService.sendTemplate(mail);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        return map;
    }
}
