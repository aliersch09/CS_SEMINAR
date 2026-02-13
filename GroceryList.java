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
    public void add(String item){
        Node incoming = new Node(item);
        if (head==null){
            head = incoming;
        }else{
            Node curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = incoming;
        }
    }
    public void add(String item, int idx){
        Node incoming = new Node(item);
        if(head==null){
            head = incoming;
        }
        else if (idx<=size() && idx >=0){
            if(idx==0){
                incoming.next=head;
                head = incoming;
            }
            else{
                Node curr = head;
                for(int i = 0; i<idx-1; i++){
                    curr=curr.next;
                }

            incoming.next = curr.next;
            curr.next = incoming;
            }
        }
    }
    public void remove(int idx){
        if(head != null && idx<size()&&idx>=0){
            if (idx==0){
                head = head.next;
            }else{
                Node curr = head;
                for(int i = 0; i<idx; i++){
                    curr = curr.next;
                }
                curr.next=curr.next.next;
            }
        }
    }
    public int size(){
        int count = 0;
        Node incoming = head;
        while(incoming!=null){
            incoming = incoming.next;
            count++;
        }
        return count;
    }
    public Map<String, Double> getGroceryMap() throws FileNotFoundException, NullPointerException, NumberFormatException{
        Map<String, Double> map = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            File f = new File("/Users/aliersch/CS/CS_SEMINAR/grocery-items.txt");
            Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
                    if(curr.data.equals(line.get(0))){
                        map.put(curr.data, Double.parseDouble(line.get(1)));
                    }
                }
            curr = curr.next;
        }
        return map;
    }
    public double getCost() throws FileNotFoundException, NullPointerException{
        double totalCost = 0;
        Node curr = head;
        while(curr!=null){
            totalCost += getGroceryMap().get(curr.data);
            curr = curr.next;
        }
        return totalCost;
    }
    public String toString(){
        String toRet = "";
        try{
            Node curr = head;
            while(curr!=null){
                toRet+= curr;
                toRet+= getGroceryMap().get(curr.data);
                curr=curr.next;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return toRet;
    }
}