package eu.noelvaes.housekeeping.services;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspect {
    @Before("execution(* *.runHouseHold(..))")
    public void before(){
        System.out.println("Before");
    }
    @AfterReturning("execution(* *.runHouseHold(..))")
    public void afterReturning(){
        System.out.println("AfterReturning");
    }
    @AfterThrowing("execution(* *.runHouseHold(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing");
    }
    @After("execution(* *.runHouseHold(..))")
    public void after(){
        System.out.println("After");
    }
}
