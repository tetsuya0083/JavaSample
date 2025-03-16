import java.util.*;

public class CollectionSample {
    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<>(10);
        //capacity 10: 용량. 내부 배열의 크기(자동 증가 가능)
        //list 자체는 비어있음. 객체(요소)가 없음.
        //메모리만 할당.
        System.out.println(arrList.size()); // 0

        arrList.add("0");
        arrList.add("1");
        arrList.add("2");
        arrList.add("3");
        arrList.add("4");
        System.out.println("arrary size: " + arrList.size()); // 5

        for (int i = 0; i < arrList.size(); i++){
            System.out.println("index: " + i + " " + "object: " + arrList.get(i));
        }
        System.out.println(" ");

        arrList.remove(2);
        /*
        index 2의 객체 "2"를 삭제
        -> index 2에 index 3의 객체가 채워짐.
        -> index 3에 index 4의 객체가 채워짐.
        즉 삭제된 index 부터 객체가 한칸씩 앞으로 당겨짐.
        */
        for (int i = 0; i < arrList.size(); i++){
            System.out.println("index: " + i + " " + "object: " + arrList.get(i));
        }




    }
}
