import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;

class ExceptionFileInputStream implements AutoCloseable {
    private String file;

    public ExceptionFileInputStream(String file) {
        this.file = file;
    }

    public void read() {
        System.out.println(file + " 을 읽습니다");
    }

    @Override
    public void close() throws Exception {
        System.out.println(file + "을 닫습니다");
    }
}

public class ExceptionSample2 {
    public static void main(String[] args) {

//        //error case1: FileNotFoundException
//        BufferedReader br = new BufferedReader(new FileReader("존재하지_않는_파일"));
//        br.readLine();
//        br.close();
        try{
            BufferedReader br = new BufferedReader(new FileReader("존재하지_않는_파일"));
            br.readLine();
            br.close();
        }catch(IOException e){
            System.out.println("error message: " + e.getMessage());
        }

//        //error case2: ArithmeticException
//        int result = 5 / 0;
        int result;
        try {
            result = 5 / 0;
        } catch (ArithmeticException e) {
            result = -1;
            System.out.println("숫자는 0으로 나눌 수 없습니다.");
        }
//        //error case3: ArrayIndexOutOfBoundsException
//        int[] array = {3, 4, 5, 6};
//        System.out.println(array[5]);

        //try-with-resource
        try (ExceptionFileInputStream fileInputStream = new ExceptionFileInputStream("file.txt")){
            fileInputStream.read();
            throw new Exception();		// 강제적으로 예외 발생시킴
        } catch (Exception e) {
            System.out.println("예외 처리 코드가 실행되었습니다.");
        }




    }
}
