import java.io.*;
import java.util.*;
public class GroceryList extends Node{
    //variable
    private Node head;
    //constructors
    public GroceryList(){
        head = null;
    }
    public GroceryList(Node head){
        this.head = head;
    }
    //methods
    //add method with item parameter
    public void add(String item){
        Node incoming = new Node(item);
        if (head==null){
            head = incoming;
        }else{
            Node curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = incoming;//adds item to the end of list
        }
    }
    //add method with item and index parameter
    public void add(String item, int idx){
        Node incoming = new Node(item);
        if(head==null){
            head = incoming;
        }
        else if (idx<size() && idx >=0){//if index is accurate
            if(idx==0){
                incoming.next=head;//sets the first value to incoming and moves all other values down one
                head = incoming;
            }
            else{
                Node curr = head;
                for(int i = 0; i<idx-1; i++){//traverse to the index before the idx
                    curr=curr.next;
                }
            //sets the item in correct index
            incoming.next = curr.next;
            curr.next = incoming;
            }
        }
    }
    //remove method - removes item at given index
    public void remove(int idx){
        if(head != null && idx<size()&&idx>=0){
            if (idx==0){
                head = head.next;
            }else{
                Node curr = head;
                for(int i = 0; i<idx-1; i++){//traverse to the index before the idx
                    curr = curr.next;
                }
                curr.next=curr.next.next;
            }
        }
    }
    //returns the size of the grocery list
    public int size(){
        int count = 0;
        Node incoming = head;
        while(incoming!=null){
            incoming = incoming.next;
            count++;
        }
        return count;
    }
    //makes a map of all the items and their prices
    public Map<String, Double> getGroceryMap() throws FileNotFoundException, NullPointerException, NumberFormatException{
        Map<String, Double> map = new HashMap<>();
        File f = new File("/Users/aliersch/CS/CS_SEMINAR/grocery-items.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()){//loop through the grocery items txt file
            String line = sc.nextLine();
            String currData = line.substring(1, line.indexOf("\" ")); //separate the grocery item
            if(indexOf(currData)!=-1){//if the grocery item is in the user's list, add it to the map with the corresponding cost
                map.put(currData, (Double.parseDouble(line.substring(line.indexOf("\" ")+2))));
            }
        }
        return map;
    }
    //index of method - checks if that data is in the grocery list, and returns its index
    public int indexOf(String data){
        int idx = 0;
        Node curr = head;
        while(curr!=null){
            if(curr.data.equals(data)){
                return idx;
            }
            idx++;
            curr=curr.next;
        }
        return -1;
    }
    //returns the total cost of the grocery list
    public double getCost() throws FileNotFoundException, NullPointerException{
        Map<String, Double> map = getGroceryMap();
        double totalCost = 0;
        Node curr = head;
        while(curr!=null){
            totalCost += map.get(curr.data);
            curr = curr.next;
        }
        return totalCost;
    }
    //returns the grocery list as a list of items with their prices - basically printing the map made in getGroceryMap method
    public String toString(){
        String toRet = "";//string to return
        try{
            Map<String, Double> map = getGroceryMap();
            Node curr = head;
            while(curr!=null){//adds that value and the corresponding cost to the string
                toRet+= curr.data + " ";
                toRet+= map.get(curr.data)+"\n";
                curr=curr.next;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return toRet;
    }
}