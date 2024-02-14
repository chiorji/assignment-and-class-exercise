# STACK
Stack is a linear data structure where elements are stored in the LIFO(Last-In, First-Out) principle where the last element inserted would be the first element deleted.
In a stack, new nodes are added to and removed from the top of the stack only.

Stack is a complex data structure because it uses other data structures such as Arrays, Linked List for implementation.

# How stack works
A stack allows all data operation at one end only, at any given time, we can only access the top element of a stack.

# Implementing a stack
A stack could be implemented using a linked list or an array(with size fixed or has dynamic resizing).

## Basic Operations
- push - inserts new element to the top of the stack
- pop - removes element from the top of the stack and returns data from the removed node
- peek - retrieves the top element on the stack without removing it
- traversing - loop through the stack and return all the data


### PUSH
1. START
2. Check if the stack is empty
4. If the stack is empty, add the element to the head
5. If the stack is not empty, traverse the list and add element to be the last node.
6. Increment size of stack
7. END

```java
 public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
```

### POP
1. START
2. Check if the stack is empty
3. If the stack is empty, produce an error and exit
4. Check if the stack has only one element, if true, dereference the head and return the data attached to it
5. Else, traverse the stack and find the element second to the last node
6. Assign NULL to the next pointer of the node found in step 5 above
7. Decrement the size of the stack
8. Return the data of the node adjacent to the node found in step 5 above
9. END

```java
  public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        
        Node<T> current = head;
        Node<T> previous = null;
        
        if (getSize() == 1) {
            T data = current.data;
            head = null;
            --size;
            return data;
        }
        
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        
        // Grab the data of the current node, which is the last node in the list
        T data = current.data;
        if (previous != null) previous.next = null;
        --size;
        return data;
    }
```

# PEEK
1. START
2. Check if the stack is empty, if TRUE, produce error and exit
3. Traverse the stack and return the data of the last element in the stack
4. END

```java
   public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
```

### Peeking the first node inserted into the stack
1. START
2. Check if the stack is empty, if TRUE, produce error and exit
3. Return the data of the first node inserted into the stack
4. END

```java

    public T peekFirst(){
        if (isEmpty()) throw new EmptyStackException();
        return head.data;
    }
    
```

# TRAVERSING
```java
    public String getStackEntry() {
        if (isEmpty()) return "[]";
        else {
            Node<T> trav = head;
            StringBuilder sb = new StringBuilder().append("[");
            while (trav != null) {
                sb.append(trav.data);
                if (trav.next != null) sb.append(", ");
                trav = trav.next;
            }
            return sb.append("]").toString();
        }
    }
```