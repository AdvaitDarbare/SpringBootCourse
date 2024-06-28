package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In a constructor: " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doStartup(){
        System.out.println("In my doStartup: " + getClass().getSimpleName());;
    }
    // define our destroy method
    @PreDestroy
    public void doDestroy(){
        System.out.println("In my doDestroy: " + getClass().getSimpleName());;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-)";
    }
}
