package lists.arraylists;

public class UseGroceryList {
    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();

        groceryList.addGroceryItem("Candy");
        groceryList.addGroceryItem("Lollipop");
        groceryList.addGroceryItem("Bubblegum");
        groceryList.printGroceryList();

        System.out.println("-----------------");

        groceryList.modifyGroceryItem("Lollipop", "Chocolate");
        groceryList.printGroceryList();

        System.out.println("-----------------");

        groceryList.removeGroceryItem("Chocolate");
        groceryList.printGroceryList();
    }
}
