package eu.noelvaes.housekeeping.services;

import eu.noelvaes.housekeeping.services.MusicMaker;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class MusicAspect {
    @DeclareParents(value = "eu.noelvaes.housekeeping.services.DomesticServiceImpl",
    defaultImpl = eu.noelvaes.housekeeping.services.MusicMakerImpl.class)
    public static MusicMaker mixin;
}
