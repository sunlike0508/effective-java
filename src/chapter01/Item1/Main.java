package chapter01.Item1;

public class Main {

    public static void main(String[] args) {
        // 장점 1
        Order primeOrder = Order.primeOrder("fish");
        System.out.println(primeOrder.getMenu());

        Order urgentOrder = Order.urgentOrder("pig");
        System.out.println(urgentOrder.getMenu());

        // 싱글톤
        //Singleton singleton = new Singleton();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1);
        System.out.println(singleton2);


    }
}
