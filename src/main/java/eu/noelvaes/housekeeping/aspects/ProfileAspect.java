package eu.noelvaes.housekeeping.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class ProfileAspect {
    @Around("execution(* *.runHouseHold(..))")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("Before proceeding household");
        Date before = new Date();
        Object returnValue = pjp.proceed();
        Date after = new Date();
        System.out.println("After proceeding household : " + (after.getTime()-before.getTime()) + " ms");
        return returnValue;
    }
}
