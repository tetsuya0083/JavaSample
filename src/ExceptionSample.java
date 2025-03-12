import java.io.*;

//custom exception
class DivideException extends RuntimeException{//ArithmeticException
    public int left;
    public int right;
    DivideException(){
        super();
    }
    DivideException(String message){
        super(message);
    }
    DivideException(String message, int left, int right){
        super(message);
        this.left = left;
        this.right = right;
    }
}

class ExceptionCalculator{
    int left, right;
    public void setOprands(int left, int right){//illegalArgumentException
//        if (right == 0){
//            throw new IllegalArgumentException("두번째 인자는 0을 허용하지 않음.");
//        }
        this.left = left;
        this.right = right;
    }
    public void divide(){//ArithmeticException
        if (right == 0){
            throw new DivideException("0으로 나눌 수 없음.", this.left, this.right);
        }
        System.out.print("계산결과는 ");
        System.out.print(this.left/this.right);
        System.out.print(" 입니다.");

        /* old code
        if (right == 0){
            throw new ArithmeticException("0으로 나눌 수 없음.");
        }
        try{
            System.out.print("계산결과는 ");
            System.out.print(this.left/this.right);
            System.out.print(" 입니다.");
        } catch (Exception e) {
            System.out.println("\n\ne.getMessage()\n" + e.getMessage());
            System.out.println("\n\ne.toString()\n" + e.toString());
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();
        }*/

        System.out.println("Divide End");
    }
}

class ExceptionA{
    private int[] arr = new int[3];
    ExceptionA(){
        arr[0]=0;
        arr[1]=10;
        arr[2]=20;
    }
    public void z(int first, int second){
        try{
            System.out.println(arr[first] / arr[second]);
        } catch(ArithmeticException e){
            System.out.println("ArithmeticException e");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException e");
        } catch(Exception e){//위 두 catch 예외 사항을 모두 포함하므로 마지막 catch로.
            System.out.println("Exception e");
        } finally {
            System.out.println("finally");
        }

    }
}
//Throw
class ExceptionB {
    void run() throws FileNotFoundException, IOException{
        BufferedReader bReader = null;
        bReader = new BufferedReader(new FileReader("out1.txt"));
//        try{
//            bReader = new BufferedReader(new FileReader("out.txt"));
//        } catch(FileNotFoundException e){
//            e.printStackTrace();
//        }

        String input = null;
        input = bReader.readLine();
//        try {
//            input = bReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//            //throw new RuntimeException(e);
//        }
        System.out.println(input);
    }
}
class ExceptionC{
    void run(){
        ExceptionB b = new ExceptionB();
        try {
            b.run();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            //e.printStackTrace();
            //throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }
}

class ExceptionD {
    void throwArithmeticException(){
        throw new ArithmeticException();
        //why doesn't the error occur?
        //unchecked exception : RuntimeException을 상속받은 Exception
    }
    void throwIOException1(){
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }
    void throwIOException2() throws IOException{
        throw new IOException();
    }
}

public class ExceptionSample {
    public static void main(String[] args) {
        ExceptionCalculator c1 = new ExceptionCalculator();
        c1.setOprands(10, 0);
        try {
            c1.divide();
        }catch(DivideException e) {
            System.out.println(e.getMessage());
            System.out.println(e.left);
            System.out.println(e.right);
        }

        ExceptionA a = new ExceptionA();
        a.z(10, 0);
        a.z(1, 0);
        a.z(2, 1);

        BufferedReader bReader = null;
        try{
          bReader = new BufferedReader(new FileReader("out.txt"));
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        String input = null;
        try {
            input = bReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        System.out.println(input);

        //throw
        ExceptionC c = new ExceptionC();
        c.run();

    }
}
