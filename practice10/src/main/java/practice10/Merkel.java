package practice10;

import org.springframework.stereotype.Component;

@Component
public class Merkel implements Politician {
    @Override
    public void doPolitic() {
        System.out.println("Merkel say: \"Aleksei, thanks for your visiting our country!)\"");
    }
}
