# DoubleLinkedList implementation in Python

# This module implements a simple DoubleLikedList with basic operations.
class Node:
    # Declare a Node consisting of data and two pointer prevent, next node
    def __init__(self, data) -> None: # type: ignore
        self.data = data # type: ignore
        self.prev = None
        self.next = None

# This class implements a DoubleLinkedList with basic operations
class DoubleLinkedList:

    # Declare the head of the DoubleLinkedList
    def __init__(self) -> None:
        self.head = None # Initialize the head of the DoubleLinkedList
        self._size = 0 # type: ignore
    
    # Method to add a new node at the end of the DoubleLinkedList
    def append(self, data) -> None: # type: ignore
        new_node = Node(data) # type: ignore # Create a new node with given data
        if not self.head: #If the DoubleLinkedList is empty
            self.head = new_node
        else:
            current = self.head # Start from the head
            while current.next:
                current = current.next
            current.next = new_node # type: ignore
            new_node.prev = current # type: ignore
        self._size += 1 # type: ignore

    # Method to delete a node with the specified data from the DoubleLinkedList
    def delete(self, data) -> None: # type: ignore
        current = self.head
        while current: # Traverse through the list
            if current.data == data: # type: ignore # If the current node's data matches
                if current.prev: # middle or last node
                    current.prev.next = current.next
                else: # first node
                    self.head = current.next
                if current.next: 
                    current.next.prev = current.prev
                self._size -= 1 # type: ignore
                return
            current = current.next # Move to the next node
    
    # Method to find with the specified data in the DoubleLinkedList
    def find(self, data): # type: ignore
        current = self.head
        while current: # Traverse through the list
            if current.data==data: # type: ignore # If the current node's data matches
                return current # Return the current node
            current = current.next
        return None # If not found, return None
    
    # Method to get the size of the DoubleLindedList
    def size(self) -> int:
        return self._size  # type: ignore
    
    # Method to print the DoubleLinkedList
    def print_list(self):
        current = self.head
        tail = None # type: ignore

        print("Forward : ", end="")
        while current: # type: ignore
            print(current.data, end=" -> ") # type: ignore
            tail = current # type: ignore
            current = current.next
        print("Null")

        print("Backward : ", end="")
        while tail:
            print(tail.data, end=" <- ") # type: ignore
            tail = tail.prev
        print("head")

# Example usage
if __name__ == "__main__":
    dll = DoubleLinkedList() # Create a new LinkedList instance
    dll.append(1) # type: ignore # Append data 1
    dll.append(2) # type: ignore # Append data 2
    dll.append(3) # type: ignore # Append data 3
    dll.append(4) # type: ignore # Append data 4
    dll.append(5) # type: ignore # Append data 5

    dll.print_list() # Print the linked list
    print(dll.find(3)) # type: ignore # Find a node with data 3
    dll.delete(3) # type: ignore # Delete the node with data 3
    dll.print_list() # Print the linked list after deletion 

    found_node = dll.find(3) # type: ignore # Find a node with data 3
    if found_node:
        print(f"Found node with data: {found_node.data}") # type: ignore
    else:
        print("Node not found")







