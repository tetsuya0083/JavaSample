import java.util.Arrays;

public class StringMethodExample {
    public static void main(String[] args) {
        String a = "Hello World!";

        System.out.println(a.indexOf("!"));
        System.out.println(a.contains("World"));

        String findChar = "What is your hobby";
        System.out.println(findChar.charAt(5));
        System.out.println(a.replaceAll("World", "Spring"));
        System.out.println(a.substring(3, 5));
        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());
        String b = "a:b:c:d";
        String[] splitResult = b.split(":");  // result는 {"a", "b", "c", "d"}
        System.out.println(Arrays.toString(splitResult));
        String concatResult = "Hello";
        System.out.println(concatResult.concat("!"));   // 결과 : Hello!

        String name1 = "Tim";
        int age1 = 30;
        String name2 = "Anna";
        int age2 = 45;
        String formatResult = String.format("%s의 나이는 %s세 입니다", name1, age1);
        String formatResult2 = String.format("%s의 나이는 %s세 입니다", name2, age2);
        System.out.println(formatResult);
        System.out.println(formatResult2);

        String result = "";
        result += "Hello ";
        result += "Java ";
        result += "World!";
        System.out.println(result);

        StringBuilder builder = new StringBuilder();
        builder.append("Hello ");
        builder.append("Java ");
        builder.append("World!");
        System.out.println(builder.toString());

        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello ");
        buffer.append("Java ");
        buffer.append("World!");
        buffer.insert(0, "World");
        System.out.println(buffer.toString());
        System.out.println(buffer.substring(6));
        System.out.println(buffer.substring(6, 7));
        System.out.println(buffer.reverse().toString());












    }
}
