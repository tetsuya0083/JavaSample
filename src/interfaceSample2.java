interface I{
    public void z();
    // interface의 접근 제어자는 당연히 public이지. impletemts하는 class에서 접근 및 구현해야하므로.
}
interface I2{
    public void x();
}

class A implements I, I2{
    public void z() {  }
    //interface I의 z()를 class A에서 반드시 구현해야함.
    //interface I는 해당 인터페이스를 implements하는 class에서 z() method를 구현하도록 강제하는 것임.
    public void x() {  }
    // I, I2를 implements. I의 z(), I2의 x() 모두 구현해야함.
}

interface I3{
    public void x();
}
interface I4 extends I3{
    public void z();
}
class B implements I4{
    public void x(){}; // I4가 I3을 상속함. I3의 x()를 구현해야함.
    public void z(){}; //
}
//인터페이스는 상속됨.

//개발자A가 개발하기로 한 기능
interface Calculatable {
    public void setOprands(int first, int second, int third) ;
    public int sum();
    public int avg();
}

//개발자B는 개발자A가 개발할 Calculatable을 Dummy로 implements해서 개발한다.
class CalculatorDummy implements Calculatable{
    public void setOprands(int first, int second, int third){}
    public int sum(){
        return 60;
    }
    public int avg(){
        return 20;
    }
}
//개발자B가 개발 중인 기능.
class CalculatorA implements Calculatable {
    int first, second, third;
    public void setOprands(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public int sum() {
        return this.first + this.second + this.third;
    }
    public int avg() {
        return (this.first + this.second + this.third) / 3;
    }
}

class CalculatorUser{
    public static void main(String[] args){
        CalculatorA c = new CalculatorA();//동시 작업(협업)과 협의된 내용(스펙)을 구현하기에 유리함.
        c.setOprands(10,20,30);
        System.out.println(c.sum()+c.avg());
    }
}

public class interfaceSample2 {
}
