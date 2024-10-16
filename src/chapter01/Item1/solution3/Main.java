package chapter01.Item1.solution3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import chapter01.Item1.solution2.Character;
import chapter01.Item1.solution2.FontFactory;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(30);
        numbers.add(1);
        numbers.add(100);
        numbers.add(2);


//        Comparator<Integer> comparator = Integer::compareTo;

//        Collections.sort(numbers, comparator);
//
//        System.out.println(numbers);

//        numbers.sort(comparator);
//
//        System.out.println(numbers);

        Comparator<Integer> comparator = Integer::compareTo;

        //numbers.sort(comparator);
        numbers.sort(comparator.reversed());

        System.out.println(numbers);
    }
}
