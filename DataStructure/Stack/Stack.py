class Stack: # A simple stack implementation using a list
    def __init__(self) -> None:
        self.items = []

    # Returns true if the stack is empty, false if it is not true.
    def is_empty(self) -> bool:
        if not self.items: # type: ignore
            return True
        return False
    
    # Input item to the stack.
    def push(self, item) -> None: # type: ignore
        self.items.append(item) # type: ignore

    # Removes the last item from the stack and returns it.
    def pop(self): # type: ignore
        if self.is_empty():
            raise IndexError("pop from empty stack")
        return self.items.pop() # type: ignore
    
    # Reurns the number of items in the stack.
    def size(self) -> int:
        return len(self.items) # type: ignore

    # Returns the last item from the stack without removing it.
    def peek(self): # type: ignore
        if self.is_empty():
            raise IndexError("peek from empty stack")
        return self.items[-1] # type: ignore

stack =Stack()
stack.push(1)
stack.push(2)
stack.push(3)  
print(stack.pop())  # Output: 3