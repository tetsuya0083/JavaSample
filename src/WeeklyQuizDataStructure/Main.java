package WeeklyQuizDataStructure;

import java.util.Scanner;

public class Main {
    private static final AddressBook book = new AddressBook();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int menuNum = 0;
        while (menuNum != 5)
        {
            System.out.println("----------------------");
            System.out.println("1. 비지니스 연락처 추가");
            System.out.println("2. 개인 연락처 추가");
            System.out.println("3. 연락처 출력");
            System.out.println("4. 연락처 검색");
            System.out.println("5. 종료");
            System.out.println("----------------------");
            System.out.println("메뉴를 선택해주세요: ");

            if (false == scanner.hasNextInt()){
                System.out.println("[Error] 입력한 글자: " + scanner.nextLine());
                System.out.println("메뉴의 숫자를 정확히 입력하세요.");
                continue;
            }

            menuNum = scanner.nextInt();
            scanner.nextLine();//nextInt()는 개행 문자(/n)가 buffer에 남기 때문에 처리함.

            switch (menuNum){
                case 1:
                    System.out.println("비지니스 연락처 추가로 이동합니다.");
                    book.addContact(new BusinessContact().addContact());
                    break;
                case 2:
                    System.out.println("개인 연락처 추가로 이동합니다.");
                    book.addContact(new PersonalContact().addContact());
                    break;
                case 3:
                    System.out.println("연락처 출력으로 이동합니다.");
                    book.displayContacts();
                    break;
                case 4:
                    System.out.println("연락처 검색으로 이동합니다.");
                    book.searchContact();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("[Error] 입력한 숫자: " + menuNum);
                    System.out.println("메뉴의 숫자를 정확히 입력하세요.");
            }
        }

        scanner.close();
        System.out.println("프로그램이 종료되었습니다.");
    }
}
