package chapter01.Item1.solution2;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import chapter01.Item1.solution1.OrderStatus;

public class Main {
    public static void main(String[] args) {

//        Character c1 = new Character('h', "white" ,"nanum", 12);
//        Character c2 = new Character('h', "white" ,"nanum", 12);

        FontFactory factory = new FontFactory();
        factory.getFont("nanum:12");

        Character c1 = new Character('h', "white" ,factory.getFont("nanum:12"));
        Character c2 = new Character('h', "white" ,factory.getFont("nanum:12"));
    }
}
