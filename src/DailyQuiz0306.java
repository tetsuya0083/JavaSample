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

    }
}
