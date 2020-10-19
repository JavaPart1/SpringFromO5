package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class HousApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(HousApp.class);

        DomesticService service =
                ctx.getBean("domesticService",DomesticService.class);

        ctx.start();
        //service.runHouseHold();
        ctx.close();
    }
}
