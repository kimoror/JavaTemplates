package practice10;

import org.springframework.stereotype.Component;

@Component
public class Biden implements Politician {
    @Override
    public void doPolitic() {
        System.out.println("Biden say: \"Who is Trump? I don`t know him...\"");
    }
}
