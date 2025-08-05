//Linked List Implementation in Java

// LinkedList class to manage the linked list operations
public class LinkedList {

    //This module defines a simple linked list structure with basic operations.
    private static class Node {
        private final int data;
        private Node next;

    // Declare a Node consisting of data and a pointer to the next node
    public Node(int data) {
        this.data = data;
        this.next = null; // Initialize next as null
    }
}
    private Node head; // Head of the list
    private int size; // Size of the list

    // Constructor to initialize the linked list
    public LinkedList() {
        this.head = null; // Start with an empty list
        this.size = 0; // Size is zero initially
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.head == null) { this.head = newNode; }
        else { Node current = this.head;
            while (current.next != null) { current = current.next; }
            current.next = newNode;
        }
        this.size++; // Increment the size of the list
    }

    // Delete a node with a specific value
    public void delete(int data) {
        if (this.head.data == data) { // If the head node is to be deleted
            this.head = this.head.next; // Move head to the next node
            this.size--; // Decrement size
        } else{
            Node current = this.head;
            while (current.next != null && current.next.data != data) {
                current = current.next; // Traverse the list
            }
            if (current.next != null) { // If the node to delete was found
                current.next = current.next.next; // Bypass the node
                this.size--; // Decrement size
            }
        }
    }

    //Find a node with a specific value
    public boolean find(int data) {
        Node current = this.head;
        while(current != null) {// Traverse the list
            if(current.data == data) { return true; }
            current = current.next; // Move to the next node
        }
        return false; // Return false if not found
    }

    // Get the size of the LinkedList
    public int size() { return this.size; }

    //Method to print the LinkedList
    public void print() {
        String lstr = "";
        Node current = this.head;

        while(current != null) {
            lstr += String.valueOf(current.data);
            lstr += " -> ";
            current = current.next;
        }
        lstr += "Null";
        System.out.println(lstr);
    }

    //Example usage
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(3);
        ll.insert(5);
        ll.insert(7);
        ll.insert(9);
        ll.print();// Output: 1 -> 3 -> 5 -> 7 -> 9 -> null
        System.out.println(ll.size());// Output: 4
        ll.delete(5);
        ll.print();// Output: 1 -> 3 -> 7 -> 9 -> null
    }
}
