# Linked List Implementation in Python

# This module implements a simple singly linked list with basic operations.
class Node:
    # Declare a Node consisting of data and a pointer to the next node
    def __init__(self, data): # type: ignore
        self.data = data # The data stored in the node
        self.next = None # Pointer to the next node

# LinkedList class to manage the linked list operations
class LinkedList:

    # Declare the head of the LinkedList
    def __init__(self):
        self.head = None # Initialize the head of the linked list
        self.size = 0    # type: ignore # Initialize the size of the linked list
    
    # Method to add a new node at the end of the linked list
    def append(self, data): # type: ignore
        new_node = Node(data) # type: ignore # Create a new node with the given data
        if not self.head: # If the linked list is empty
            self.head = new_node # Set the new node as the head
        else:
            current = self.head # Start from the head
            while current.next: # Traverse to the last node
                current = current.next # Move to the next node
            current.next = new_node # type: ignore # Link the new node at the end
        self.size += 1 # type: ignore # Increment the size of the linked list

    # Delete a node with the specified data from the LinkedList
    def delete(self, data): # type: ignore
        current = self.head
        previous = None # Keep track of the previous node
        while current: # Traverse through the list
            if current.data == data: # type: ignore # If the current node's data matches
                if previous: # If it's not the head node
                    previous.next = current.next # Bypass the current node
                else: # If it is the head node
                    self.head = current.next # Move the head to the next node
                self.size -= 1 # type: ignore # Decrement the size of the linked list
                return # Exit after deletion
            previous = current # Link to the before node
            current = current.next # Move to the next node

    # Find a node with the specified data in the LinkedList
    def find(self, data): # type: ignore
        current = self.head
        while current: # Traverse through the list
            if current.data == data: # type: ignore # If the current node's data matches
                return current # Return the current node
            current = current.next # Move to the next node
        return None # If not found, return None
    
    # Get the size of the LinkedList
    def size(self):
        return self.size
    
    # Method to print the LinkedList
    def print_list(self):
        current = self.head
        while current: # Traverse through the list and print each node's data
            print(current.data, end=" -> ") # type: ignore
            current = current.next
        print("None") # Indicate the end of the list

# Example usage
if __name__ == "__main__":
    linklist = LinkedList() # Create a new LinkedList instance
    linklist.append(1) # type: ignore # Append data 1
    linklist.append(2) # type: ignore # Append data 2
    linklist.append(3) # type: ignore # Append data 3
    linklist.append(4) # type: ignore # Append data 4
    linklist.append(5) # type: ignore # Append data 5

    linklist.print_list() # Print the linked list
    print(linklist.find(3)) # type: ignore # Find a node with data 3
    linklist.delete(3) # type: ignore # Delete the node with data 3
    linklist.print_list() # Print the linked list after deletion 

    found_node = linklist.find(3) # type: ignore # Find a node with data 3
    if found_node:
        print(f"Found node with data: {found_node.data}") # type: ignore
    else:
        print("Node not found")
