package com.spring.application.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
   // @Before("com.spring.application.demo.aspect.AopExpressions.forNoGetterSetter")
    @Before("execution(* com.spring.application.demo.controller.LecturerController.listLecturers(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("======>>>>> Before Showing Lecturer List");
    }
    @Before("execution(* com.spring.application.demo.controller.LecturerController.showLecturerStudent(..))")
    public void beforePrincipleLecturer(JoinPoint joinPoint){
        System.out.println("======>>>>> Before Showing Lecturer List in principle page");
    }
    @Before("execution(* com.spring.application.demo.controller.LecturerController.showPrinciple(..))")
    public void beforePrinciple(JoinPoint joinPoint){
        System.out.println("======>>>>> Before Showing Lecturer List in principle page");
    }
    @After("execution(* com.spring.application.demo.controller.LecturerController.showLecturerStudent(..))")
    public void afterPrincipleLecturer(JoinPoint joinPoint){
        System.out.println("======>>>>> After displaying Lecturer List in principle page");
    }

}
