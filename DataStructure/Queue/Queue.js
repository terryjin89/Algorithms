//This class implements a simple Queue data structure using an array of JavaScript.
class Queue {
    
    //The constructor initializes an empty array to queue data structure.
    constructor() {
        this.items = [];
    }

    //Returns true if the queue is empty, false if it is not.
    isEmpty() { return this.items.length == 0;}

    //Input an element to the end of the queue.
    push(item) { this.items.push(item); }

    //Romove the front element from the queue and return it.
    pop() {
        if(this.isEmpty()) {
            return null;
        }
        else { return this.items.shift(); }
    }

    //Return size of the queue.
    size() { return this.items.length; }

    //Return the front element of the queue without removing it.
    peek() {
        if(this.isEmpty()) {
            return null;
        }
        else { return this.items[0]; }        
    }
}

queue = new Queue();
queue.push(1);
queue.push(2);
queue.push(3);
console.log(queue.peek()); // Output: 1
console.log(queue.pop());  // Output: 1
console.log(queue.peek()); // Output: 2
