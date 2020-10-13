package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HousApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();

        //        CleaningService jill = ctx.getBean("jill",CleaningService.class);
//        CleaningService bob = ctx.getBean("bob",CleaningService.class);
//        CleaningService scott = ctx.getBean("scott",CleaningService.class);
//        GardeningService scotty = ctx.getBean("scotty",GardeningService.class);

        ctx.getEnvironment().setActiveProfiles("bigHouse");
        ctx.register(AppConfig.class);
        ctx.refresh();
        DomesticService service =
                ctx.getBean("domesticService",DomesticService.class);

//        CleaningTool broom = new Broom();
//        CleaningTool vacuum = new VacuumCleaner();

//        CleaningServiceImpl jill = new CleaningServiceImpl();
//        jill.setCleaningTool(broom);
//        CleaningServiceImpl bob = new CleaningServiceImpl();
//        bob.setCleaningTool(vacuum);

//        jill.clean();
//        bob.clean();
//        scott.clean();
//        scott.clean();
//        scotty.garden();

        service.runHouseHold();

        ctx.close();
    }
}
