package eu.noelvaes.housekeeping.services;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class ProfileAspect {
    @Around("execution(* *.runHouseHold(..))")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("Before proceeding");
        Date before = new Date();
        Object returnValue = pjp.proceed();
        Date after = new Date();
        System.out.println("After proceeding : " + (after.getTime()-before.getTime()) + " ms");
        return returnValue;
    }
}
