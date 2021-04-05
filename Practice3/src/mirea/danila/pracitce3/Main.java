package mirea.danila.pracitce3;

public class Main {
    public static void main(String[] args) {

        MyList list = new MyList();
        MySet<String> set = new MySet<String>();

        Thread th1List = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                list.add("one");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2List = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                list.add("two");
            }
        });

        Thread th1Set = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                set.add("one");
            }
        });

        Thread th2Set = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                set.add("two");
            }
        });

        th1List.run();
        th2List.run();
        th1Set.run();
        th2Set.run();

        System.out.println("List:");
        list.forEach(System.out::println);
        System.out.println("---");
        System.out.println("Set:");
        list.forEach(System.out::println);


    }
}
