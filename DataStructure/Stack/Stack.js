class Stack {
    // The cosntructor initializes the stack data structure.
    constructor() { this.items = [];}

    // Return true if the stack is empty, false if it it not true.
    is_empty() { return this.items.lentgh == 0;}

    // Input an element to the top of the stack.
     push(item){ this.items.push(item);}
    
    // Remove the top element from the stack and return it.
    pop() {
        if(this.is_empty()){
            return null
        }
        return this.items.pop();
    }

    // Return length of the stack.
    size() { return this.items.length; }

    // Return the top element of the stack without removing it.
    peek() {
        if(this.is_empty()){
            return null;
        }
        return this.items[this.items.length - 1];
    }
}

stack = new Stack();
stack.push(1);
stack.push(2);
stack.push(3);
console.log(stack.peek()); // Output: 3
console.log(stack.pop());  // Output: 3
console.log(stack.peek()); // Output: 2