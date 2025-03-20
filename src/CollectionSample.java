import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionSample {

    static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while (i.hasNext()){
            System.out.println(i.next().getKey() +" : " + i.next().getValue());
        }
    }

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

        Iterator hi = hashSetA.iterator();
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

        //Map
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        System.out.println("HashMap: " + hm.get("one"));
        System.out.println("HashMap: " + hm.get("two"));
        System.out.println("HashMap: " + hm.get("three"));
        System.out.println("HashMap size: " + hm.size());

        Set<String> keySet = hm.keySet();//순서를 보장하지 않는다!!!
        Iterator<String> itr = keySet.iterator();
        while(itr.hasNext()){
            String key = itr.next();
            Integer value = hm.get(key);
            System.out.println("HashMap used keySet:" + key + value);
        }

        iteratorUsingForEach(hm);
        iteratorUsingIterator(hm);

        //Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);

        System.out.println("Top element: " + stack.peek());//the lastest push element, 33
        System.out.println("pop element: " + stack.pop());//pop element, 33
        System.out.println("Is stack empty? " + stack.isEmpty());// false
        System.out.println("stack size: " + stack.size());//2

        String strStack = "Hello";
        Stack<Character> charStack = new Stack<>();
        for (char c : strStack.toCharArray()){
            charStack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(charStack.isEmpty() == false){
            sb.append(charStack.pop());
        }
        System.out.println(sb);//olleH

        //Queue
        //Queue - LinkedList
        Queue<String> queueLL = new LinkedList<>();

        queueLL.offer("Apple");
        queueLL.offer("Banana");
        queueLL.offer("Cherry");

        System.out.println("Front element: " + queueLL.peek()); // the oldest element, Apple
        System.out.println("Removed: " + queueLL.poll()); // poll oldest element, Apple
        System.out.println("Queue size: " + queueLL.size()); //2
        System.out.println(queueLL);//[Banana, Cherry]

        //Queue - ArrayDeque
        Queue<Integer> queueAD = new ArrayDeque<>();

        queueAD.offer(0);
        queueAD.offer(1);
        queueAD.offer(2);

        System.out.println("Front element: " + queueAD.peek()); // 0
        System.out.println("Removed: " + queueAD.poll()); // the oldest element, 0
        System.out.println(queueAD);// [1, 2]












    }
}
