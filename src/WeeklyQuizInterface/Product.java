package WeeklyQuizInterface;

public class Product {
    final private String name;
    final private int weight; //무게
    final private int price; //가격
    private int discountAmount; //할인금액

    Product(String name, int price, int weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discountAmount = 0;
    }

    // 주어진 main 함수에서 할인 금액을 인자로 넘기지 않는다.
    // 상품별 할인금액의 속성은 필요하므로 추가함.
    public void setDiscountAmount(int discountAmount){
        this.discountAmount = discountAmount;
    }

    public int getPrice(){return price;}
    public int getWeight(){return weight;}
    public int getDiscountAmount(){return discountAmount;}

}

class Grocery extends Product{
    public Grocery(String name, int price, int weight){
        super(name, price, weight);
        setDiscountAmount(2_000);//주어진 고정값
    }
}

class Beauty extends Product{
    public Beauty(String name, int price, int weight){
        super(name, price, weight);
        setDiscountAmount(10_000);//주어진 고정값
    }
}

class LargeAppliance extends Product{
    public LargeAppliance(String name, int price, int weight){
        super(name, price, weight);
        setDiscountAmount(0);//주어진 고정값
    }
}
