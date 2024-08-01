public interface StackCharacter {
    public void push (char data);//adds an element to the top of the stack
    public char pop();           //Removes and returns the element at the top of the stack
    public int size();          //returns the current number of elements i nthe stack.
    public boolean empty();     //checks if stack is empty or not
    public char ontop();         //returns the elemetn ar the top of the stack but does not remove it.
    
}

class LinkedListStackChar implements StackCharacter {
    private NodeCharacter top;
    private int size;
    
    public LinkedListStackChar() {
        top = null;
        size = 0;
    }

    public void push(char data) {
        NodeCharacter newNode = new NodeCharacter(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    
    public char pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }
    
    
    public int size() {
        return size;
    }
    
    public boolean empty() {
        return (size == 0);
    }
    
    public char ontop() {
        if (empty()) {
            throw new IllegalStateException("stack is empty");
        }
        return top.getData();
    }
}
