package WeeklyQuizDataStructure;

import java.util.Objects;
import java.util.Scanner;

@FunctionalInterface
interface AddContact{
    Contact Addcontact();
}

public class Contact {
    private String name;
    private String phoneNumber;

    Contact(){

    }
    Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class BusinessContact extends Contact{
    private String company;

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    Contact AddBusinessContact(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("이름을 입력하세요:");
            setName(scanner.nextLine());
            System.out.println("전화번호를 입력하세요:");
            setPhoneNumber(scanner.nextLine());
            System.out.println("회사명을 입력하세요:");
            setCompany(scanner.nextLine());

            System.out.println("\"이름: "+getName()+", 전화번호: "+getPhoneNumber()
                    +", 회사명: "+getCompany()+"\" 맞습니까?(y/n)");
            if (Objects.equals(scanner.nextLine(), "y"))
                break;
        }
        System.out.println("연락처가 저장되었습니다. 메인 메뉴로 이동합니다.");
        return this;
    }
}

class PersonalContact extends Contact{
    private String relationship;

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    Contact AddPersonalContact(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("이름을 입력하세요:");
            setName(scanner.nextLine());
            System.out.println("전화번호를 입력하세요:");
            setPhoneNumber(scanner.nextLine());
            System.out.println("관계를 입력하세요:");
            setRelationship(scanner.nextLine());

            System.out.println("\"이름: "+getName()+", 전화번호: "+getPhoneNumber()
                    +", 관계: "+getRelationship()+"\" 맞습니까?(y/n)");
            if (Objects.equals(scanner.nextLine(), "y"))
                break;
        }
        System.out.println("연락처가 저장되었습니다. 메인 메뉴로 이동합니다.");
        return this;
    }



}