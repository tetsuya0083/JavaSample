package WeeklyQuizInterface;

public class Cart {
    final private Product[] products;

    Cart(Product[] products){
        this.products = products;
    }

    //배송비 계산
    public int calculateDeliveryCharge(){
        int deliveryCharge;
        int discount;
        int totalWeight = 0;
        int totalPrice = 0;

        for (Product product : products){
            totalWeight += product.getWeight();
            totalPrice += ( product.getPrice() - product.getDiscountAmount() );
        }

        //무게의 총합 구간에 따른 배송비 설정
        if (totalWeight < 3){
            deliveryCharge = 1_000;
        } else if (totalWeight < 10) {
            deliveryCharge = 5_000;
        } else {
            deliveryCharge = 10_000;
        }

        //상품 가격 총합 구간에 따른 배송비 할인 금액
        if(totalPrice <= 100_000){
            discount = 1_000;
        } else {
            discount = deliveryCharge;
        }

        deliveryCharge -= discount;

        return deliveryCharge;
    }
}
