# 1장

## Item 1 : 생성자 대신 정적 팩터리 메서드를 고려하라.

* 디자인 패턴의 팩터리 메서드 패턴이랑 다르다.

* 장점

  1) 이름을 가질 수 있다. 이는 메서드가 반환할 객체의 특성을 쉽게 알 수 있다.
  2) 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
    * 불변 클래스의 경우 인스턴스를 미리 만들어 놓거나 새로 생성한 인스턴스를 캐싱하여 재활용할수 있다. (Flyweight pattern과 비슷)
    * 이렇게 인스턴스 생성을 통제하는 클래스를 인스턴스 통제(instance-controlled) 클래스라고 부른다.
    * 이렇게 통제하면 싱글턴 or 인스턴스화 불가로 만들 수 있다.
    * 또한 불변 값 클래스에서 동치인 인스턴스가 단 하나뿐임을 보장할 수 있다. (a.equals(b))
    * 인스턴스 통제는 플라이웨이트 패턴의 근간이 되며, 열거 타입은 인스턴스가 하나만 만들어짐을 보장한다.
  3) 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    * 반환할 객체의 클래스를 자유롭게 선택할 수 있게 하는 유연성을 제공한다.
    * 이는 인터페이스를 정적 팩터리 메서드의 반환 타입으로 사용하는 인터페이스 기반 프레임워크를 만드는 핵심 기술이다.
    * 자바 8 전에는 인터페이스에 정적 메서드를 선언할 수 없었다. 그러나 자바 8부터 풀렸기 때문에 인스턴스화 불가 동반 클래스를 둘 이유가 없다.
    * 정적 팩터리 메서드를 사용하는 클라이언트는 얻은 객체를 인터페이스만으로 다룰 수 있다.
  4) 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환될 수 있다.
    * 예를 들어 EnumSet 클래스는 원소의 수에 따라 두 가지 하위 클래스를 반환한다. 원소가 64개 이하면 RegularEnumSet. 65개 이상이면 JumboEnumset 인스턴스를 반환한다.
    * 클라이언트는 Regular, Jumbo를 모른다. 단지 EnumSet을 가지고 사용한다. EnumSet이 regular인지 jumbo인지 알 수도 없고 알 필요도 없다.
  5) 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
    * 서비스 제공자 프레임워크를 만드는 근간이 된다.  ex) JDBC

* 단점
1) 상속하려면 public, protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
 * 상속 대신 해당 객체를 멤버변수로 가지는 CLASS로 만들수 있다.
```java
class Setting {
  private Setting() {
  }
}

class AdvancedSetting {
  Setting setting;
}
```
 * 아니면 private 생성자를 그냥 public으로 열어둔다. ex) List. List.of로 쓸수도 new ArrayList()로 쓸수도 있다.

***특히 문서화를 잘해라. javadoc을 사용하면 더 좋다***
  
2) 정적 팩토리 메서드는 프로그래머가 찾기 힘들다.
 
* 단점 2)의 보완을 위해 메서드명을 잘 지어야 한다. 이를 위한 관례는 아래와 같다.
    * from : 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
    * of : 여러 매개변수를 받아 적합 한 타입의 인스턴스를 반환하는 집게 메서드
    * valueOf : from과 of의 더 자세한 버전
    * instance or getInstance : (매개변수를 받는다면) 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스임을 보장하지는 않는다.
    * create or newInstance : instance와 같지만 매번 새로운 인스턴스를 생성해 반환함을 보장한다.
    * getType : instance와 같지만 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. "Type"은 팩터리 메서드가 반환할 객체의 타입
      * ex) FileStroe fs = Files.getFileStore(path)
    * newType : create와 같으나 생성할 클래스가 아닌 다른 클래스에 팩터러 메서드를 정의할 때 쓴다.
    * type : getType, newType 간결한 버전
      * ex) List<Comsumer> customers = Collections.list(legacyCustomers);
     
**정리 : 정적 팩터리 메서드와 public 생성자는 각자의 쓰임새가 있으니 상대적인 장단점을 잘 파악하고 쓰자. 그래도 정적 팩터리가 유리한 경우가 많다.**

### 완벽 공략 1. 열거 타입

**이뮴이라고 보통 부른다. 외국인들은. 왜냐하면 enumeration이기 때문에.

* 상수 목록을 담을 데이터 타입
* 특정한 변수가 가질 수 있는 값을 제한할 수 있다. (Type-Safety)를 보장할 수 있다.
* 싱글톤 패턴을 구현할 때 사용하기도 한다.
* 질문1) 특정 enum 타입이 가질 수 있는 모든 값을 순회하며 출력하라
* 질문2) enum은 자바의 클래스처럼 생성자, 메소드, 필드를 가질 수 있는가?
* 질문3) enum 값은 == 연산자로 비교가 가능한가?
  * equals를 쓸수도 있지만 굳이 쓸필요가 없다. == 연산자는 null 예외도 발생할 여지가 없다.
