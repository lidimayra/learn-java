// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

package lists.arraylists.challengepart1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MobilePhone myMobilePhone = new MobilePhone("11912345678");
    static boolean quit = false;

    public static void main(String[] args) {
        chooseOption();
    }


    public static void chooseOption() {
        while(!quit) {
            printInstructions();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    quit();
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    removeContact();
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println(
                "Choose an option:\n" +
                        "1. Quit\n" +
                        "2. Print list of contacts\n" +
                        "3. Add new contact\n" +
                        "4. Update contact\n" +
                        "5. Search contact\n" +
                        "6. Remove contact\n"
        );
    }

    public static void quit() {
        System.out.println("Quitting...");
        quit = true;
    }

    public static void printContacts() {
        myMobilePhone.listContacts();
        System.out.println("-----");
    }

    public static void addContact() {
        Contact contact = promptContactData();

        String name = contact.getName();

        Contact existentContact = myMobilePhone.findContact(name);

        if (existentContact == null) {
            myMobilePhone.addContact(contact);
            System.out.printf("%s has been added to contacts list.\n", name);
        } else {
            System.out.printf("Contact %s is already registered.\n", name);
        }

        System.out.println("-----");
    }

    public static void updateContact() {
        System.out.println("Enter name of the contact that will be replaced:");
        String oldContactName = scanner.next();

        Contact oldContact = myMobilePhone.findContact(oldContactName);

        if (oldContact == null) {
            System.out.println("Contact not found");
        } else {
            Contact newContact = promptContactData();
            myMobilePhone.updateContact(oldContact, newContact);
            System.out.printf("Contact %s has been updated\n", newContact.getName());
        }

        System.out.println("-----");
    }

    public static void searchContact() {
        System.out.println("Enter the name of the contact to be searched:");
        String name = scanner.next();

        Contact contact = myMobilePhone.findContact(name);

        if (contact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.printf("%s: %s\n", contact.getName(), contact.getPhoneNumber());
        }

        System.out.println("-----");
    }

    public static void removeContact() {
        System.out.println("Enter the name of the contact to be removed:");
        String name = scanner.next();

        if (myMobilePhone.removeContact(name)) {
            System.out.println("Success!");
        } else {
            System.out.println("Error!");
        }

        System.out.println("-----");
    }

    public static Contact promptContactData() {
        System.out.println("Enter contact name:");
        String name = scanner.next();

        System.out.println("Enter contact phone number:");
        String phoneNumber = scanner.next();

        Contact contact = Contact.createContact(name, phoneNumber);
        return contact;
    }
}
