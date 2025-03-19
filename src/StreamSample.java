import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
//import java.util.*;

public class StreamSample {
    public static void main(String[] args) {

        //Collection
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Stream<String> colStream = list.stream();
        colStream.forEach(System.out::println);


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












    }
}
