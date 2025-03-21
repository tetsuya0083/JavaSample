package DailyQuiz;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DailyQuiz0320 {

    static class PrintMoreBigNumber{
        public List<Integer> solution(int n, int[] array) {
            List<Integer> answer = new ArrayList<>();
            // 코드 작성
            // not stream ver.
            int i = 0;
            do {
                if(i == 0){
                    answer.add(array[i]);
                }else if (array[i] > array[i -1]){
                    answer.add(array[i]);
                }
                i++;
            }while(i < array.length);

            // stream ver.
            answer.add(array[0]);
            List<Integer> filteredList = IntStream.range(1, n)
                    .filter(j -> array[j] > array[j-1])
                    .mapToObj(j -> array[j])/*.map(j -> array[j]).boxed()*/
                    .toList();
            answer.addAll(filteredList);

            return answer;
        }
    }

    static class AscendingSort {
        public int[] solution(int[] array1, int[] array2) {
            int[] result = new int[array1.length + array2.length];

            // 코드 작성
            // not stream ver.
            System.arraycopy(array1, 0, result, 0, array1.length);
            System.arraycopy(array2, 0, result, array1.length, array2.length);
            Arrays.sort(result);

            //stream ver.
//            Stream<Integer> stream1 = Arrays.stream(array1).boxed();
//            Stream<Integer> stream2 = Arrays.stream(array2).boxed();
//            Stream<Integer> concatStream = Stream.concat(stream1, stream2);
//            List<Integer> concatSortedList = concatStream.sorted().toList();
            List<Integer> concatSortedList =
                    Stream.concat(Arrays.stream(array1).boxed(), Arrays.stream(array2).boxed())
                            .sorted()
                            .toList();
            for (int i = 0; i < result.length; i++){
                result[i] = concatSortedList.get(i);
            }
            return result;
        }
    }

    public static void main(String[] args){

        /*
        1. 큰 수 출력하기
        N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작
        성하세요. (첫 번째 수는 무조건 출력합니다)
        입력설명
        첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력됩니다.

        출력설명
        자신의 바로 앞 수보다 큰 수만 한 줄로 출력합니다.

        입력 예제
        6
        7 3 9 5 6 12

        출력 예제
        7 9 6 12
        */
        PrintMoreBigNumber printMoreBigNumber = new PrintMoreBigNumber();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("1번 문제");
        for (int x : printMoreBigNumber.solution(number, array)) {
            System.out.print(x + " ");
        }

        /*
        2. 두 배열 합치기
        입력설명
        첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
        두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
        세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
        네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
        각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

        출력설명
        오름차순으로 정렬된 배열을 출력합니다.

        입력 예제
        3
        1 3 5
        5
        2 3 6 7 9

        출력 예제
        1 2 3 3 5 6 7 9
        */
        AscendingSort ascendingSort = new AscendingSort();
        Scanner scanner2 = new Scanner(System.in);

        int number2 = scanner2.nextInt();
        int[] array2 = new int[number2];

        for (int i = 0; i < number2; i++) {
            array2[i] = scanner2.nextInt();
        }

        int number3 = scanner2.nextInt();
        int[] array3 = new int[number3];

        for (int i = 0; i < number3; i++) {
            array3[i] = scanner2.nextInt();
        }

        System.out.println("");
        System.out.println("2번 문제");
        for (int x : ascendingSort.solution(array2, array3)) {
            System.out.print(x + " ");
        }

    }
}