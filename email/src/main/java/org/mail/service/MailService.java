package org.mail.service;

import freemarker.template.TemplateException;
import org.mail.entity.Mail;

import javax.mail.MessagingException;
import java.io.IOException;


public interface MailService {

    public void send(String to, String subject, String text);

    public void sendAttachments(String to, String subject, String text) throws MessagingException;

    public void sendTemplate(Mail mail) throws MessagingException, IOException, TemplateException;

}
