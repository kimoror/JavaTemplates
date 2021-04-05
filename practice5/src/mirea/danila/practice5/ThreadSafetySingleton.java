package mirea.danila.practice5;

public class ThreadSafetySingleton {
    private static volatile ThreadSafetySingleton instanse;

    private ThreadSafetySingleton() {
    }

    ;

    public static ThreadSafetySingleton getInstance() {
        synchronized (ThreadSafetySingleton.class) {
            if (instanse == null) {
                instanse = new ThreadSafetySingleton();
            }
        }
        return instanse;
    }
}
