class Calculator {
    int result = 0;

    int add(int num) {
        result += num;
        return result;
    }

    int multiple(int num) {
        result *= num;
        return result;
    }
}

class Car {
    String company;
    String model;
    int maxSpeed;

    //1번 생성자
    Car(String company) {
        this.company = company;
    }

    //2번 생성자
    Car(String company, String model) {
        this.company = company;
        this.model = model;
    }

    //3번 생성자
    Car(String company, String model, int maxSpeed) {
        this.company = company;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}

public class ClassSample {
    public static void main(String[] args) {

        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();

        System.out.println(cal1.add(5));
        System.out.println(cal1.add(4));
        System.out.println(cal1.multiple(2));

        System.out.println(cal2.add(1));
        System.out.println(cal2.add(10));

        Car sonata = new Car("현대");                 // 1번 생성자 이용
        Car sportage = new Car("기아", "sportage");   // 2번 생성자 이용
        Car gv80 = new Car("제네시스", "gv80", 300);   // 3번 생성자 이용

        System.out.println(sonata.getCompany());;
    }
}
