package mirea.danila.pracitce2;

import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        //вар7
        context.humanList.stream().limit(5)
                .sorted(Comparator.comparing(Human::getBirthDate))
                .filter(x -> x.getWeight() < 60)
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
//        for debug
//               .forEach(x -> System.out.println(x.getFirstName() + " " +  x.getLastName()+ " " +
//                        x.getAge() + " years " + x.getBirthDate() + " " + x.getWeight() + " weight"));

        //Вар 8
//        Optional<Integer> sum = context.humanList.stream().filter(x -> x.getAge() > 20)
//                .sorted(Comparator.comparing(Human::getLastWordOfName))
//                .map(x -> x.getAge())
//                .reduce((x1,x2) -> x1 + x2 + 3);
//        int count = (int) context.humanList.stream().filter(x -> x.getAge() > 20).count();
//        System.out.println((sum.get()+3)/count);
    }
}
