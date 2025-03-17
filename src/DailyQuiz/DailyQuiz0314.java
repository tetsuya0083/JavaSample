package DailyQuiz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DailyQuiz0314 {
    public static void main(String[] args) {
        Random random = new Random();
        int randNum = random.nextInt(9999) + 1;

        Solution1 sol1 = new Solution1();
        System.out.println("sol1: " + sol1.solution(randNum));

        Solution2 sol2 = new Solution2();
        String str2 = "Hello";
        int num2 = random.nextInt(99)+1;
        System.out.println("sol2: " + sol2.solution(str2, num2));

        Solution3 sol3 = new Solution3();
        int a = random.nextInt(9_999) + 1;
        int b = random.nextInt(9_999) + 1;
        int num3 = sol3.solution(a, b);
        System.out.println("sol3: " + num3);

        Solution4 sol4 = new Solution4();
        sol4.Solution();

        Solution5 sol5 = new Solution5();
        int num5 = sol5.solution(a, b);
        System.out.println("sol5: " + num5);

        Solution6 sol6 = new Solution6();
        String[] arrStr6 = sol6.solution("banana");
        for (String str : arrStr6){
            System.out.println("sol6: " + str);
        }
    }

    //정수 n이 주어질 때, n을 문자열로 변환하여 return하도록
    //제한 사항: 1 ≤ n ≤ 10000
    static class Solution1 {
        public String solution(int n) {
            String answer = "";
            answer = Integer.toString(n);
            return answer;
        }
    }

    //문자열 my_string과 정수 k가 주어질 때,
    // my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.
    //제한사항
    //1 ≤ my_string의 길이 ≤ 100
    //my_string은 영소문자로만 이루어져 있습니다.
    //1 ≤ k ≤ 100
    static class Solution2 {
        public String solution(String my_string, int k) {
            String answer = "";
//            ArrayList<String> arrList = new ArrayList<>(k);
//            for (int i = 0; i < k; i++){
//                arrList.add(my_string);
//            }
//            answer = String.join("", arrList);
            return my_string.repeat(k);
        }
    }

    //연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
    //
    //12 ⊕ 3 = 123
    //3 ⊕ 12 = 312
    //양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
    //단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
    //제한사항
    //1 ≤ a, b < 10,000
    static class Solution3 {
        public int solution(int a, int b) {
            int answer = 0;;
            int num1 = Integer.parseInt(a + "" + b);
            int num2 = Integer.parseInt(b + "" + a);
            //Java는 정수형 자료형(int) + 문자열 자료형(String)을 +연산하면
            //int가 자동으로 String으로 변경되어 연산된다.
            answer = Math.max(num1, num2);
            return answer;
        }
    }

    //두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
    //입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.
    //apple pen -> applepen
    //제한사항
    //1 ≤ str1, str2의 길이 ≤ 10
    static class Solution4 {
        public void Solution(){
            Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String b = sc.next();
            System.out.println("sol4: " + a + b);
        }
    }

    //연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
    //
    //12 ⊕ 3 = 123
    //3 ⊕ 12 = 312
    //양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
    //
    //단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
    //제한사항
    //1 ≤ a, b < 10,000
    static class Solution5 {
        public int solution(int a, int b) {
            int answer = 0;
            int num1 = Integer.parseInt(a + "" + b);
            int num2 = 2 * a * b;
            answer = Math.max(num1, num2);
            return answer;
        }
    }

    //어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
    //예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
    //문자열 my_string이 매개변수로 주어질 때,
    //my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
    //제한사항
    //my_string은 알파벳 소문자로만 이루어져 있습니다.
    //1 ≤ my_string의 길이 ≤ 100
    static class Solution6 {
        public String[] solution(String my_string) {
            String[] answer = {};

            int len = my_string.length();
            String[] suffixes = new String[my_string.length()];
            for (int i = 0; i < len; i++){
                suffixes[i] = my_string.substring(i);
            }
            Arrays.sort(suffixes);
            answer = suffixes;

            return answer;
        }
    }

}
