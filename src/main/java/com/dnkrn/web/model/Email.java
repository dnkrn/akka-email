package com.dnkrn.web.model;

import java.io.Serializable;

public class Email implements Serializable {

    private static final long serialVersion= 1L;

    private String to;

    private String cc;

    private String subject;

    private String msg;

    private Integer failCounter;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getFailCounter() {
        return failCounter;
    }

    public void setFailCounter(Integer failCounter) {
        this.failCounter = failCounter;
    }
}
