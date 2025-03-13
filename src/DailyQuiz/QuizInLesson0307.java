package DailyQuiz;

import java.util.Map;
import java.util.LinkedHashMap;

public class QuizInLesson0307 {
    public static void main(String[] args) {
        //"aaaabbccd" 문자열 한 글자씩 출력하기.
        StringBuilder sb1 = new StringBuilder("aaaabbccd");
        System.out.println(sb1);
        for (int i = 0; i < sb1.length(); i++){
            System.out.println(sb1.charAt(i));
        }

        //단어 순서 뒤집기
        //"Hello Welcome Java" -> "Java Welcome Hello"
        String str2 = "Hello Welcome Java";
        String[] arrSplit = str2.split(" ");
        for (int i = arrSplit.length - 1; i >= 0 ; i--){
            System.out.print(arrSplit[i]+" ");
        }

        //공백제외해서 하나의 문자로 출력
        //"    Hello Welcome Java    " -> "HelloWelcomeJava"
        String str3 = "    Hello Welcome Java    ";
        System.out.println(str3.replace(" ",""));

        //연속된 문자의 반복 횟수로 문자열 압축해보기
        //"aaaabbccd" -> "a4b2c2d1"
        String str = "aaaabbccd";
        Map<Character, Integer> charNumMap = new LinkedHashMap<>();
        StringBuilder sb4 = new StringBuilder();

        for (char c : str.toCharArray()){
            charNumMap.put(c, charNumMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charNumMap.entrySet()){
            sb4.append(entry.getKey()).append(entry.getValue());
        }
        System.out.println(sb4);


    }
}
