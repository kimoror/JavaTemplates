package mirea.danila.practice4;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService exec = Executors.newFixedThreadPool(3);//если поставить сюда один поток, то будет выполняться сначала первый поток, потом второй
        exec.submit(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + " from th1");
            }
            ;
        });
//        exec.shutdown(); //Если применим эту штуку и количество потоков в конструкторе = 1, то следующий поток не выполнится
        Thread th = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + " from th2");
            }
            ;
        });

        exec.submit(th);

    }
}
