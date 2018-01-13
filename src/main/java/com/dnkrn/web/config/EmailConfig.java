package com.dnkrn.web.config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.dnkrn.web.service.EmailSupervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class EmailConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${email.maxRetry}")
    private String maxRetry;

    @Value("${email.retryInterval}")
    private String retryInterval;

    @Bean
    public ActorSystem actorSystem()
    {
        return ActorSystem.create("EmailAkka");
    }

    @Bean
    public ActorRef actorRef(){
        return actorSystem().actorOf(Props.create(EmailSupervisor.class,applicationContext,maxRetry,retryInterval),"emailSupervisor");
    }

    @PreDestroy
    public void cleanUp()
    {
        actorSystem().stop(actorRef());
    }
}
