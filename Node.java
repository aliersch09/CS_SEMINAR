public class Node{
    //variables
    protected String data;
    protected Node next;
    //constructor with one parameter
    public Node(String data){
        this.data = data;
        this.next = null;
    }
    //constuctor with no parameters
    public Node(){
        this.data = null;
        this.next=null;
    }
    //constuctor with two parameters
    public Node(String data, Node next){
        this.data = data;
        this.next = next;
    }
}