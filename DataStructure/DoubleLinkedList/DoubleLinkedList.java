package DataStructure.DoubleLinkedList;

// DoubleLinkedList implemention in JAVA

// This module implements a simple DoubleLinkedList with basic operations
public class DoubleLinkedList<T> {
        
    // Declare a node consisting of data and a pointer to the next node
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        //Constructor to initialize the node
        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    
    }
    private Node<T> head;// Head of the list
    private Node<T> tail;// Tail of the list
    private int _size;   // Size of the list

    //Constructor to initialize the node
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this._size = 0;
    }

    //Method to insert a new node at the end of the list
    public void insert(T data) {
        Node<T> new_node = new Node<>(data); 

        // If head is empty, input the new node to head
        if(this.head == null) { 
            this.head = new_node;
            this.tail = new_node; 
        }
        else {
            this.tail.next = new_node;//In next of the last node, enter a new node
            new_node.prev = this.tail;//In prev of new node, enter the tail node
            this.tail = new_node;// Move the pointer tail node to new node
        }
        this._size++;
    }

    //Method to delete a node with a specific value
    public void delete(T data) {
        // If head is emply
        if( this.head == null) { System.out.println("List is empty!"); return; }
        else {
            int f_size = this._size;

            // first node
            if(this.head.data.equals(data)) {//first node
                if(this.head == this.tail) {// list is 1 node
                    this.head = null;
                    this.tail = null;
                } else {
                    this.head = this.head.next;
                    this.head.prev = null;
                }
            this._size--;
            } else {
                Node<T> current = this.head;

                while(current != null) {
                    Node<T> nextNode = current.next;
                    if(current.data.equals(data)) {
                        if(this.tail == current) {//last node
                            this.tail = current.prev;
                            this.tail.next = null;
                        } else{//middle node
                            current.prev.next = current.next;
                            current.next.prev = current.prev;
                        }
                        this._size--;
                    }
                    current = nextNode;
                }
            }
            if(f_size == _size) {System.out.println("Data not found!");}
        }
    }

    //Method to find 
    public boolean find(T data) {
        Node<T> current = this.head;
        while(current != null) {
            if(current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() { return this._size; }

    public void print() {
        Node<T> current = this.head;
        
        System.out.print("Forward : head -> ");
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");

        current = this.tail;

        System.out.print("Backword : null -> ");
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("head");
    }

        public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insert(1);
        dll.insert(3);
        dll.insert(5);
        dll.insert(7);
        dll.insert(9);
        dll.print();// Output: 1 -> 3 -> 5 -> 7 -> 9 -> null
        System.out.println(dll.size());// Output: 4
        dll.delete(5);
        dll.print();// Output: 1 -> 3 -> 7 -> 9 -> null
    }
}