public interface StackInteger {
    public void push (int data);//adds an element to the top of the stack
    public int pop();           //Removes and returns the element at the top of the stack
    public int size();          //returns the current number of elements in the stack.
    public boolean empty();     //checks if stack is empty or not
    public int ontop();         //returns the elemetn ar the top of the stack but does not remove it.
    
}

class LinkedListStackInt implements StackInteger {
    private NodeInteger top;
    private int size;
    
    public LinkedListStackInt() {
        top = null;
        size = 0;
    }

    public void push(int data) {
        NodeInteger newNode = new NodeInteger(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    
    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.getData();
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
    
    public int ontop() {
        if (empty()) {
            throw new IllegalStateException("stack is empty");
        }
        return top.getData();
    }
}
