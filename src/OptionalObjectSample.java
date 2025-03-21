import java.util.Optional;

public class OptionalObjectSample {
    public static void main(String[] args) {

        //Optional class
        //null 값을 안전하게 처리하기 위해 사용
        //null 체크 및 NPE(Null Point Exception)방지를 위한 기능 제공.

//        String str = null;
//        System.out.println(str.length()); //Null Pointer Exception

        //Optional 생성 방법
        //1. Optional.of(T value)
        String name = "이름";
        String nameNull = null;
        Optional<String> optionalName = Optional.of(name);//value must not be null.
        //Optional<String> optionalNameNull = Optional.of(nameNull);//name2 is null. NPE
        System.out.println(optionalName.isPresent());//true
        System.out.println(optionalName.get()); //이름


        //2. Optional.ofNullable(T value)
        String nameNullable = null;
        Optional<String> optionalNameNullable = Optional.ofNullable(nameNullable);
        System.out.println(optionalNameNullable.isPresent());//false
        System.out.println(optionalNameNullable.orElse("Default Value"));

        //3. Optional.empty()
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());//false





        



    }
}
