package mirea.danila.practice5;

public class ThreadSingle implements Runnable {
    String name;
    ThreadSafetySingleton cotext;

    public ThreadSingle(ThreadSafetySingleton cotext, String name) {
        this.cotext = cotext;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++)
            System.out.println("Now: thread " + name);
        cotext = ThreadSafetySingleton.getInstance();
    }
}
