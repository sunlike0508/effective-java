package chapter02.Item1.factory;

public interface HelloService {

    String hello();

    static HelloService of(String language) {
        if("ko".equals(language)) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }
}