* 과제) enum을 key로 사용하는 Map을 정의하세요. 또는 enum을 담고 있는 set을 만들어보세요.

**EnumSet**

EnumSet을 사용할 때 유의해야할 점이 있습니다.

EnumSet에는 열거형 값만 저장할 수 있습니다. 그리고 모든 값은 같은 열거형에 속해야합니다.

EnumSet에는 null을 추가할 수 없습니다. 만약 추가하려고 한다면 NullPointerException이 발생하게 됩니다.

EnumSet은 thread-safe하지 않습니다. 만약 동기화가 필요하다면, 외부에서 동기화 처리를 해주어야 합니다.

요소들은 열거형에 정의된 순서에 따라 저장됩니다.

EnumSet은 복사시에 실패에 안전한 반복자를 사용하므로 컬렉션이 반복되는 도중에 변경되어도 ConcurrentModificationException이 발생하지 않습니다.

EnumSet

EnumSet은 Enum의 요소를 Set으로 만든 것인데, 이 때 요소는 enum 에 선언된 순서대로 저장됩니다.

EnumSet은 산술 비트 연산을 사용하기 때문에, 계산이 매우 빠릅니다.

```java
EnumSet<Status> statuses = EnumSet.allOf(Status.class); // Enum 요소 모두 포함
EnumSet<Status> range = EnumSet.range(Status.RUNNING, Status.FINISH); // range에 들어간 것만
EnumSet<Status> complementOf = EnumSet.complementOf(EnumSet.of(Status.RUNNING, Status.FINISH)); // 특정 요소 제외하고 나머지
```

EnumMap

EnumMap 은 Enum만 키로 사용하는 Map을 말합니다. 

이때 요소의 선언 순서인 ordinal을 이용해 Array로 데이터를 저장합니다.  

또한 부수적인 자료형 또한 필요하지 않으므로 메모리를 효율적으로 사용할 수 있습니다.

Enum 요소를 Key로 사용해야 된다면 EnumMap을 고려해보는게 좋습니다.

```
EnumMap<Status, String> activityMap = new EnumMap(Status.class);
activityMap.put(Status.START, "start-test");
activityMap.put(Status.RUNNING, "running-test");
activityMap.put(Status.FINISH, "finish-test");

activityMap.forEach((key,value) -> log.info("key={}, value={}", key, value)); 
```

### 완벽 공략2 - 플라이웨이트 패턴

같은 객체가 자주 사용된다면 어떻게 할것인가?

캐싱을 한다, 미리 생성해서 저장하고 있다가 사용한다. 결국 재사용하는 알고리즘을 생각한다.

이러한 재사용하는 패턴을 플라이웨이트 패턴이다.

#### 플라이웨이트 패턴

* 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
* 자주 변하는 속성(또는 외적인 속성, extrinsit)과 변하지 않는 속성(또는 내적인 속성, intrinsit)을 분리하고 재사용하여 메모리 사용을 줄일 수 있다.

### 완벽공략 3.  인터페이스와 정적메서드

기본 메소드(default)와 정적 메소드를 가질 수 있다.

* 기본 메소드
  * 인터페이스에서 메소드 선언 뿐 아니라 기본적인 구현체를 가짐
  * 기존의 인터페이스를 구현하는 클래스에 새로운 기능을 추가할 수 있다.
* 정적 메소드
  * 자바 9부터 private static 메소드를 가질 수 있다.
    * 이렇게하면 인터페이스 차원에서 진짜 유틸리티하게 사용할 있고 하위 구현체에서 이것을 상속받아 사용 못하도록 막는다.
    * 이것을 보통 이전에는 유틸클래스로 만들었는데 이제는 그럴 필요가 없다.(물론 100프로는 아니다)
    * 이로 인해 많은 불필요한 추상 클래스가 사라짐
  * 단 private 필드는 아직 선언이 불가
* 질문1) 내림차순으로 정렬하는 Comparator를 만들고 List<Integer>를 정렬하라
* 질문2) 질문1에서 만든 Comparator 를 사용해서 오름차순으로 정렬하라

### 완벽공략 4. 서비스 제공자 프레임워크

확장 가능한 어플리케이션을 만드는 방법

대표적으로 스프링에서 사용하는 프레임워크라고 보면 된다. 빈등록 객체를 ApplicationContext에서 관리하며 제공하니까

* 주요 구성 요소
  * 서비스 제공자 인터페이스(SPI)와 서비스 제공자(서비스 구현체)
  * 서비스 제공자 등록 API (서비스 인터페이스의 구현체를 등록하는 방법)
  * 서비스 접근 API (서비스의 클라이언트가 서비스 인터페이스의 인스턴스를 가져올 때 사용하는 API)
* 다양한 변형
  * 브릿지 패턴
  * 의존 객체 주입 프레임워크
  * java.util.ServiceLoader

https://docs.oracle.com/javase/tutorial/sound/SPI-intro.html

## Item 3

## Item 4
## Item 17
## Item 20
## Item 34
