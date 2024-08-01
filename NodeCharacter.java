public class NodeCharacter {
    private char data;       //This variable holds the character data for the node.
    private NodeCharacter next;      //This variable holds a reference to the next Node in the linked list.
    
    //Constructors
    public NodeCharacter() {
        this('n', null);      //The default constructor initializes the data to 'n' and the next reference to null.
    }
    
    public NodeCharacter (char d) {   //The second constructor initializes the data to the specified character provided as an argument.
        data = d;
    }
    
    public NodeCharacter (char d, NodeCharacter n) {   //The third constructor initializes both the data and the next reference to the specified values provided as arguments.
        data = d;
        next = n; 
    }
    
    
    //Setter and Getter Methods:
    public void setData (char newData) {    //setData and setNext methods are used to set the data and the next reference, respectively.
        data = newData;
    }
    
    public void setNext (NodeCharacter newNext) {
        next = newNext;
    }
    
    public char getData () {     //getData and getNext methods are used to retrieve the data and the next reference, respectively.
        return data;
    }
    
    public NodeCharacter getNext() {
        return next; 
    }
    
    public void displayNode() {     //prints out the data as specified Node
        System.out.print(data);
    }
}