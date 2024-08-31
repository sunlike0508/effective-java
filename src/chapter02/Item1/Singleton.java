package chapter02.Item1;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton {

    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

//    public static Singleton newInstance() {
//        if(singleton == null) {
//            return new Singleton();
//        }
//
//        return singleton;
//    }
}
