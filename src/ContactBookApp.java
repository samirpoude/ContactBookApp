import java.util.LinkedList;
import java.util.Scanner;

public class ContactBookApp {
   private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Contact> contactList = new LinkedList<>();

        while(true){
            printActions();
            int action = scanner.nextInt();

            switch(action){
                case 1-> {
                    addContact(contactList);
                System.out.println(contactList);
                }
                case 2-> {
                    deleteContact(contactList);
                    System.out.println(contactList);
                }
                case 3-> searchContact(contactList);
                case 4 -> listContact(contactList);
                case 5-> {
                    System.out.println("..............Exiting the Contact Book...............");
                    return;
                }
                default -> System.out.println("Invalid choice!!!!!");

            }
        }

    }
  //------Method to add contact to the list---->//
    public static void addContact(LinkedList<Contact> contact){
        System.out.println("Enter the name you want to add: ");
        String name = scanner.next();
        System.out.println("Enter the Phone Number: ");
        String number = scanner.next();

        contact.add(new Contact(name, number));
    }

    //--------Method to search the contact by name-------///

    public static void searchContact(LinkedList<Contact> contacts){
        System.out.println("Enter the name you want to search in you Contact Book: ");
        String search = scanner.next();
        for(Contact c : contacts){
            if(c.name.equalsIgnoreCase(search)){
                System.out.println("Contact found!!");
                System.out.println("Name: " + c.name + " Phone Number : " + c.phoneNumber);
            }else{
                System.out.println("Contact not found!!");
            }
            return;
        }
    }

    //--------Method to delete a contact by name-----//

    public static void deleteContact(LinkedList<Contact> contacts){
        System.out.println("Enter the name you want to delete: ");
        String delName = scanner.next();
        for(Contact del: contacts){
            if(del.name.equalsIgnoreCase(delName)){
                contacts.remove(del);
                return;
            }
        }


    }
    // ----Method to List all contacts---//
    public static void listContact(LinkedList<Contact> contacts){
        for(Contact i: contacts){
            System.out.println("Name: " + i.name + "\n Phone Number: " + i.phoneNumber);

        }
    }


    public static void printActions(){
        System.out.println("""
               \s
                        Contact Book
                       \s
                Enter (1) to Add a contact
                Enter (2) to Delete a contact by name
                Enter (3) to Search a contact by name
                Enter (4) to List all contacts
                Enter (5) to Quit the Contact Book
                       \s
                       \s
               \s""");
    }
}
