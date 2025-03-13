import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Info {
    String author();
    String date();
    int num() default 5;
}

public class AnnotationSample {

    @Info(author="lion", date ="2025-03-13")
    public void MyAnnotationMethod(){
        System.out.println("execute my annotation method");
    }

    public static void main(String[] args) throws Exception {
        Method method = AnnotationSample.class.getMethod("MyAnnotationMethod");
        Info info = method.getAnnotation(Info.class);

        if(info != null){
            System.out.println("Author: " + info.author());
            System.out.println("Date: " + info.date());
            System.out.println("Number: " + info.num());
        }

    }
}
