import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Integer> arrayList = new ArrayList<>();

        /* AutoBoxing */
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("ArrayList: " + arrayList);

        //Generic
        ArrayList<String> list = new ArrayList<>();  // 제네릭 사용
        list.add("Hello");
        String str = list.get(0);  // 형 변환 불필요
        System.out.println(str);
        //Generic class
        class genericBox<T>{
            private T value;
            public void setValue(T value){
                this.value = value;
            }
            public T getValue(){
                return value;
            }
        }
        genericBox<Integer> intBox = new genericBox<>();  // T → Integer
        intBox.setValue(100);
        System.out.println(intBox.getValue());  // 출력: 100

        genericBox<String> strBox = new genericBox<>();  // T → String
        strBox.setValue("Hello");
        System.out.println(strBox.getValue());  // 출력: Hello

        //Generic method
        class Util {
            // <T>는 메서드에서만 사용되는 타입 매개변수
            public static <T> void print(T value) {
                System.out.println(value);
            }
        }
        Util.print(100);       // 출력: 100
        Util.print("Hello");   // 출력: Hello
        Util.print(3.14);      // 출력: 3.14
        //하나의 메서드에서 int, String, double type 처리 가능.

        //convert String to int/Integer
        String strNum = "12345";
        int intValue = Integer.parseInt(strNum);
        Integer integerValue = Integer.valueOf(strNum);
        System.out.println(intValue);
        System.out.println(integerValue);

        //convert String to long/Long
        String strLongNum = "10000000000";             // 100억 숫자값으로 입력
        long strTolong = Long.parseLong(strLongNum);   // primitive Type (long)으로 변환
        Long strToLong = Long.valueOf(strLongNum);    // Wrapper class (Long)으로 변환
        System.out.println(strToLong);

        //convert String to float/Float
        String strFloat = "1000000.985";
        float floatType = Float.parseFloat(strFloat);// 문자열(String)을 primitive type(float)으로 변환
        Float strToFloat = Float.valueOf(strFloat);// 문자열(String)을 Wrapper class (Float)으로 변환
        System.out.println(floatType);
        System.out.println(strToFloat);

        //convert String to double/Double
        String strDouble = "1000000.985";
        double doubleType = Double.parseDouble(strDouble);// 문자열(String)을 privmitive type(double)으로 변환
        Double strToDouble = Double.valueOf(strDouble);// 문자열(String)을 Wrapper class (Double)으로 변환
        System.out.println(doubleType);
        System.out.println(strToDouble);

        //convert int to String
        int intValue2 = 10;
        String strValue2;

        strValue2 = String.valueOf(intValue);
        strValue2 = Integer.toString(intValue);
        strValue2 = "" + intValue; // 정수값에 빈 문자열을 더해 문자열 합치기 연산으로 작동되게 한다

        Object nullValue = null;
        String str3;
        //str3 = nullValue.toString(); // NullPointerException 발생
        str3 = String.valueOf(nullValue); // 문자열 "null"로 변환됨

        //Array
        int[] arrNumbers = {0,1,2,3,4,5};
        System.out.println(arrNumbers.length);
        for (int arrNumber : arrNumbers) {
            System.out.println(arrNumber);
        }
        System.out.println(arrNumbers[3]);

        //ArrayList
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; ++i){
            list2.add(i);
        }
        System.out.println(list2.size());
        System.out.println(list2.get(7));

        String strHello1 = "Hello";
        String strHello2 = "Hello";
        String strHello3 = new String("Hello"); // Heap 영역에 새로운 객체 생성

        System.out.println("str1 hash: " + System.identityHashCode(strHello1));
        System.out.println("str2 hash: " + System.identityHashCode(strHello2));
        System.out.println("str3 hash: " + System.identityHashCode(strHello3)); // 다른 주소값

        int number1 = 10;
        double number2 = 2.0;

        // 사칙연산 코드 추가
        double result1 = number1 + number2;
        double result2 = number1 - number2;
        double result3 = number1 * number2;
        double result4 = number1 / number2;
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

        System.out.println(10 / 2 + 3 * 4);

        int number = 10;

        int result10 = number + 1;
        int result20 = number++;
        int result30 = number;
        int result40 = --number;

        System.out.println(result10);
        System.out.println(result20);
        System.out.println(result30);
        System.out.println(result40);

        int num1 = 5;
        int num2 = 7;

        System.out.println((num1 > 5) && (num2 > 5));
        System.out.println((num1 > 5) || (num2 > 5));
        System.out.println(!((num1 > 5) && (num2 > 5)));

        int i_r = 7;
        if ( i_r%2 == 0 || i_r%3 == 0 ) {
            System.out.println("i_r은 2의 배수 또는 3의 배수이다.");
        }else {
            System.out.println("i_r은 2의 배수도 아니고 3의 배수도 아니다.");
        }








    }
}
