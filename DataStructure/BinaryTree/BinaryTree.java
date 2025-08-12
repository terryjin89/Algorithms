package DataStructure.BinaryTree;

public class BinaryTree<T> {

    private class Node{
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {

    }

    public boolean search(T data) {

    }

    public void delete(T data) {

    }

    public T[] inorder() {}
}
