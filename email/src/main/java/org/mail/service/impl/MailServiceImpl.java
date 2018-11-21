package org.mail.service.impl;

import org.mail.entity.Mail;
import org.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfiguration;

    @Override
    public void send(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("xxx@163.com");
        message.setReplyTo("xxx@163.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);
    }

    @Override
    public void sendAttachments(String to, String subject, String text) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("xxx@163.com");
        helper.setReplyTo("xxx@163.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        helper.addAttachment("a.jpg", new ClassPathResource("static/images/a.jpg"));

        emailSender.send(message);
    }

    @Override
    public void sendTemplate(Mail mail) throws MessagingException, IOException, TemplateException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Template t = freemarkerConfiguration.getTemplate("email-template.ftl");

        Map<String, String> model = new HashMap<String, String>();
        model.put("name", mail.getName());
        model.put("signature", mail.getSignature());
        model.put("organization", mail.getOrganization());
        System.out.println(model);

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        helper.setReplyTo("xxx@163.com");
        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        helper.addInline("logo.png", new ClassPathResource("static/images/a.jpg"));

        emailSender.send(message);
    }
}
