package DailyQuiz;
/*
1. 4
2. 4
3. 4
4. 2
5. 3
6.
10
"숫자로 변환할 수 없음"
10
7. 코드 참고
*/
import java.io.IOException;

public class DailyQuiz0313 {
    public static void main(String[] args) {
        try {
            login("white", "12345");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            login("blue", "54321");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static class NotExistsIdException extends IOException {
        NotExistsIdException(){
            super();
        }
        NotExistsIdException(String msg){
            super(msg);
        }
    }
    public static class WrongPasswordException extends IOException{
        WrongPasswordException(){
            super();
        }
        WrongPasswordException(String msg){
            super(msg);
        }
    }

    public static void login(String id, String password) throws NotExistsIdException, WrongPasswordException {
        if (!id.equals("blue")){
            throw new NotExistsIdException("아이디가 존재하지 않습니다.");
        }

        if(!password.equals("12345")){
            throw new WrongPasswordException("패스워드가 틀립니다.");
        }
    }
}
