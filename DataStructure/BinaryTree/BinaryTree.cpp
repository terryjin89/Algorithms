#include <iostream>
using namespace std;

template <typename T>
class BinaryTree {
    private:
        class Node {
            private:
                T data;
                Node* left;
                Node* right;
            
            public:
                Node(T data) {
                    this->data = data;
                    this->left = nullptr;
                    this->right = nullptr;
                }
        };
        Node* root = nullptr;
        
        Node* _insert(Node* node, T data) {
            if(node == nullptr) return new Node(data);
            else if(node->data > data) node->left = _insert(node->left, data);
            else if(node->data < data) node->right = _insert(node->right, data);
            return node;
        }

        bool _search(Node* node, T data) {
            if(node->data == data) return true;
            if(node == nullptr) return false;
            return (node->data > data) ? _search(node->left, data) : _search(node->right, data);
        }

        Node* _findMin(Node* node) {
            while(node->left != nullptr) {  node= node->left; }
            return node;
        }
        Node* _remove(Node* node, T data) {
            if(node->data > data) return _remove(node->left, data);
            else if(node->data < data) return _remove(node->right, data);
            else {
                if(node->left == nullptr && node->right) {
                    delete node;
                    return nullptr;
                }

                if(node->left == nullptr) {
                    Node* temp = node->right;
                    delete node;
                    return temp; 
                }
                if(node->right == nullptr) {
                    Node* temp = node->left;
                    delete node;
                    return temp;
                }
                
                Node* succ = _findMin(node->right);
                node->data = succ->data;
                node->right = _remove(node->right, succ->data);
            }
            return node;
        }
    public:
        void insert(T data) {
            this->root = _insert(this->root, data);
        }

        void search(T data) {
            this->root = _search(this->root, data);
        }

        void remove(T data) {
            this->root = _remove(this->root, data);
        }
    
};