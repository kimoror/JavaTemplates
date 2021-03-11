package practice10;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Trump implements Politician{
    @Override
    public void doPolitic() {
        System.out.println("Trump say: \"Please, unblock me in Twitter\"");
    }
}
