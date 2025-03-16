package WeeklyQuizInterface;

public class Cart implements Promotion {
    final private Product[] products;

    Cart(Product[] products){
        this.products = products;
    }

    //배송비 계산
    public int calculateDeliveryCharge(){
        int deliveryCharge;
        int totalWeight = 0;

        for (Product product : products){
            totalWeight += product.getWeight();
        }

        //무게의 총합 구간에 따른 배송비 설정
        if (totalWeight < 3){
            deliveryCharge = 1_000;
        } else if (totalWeight < 10) {
            deliveryCharge = 5_000;
        } else {
            deliveryCharge = 10_000;
        }

        deliveryCharge -= getDiscountAmount(deliveryCharge);

        return deliveryCharge;
    }

    //Promotion 이벤트
    @Override
    public int getDiscountAmount(int deliveryCharge){
        int totalPrice = 0;
        int discount = 0;

        //상품 가격 총합 구간에 따른 배송비 할인 금액
        for (Product product : products){
            totalPrice += product.getPrice();
        }
        if(totalPrice <= 100_000){
            discount = 1_000;
        } else {
            discount = deliveryCharge;
        }
        return discount;
    }
}
