package mirea.Danila.Practice1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


//TODO Попробуй второй вариант
public class Main {
    public static void main(String[] args) {
        /**
         * Вариант 11
         */
        Predicate<Integer> predicate = (a) -> (a & -a) == a;
        System.out.println(predicate.test(-1));

//        Function<ArrayList<Student>, HashMap<Integer, ArrayList<Student>>> convertToMap = x -> {
//            HashMap<Integer, ArrayList<Student>> map = new HashMap<>();
//            for(int i = 0; i < x.size(); i++){
//                map.put(i, x);
//            }
//            return map;
//        };
//
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("Oleg", "Vasiliev"));
//        students.add(new Student("Vladimir", "Putyan"));
//        students.add(new Student("Aleksiy", "Provalnyi"));
//        HashMap<Integer, ArrayList<Student>> mapInMain =  convertToMap.apply(students);
////        mapInMain.entrySet().forEach(a -> a.getValue().forEach(b-> System.out.println(b.firstName)));
//        System.out.println(mapInMain.get(1).get(0).firstName + " " + mapInMain.get(1).get(0).LastName);
    }
}
