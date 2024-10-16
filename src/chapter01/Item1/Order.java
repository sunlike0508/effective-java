package chapter01.Item1;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import chapter01.Item1.solution1.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    private boolean prime;

    private boolean urgent;

    private String menu;

    private OrderStatus orderStatus;

    /**
     * 기본 생성자
      */
//    public Order(String menu, boolean prime) {
//        this.menu = menu;
//        this.prime = prime;
//    }


    /**
     * 아래 생성자는 당연히 생성이 불가능
     */
    //    public Order(String menu, boolean urgent) {
//        this.menu = menu;
//        this.urgent = urgent;
//    }


    /**
     * 이렇게는 가능하지만 좋아보이지 않다.
     */
//    public Order(boolean urgent, String menu) {
//        this.menu = menu;
//        this.urgent = urgent;
//    }

    /**
     *
     */
    public static Order primeOrder(String menu) {
        Order order = new Order();
        order.prime = true;
        order.menu = menu;
        return order;
    }

    public static Order urgentOrder(String menu) {
        Order order = new Order();
        order.urgent = true;
        order.menu = menu;
        return order;
    }

    public static void main(String[] args) {
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);

        Arrays.stream(OrderStatus.values()).forEach(orderStatus1 -> System.out.println(orderStatus1.getDescription()));

        EnumMap<OrderStatus, String> map = new EnumMap<>(OrderStatus.class);

        EnumSet<OrderStatus> set = EnumSet.allOf(OrderStatus.class);
    }

}
