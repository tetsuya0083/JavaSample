import java.util.*;

public class CollectionSample {
    public static void main(String[] args) {

        //ArrayList
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
        System.out.println(" ");

        //LinkedList
        List<String> linkedList = new LinkedList<>();
        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.add("linkedList");
        System.out.println(linkedList2.get(0));

        //HashSet
        //값이 중복되지 않음. 순서를 보장하지 않음.
        HashSet<Integer> hashSetA = new HashSet<>();
        hashSetA.add(1);
        hashSetA.add(2);
        hashSetA.add(2);
        hashSetA.add(2);
        hashSetA.add(3);

        Iterator hi = (Iterator) hashSetA.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }

        HashSet<Integer> hashSetB = new HashSet<>();
        hashSetB.add(3);
        hashSetB.add(4);
        hashSetB.add(5);

        HashSet<Integer> hashSetC = new HashSet<>();
        hashSetC.add(1);
        hashSetC.add(2);

        System.out.println(hashSetA.containsAll(hashSetB));//false
        System.out.println(hashSetA.containsAll(hashSetC));//true

//        hashSetA.addAll(hashSetB);
        hashSetA.retainAll(hashSetB);//intersect
//        hashSetA.removeAll(hashSetB);//difference

        Iterator hi2 = (Iterator) hashSetA.iterator();
        while(hi2.hasNext()){
            System.out.println(hi2.next());
        }










    }
}
