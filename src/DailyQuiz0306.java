import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DailyQuiz0306 {
    public static void main(String[] args) {
        //-----------------------------------------------------------------------
        // 1.
        // for문을 이용해서 a배열의 값을 b배열로 복사해보세요.
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = new int[3][3];

        // for문 작성하는 부분
        // …
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                b[i][j] = a[i][j];
            }
        }
//        for (int i = 0; i < a.length; i++){
//            System.arraycopy(a[i], 0, b[i], 0, a[i].length);
//        }

        // a배열과 b배열 출력
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("a[" + i + "][" + j + "]: " + a[i][j]);
                System.out.println("b[" + i + "][" + j + "]: " + b[i][j]);
            }
        }

        //-----------------------------------------------------------------------
        // 2.
        // for문을 이용하여 배열에 있는 숫자들의 최대값과 평균을 구하세요.
        int[] array = {12, 4, 7, 20, 1};

        // 코드 작성하는 부분
        // ...
        int max = 0;
        int avg = 0;
        int sum = 0;
        for (int num : array) {
            sum += num;
            if (max < num) {
                max = num;
            }
        }
        avg = sum / array.length;
        // 결과 출력 (최대값: max, 평균: avg)
        System.out.println(max);
        System.out.println(avg);

        // 3.
        //-----------------------------------------------------------------------
        // 0부터 20까지 짝수만 출력하는 코드를 작성해보세요.
        int i = 0;
        do {
            ++i;
            if (i%2==0){
                System.out.println(i);
            }
        }while(i <= 20);

        // 4. 프로그래머스 문제
        //-----------------------------------------------------------------------
        // 짝수의 합: 정수 n이 주어질 때, n이하의 짝수를 모두 더한 값
        class Solution1 {
            public int solution1(int n) {
                int answer = 0;
                for(int i = 1; i <= n; i++){
                    if(i%2!=0) continue;
                    answer += i;
                }
                return answer;
            }
        }
        Solution1 sol =  new Solution1();
        int sumEvenNum = sol.solution1(10);
        System.out.println(sumEvenNum);

        // 배열의 평균:
        // 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록
        class Solution2 {
            public double solution2(int[] numbers) {
                double answer = 0;
                for (int num : numbers){
                    answer += (double) num;
                }
                answer = answer / numbers.length;
                return answer;
                //return Arrays.stream(numbers).average().orElse(0);
            }
        }
        Solution2 sol2 = new Solution2();
        int[] sol2ArrNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double sol2Answer = sol2.solution2(sol2ArrNum);
        System.out.println(sol2Answer);

        // 양꼬치
        // 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
        // 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다.
        // 정수 n과 k가 매개변수로 주어졌을 때,
        // 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지
        // return 하도록 solution 함수를 완성해보세요.
        class Solution3 {
            public int solution3(int n, int k) {
                int answer = 0;
                int lamb = 12000;//n
                int beverage = 2000;//k
                int freeBeverage = n/10;
                answer = (lamb * n) + (beverage * (k - freeBeverage));
                return answer;
            }
        }
        Solution3 sol3 = new Solution3();
        int sol3Lamb = 23;
        int sol3Beverage = 13;
        double sol3Answer = sol3.solution3(sol3Lamb, sol3Beverage);
        System.out.println(sol3Answer);

    }
}
