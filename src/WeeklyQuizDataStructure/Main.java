package WeeklyQuizDataStructure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AddressBook book = new AddressBook();
        int menuNum = 0;

        do {
            System.out.println("----------------------");
            System.out.println("1. 비지니스 연락처 추가");
            System.out.println("2. 개인 연락처 추가");
            System.out.println("3. 연락처 출력");
            System.out.println("4. 연락처 검색");
            System.out.println("5. 종료");
            System.out.println("----------------------");

            System.out.println("메뉴를 선택해주세요: ");
            Scanner scanner = new Scanner(System.in);
            menuNum = scanner.nextInt();//todo 문자 입력 시의 예외 처리 필요

            switch (menuNum){
                case 1:
                    System.out.println("비지니스 연락처 추가로 이동합니다.");
                    book.setContacts(new BusinessContact().AddBusinessContact());
                    break;
                case 2:
                    System.out.println("개인 연락처 추가로 이동합니다.");
                    book.setContacts(new PersonalContact().AddPersonalContact());
                    break;
                case 3:
                    System.out.println("연락처 출력으로 이동합니다.");
                    book.DisplayContacts();
                    break;
                case 4:
                    System.out.println("연락처 검색으로 이동합니다.");
                    book.SearchContact();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
        }while(menuNum < 5);

        System.out.println("프로그램이 종료되었습니다.");

    }
}
