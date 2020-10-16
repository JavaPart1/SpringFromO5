package eu.noelvaes.housekeeping.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspect {
    @Before("execution(* *.runHouseHold(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Before " + joinPoint.getTarget().toString());
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
