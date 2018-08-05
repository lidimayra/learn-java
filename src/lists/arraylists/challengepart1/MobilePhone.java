package lists.arraylists.challengepart1;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        myContacts.add(contact);
    }

    public boolean removeContact(String name) {
        Contact existingContact = findContact(name);

        if(existingContact == null) {
            System.out.printf("Contact %s has not been found.\n", name);
            return false;
        } else {
            myContacts.remove(existingContact);
            System.out.printf("Contact %s has been deleted.\n", name);
            return true;
        }
    }

    public void listContacts() {
        System.out.printf("You have %d contacts in your list.\n", myContacts.size());

        for (int i = 0; i < myContacts.size(); i++) {
            System.out.printf("%d. %s --> %s\n", i+1, myContacts.get(i).getName(), myContacts.get(i).getPhoneNumber());
        }
    }

    public void updateContact(Contact oldContact, Contact newContact) {
       int index = myContacts.indexOf(oldContact);
       myContacts.set(index, newContact);
    }

    public Contact findContact(String name) {
        int position = contactPosition(name);

        if(position >= 0) {
            Contact contact = findContact(position);
            return contact;
        }

        return null;
    }

    private Contact findContact(int position) {
       Contact contact = myContacts.get(position);
       return contact;
    }

    private int contactPosition(String name) {
        Contact contact;

        for (int i = 0; i < myContacts.size(); i++) {
            contact = myContacts.get(i);
            if(contact.getName().equals(name)) { return i; }
        }

        return -1;
    }

}
