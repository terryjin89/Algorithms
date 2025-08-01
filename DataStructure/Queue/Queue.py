#This class implements a simple Queue data structure using a list in Python.
class Queue:

    # The constructor initializes the queue data structure.
    def __init__(self) -> None:
        self.items = []
    
    # Returns true if the queue is empty, false it is not.
    def is_empty(self) -> bool:
        return len(self.items) == 0 # type: ignore
    
    # Input item to the queue.
    def push(self, item) -> None:
        self.items.append(item)
    
    # Removes the first item from the queue and returns it.
    def pop(self): # type: ignore
        if self.is_empty():
            raise IndexError("pop from empty queue")
        else:
            return self.items.pop(0)  # type: ignore
    
    # Return the number of items in the queue.
    def size(self) -> int: # type: ignore
        return len(self.items) # type: ignore
    
    # Returns the first item from the queue without removing it.
    def peek(self): # type: ignore
        if self.is_empty():
            raise IndexError("peek from empty queue")
        else:
            return self.items[0] # type: ignore

queue = Queue()
queue.push(1)
queue.push(2)
queue.push(3)
print(queue.pop())  # Output: 1
print(queue.peek())  # Output: 2