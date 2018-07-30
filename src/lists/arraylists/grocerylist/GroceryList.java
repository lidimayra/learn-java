package lists.arraylists.grocerylist;

import java.io.PrintStream;
import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.printf("You have %d items in your grocery list:\n", groceryList.size());

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.printf("%d. %s\n", i+1, groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if(position > 0) {
            modifyGroceryList(position, newItem);
        }
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if(position > 0) {
            removeGroceryItem(position);
        }
    }

    public int findItem(String item) {
        int position = groceryList.indexOf(item);
        return position;
    }

    private void modifyGroceryList(int position, String item) {
        groceryList.set(position, item);

        System.out.printf("Grocery item %d has been modified.\n", position+1);
    }

    private void removeGroceryItem(int position) {
        String item = groceryList.remove(position);
        System.out.printf("%s has been removed from grocery list.\n", item);
    }
}
