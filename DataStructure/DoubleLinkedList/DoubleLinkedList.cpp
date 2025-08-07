#include <iostream>
using namespace std;
//DoubleLinkedList implemention in C++

//This modul implements a simple DoubleLinkedList with basic operations
template <typename T> // Templates allow to write data type-independent code
class DoubleLinkedList {
    private:
        // Declare a node consisting of data a pointer to the next node
        class Node{
            public:
                T data;
                Node* prev;
                Node* next;

                // Constructor to initialize the node
                Node(T data) {
                    this->data = data;
                    this->prev = nullptr;
                    this->next = nullptr;
                }
        };
        Node* head;
        Node* tail;
        int _size;
    
    public:
        
        DoubleLinkedList() {
            head = nullptr;
            tail = nullptr;
            _size = 0;
        }
        
        //Method to insert a new node at the end of the list
        void insert(T data) {
            Node* new_node = new Node(data);

            if(this->head == nullptr) {// Head is empty
                this->head = new_node;
                this->tail = new_node;
            } else {// Head is not empty
                this->tail->next = new_node;// In next of the last node, enter a new node
                new_node->prev = this->tail;// In prev oft new node, enter a tail node
                this->tail = new_node;// Move the pointer tail node to new node
            }
            this->_size++;
        }

        //Method to delete a node whih a specific data

        bool remove(T data) {
            Node* temp = nullptr;

            // Case 1: List is empty
            if(this->head == nullptr) { cout << "head is empty\n"; return false; }

            // Case 2: Only one node in the list
            if(this->head == this->tail) {
                if(this->head->data == data) {
                    delete this->head;
                    this->head = nullptr;
                    this->tail = nullptr;
                    this->_size--;
                    return true;
                } else { cout << "No matching data\n"; return false; }
            }

            // Case 3: Match haed node
            if(this->head->data == data) {
                temp = this->head;
                this->head = this->head->next;
                this->head->prev = nullptr;
                delete temp;
                this->_size--;
                return true;
            }
            
            // Case 4: Match tail node
            if(this->tail->data == data) {
                temp = this->tail;
                this->tail = this->tail->prev;
                this->tail->next = nullptr;
                delete temp;
                this->_size--;
                return true;
            }

            // Case 5: Search in middle node
            Node * current = this->head->next;
            while(current != nullptr) {
                if(current->data == data) {
                    temp = current;
                    current->prev->next = current->next;
                    current->next->prev = current->prev;
                    delete temp;
                    this->_size--;
                    return true;
                }
                current = current->next;
            }

            cout << "No matching data\n";
            return false;
        }

        // Method to find a node with aspecific data
        bool find(T data) {
            // If list is empty
            if(this->head == nullptr) { cout << "List is empty.\n"; return false; }

            Node* current = this->head;
            while(current != nullptr) {
                if(current->data == data) {
                    return true;
                }
                current = current->next;
            }
            return false;
        }

        // Method to size of the list
        int list_size() {return this->_size; }

        // Method to print list's data
        void print() {
            Node* current = this->head;
            cout << "Forward : head -> ";
            while(current != nullptr) {
                cout << current->data << " -> ";
                current = current->next;
            }
            cout << "null\n";

            cout << "Backward : null -> ";
            current = this->tail;
            while(current != nullptr) {
                cout << current->data << " -> ";
                current = current->prev;
            }
            cout << "head\n";
        }
};

int main() {
    DoubleLinkedList<int> dll;
    dll.insert(1);
    dll.insert(2);
    dll.insert(3);
    dll.insert(4);
    dll.insert(5);
    dll.print(); // 1->2->3->->null
    cout << dll.list_size() << endl; // 3
    cout << (dll.find(2) ? "found" : "not found") << endl; // found
    dll.remove(2);
    dll.print(); // 1->3->null
    cout << dll.list_size() << endl; // 2
    return 0;
}