package lists.arraylists.challengepart1;

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

    public void listContacts() {
        System.out.printf("You have %d contacts in your list.\n", myContacts.size());

        for (int i = 0; i < myContacts.size(); i++) {
            System.out.printf("%d. %s --> %s", i+1, myContacts.get(i).getName(), myContacts.get(i).getPhoneNumber());
        }
    }
}
