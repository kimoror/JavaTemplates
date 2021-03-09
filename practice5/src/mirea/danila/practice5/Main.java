package mirea.danila.practice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Lazy man = Lazy.getObject(78.3, 176);
        man = Lazy.getObject(89,190);
        System.out.println(man.toString());

        ENUM e = ENUM.woman.getWoman();
        System.out.println("Enum e = " + e);


        ThreadSafetySingleton thSafeSingle = ThreadSafetySingleton.getInstance();
        ThreadSingle th1 = new ThreadSingle(thSafeSingle, "th1");
        ThreadSingle th2 = new ThreadSingle(thSafeSingle, "th2");
        th1.run();
        th2.run();
        try {
            Thread.sleep(200);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }
}
