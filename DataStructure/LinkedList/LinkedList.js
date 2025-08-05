//Linked List implementation in JavaScript

// This class implements a simple single node of a LinkedList
class Node {
    //Declare a Node with data and a pointer to the next node
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

// This class implements a LinkedList with basic operations
class LinkedList {

    // Declare a LinkedList with a head node
    constructor() {
        this.head = null;
        this.size = 0;
    }

    // Method to add a new node at the end of the LinkedList
    append(data) {
        const newNode = new Node(data); // Create a new node with the given data
        if(!this.head) { this.head = newNode; } // If the list is empty, set the head to the new node
        else {
            let current = this.head; // Start from the head node
            while(current.next) {    // Traverse to the end of the list
                current = current.next;
            }
            current.next = newNode; // Set the next of the last node to the new node
        }
        this.size++;
    }

    // Method to delete a node by value
    delete(data) {
        if(!this.head) return;
        else {
            if(this.head.data === data) {
                this.head = this.head.next;
                this.size--;
                return;
            } else {
                let current = this.head;
                while(current.next && current.next.data !== data) {
                    current = current.next;
                }
                if(current.next) { current.next = current.next.next;}
                this.size--;
            }
        }
    }

    // Method to find a node by value
    find(data) {
        let current = this.head;
        while(current) { // Traverse through the list
            if(current.data === data) return current; // Return the node if found
            current = current.next; // Move to the next node
        }
        return null; // Return null if not found
    }

    // Method to get the size of the LinkedList
    getSize() { return this.size; }

    // Method to print the LinkedList
    print() {
        let current = this.head;
        let output = '';
        while(current) { // Traverse through the list
            output += current.data + ' -> '; // Append data to output string
            current = current.next; // Move to the next node
        }
        output += 'null'; // End of the list
        console.log(output); // Print the LinkedList
    }
}

// Example usage
const list = new LinkedList();
list.append(10);
list.append(20);
list.append(30);
list.append(40);
list.append(50);
list.print(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null
list.delete(30);
list.print(); // Output: 10 -> 20 -> 40 -> 50 -> null
console.log(list.find(20)); // Output: Node { data: 20, next: null }
console.log(list.getSize()); // Output: 4