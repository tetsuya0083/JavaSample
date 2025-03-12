abstract class Aabstract{
    // class Aabstract가 abstract method인 b()를 가지고 있기 때문에
    // abstract class Aabstract가 된 것이다.

    // 본체{System.out.println("hello")}가 있는 메소드는 abstract 키워드를 가질 수 없다.
    // public abstract int c(){System.out.println("hello")} -> error다. 이렇게 안된다는 것임.
    public abstract int b();//abstract method.
    // 상속, 오버라이딩해서 구체적인 본체{}를 구현해서 사용해야함.
    // C++ 가상함수와 비슷?

    // 추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재 할 수 있다.
    public void d(){
        System.out.println("World");
    }
}
class Babstract extends Aabstract{
    public int b(){
        return 1;
    }
}

public class abstractSample {
    public static void main(String[] args) {
        //A obj = new A(); error, abstract(추상) class는 반드시 상속을 받아서 사용해야한다.
        //즉 abstract는 상속을 강제하기 위해서 사용함.
        Babstract obj = new Babstract();

    }
}
