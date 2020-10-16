package eu.noelvaes.housekeeping.AOP;

import eu.noelvaes.housekeeping.AOP.MyInterface;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class MyBean implements MyInterface {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayGoodBye(String name) {
        return "Goodbye " + name;
    }
}
