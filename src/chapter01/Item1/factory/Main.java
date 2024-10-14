package chapter01.Item1.factory;

public class Main {

    public static void main(String[] args) {
        HelloService eng = HelloService.of("ko");
        System.out.println(eng.hello());


//        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
//
//        Optional<HelloService> helloServiceOptional = loader.findFirst();
//
//        helloServiceOptional.ifPresent(h -> System.out.println(h.hello()));
    }
}
