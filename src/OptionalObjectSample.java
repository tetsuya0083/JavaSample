import java.util.Optional;

public class OptionalObjectSample {
    public static void main(String[] args) {
//        String str = null;
//        System.out.println(str.length()); //Null Pointer Exception

        Optional<String> optionalStr = Optional.ofNullable(null);
        System.out.println(optionalStr.orElse("Default Value"));
    }
}
