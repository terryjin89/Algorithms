#include <iostream>
using namespace std;

//Linked List Implemention in C++

class LinkedList {
    private:
        // This module defines a simple linked list sturcture with basic operations.
        class Node{
            public:
                int data;
                Node* next;

                //Declare a Node consisting of data and pointer to the next node
                Node(int data) : data(data), next(nullptr) {}
        };

        Node* head;
        int size;

    public:
        LinkedList() : head(nullptr), size(0) {}

        // Method to insert a new node at the end of the list
        void insert(int data) {
            Node* newNode = new Node(data); // Create a new node with the given data
            if(this->head == nullptr) { this->head = newNode; } // if head is null, set the new node as the head
            else {
                Node* current = head;// Start from the head
                while(current->next != nullptr) {  current = current->next; } // Traverse to the last node
                current->next = newNode; // Link the new node at th and
            }
            this->size++;
        }

        // Method to delete a node with a specific value
        void remove(int data) {
            if(this->head == nullptr) return;// Make sure head is empty
            if(this->head->data == data) {   // Make sure first Node equal to data
                Node* temp = head;
                this->head = this->head->next;
                delete temp;
                this->size--;
            }
            else {
                Node* current = this->head;//
                while(current->next != nullptr && current->next->data != data) { current = current->next; }
                if(current->next != nullptr) {
                    Node* temp = current->next;
                    current->next = current->next->next;
                    delete temp;
                    this->size--;
                }
            
            }
        }

        // Method to find a node with a specific value
        bool find(int data) {
            Node* current = this->head;
            while(current != nullptr) {
                if(current->data == data) { return true; }
                current = current->next;
            }
            return false;
        }

        // Method to size of the LinkedList
        int list_size() {return this->size; }

        // Method to print the LinkedList
        void print() {
            Node* current = this->head;
            while(current != nullptr) {
                cout << current->data << "->";
                current = current->next;
            }
            cout << "null" << endl;
        }
};

int main() {
    LinkedList ll;
    ll.insert(1);
    ll.insert(2);
    ll.insert(3);
    ll.insert(4);
    ll.insert(5);
    ll.print(); // 1->2->3->->null
    cout << ll.list_size() << endl; // 3
    cout << (ll.find(2) ? "found" : "not found") << endl; // found
    ll.remove(2);
    ll.print(); // 1->3->null
    cout << ll.list_size() << endl; // 2
    return 0;
}