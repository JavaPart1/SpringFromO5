package eu.noelvaes.housekeeping.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Before("execution(* *.sayHello(..))")
    public void before(){
        System.out.println("Before");
    }
    @AfterReturning("execution(* *.sayHello(..))")
    public void afterReturning(){
        System.out.println("AfterReturning");
    }
    @AfterThrowing("execution(* *.sayHello(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing");
    }
    @After("execution(* *.sayHello(..))")
    public void after(){
        System.out.println("After");
    }
}
