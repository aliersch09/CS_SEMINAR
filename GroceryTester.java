import java.io.*;
import java.util.*;
public class GroceryTester{
    public static void main(String[] args) throws FileNotFoundException{
        //calls the user interface method
        userInterface();
    }
    public static void userInterface() throws FileNotFoundException{
        //runs if interact is true, exits loop if interact is false
        boolean interact = true;
        GroceryList test = new GroceryList(); //creates grocery list
        while(interact==true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Here are your choices: \n1) add an item to your list \n2) remove an item from your list \n3) view total size of your list \n4) view the total cost of your list \n5) view your list \n6) add to your list at a specific index \nEnter a number 1-6:");
            //stores users choice in what method they want to run
            String choice = scanner.nextLine();
            //if they chose first it adds their element to the list 
            if(choice.equals("1")){
                System.out.println("What would you like to add to your list?");
                String data = scanner.nextLine();
                test.add(data);
            }//if they chose second it removes that element at that index from the list
            else if(choice.equals("2")){
                System.out.println("What is the index of the item would you like to remove from your list?");
                int index = Integer.parseInt(scanner.nextLine());
                if(test.size()>index&&index>-1){
                    test.remove(index);
                }
                else{//if that is not an index in the list, it tells the user
                    System.out.println("That is not an accurate index.");
                }
            }//if they chose 3, it displays the size of list
            else if(choice.equals("3")){
                System.out.println(test.size());
            }//if they chose 4, it displays the total cost of list
            else if(choice.equals("4")){
                System.out.println(test.getCost());
            }//if they chose 5, it displays the list
            else if(choice.equals("5")){
                System.out.println(test);
            }
            else if(choice.equals("6")){
                //collects the user's item and index they want to add to
                System.out.println("What would you like to add to your list?");
                String dataValue = scanner.nextLine();
                System.out.println("What index would you like to put it at?");
                int index = Integer.parseInt(scanner.nextLine());
                if(index<test.size()&&index>=0){
                    test.add(dataValue,index); //adds according to what user says
                }
                else{
                    System.out.println("That is not an accurate index.");
                }
            }
            //if they did not choose 1-5 it says that it is not an option cause its not
            else{
                System.out.println("That is not an option.");
            }//asks user if they want to continue interacting with list and stores answer in variable
            System.out.println("Do you want to continue to interact with your grocery list? (yes/no)");
            String answer = scanner.nextLine();
            //if they said no, interact changes to false and the loop is done
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
needed to run the method, and then it runs that method in the grocery list class. This enhances my code because it allows 
a user to interact with the program without having to code it themselves.
2) One major limitation of the program is the length of the grocery-items txt file, for there are not many foods on it. If 
this was changed, the user would be able to create a more realistic grocery list, instead of having to only choose items
that are in the txt file. This is important because expanding the grocery list would make the program more useful to the user.
3) Diagram (possible path): (I also handed in a diagram)
User selects option 1 each time, adding these items to list (selects yes after to keep adding):
    eggs, sugar, steak, lettuce, cookies
User inputs yes and chooses option 2, and removes at index 2:
    eggs, sugar, lettuce, cookies
User inputs yes and chooses option 3 and size is displayed:
    4
User inputs yes and chooses option 4 and views the total cost:
    12.65
 */