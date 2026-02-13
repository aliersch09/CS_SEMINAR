import java.io.*;
import java.util.*;
public class GroceryTester{
    public static void main(String[] args) throws FileNotFoundException{
        /*
        GroceryList list = new GroceryList();
        list.add("eggs");
        list.add("cookies");
        list.add("steak");
        list.add("lettuce");
        list.add("sugar",2);
        list.remove(1);
        System.out.println(list.getGroceryMap());
        System.out.println(list.size());
        System.out.println(list.getCost());
        */
       userInterface();
    }
    public static void userInterface() throws FileNotFoundException{
        boolean interact = true;
        while(interact==true){
            GroceryList test = new GroceryList();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Here are your choices: \n1) add an item to your list \n2) remove an item from your list \n3) view total size of your list \n4) view the total cost of your list \n\nEnter a number 1-4:");
            String choice = scanner.nextLine();
            if(choice.equals("1")){
                System.out.println("What would you like to add to your list?");
                String data = scanner.nextLine();
                test.add(data);
            }
            if(choice.equals("2")){
                System.out.println("What is the index of the item would you like to remove from your list?");
                String index = scanner.nextLine();
                test.remove(Integer.parseInt(index));
            }
            if(choice.equals("3")){
                System.out.println(test.size());
            }
            if(choice.equals("4")){
                System.out.println(test.getCost());
            }
            System.out.println("Do you want to continue to interact with your grocery list? (yes/no)");
            String answer = scanner.nextLine();
            if(answer.equals("no")){
                interact = false;
            }
        }
    }
}
/*
Reflection:
1) The additional method that I added was the user interface in the tester class. This method is an ongoing loop until
the user decides it is finished interacting with their grocery list. The user has options of what methods from the grocery
list class they want to run, and they type in the number of what they choose. The method then asks the user for any parameters
needed to run the method, and then it runs that method in the grocery list class.
2) One major limitation of the program is the length of the grocery-items txt file, for there are not many foods on it. If 
this was changed, the user would be able to create a more realistic grocery list, instead of having to only choose items
that are in the txt file. Also, if the user chooses an item not on the list, that cost is not accounted for, so there might 
be a lower total cost printed than is actually true.
3) Diagram (possible path):
User selects option 1 each time, adding these items to list (selects yes after to keep adding):
    eggs, sugar, steak, lettuce, cookies
User inputs yes and chooses option 2, and removes at index 2:
    eggs, sugar, lettuce, cookies
User inputs yes and chooses option 3 and size is displayed:
    4
User inputs yes and chooses option 4 and views the total cost:
    12.65
 */