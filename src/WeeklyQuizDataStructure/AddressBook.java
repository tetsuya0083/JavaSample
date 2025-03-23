package WeeklyQuizDataStructure;
import java.util.List;
import java.util.ArrayList;

public class AddressBook {
    private List<Contact> contacts;

    AddressBook(){this.contacts = new ArrayList<>();}
    public <T extends Contact> void addContact(T value) {this.contacts.add(value);}

    public void displayContact(Contact contact){
        System.out.print("이름: "+contact.getName()+", 전화번호: "+contact.getPhoneNumber());

        // BusinessContact인지 확인하고 회사명 출력
        if (contact instanceof BusinessContact) {
            BusinessContact bc = (BusinessContact) contact;
            System.out.println(", 회사명: "+bc.getCompany());
        }
        // PersonalContact인지 확인하고 관계 출력
        else if (contact instanceof PersonalContact) {
            PersonalContact pc = (PersonalContact) contact;
            System.out.println(", 관계: "+pc.getRelationship());
        }
    }

    public void displayContacts(){
        if (contacts.isEmpty()){
            System.out.println("연락처가 비었습니다.");
        }else {
            System.out.println("저장된 연락처 입니다.");
            contacts.stream().forEach(this::displayContact);
        }
    }

    public void searchContact() {

        if (contacts.size() <= 0){
            System.out.println("연락처가 비었습니다.");
            return;
        }

        System.out.println("검색할 이름을 입력하세요.");
        String name = Main.scanner.nextLine();

        List<Contact> foundContacts = contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .toList();

        if (true == foundContacts.isEmpty()){
            System.out.println("연락처를 찾을 수 없습니다.");
        } else {
            foundContacts.forEach(this::displayContact);
        }
    }

}
