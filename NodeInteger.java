public class NodeInteger {
    private int data;       //This variable holds the character data for the node.
    private NodeInteger next;      //This variable holds a reference to the next Node in the linked list.
    
    //Constructors
    public NodeInteger(){
        this(0, null);      //The default constructor initializes the data to 'n' and the next reference to null.
    }
    
    public NodeInteger (int d) {   //The second constructor initializes the data to the specified character provided as an argument.
        data = d;
    }
    
    public NodeInteger (int d, NodeInteger n) {   //The third constructor initializes both the data and the next reference to the specified values provided as arguments.
        data = d;
        next = n; 
    }
    
    
    //Setter and Getter Methods:
    public void setData (int newData) {    //setData and setNext methods are used to set the data and the next reference, respectively.
        data = newData;
    }
    
    public void setNext (NodeInteger newNext) {
        next = newNext;
    }
    
    public int getData () {     //getData and getNext methods are used to retrieve the data and the next reference, respectively.
        return data;
    }
    
    public NodeInteger getNext() {
        return next; 
    }
    
    public void displayNode() {     //prints out the data as specified Node
        System.out.print(data);
    }
}