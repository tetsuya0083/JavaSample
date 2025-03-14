import java.util.*;

class Person<T> {
    public T info;

    public Person(T info) {
        this.info = info;
    }
}

class Box<T>{
    private T value;

    public void setValue(T value){
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}

class Util{
    public static <T> void print(T value){
        System.out.println(value);
    }
}
class Util2{
    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.setValue(t);
        return box;
    }

    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        return Double.compare(v1, v2);
    }
}

class WildcardExample {
    //Unbounded Wildcard
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    //Upper Bounded Wildcard (? extends Number) - Number 또는 그 자식 클래스만 가능
    public static double sumOfNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue(); // Number 타입이므로 double 변환 가능
        }
        return sum;
    }

    //Lower Bounded Wildcard (? super Integer) - Integer 또는 그 부모 클래스만 가능
    public static void addNumbers(List<? super Integer> list) {
        list.add(100); // Integer 값 추가 가능
        list.add(200);
        // list.add(3.14); error, Double은 Integer의 부모가 아님
    }
}

class genericParent<T>{
    T value;
    public genericParent(T value){
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
class genericChild<T> extends genericParent<T>{
    public genericChild(T value){
        super(value);
    }
    public void genericChildType(){
        System.out.println("genericChild Type: " + value.getClass().getName());
    }
}
class genericStringChild extends genericParent<String>{
    public genericStringChild(String value){
        super(value);
    }
    public void useParentUpperCase(){
        System.out.println("Upper Case: " + value.toUpperCase());
    }
}
class genericAddTypeChild<T, R> extends genericParent<T>{
    R childValue;
    public genericAddTypeChild(T value, R childValue){
        super(value);
        this.childValue = childValue;
    }
    public void showValueTypes(){
        System.out.println("T value: " + value + " " + value.getClass().getName());
        System.out.println("R value: " + childValue + " " + childValue.getClass().getName());
    }
}



public class GenericSample {
    public static void main(String[] args) {

        Person<String> p1 = new Person<String>("Hello");
        Person<StringBuilder> p2 = new Person<StringBuilder>(new StringBuilder());
        p2.info.append("World");
        System.out.println(p1.info+p2.info);

        // no generic
        ArrayList normalList = new ArrayList();
        normalList.add("No generic");
        normalList.add(123); // 자료형이 달라도 배열에 들어가기는 함. 그래서 문제.

        String str1 = (String) normalList.get(0); // If doesn't casting, compile error
        /*String str2 = (String) normalList.get(1);
        compile error
        ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
        (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')*/

        System.out.println(str1);
        //System.out.println(str2);

        // generic
        ArrayList<String> generalList = new ArrayList<>();
        generalList.add("Generic");
        //generalList.add(0); compile error

        String str3 = generalList.get(0);
        System.out.println(str3);

        //generic class
        //class Box Type에 다양한 타입을 사용할 수 있음.
        Box<Integer> intBox = new Box<>(); //이 객체의 T(Type)는 Integer
        intBox.setValue(100);
        System.out.println(intBox.getValue());

        Box<String> strBox = new Box<>(); // 이 객체의 T는 String
        strBox.setValue("100");
        System.out.println(strBox.getValue());

        //generic method
        Util.print(200);
        Util.print("generic method");
        Util.print(3.14);

        Box<Integer> utilBox1 = Util2.boxing(300);
        System.out.println(utilBox1.getValue());

        Box<String> utilBox2 = Util2.boxing("generic method2");
        System.out.println(utilBox2.getValue());

        //
        int result1 = Util2.compare(1, 2);// int -> Integer (자동 Boxing)
        System.out.println(result1);

        int result2 = Util2.compare(4.5, 3);// double -> Double (자동 Boxing)
        System.out.println(result2);

        //wildcard
        //? -> 모든 타입 받을 수 있음.
        // Unbounded Wildcard
        List<String> strList1 = Arrays.asList("Apple", "Banana", "Cherry");
        List<Integer> intList1 = Arrays.asList(1,1,1,1,1);
        System.out.println("Unbounded Wildcard: ");
        WildcardExample.printList(strList1);
        WildcardExample.printList(intList1);

        //? extends T -> T 또는 T를 상속받은 타입만 가능
        // Upper Bounded Wildcard
        List<Integer> intList2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList2 = Arrays.asList(1.1, 1.2, 1.3);
        List<String> strList2 = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("Upper Bounded Wildcard (Sum of Numbers): ");
        System.out.println(WildcardExample.sumOfNumbers(intList2));
        System.out.println(WildcardExample.sumOfNumbers(doubleList2));
        /*
        * System.out.println(WildcardExample.sumOfNumbers(strList2));
        * strList2의 Type String은 Number를 상속받지 않음.
        * 즉, Number를 상속받은 Integer, Double 등의 Type만 가능함.
        */

        //? super T -> T 또는 T의 부모 타입만 가능
        // Lower Bounded Wildcard
        List<Number> numList3 = new ArrayList<>();
        WildcardExample.addNumbers(numList3);
        System.out.println("Lower Bounded Wildcard:");
        WildcardExample.printList(numList3);

        //inherit 샹속.
        //case 1.
        //타입 유지. 자식의 타입이 부모의 타입.
        genericChild<Integer> child = new genericChild<>(500);
        System.out.println("value: " + child.getValue());
        child.genericChildType();

        //case 2.
        //부모로 부터 T를 String으로 상속(부모는 T, 자식은 String으로 사용하겠다.)
        genericParent<Integer> intParent = new genericParent<>(600);
        genericStringChild child2 = new genericStringChild("hello");
        System.out.println("Value: " + child.getValue());
        System.out.println(intParent.value);
        child2.useParentUpperCase();

        //case 3.
        //자식은 Type R을 추가, T는 부모로 부터 상속
        genericAddTypeChild<Integer, String> child3 = new genericAddTypeChild<>(700, "child add type");
        child3.showValueTypes();

        //case 4. ...

        //인터페이스도 상속.
    }
}
