package com.dnkrn.web.controller;

import com.dnkrn.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @Autowired
    private EmailService emailService;

    @RequestMapping("/email")
    public String hello(){
        emailService.sendEmail();
        return "hello";
    }
}