package com.spring.application.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.spring.application.demo.controller.LecturerController.*(..))")
    public void DAOpackage(){}
    @Pointcut("execution(* com.spring.application.demo.controller.LecturerController.get*(..))")
    public void getter(){}
    @Pointcut("execution(* com.spring.application.demo.controller.LecturerController.set*(..))")
    public void setter(){}

    @Pointcut("DAOpackage() && (! (getter() || setter()))")
    public void forNoGetterSetter(){}
}
