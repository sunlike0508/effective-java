package chapter01.Item1.solution1;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        EnumSet<OrderStatus> enumSet = EnumSet.allOf(OrderStatus.class);

        HashSet<OrderStatus> hashSet = new HashSet<>(enumSet);

        EnumMap<OrderStatus, Integer> enumMap = new EnumMap<>(OrderStatus.class);

        HashMap<OrderStatus, Integer> hashMap = new HashMap<>();
    }
}
