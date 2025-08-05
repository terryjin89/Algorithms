#include <iostream>
using namespace std;

//This class implements a simple queue data structure in C++.
class Queue {

    //Declare the int array, the front index, rear index, and the max size.
    private:
        int* items;
        int front;
        int rear;
        int maxSize;

    public:
        
        //The constructor initializes the queue data structure.
        Queue(int size) {
            this->items = new int[size];
            this->front = 0;
            this->rear = -1;
            this->maxSize = size;
        }

        //Return true if the queue is empty, false if it is not.
        bool isEmpty() { return this->front > this->rear; }

        //Input an item to the rear of the queue.
        void enqueue(int item) {
            if(this->rear == this->maxSize -1) {
                cout << "Queue overflow" << endl;
            } else {
                this->items[++this->rear] = item;
            }
        }

        //Remove the front item from the queue and return it.
        int dequeue() {
            if(isEmpty()) {
                cout << "Queue underflow" << endl;
                return -1;  // Meaningful value indicating queue is empty
            } else {
                return this->items[this->front++];
            }
        }
        
        //Return size of the queue.
        int size() { return this->rear - this->front + 1; }

        //Return the front item of the queue without removing it.
        int peek() {
            if(isEmpty()) {
                cout << "Queue is empty" << endl;
                return -1;  // Meaningful value indicating queue is empty
            } else {
                return this->items[this->front];
            }
        }
};

int main() {
    Queue queue = Queue(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    cout << "Front item is: " << queue.peek() << endl;
    cout << "Front item is: " << queue.dequeue() << endl;
    cout << "Front item after dequeue is: " << queue.peek() << endl;
    cout << "Queue size is: " << queue.size() << endl;
    return 0;
}