package eu.noelvaes.AOP;

import eu.noelvaes.housekeeping.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyAppAOP {
    public static void main(String[] args) {
        try
            (ConfigurableApplicationContext ctx = new
                    AnnotationConfigApplicationContext(AppConfig.class)) {
            MyInterface bean = ctx.getBean("myBean",MyInterface.class);
            System.out.println(bean.sayHello("Homer"));
            System.out.println(bean.sayGoodBye("Homer"));
        }
    }
}
