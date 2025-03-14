import java.util.Arrays;

class WildcardPerson{
    String name;
    WildcardPerson(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
class WildcardWorker extends WildcardPerson{
    WildcardWorker(String name){
        super(name);
    }
}
class WildcardStudent extends WildcardPerson{
    WildcardStudent(String name){
        super(name);
    }
}
class WildCardHighStudent extends WildcardStudent{
    WildCardHighStudent(String name){
        super(name);
    }
}
class Course<T>{
    private String name;
    private T[] students;

    public Course(String name, int capacity){
        this.name = name;
        this.students = (T[]) (new Object[capacity]);
    }
    public String getName() {
        return name;
    }
    public T[] getStudents() {
        return students;
    }
    public void add(T t) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }
}

public class GenericWildcardSample {

    public static void registerCourse(Course<?> course) {    //모든 과정
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }

    public static void registerCourseStudent(Course<? extends WildcardStudent> course) {    //학생 과정
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }

    public static void registerCourseWorker(Course<? super WildcardWorker> course) {    // 직장인과 일반인 과정
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args) {

        Course<WildcardPerson> personCourse = new Course<>("일반인과정", 5);
        personCourse.add(new WildcardPerson("일반인"));
        personCourse.add(new WildcardWorker("직장인"));
        personCourse.add(new WildcardStudent("학생"));
        personCourse.add(new WildCardHighStudent("고등학생"));

        Course<WildcardWorker> workerCourse = new Course<>("직장인과정", 5);
        workerCourse.add(new WildcardWorker("직장인"));

        Course<WildcardStudent> studentCourse = new Course<>("학생과정", 5);
        studentCourse.add(new WildcardStudent("학생"));
        studentCourse.add(new WildCardHighStudent("고등학생"));

        Course<WildCardHighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
        highStudentCourse.add(new WildCardHighStudent("고등학생"));

        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);				// 모든 과정 등록 가능
        System.out.println();

        //Course<? extends WildcardStudent>
        //WildcardStudent 자신과, WildcardStudent를 상속받은 WildcardHighStudent 타입만 허용함.
        //WildcardStudent는 WildcardPerson을 상속했기 때문에 허용할 줄 알았는데.. 아니야. 안됨.
        //registerCourseStudent(personCourse); -> 이거 안된다.
        //registerCourseStudent(workerCourse);
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        //person과 worker만 등록 가능
        //Course<? super WildcardWorker> course
        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
        //registerCourseWorker(studentCourse);
        //registerCourseWorker(highStudentCourse);
    }
}
