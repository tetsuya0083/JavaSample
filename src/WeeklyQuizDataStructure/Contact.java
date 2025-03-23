package WeeklyQuizDataStructure;

import java.util.Objects;

@FunctionalInterface
interface AddContact{Contact addContactVer2();}//There is this way, too

abstract public class Contact {
    private String name;
    private String phoneNumber;

    Contact(){}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getPhoneNumber() {return phoneNumber;}
    public abstract Contact addContact();
}

class BusinessContact extends Contact implements AddContact{
    private String company;

    BusinessContact(){}
    public void setCompany(String company) {this.company = company;}
    public String getCompany() {return company;}
    @Override public Contact addContactVer2(){return this;}

    @Override
    public Contact addContact(){

        while(true){
            System.out.println("이름을 입력하세요:");
            super.setName(Main.getScanner().nextLine());
            System.out.println("전화번호를 입력하세요:");
            super.setPhoneNumber(Main.getScanner().nextLine());
            System.out.println("회사명을 입력하세요:");
            setCompany(Main.getScanner().nextLine());

            System.out.println("\"이름: "+getName()+", 전화번호: "+getPhoneNumber()
                    +", 회사명: "+getCompany()+"\" 맞습니까?(y/n)");

            if (Objects.equals(Main.getScanner().nextLine(), "y"))
                break;
        }

        System.out.println("연락처가 저장되었습니다. 메인 메뉴로 이동합니다.");
        return this;
    }
}

class PersonalContact extends Contact implements AddContact{
    private String relationship;

    PersonalContact(){}
    public void setRelationship(String relationship) {this.relationship = relationship;}
    public String getRelationship() {return relationship;}
    @Override public Contact addContactVer2(){return this;}

    @Override
    public Contact addContact(){

        while(true){
            System.out.println("이름을 입력하세요:");
            super.setName(Main.getScanner().nextLine());
            System.out.println("전화번호를 입력하세요:");
            super.setPhoneNumber(Main.getScanner().nextLine());
            System.out.println("관계를 입력하세요:");
            setRelationship(Main.getScanner().nextLine());

            System.out.println("\"이름: "+getName()+", 전화번호: "+getPhoneNumber()
                    +", 관계: "+getRelationship()+"\" 맞습니까?(y/n)");

            if (Objects.equals(Main.getScanner().nextLine(), "y"))
                break;
        }

        System.out.println("연락처가 저장되었습니다. 메인 메뉴로 이동합니다.");
        return this;
    }


}