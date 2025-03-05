class Person<T>{
    public T info;
    public Person(T info){
        this.info = info;
    }
}

public class Generic {
    public static void main(String[] args) {
       Person<String> p1 = new Person<String>("Hello");
       Person<StringBuilder> p2 = new Person<StringBuilder>(new StringBuilder());
       p2.info.append("World");

       System.out.println(p1.info+p2.info);

    }
}
