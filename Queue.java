public interface Queue {
    
    public void enqueue (char data);     //adds an item to the back of the queue
    public char dequeue();               //removes and returns the item at the ront of the queue
    public int size();                  //returns the the number of elemetns in the queue.
    public boolean empty();             //checks whether the queue is empty or not
    public char front();                 //returns the item at the front of the queue wihtout removing it.
    public String toString();           //returns a string of the queue
}

class LinkedListQueue implements Queue {
    private NodeCharacter front;
    private NodeCharacter rear;
    private int size;
    
    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueue(char data) {
        NodeCharacter newNode = new NodeCharacter(data);
        newNode.setData(data);
        newNode.setNext(null);
        if (this.empty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }
    
    public char dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        char data = front.getData();
        front = front.getNext();
        size--;
        
        if (empty()) {
            rear = null;
        }
        return data;
    }

    public int size() {
        return size;
    }
    
    public boolean empty () {
        return (size == 0);
    }

    public char front() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.getData();
    }

    public String toString() {
        if (empty()) {
            return "";
        }
        String result = "";
        NodeCharacter next = front;
        while (next != null) {
            result += next.getData();
            next = next.getNext();
        }
        return result;
    }
}
