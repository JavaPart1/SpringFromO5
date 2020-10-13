package eu.noelvaes.spEL;

import eu.noelvaes.housekeeping.AppConfig;
import eu.noelvaes.housekeeping.services.Computer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("spEL");
        ctx.register(AppConfig.class);
        ctx.refresh();

        Computer acer = ctx.getBean("computer",Computer.class);
        System.out.println(acer.toString());

        ctx.close();

    }
}
