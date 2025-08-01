//This class implements a simple Queue data structure using an array in Java.
public class Queue {

    // Declare the array and pointers.
    private int[] items;
    private int front;
    private int rear;
    private int currentSize;
    private int capacity;

    // The constructor initializes the queue.
    public Queue(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Return true if the queue is full.
    public boolean isFull() {
        return this.currentSize == this.capacity;
    }

    // Return true if the queue is empty.
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    // Input an item to the rear of the queue.
    public void push(int item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.items[this.rear] = item;
        this.currentSize++;
    }

    // Remove the front item from the queue and return it.
    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        int item = this.items[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.currentSize--;
        return item;
    }

    // Return the front item of the queue without removing it.
    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return this.items[this.front];
    }

    // Return the current number of items in the queue.
    public int size() {
        return this.currentSize;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek()); // Expected output: 1
        System.out.println(queue.pop());  // Expected output: 1
        System.out.println(queue.peek()); // Expected output: 2
        queue.push(4);
        queue.push(5);
        // The queue is now [2, 3, 4, 5]
        System.out.println(queue.pop()); // Expected output: 2
        System.out.println(queue.size()); // Expected output: 3
    }
}