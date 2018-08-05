package lists.arraylists.challengepart1;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact) {
        String name = contact.getName();

        if(contactExists(name)) {
            System.out.printf("Contact %s is already registered\n", name);
            return false;
        } else {
            myContacts.add(contact);
            System.out.printf("Contact %s has been added to list.\n", name);
            return true;
        }
    }

    public boolean removeContact(String name) {
        if(contactExists(name)) {
            Contact contact = findContact(name);
            myContacts.remove(contact);
            System.out.printf("Contact %s has been deleted.\n", name);
            return true;
        } else {
            System.out.printf("Contact %s has not been found.\n", name);
            return false;
        }
    }

    public void listContacts() {
        System.out.printf("You have %d contacts in your list.\n", myContacts.size());

        for (int i = 0; i < myContacts.size(); i++) {
            System.out.printf("%d. %s --> %s\n", i+1, myContacts.get(i).getName(), myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean updateContact(String name, Contact newContact) {
       Contact oldContact = findContact(name);

       if (contactExists(newContact.getName())) {
           System.out.printf("Contact %s is already registered.\n", newContact.getName());
           return false;
       } else if (contactExists(name)) {
           int index = myContacts.indexOf(oldContact);
           myContacts.set(index, newContact);
           System.out.printf("Contact %s has been updated\n", newContact.getName());
           return true;
       } else {
           System.out.printf("Contact %s has not been found.\n", name);
           return false;
       }
    }

    public Contact findContact(String name) {
        int position = contactPosition(name);

        if(position >= 0) {
            Contact contact = findContact(position);
            return contact;
        }

        return null;
    }

    private boolean contactExists(String name) {
        Contact contact = findContact(name);

        return contact != null;
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
