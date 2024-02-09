# QUEUE DATA STRUCTURE
A queue is a linear data structure where elements are stored in the FIFO(First In First Out) principle where the first element inserted would be the first element to be accessed. 

A queue is an Abstract Data Structure(ADT) similar to stack, the only difference is that queue is open at both end.

## IMPLEMENTATION
A queue can be implemented using Arrays, Linked List or Pointers.
Queue uses two pointers, front and rear pointers.

- Front Pointer - accesses element from the front(enqueuing)
- Rear pointer - accesses element from the back(de-queuing)

## Basic Operations on Queue
- enqueue - used to insert element into the stack
- dequeue - used to remove element from the stack
- peek - retrieve the front-most element in the queue without deleting it.
- isFull - verifies whether the stack is full
- isEmpty - verifies whether the stack is empty

### enqueue
1. START
2. Check if the queue is full
3. If the queue is full, produce overflow error and exit
4. Check if the queue is empty
5. If the queue is empty, increment the front/rear pointer to point to the next empty slot
6. If the queue is not empty, increment the rear pointer to point to the next empty slot
7. Add element to the queue location, where the rear is pointing 
8. Return success 
9. END

### dequeue
1. START
2. Check if the queue is empty, if the queue is empty, produce underflow error and exit
3. If the queue is not empty, access the data where front is pointing
4. Increment front pointer to point to the next available data element
5. Return success
6. END

### peek
1. START
2. Check if the queue is empty, if empty produce error and exit
3. If not empty, return the element at the front of the queue
4. END

### isFull
1. START
2. If the size of the queue elements is equal the queue capacity, return true
3. Else, return false
4. END

### isEmpty
1. START
2. If the count of the queue elements equals zero, return true
3. Else, return false
4. END

