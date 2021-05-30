package practice10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Politician trump = context.getBean("trump", Trump.class);
        Politician biden = context.getBean("biden", Biden.class);
        Politician merkel = context.getBean("merkel", Merkel.class);

        trump.doPolitic();
        biden.doPolitic();
        merkel.doPolitic();
    }
}
