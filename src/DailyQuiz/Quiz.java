package DailyQuiz;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Quiz {
    public static void main(String args[]) {
//        for (int i = 2; i < 10; i++){
//            for (int j = 1; j < 10; j++){
//                int result = i * j;
//                System.out.printf(String.valueOf(result + " "));
//            }
//            System.out.println("\n");

        Scanner scanner1 = new Scanner(System.in);
        int num = parseInt(scanner1.nextLine());
        System.out.println("input number: " + num);

        int result = 1;
        while(num>0){
            result = result * num;
            num--;
        }
        System.out.println("result: " + result);

        Scanner scanner2 = new Scanner(System.in);
        int dan = parseInt(scanner2.nextLine());
        System.out.println("input dan: " + dan );
        for (int i = 1; i <= 9; i++){
            System.out.println(dan + " * " + i +  " = " + dan * i);
        }

        //별 그리기
        Scanner scanner3 = new Scanner(System.in);
        int ln = parseInt(scanner3.nextLine());
        for (int i = 0; i < ln; i++){
            for (int j = ln; j > ln-i; j--){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        //입력받은 숫자 뒤집어서 출력하기.
        Scanner scanner4 = new Scanner(System.in);
        int number = scanner4.nextInt();
        String reversed = new StringBuilder(String.valueOf(number)).reverse().toString();
        System.out.println(reversed);

        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10; // 마지막 자리 숫자 가져오기
            reversedNumber = reversedNumber * 10 + digit; // 숫자 뒤집기
            number /= 10; // 마지막 자리 제거
        }

        // 결과 출력
        System.out.println("뒤집힌 숫자: " + reversedNumber);




    }
}