import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
//import java.util.*;

public class StreamSample {
    public static void main(String[] args) {

        //Collection
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        list2.add(3, "grape");
        Stream<String> colStream = list.stream();
        Stream<String> colStream2 = list2.stream();
        colStream.forEach(System.out::println);
        colStream2.forEach(System.out::println);
//        Array array;
//        Arrays arrays;


        //Array
        String[] strArr = {"apple", "banana", "cherry"};
        Stream<String> arrStream = Arrays.stream(strArr);


        //Stream.of() method
        Stream<String> streamOf = Stream.of("apple", "banana", "cherry");

        //Builder pattern
        Stream<String> builderStream = Stream.<String>builder()
                .add("apple").add("banana").add("cherry").build();

        //range & rangeClosed & random
        IntStream intStream =IntStream.range(1, 5); //[1, 2, 3, 4]
        LongStream longStream = LongStream.rangeClosed(1, 5);//[1, 2, 3, 4, 5]
        DoubleStream doubleStream = new Random().doubles(5);//난수 5개

        //from File---
        //File class
        try {
            Stream<String> fileStream = Files.lines(Paths.get("stream_file.txt"), Charset.forName("UTF-8"));
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        //BufferedReader class
//        FileReader fileReader = new FileReader(Paths.get("file.txt").toFile());
//        BufferedReader br = new BufferedReader(fileReader);
//        stream = br.lines();
//        stream.forEach(System.out::println);
//        //---

        //Stream.concat
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);

        Stream<Integer> newStream = Stream.concat(stream1, stream2);
        newStream.forEach(System.out::println); // 1, 2, 3, 4, 5, 6

        //distinct
        System.out.println("distinct");
        List<String> distinctlist = Arrays.asList("a", "b", "b", "c", "d");
        // [a, b, c, d]
        distinctlist.stream()
                    .distinct()
                    .forEach(System.out::println);

        //filter
        System.out.println("filter");
        List<String> filterlist = Arrays.asList("김밥", "김밥", "김치", "나비", "나방");
        // [김밥, 김밥, 김치]
        filterlist.stream()
                .filter(str -> str.startsWith("김"))
                .forEach(System.out::println);

        //distinct & filter
        System.out.println("distinct & filter");
        List<String> distFilterlist = Arrays.asList("김밥", "김밥", "김치", "나비", "나방");
        // [김밥, 김치]
        distFilterlist.stream()
                .distinct()
                .filter(str -> str.startsWith("김"))
                .forEach(System.out::println);

        //map
        List<String> maplist = Arrays.asList("a", "b", "c", "d", "e");
        // [A, B, C, D, E]
        maplist.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //flatMap
        List<String> flatMaplist = Arrays.asList("Hello World", "Java stream");
        // [Hello, World, Java, stream]
        flatMaplist.stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .forEach(System.out::println);

        //sorted
        List<Integer> sortedNumberlist = Arrays.asList(12, 4, 2, 8, 11);
        // [2, 4, 8, 11, 12]
        sortedNumberlist.stream()
                .sorted()
                .forEach(System.out::println);
        List<String> sortedCharlist = Arrays.asList("e", "a", "c", "z", "d");
        // [a, c, d, e, z]
        sortedCharlist.stream()
                .sorted()
                .forEach(System.out::println);
        List<String> sortedCharRevlist = Arrays.asList("e", "a", "c", "z", "d");
        // [z, e, d, c, a]
        sortedCharRevlist.stream()
                .sorted(Comparator.reverseOrder())  // 역순 정렬
                .forEach(System.out::println);

        //peek
        System.out.println("peek");
        List<Integer> peekList = Arrays.asList(1, 2, 3, 4, 5);
        int sum = peekList.stream()
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println(n))//2, 4
                .sum();  // sum을 사용하지 않으면 peek은 동작하지 않음
        System.out.println("peek sum: " + sum);//6

        //forEach
        List<Integer> forEachList = Arrays.asList(1, 2, 3, 4, 5);
        forEachList.stream()
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));//2, 4

        //collect()
        List<Integer> collectList = Arrays.asList(1, 2, 3, 4, 5);
        // 짝수만 골라내어 새로운 리스트로 collect
        List<Integer> newCollectList = collectList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        newCollectList.stream().forEach(System.out::println);//2, 4

        List<Integer> collectSetList = Arrays.asList(1, 2, 3, 4, 5);
        Set<Integer> set = collectSetList.stream()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toCollection(HashSet::new));
        set.stream().forEach(System.out::println);  // {1, 3, 5}

        List<Integer> groupingList = Arrays.asList(1, 1, 2, 2, 2, 3, 4, 5, 5, 5);

        Map<Integer, Long> result = groupingList.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting() ) );
        /*
         * 1: 2개
         * 2: 3개
         * 3: 1개
         * 4: 1개
         * 5: 3개
         */
        result.forEach((key, value) -> System.out.println(key + ": " + value + "개"));





    }
}
