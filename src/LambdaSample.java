import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntBiFunction;


@FunctionalInterface
//-> 단 하나의 추상 메소드만 선언된 인터페이스
interface MyMathOperation{
    int add(int a, int b);
}

class MathUtils {
    private int id;
    private String name;

    MathUtils(){
        System.out.println("MathUtils() 생성자 호출");
    }
    MathUtils(int id, String name){
        this.id = id;
        this.name = name;
        System.out.println("MathUtils(int id, String name) 생성자 호출");
        System.out.println("Id: " + id + " " + "name: " + name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int squareStatic(int num) {
        return num * num;
    }

    public int squareInstance(int num){
        int x = num;
        int y = num;
        return x * y;
    }
}

public class LambdaSample {

    // 일반적인 (이름이 있는) 함수, 함수를 선언(정의)되어 있음.
    public static int thisIsName(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        // 익명 클래스(Anonymous Class)란
        // 선언과 동시에 객체를 생성하는 방식
        // classA objA = new classA(){ }
        // class ClassName{ 구현구현 } .. 이렇게 class keyword로 클래스를 선언하지 않음.
        // 클래스 선언 없이 바로 객체를 만들었기 떄문에 익명 클래스임.
        // 반드시 interface나 abstract class가 있어야함.
        // 당연히 구현해야할 함수 "하나" 포함. -> FunctionalInterface

        // 익명 함수(Anonymous Function)란
        // thisIsName 함수와 같이 명시적인 이름(선언)이 없는 함수.
        // 일반적으로 일회성으로 사용
        // 익명 클래스나 람다(lambda)표현식으로 익명 함수 구현.
        // *** 변수에 할당 할 수 있음.***
        // *** 매개변수로 전달 가능 ***

        // 익명 함수 사용 방법.
        // 1. 익명 클래스 사용
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, Anonymous Class");
            }
        };
        // 2. 람다 표현식으로 사용
        // 람다 표현식: 익명 함수(Anonymous Function)를 표현하는 방식. 익명 함수의 한 형태.
        // interface나 abstract class에 하나의 함수만 있어야 사용 가능함.
        // 여러 개의 함수가 있다면 람다 사용 불가 -> 익명 클래스를 사용해야함.
        // 표현식: (매개변수) -> { 실행할 함수 }
        MyMathOperation af = (a, b) -> { return a + b; };
        MyMathOperation af2 = (a,b) -> a + b;//한줄 실행은 중괄호 생략 가능

        System.out.println("Hello, Lambda: " + af.add(1, 2));
        System.out.println("Hello, Lambda: " + af2.add(3, 4));

        // 기존 익명 클래스 방식
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread running (Anonymous class)");
                    }
                });

        thread1.start();
        // 람다식 방식
        Thread thread2 = new Thread(
                () -> System.out.println("Thread running (Lambda)")
        );
        thread2.start();
        
        // 기존 익명 클래스 방식
        List<String> names = Arrays.asList("Apple", "Orange", "Banana", "Grape");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });
        System.out.println("Sorted using Anonymous Class: " + names);
        // 람다식 방식
        names.sort(
                (str1, str2) -> { return str1.compareTo(str2); }
        );
        System.out.println("Sorted using Lambda: " + names);

        //Static Method Reference
        //람다 표현식을 클래스 이름::메서드 이름으로 간결하게 변경 가능

        // lambda
        Function<Integer, Integer> lambdaSquare = (num) -> MathUtils.squareStatic(num);
        System.out.println(lambdaSquare.apply(3));

        // static method reference
        Function<Integer, Integer> methodRefSquare = MathUtils::squareStatic;
        System.out.println(methodRefSquare.apply(4));

        // lambda
        MathUtils mu = new MathUtils();
        Function<Integer, Integer> instanceRefSquare =
                (num) -> { return  mu.squareInstance(num); };
        System.out.println(instanceRefSquare.apply(5));

        //instance method reference
        Function<Integer, Integer> instanceRefSquare2 = mu::squareInstance;
        System.out.println(instanceRefSquare2.apply(6));

        //parameter reference
        ToIntBiFunction<MathUtils, Integer> parameterRefMethod =
                (mathUtils, num) -> { return mathUtils.squareInstance(num); };
        System.out.println(parameterRefMethod.applyAsInt(mu, 7));

        //생성자 참조
        ToIntBiFunction<Integer, String> lamdaConstructor =
                (id, name) -> { new MathUtils(id, name); return 0;};
        //int constructorRef = MathUtils::new;  MathUtils가 functional interface라면 같은 의미임.
        //class::new;
        int result = lamdaConstructor.applyAsInt(11111, "name");
        System.out.println(result);

    }
}
