package DailyQuiz;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

//1번 문제 답: 4
//2번 문제 답: 4
//3번 문제 답: 2
/*4번 문제 답: x *= 10; line에서 error. 내부에서 변수 수정 불가.
local variables referenced from a lambda expression must be final or effectively final*/

public class DailyQuiz0318 {

    static class LambdaExample_5 {
        private static int[] scores = {10, 50, 3};

        public static int maxOrMin(IntBinaryOperator operator) {
            int result = scores[0];
            for (int score : scores) {
                result = operator.applyAsInt(result, score);
            }
            return result;
        }
    }

    static class LambdaExample_6 {
        private static Student[] students = {
                new Student("홍길동", 90, 96),
                new Student("저팔계", 95, 93)
        };

        //6번 문제 avg() 메소드 작성
        public static double avg(Function<Student, Integer> function){
            int totalScore = 0;
            double avgScore = 0;
            for (Student student : students){
                totalScore += function.apply(student);
            }
            avgScore = (double) totalScore / students.length;
            return avgScore;
        }

        public static class Student {
            private String name;
            private int englishScore;
            private int mathScore;

            public Student(String name, int englishScore, int mathScore) {
                this.name = name;
                this.englishScore = englishScore;
                this.mathScore = mathScore;
            }
            public String getName() {
                return name;
            }
            public int getEnglishScore() {
                return englishScore;
            }
            public int getMathScore() {
                return mathScore;
            }
        }
    }

    public static void main(String[] args) {

        //5번 문제
        int max = LambdaExample_5.maxOrMin(
                /* 최대값 얻기 구현 */
                (left, right) -> Math.max(left, right)
        );
        System.out.println("최대값 : " + max);

        int min = LambdaExample_5.maxOrMin(
                /* 최소값 얻기 구현 */
                (left, right) -> Math.min(left, right)

        );
        System.out.println("최소값: " + min);

        double englishAvg = LambdaExample_6.avg(s -> s.getEnglishScore());
        System.out.println("영어 평균 점수: " + englishAvg);

        double mathAvg = LambdaExample_6.avg(s -> s.getMathScore());
        System.out.println("수학 평균 점수: " + mathAvg);

        //7번 문제
        double englishAvg2 = LambdaExample_6.avg(LambdaExample_6.Student::getEnglishScore);
        System.out.println("영어 평균 점수: " + englishAvg);

        double mathAvg2 = LambdaExample_6.avg(LambdaExample_6.Student::getMathScore);
        System.out.println("수학 평균 점수: " + mathAvg);
    }
}