package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a generic Binary Search Tree (BST).
 * The type T must implement the Comparable interface to allow for ordering of elements.
 * @param <T> the type of values stored in the tree
 */
public class BinaryTree<T extends Comparable<T>> {

    /**
     * Represents a node in the binary tree.
     * It contains the data and references to the left and right children.
     */
    private class Node {
        private T data;
        private Node left;
        private Node right;

        /**
         * Constructs a new node with the given data.
         * @param data The data to be stored in the node.
         */
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // The root node of the binary tree.
    private Node root;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Public method to insert data into the tree.
     * It calls the recursive helper function starting from the root.
     * @param data The data to insert.
     */
    public void insert(T data) {
        this.root = insertRecursive(this.root, data);
    }

    /**
     * Private recursive helper method to insert a new node.
     * @param node The current node in the recursion.
     * @param data The data to insert.
     * @return The node after insertion, used to link the tree back up.
     */
    private Node insertRecursive(Node node, T data) {
        // If the current node is null, we've found the insertion point.
        if (node == null) {
            return new Node(data);
        }

        // Compare the new data with the current node's data to decide the direction.
        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        } else {
            // If data is equal to node.data, do nothing (no duplicates).
        }

        return node;
    }

    /**
     * Public method to search for a value in the tree.
     * @param data The value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean search(T data) {
        return searchRecursive(this.root, data);
    }

    /**
     * Private recursive helper method to search for a value.
     * @param node The current node in the recursion.
     * @param data The value to search for.
     * @return true if the value is found, false otherwise.
     */
    private boolean searchRecursive(Node node, T data) {
        if (node == null) {
            return false;
        }
        if (data.equals(node.data)) {
            return true;
        }
        return data.compareTo(node.data) < 0
                ? searchRecursive(node.left, data)
                : searchRecursive(node.right, data);
    }

    /**
     * Public method to delete a value from the tree.
     * @param data The value to delete.
     */
    public void delete(T data) {
        this.root = deleteRecursive(this.root, data);
    }

    /**
     * Finds the node with the minimum value in a given subtree.
     * @param node The root of the subtree to search.
     * @return The node with the minimum value.
     */
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Private recursive helper method to delete a node.
     * @param node The current node in the recursion.
     * @param data The value to delete.
     * @return The node after deletion, used to link the tree back up.
     */
    private Node deleteRecursive(Node node, T data) {
        if(node == null) {
            return null; // Value not found
        }

        // Traverse the tree to find the node to delete
        int compare = data.compareTo(node.data);
        if(compare < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if(compare > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Node to be deleted is found

            // Case 1: Node is a leaf (no children)
            if(node.left == null && node.right == null) {
                return null;
            }
            // Case 2: Node has one child
            if(node.left == null) {
                return node.right;
            }
            if(node.right == null) {
                return node.left;
            }

            // Case 3: Node has two children
            // Find the inorder successor (smallest value in the right subtree)
            Node succ = findMin(node.right);
            // Copy the successor's data to this node
            node.data = succ.data;
            // Delete the inorder successor from the right subtree
            node.right = deleteRecursive(node.right, succ.data);
        }
        return node;
    }

    /**
     * Public method to perform an inorder traversal of the tree.
     * @return A List containing the elements in sorted order.
     */
    public List<T> inorder() {
        List<T> res = new ArrayList<>();
        inRecursive(this.root, res);
        return res;
    }

    /**
     * Private recursive helper method for inorder traversal.
     * @param node The current node in the recursion.
     * @param res The list to store the traversal result.
     */
    private void inRecursive(Node node, List<T> res) {
        if (node == null) return;
        inRecursive(node.left, res);
        res.add(node.data);
        inRecursive(node.right, res);
    }

    /**
     * Main method for demonstration and testing.
     */
    public static void main(String[] args) {
        BinaryTree<Integer> bst = new BinaryTree<>();
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

        System.out.println("Inorder traversal: " + bst.inorder());

        System.out.println("\nDeleting 9 (leaf node)...");
        bst.delete(9);
        System.out.println("Inorder traversal: " + bst.inorder());

        System.out.println("\nDeleting 1 (node with one child)...");
        bst.delete(1);
        System.out.println("Inorder traversal: " + bst.inorder());

        System.out.println("\nDeleting 7 (node with two children)...");
        bst.delete(7);
        System.out.println("Inorder traversal: " + bst.inorder());

        System.out.println("\nDeleting 4 (root node)...");
        bst.delete(4);
        System.out.println("Inorder traversal: " + bst.inorder());
    }
}