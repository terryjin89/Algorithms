// BinaryTree implementation in JavaScript

// Classes representing each node in the tree
class Node{
    // Declare a Node consisting of data and two pointer left,right pointer
    constructor(data) {
        this.data = data; // Variables with Value
        this.left = null; // Reference to Left Child Node
        this.right = null;// Reference to Right Child Node
    }
}

// Classes implements a BinaryTree with basic operations
class BST{
    // Declare the root of tree
    constructor() {
        this.root = null // Point to the root node of the tree
    }

    //Method to insert new node of the tree
    insert(data) {
        //Internal recursive function responsible for actual insertion
        const _insert = (node, data) => {
            if (node === null) { return new Node(data); }
            if (node.data > data) { node.left = _insert(node.left, data); }
            else{ node.right = _insert(node.right, data); }
            return node;
        };
        this.root = _insert(this.root, data);
    }

    // Method to search node of the tree
    search(data) {
        const _search = (node, data) => {
            if(node === null) { return false; }
            if(node.data === data) { return true; }
            if(node.data > data) { return _search(node.left, data); }
            else { return _search(node.right, data); }
        }
        return _search(this.root, data);
    }

    // Method to delete node of the tree
    delete(data) {
        const _findMin = (node) => {
            while(node.left) {
                node = node.left;
            }
            return node;
        };

        const _delete = (node, data) => {
            if(node === null) { return null; }
            if(data < node.data) { node.left = _delete(node.left, data); }
            else if(data > node.data) { node.right = _delete(node.right, data); }
            else {
                // case 1: leaf node
                if (node.left === null && node.right === null) { return null; }
                // case 2: left child is not exist -> exchange right child
                if (node.left === null) { return node.right; }
                // case 3: right child is not exist -> exchange left child
                if (node.right === null) { return node.left; }
                // case 4: both exist
                const succ = _findMin(node.right);
                node.data = succ.data;
                node.right = _delete(node.right, succ.data);
            }
            return node
        };
        return _delete(this.root,data);
    }

    // Method to print Inorder Traversal
    inorder() {
        let res = []
        const _in = (node) => {
            if(node === null) return;
            _in(node.left);
            res.push(node.data);
            _in(node.right);
        }
        _in(this.root);
        console.log(res);
        return res;
    }
}

// Example usage
const bst = new BST();
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
bst.inorder();
bst.delete(9);
bst.inorder();
bst.delete(1);
bst.inorder();
bst.delete(7);
bst.inorder();