package mirea.danila.pracitce2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Context {
    List<Human> humanList = new ArrayList<>();

    public Context() {
        humanList.add(new Human(53, "Oleg", "Tinkoff", new Date(1967, 11, 23), 78));
        humanList.add(new Human(42, "Anton", "Komolov", new Date(1987, 8, 28), 88));
        humanList.add(new Human(20, "Vladimir", "Medvedev", new Date(2001, 5, 3), 51));
        humanList.add(new Human(25, "Michel", "Putinkov", new Date(1995, 3, 23), 59));
        humanList.add(new Human(71, "Breez", "Olonsky", new Date(1949, 11, 29), 55));
        humanList.add(new Human(17, "Mike", "Lomchenko", new Date(2003, 7, 15), 52));
        humanList.add(new Human(22, "Magomed", "Chernenko", new Date(1998, 2, 5), 82));
        humanList.add(new Human(48, "Kamal", "Ismailov", new Date(1972, 9, 12), 57));
    }
}
