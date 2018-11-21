package org.mail.entity;

public class Mail {

    private String from;
    private String to;
    private String subject;
    private String content;

    private String name;
    private String signature;
    private String organization;

    public Mail() {
    }

    public Mail(String from, String to, String subject, String content, String name, String signature, String organization) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.signature = signature;
        this.organization = organization;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}