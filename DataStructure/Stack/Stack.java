import java.util.EmptyStackException;

public class Stack{

    // Declare the int array and the top index.
    private int[] items;
    private int top;

    // The constructor initializes the stack data structure.
    public Stack(int size) {
        this.items = new int[size];
        this.top = -1; // Stack is initially empty
    }
    // Return true if the top index is -1, indicating the stack is empty.
    public boolean isEmpty() { return this.top == -1; }

    // Input an item to the stack.
    public void push(int item) {
        if (top == this.items.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        this.items[++top] = item;
    }

    // Remove the top item from the stack and return it.
    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return this.items[this.top--];
    }

    // Return length of the stack.
    public int size() { return this.top + 1; }

    // Return the top item of the stack without removing it.
    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return this.items[top];
    }

        public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // Output: 3
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.peek()); // Output: 2
    }
}

