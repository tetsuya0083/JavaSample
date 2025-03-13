package DailyQuiz;

import java.util.Arrays;

//정수 리스트 num_list가 주어질 때,
//마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
//마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return
//제한사항
//2 ≤ num_list의 길이 ≤ 10
//1 ≤ num_list의 원소 ≤ 9
class Solution1 {
    public int[] solution(int[] num_list) {
        int[] answer = {};

        int lastNum = num_list[num_list.length - 1];
        int prevNum = num_list[num_list.length - 2];
        int addNum = 0;

        addNum = (lastNum > prevNum) ? (lastNum - prevNum) : (lastNum * 2);

        answer = Arrays.copyOf(num_list, num_list.length + 1);
        answer[answer.length - 1] = addNum;

        return answer;
    }
}

//정수 리스트 num_list와 찾으려는 정수 n이 주어질 때,
//num_list안에 n이 있으면 1을 없으면 0을 return하도록 solution 함수를 완성해주세요.
//제한사항
//3 ≤ num_list의 길이 ≤ 100
//1 ≤ num_list의 원소 ≤ 100
//1 ≤ n ≤ 100
class Solution2 {
    public int solution(int[] num_list, int n) {
        int answer = 0;

        for (int i : num_list){
            if (n == i){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}

//정수 start_num와 end_num가 주어질 때,
// start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록
//제한사항
//0 ≤ start_num ≤ end_num ≤ 50
class Solution3 {
    public int[] solution(int start_num, int end_num) {
        int[] answer = {};
        int maxIndex = end_num - start_num + 1;
        answer = Arrays.copyOf(answer, maxIndex);
        for (int i = 0; i < maxIndex; i++){
            answer[i] = start_num + i;
        }
        return answer;
    }
}
//문제 설명
//정수 배열 arr가 주어집니다.
// arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고,
// 50보다 작은 홀수라면 2를 곱합니다.
// 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
//제한사항
//1 ≤ arr의 길이 ≤ 1,000,000
//1 ≤ arr의 원소의 값 ≤ 100
class Solution4 {
    public int[] solution(int[] arr) {
//        int[] answer = {};
//        int maxIndex = arr.length;
//        answer = Arrays.copyOf(answer, maxIndex);
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            if ( (arr[i] >= 50) && (arr[i] % 2 == 0) ){
                answer[i] = arr[i] / 2;
            }
            else if ((arr[i] < 50) && (arr[i] % 2 == 1)){
                answer[i] = arr[i] * 2;
            }else {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}



public class DailyQuiz0311 {
    public static void main(String[] args) {
        int[] num_list = {7,9,2};
        Solution1 sol1 = new Solution1();
        int[] result1 = sol1.solution(num_list);
        System.out.println(Arrays.toString(result1));

        int[] num_list2 = {1,2,3,4,5};
        int num2 = 3;
        Solution2 sol2 = new Solution2();
        int result2 = sol2.solution(num_list2, num2);
        System.out.println(result2);

        int num3_1 = 7;
        int num3_2 = 13;
        Solution3 sol3 = new Solution3();
        int[] result3 = sol3.solution(num3_1, num3_2);
        System.out.println(Arrays.toString(result3));

        int[] arrNum4 = {14, 35, 62, 63, 78, 77};
        Solution4 sol4 = new Solution4();
        int[] result4 = sol4.solution(arrNum4);
        System.out.println(Arrays.toString(result4));

    }
}
