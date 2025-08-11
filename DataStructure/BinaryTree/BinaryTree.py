#type: ignore # BinaryTree implementation in Python

class Node:# Classes representing each node in the tree
    
    # Declare a Node consisting of data and two pointer left,right pointer.
    def __init__(self, data) -> None:
        self.data = data # Variables with Value
        self.left = None # Reference to Left Child Node
        self.right = None # Reference th Right Child Node

# Classes implements a BinaryTree with basic operations
class BST:
    # Declare the root of tree
    def __init__(self) -> None:
        self.root = None # Point to the root node of the tree

    # Methode to insert new node of the tree
    def insert(self, data) -> None:
        # Internal recursive function responsible for actual insertion
        def _insert(node, data):
            if node is None: # step 2-1 : if this node is empty,new node insert to this node.
                return Node(data)
            if data < node.data: # step 2-2 : if new data smaller than root's data, move to left node
                node.left = _insert(node.left, data)
            else:# step 2-3 : if new data bigger than root's data, move to right node
                node.right = _insert(node.right, data)
            return node # step 3 : return the current node (keep the connection)
        self.root = _insert(self.root, data) # step 1 : Start to insert root

    # Method to search node of the tree
    def search(self, data) -> bool:
        # Internal recursive function responsible for actual insertion
        def _search(node, data):
            if node is None: # if the navigation position is empty,
                return False # False return because there is no value.
            if data == node.data: # if the current node data is the same as the one found,
                return True       #  return True because it was found.
            # Move to left if the search value is smaller and to the right if it's larger
            return _search(node.left, data) if data < node.data else _search(node.right, data)
        return _search(self.root, data) # Start to search from root
    
    # Method to delete to node of the tree
    def delete(self, data) -> None:
        # Function to find minimum node in right subtree(find successor)
        def _findMin(node):
            while node.left:
                node = node.left
            return node
        # Internal recursive function responsible for actual insertion
        def _delete(node, data):
            if node is None: # if this node is empty,
                return None  # return as is
            if data < node.data: # if delete data smaller than current data,
                node.left = _delete(node.left, data) # Move to left node
            elif data > node.data: # if delete data bigger than current data,
                node.right = _delete(node.right, data) # Move to right node
            else: # if it found the destination to delete(data == node.data)
                # case 1: leef node
                if node.left is None and node.right is None:
                    return None
                # case 2: left child is not exist -> exchange right child
                if node.left is None:
                    return node.right
                # case 3: right child is not exist -> exchange left child
                if node.right is None:
                    return node.left
                # case 4: both exist 
                # ->find the minimun data(successor) in the right subtree and replace the current data
                succ = _findMin(node.right)
                node.data = succ.data
                node.right = _delete(node.right, succ.data) # Delete successor from right subtree
            return node # return exchanged current node
        self.root = _delete(self.root, data) # start to delete from root

    # Method to print Inorder Traversal
    def inorder(self) -> []:
        res = []
        def _in(node): # if node is empty, exit
            if not node: return 
            _in(node.left) # left subtree circuit
            res.append(node.data) # current node's data insert to res list
            _in(node.right) # right subtree circuit
        _in(self.root) # start to root
        return print(res), res
    

# Example usage
if __name__ == "__main__":
    bst = BST()
    bst.insert(4)
    bst.insert(2)
    bst.insert(7)
    bst.insert(1)
    bst.insert(3)
    bst.insert(5)
    bst.insert(8)
    bst.insert(0)
    bst.insert(6)
    bst.insert(9)
    bst.inorder()
    bst.delete(9)
    bst.inorder()
    bst.delete(1)
    bst.inorder()
    bst.delete(7)
    bst.inorder()

