#include<iostream>
using namespace std;

//This class implements a simple stack data structure in C++.
class Stack {

    //Declare the int array, the top index, and the max size.
    private:
        int* items;
        int top;
        int maxSize;
    
    public:
        //The constructor initializes the stack data structure.
        Stack(int size) {
            this->items = new int[size];
            this->top = -1;
            this->maxSize = size;
        }

        //Return true if the stack is empty, false if it is not.
        bool isEmpty() { return this->top == -1;}

        //Input an item to the top of the stack.
        void push(int item) {
            if (this->top == this->maxSize - 1) {
                cout << "Stack overflow" << endl;
            } else {
                this->items[++this->top] = item;
            }
        }

        //Remove the top item from the stack and return it.
        int pop() {
            if(this->isEmpty()) {
                cout << "Stack underflow" << endl;
                return -1;  // Meaningful value indicating stack is empty
            }
            return this->items[this->top--];
        }

        //Return length of the stack.
        int size() { return this->top + 1;}

        //Return the top item of the stack without removing it.
        int peek() {
            if(this->isEmpty()) {
                cout << "Stack is empty" << endl;
                return -1;  // Meaningful value indicating stack is empty
            } else{ return this->items[this->top]; }
            
        }
};

int main() {
    Stack stack(5);

    stack.push(1);
    stack.push(2);
    stack.push(3);

    cout << "Top item is: " << stack.peek() << endl;

    stack.pop();
    cout << "Top item after pop is: " << stack.peek() << endl;

    cout << "Stack size is: " << stack.size() << endl;

    return 0;
}