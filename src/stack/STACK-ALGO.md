# STACK
Stack is a linear data structure where elements are stored in the LIFO(Last In First Out) principle where the last element inserted would be the first element deleted.

Stack is a complex data structure because it uses other data structures such as Arrays, Linked List for implementation.

A stack allows all data operation at one end only. At any given time, we can only access the top element of a stack.

Stack can be fixed size or has dynamic resizing.

## Basic Operations on Stack
- push - insert element to the stack
- pop - delete element from the stack
- peek - get the top element on the stack
- isFull - determine if the stack is full
- isEmpty - determine if the stack is empty

### PUSH
1. Check if the stack is full
2. If the stack is full, produce an error an exit
3. If the stack is not full, increment top point next empty space
4. Add data element to the stack location where top is pointing
5. Return success


