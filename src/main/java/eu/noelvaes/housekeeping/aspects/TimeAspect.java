package eu.noelvaes.housekeeping.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

@Component
@Aspect
public class TimeAspect {
    private int startWork;
    private int endWork;
    @Around("execution(* eu.noelvaes.housekeeping.services.VacuumCleaner.doCleanJob(..))")
    public Object aroundVC(ProceedingJoinPoint pjp)throws Throwable{
        try {
            Date before = new Date();
            System.out.println("Before proceeding vacuum ");
            int hour = LocalTime.now().getHour();
            if (hour > startWork && hour < endWork){
                System.out.println("Working hours, ok");
                Object returnValue = pjp.proceed();
                Date after = new Date();
                System.out.println("After proceeding vacuum : " + (after.getTime()-before.getTime()) + " ms");
                return returnValue;
            } else {
                throw new RuntimeException("Working hours are over !");
            }
        } catch (RuntimeException r) {
            System.out.println(r.getMessage());
            return new Object();
        }
    }

    @Value("${startWork}")
    public void setStartWorkingHours(int startWork){
        this.startWork = startWork;
    }

    @Value("${endWork}")
    public void setEndWork(int endWork) {
        this.endWork = endWork;
    }
}
