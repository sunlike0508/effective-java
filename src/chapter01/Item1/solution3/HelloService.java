package chapter01.Item1.solution3;

public interface HelloService {

    public String hello();

    public static String hi1() {
        prepareMessage();
        return "Hello World";
    }

    /**
     * 공통적으로 쓰는건데 이건 public으로 공개하고 싶지 않은데?
     */
    private static void prepareMessage() {

    }

    public static String hi2() {
        prepareMessage();
        return "Hello World";
    }

    public static String hi3() {
        prepareMessage();
        return "Hello World";
    }

    public default String bye() {
        return "Bye World";
    }

}
