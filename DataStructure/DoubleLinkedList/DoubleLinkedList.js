console.log("Executing from:", process.cwd());
// DoubleLinkedList implementation in JavaScript

// This module implements a simple DoubleLinkedList with basic operations
class Node{

    // Declare a Node consisting of data and two pointer prevent, next node
    constructor(data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// This class implements a DoubleLinkedList with basic operations
class DoubleLinkedList{

    // Declare the head of the DoubleLinkedList
    constructor() {
        this.head = null;
        this._size = 0;
    }

    // Method to add a new node at the end of the DoubleLinkedList
    append(data) {
        const new_node = new Node(data)
        if(this.head === null) { this.head = new_node }
        else {
            let current = this.head
            while(current.next != null) {
                current = current.next;
            }
            current.next = new_node;
            new_node.prev = current;
        }
        this._size++;
    }

    // Method to delete a note with the specified data from in DoubleLinkedList
    delete(data) {
        if(!this.head) return; // head is empty
        
        let current = this.head;

        while(current) { // Traverse through the list
            if(current.data === data) { // If the current node's data matches
                if(current === this.head) { // Data match first node
                    this.head = current.next;
                    if(this.head) { this.head.prev = null; }
                } else {// Data match other node
                    if(current.next) { current.next.prev = current.prev; }
                    current.prev.next = current.next;
                }
                this._size--;
            }
            current = current.next;
        }
    }

    // Method to find with the specified data in the DoubleLinkedList.
    find(data) {
        if(!this.head) return;

        let current = this.head;

        while(current) {
            if(current.data === data) {return current; }
            else { current=current.next; }
        }

        return null;
    }

    //Method to get the size of the DoubleLinkedList
    size() { return this._size; }

    //Method to print the DoubleLinkedList
    print() {
        if(!this.head) return console.log("Empty!");
        
        let current = this.head;
        let tail = null;
        let list_str = "";
        
        list_str = "Forward : head";
        while(current) {
            list_str += (current.data + " -> ");
            tail = current;
            current = current.next;
        }
        list_str += "null"
        console.log(list_str);
        list_str = "";

        list_str = "Backword : ";
        while(tail) {
            list_str += (tail.data + " <- ");
            tail = tail.prev;
        }
        list_str += "head "
        console.log(list_str);
    }
}

// Example usage
const doublelist = new DoubleLinkedList();
doublelist.append(10);
doublelist.append(20);
doublelist.append(30);
doublelist.append(40);
doublelist.append(50);
doublelist.print(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null
doublelist.delete(30);
doublelist.print(); // Output: 10 -> 20 -> 40 -> 50 -> null
console.log(doublelist.find(20)); // Output: Node { data: 20, next: null }
console.log(doublelist.size()); // Output: 4