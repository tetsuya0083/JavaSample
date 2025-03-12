class Animal{
    String species;
    Animal(){
        this.species = "Default";
        System.out.println("parent: " + species);
    }
}

class Dog extends Animal{
    String name;
    Dog(){
        this.name = "Default";
        System.out.println("child: " + name);
    }
}

class Personinherit{
    private String name;
    private String ssn;
    public Personinherit(String name, String ssn){
        this.name = name;
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }
}

class Student extends Personinherit{
    int studentNo;

    public Student(String name, String ssn, int studentNo){
        super(name, ssn);
        this.studentNo = studentNo;
    }
}

class Calculator2 {
    private static final double PI = 3.14159;

    double areaCircle(double r) {
        System.out.println("Calculator 객체의 areaCircle() 실행");
        return PI * r * r;
    }
}

class Computer extends Calculator2 {
    @Override
    double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}

public class inheritanceSample {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Student student = new Student("길동", "123456-1234567", 1);

        System.out.println("name: " + student.getName());	// 부모에게서 물려받은 필드 출력
        System.out.println("ssn: " + student.getSsn());		// 부모에게서 물려받은 필드 출력
        System.out.println("studentNo: " + student.studentNo);

        int r = 10;

        Calculator2 calculator = new Calculator2();
        System.out.println("원면적: " + calculator.areaCircle(r));
        System.out.println();

        Computer computer = new Computer();
        System.out.println("원면적: " + computer.areaCircle(r));    // 재정의된 메소드 호출



    }
}
