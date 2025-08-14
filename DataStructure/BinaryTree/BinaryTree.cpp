#include <iostream>
#include <vector>
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

        Node* _inorder(Node* node, vector<T> res) {
            if(node == nullptr) return;
            _inorder(node->left, res);
            res.push_back(node->data);
            _inorder(node->right, res);
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
        
        void inorder() {
            vector<T> res = new vector<T>();
            _inorder(this->root,res);
        }
};

int main() {

    BinaryTree<int> bst;
    bst.insert(4);
    bst.insert(2);
    bst.insert(7);
    bst.insert(1);
    bst.insert(3);
    bst.insert(5);
    bst.insert(8);
    bst.insert(0);
    bst.insert(6);
    bst.insert(9);

        cout << "Inorder traversal: "; 
        cout << bst.inorder() << endl;

        out << "\nDeleting 9 (leaf node)...");
        bst.delete(9);
        out << "Inorder traversal: " + bst.inorder());

        out << "\nDeleting 1 (node with one child)...");
        bst.delete(1);
        out << "Inorder traversal: " + bst.inorder());

        out << "\nDeleting 7 (node with two children)...");
        bst.delete(7);
        out << "Inorder traversal: " + bst.inorder());

        out << "\nDeleting 4 (root node)...");
        bst.delete(4);
        out << "Inorder traversal: " + bst.inorder());    



    return 0;
}

