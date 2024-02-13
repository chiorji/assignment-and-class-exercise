# SINGLY-LINKED LIST
A self-referential class contains an instance that refers to another object of the same class type.

```java
class Node {
    private int data;
    private Node next;
    
    public int getData() {/*method body*/}
    public void setData(int data){/*method body*/}
    
    public int getNext() {/*method body*/}
    public void setNext(Node next){/*method body*/}
}
``` 
Programs can link self-referential objects together to form such useful structure as lists, queues, stacks and trees.

A Linked List is a collection of self-referential class objects called nodes, connected by reference links, hence the term "linked" list.

A program access a linked list via a reference to the first node in the list, the program accesses each subsequent node via the link reference stored in the previous node, the link reference in the last node in the list is set to null.

Data is stored in a linked list dynamically, i.e, the program creates each node as necessary.

A node consists a data value and a pointer to the address of the next node within the linked list.
A node can contain data of any type, including references to objects of other classes. Stack and Queues are also linear data structure.

Below is a comparison table between Array and Linked List
-
| Linked List                                                                                                                                                                   | Array                                                                                                                     |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| Used when the number of elements to be stored are unpredictable                                                                                                               | Used when the  number of element to be stored are predictable                                                             |
| Dynamic - length can increase or decrease as necessary                                                                                                                        | Fixed - size is fixed at the time of creation and can not be altered.                                                     |
| Became full when the system runs out of memory                                                                                                                                | Become full when the limit is reached                                                                                     |
| Provides better memory utilization, it adapts to memory needs at execution time                                                                                               | Declared to contain more memory space, thereby wasting memory                                                             |
| Insertion and deletion are faster, only two references are moved(after locating the insertion/deletion point). All existing node locations remain in their memory allocation. | Insertion and deletion can be time-consuming because all elements following the inserted or deleted element must be moved |

Basic Operations
---
- insertion - adds elements at the beginning/ending of the list
- deletion - deletes an element from the beginning/ending of the list
- find - searches for an element with the specified key
- traversal - loops through the elements of the list and displays the data
- remove - deletes an element at the specified key
- isEmpty - checks if the list is empty
- Peek - retrieves element at the beginning/ending of the list without deleting it, this operation does not alter the list

## Insertion Operations
### Insert at beginning
Outlined is the algorithm to add elements at the beginning of the list
1. START
2. Create a Node to store the data
3. Check if the list is empty
   1. If the list is empty
   2. THEN: add the data to the Node and assign the head pointer to it 
   3. ELSE: add the data to the node and link to the current head, assign the head to the newly created node
4. Increment the size counter
5. END

```java
import java.util.EmptyStackException;

public class SinglyLinkedList<T> {
  private int size = 0; // Number of elements in the list
  Node<T> head = null; // Initial head value

  /* An internal Node for storing data */
  private class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
  
  // add at beginning
  public void addToBeginning(T data){
      Node<T> newNode = new Node<>(data);
      if(!isEmpty()) {
          newNode.next = head;
      }
     head = newNode;
      size++;
  }
}
```
### Insert at ending
1. START
2. Create a new node and assign the data
3. Check if the list is empty 
   1. If the list is empty 
   2. THEN point the head to the new node 
   3. ELSE traverse the list and find the last node
   4. Point the last node to the new node
4. Increment the size counter
5. END

```java
    // Add element to the end of the list
    public void add(T data) {
        addToEnding(data);
    }
    
 // add at ending
  public void addToEnding(T data) {
      Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
        head = newNode;
    } else {
        Node<T> trav = head;
        while(trav.next != null) {
            trav = trav.next;
        }
        trav.next = newNode;
    }
    size++;
  }
```

### Insert at an index
1. START
2. Check if the list is empty
   1. If empty, throw empty stack exception
3. Check if index is < 0 or index > current list size
   1. If TRUE, throw index out of bound exception
4. If index = 0; 
   1. Insert at the beginning of the list
   2. RETURN
5. If index == size
   1. Insert at the end of the list
   2. RETURN
6. Traverse the list and find the element at the index
   1. Assign the previous node's next pointer to the new node
   2. Assign current node to be the adjacent node of the new node
7. Increment size
8. END

```java
    public void insertAtIndex(T data, int index) {
        if (isEmpty()) throw new EmptyStackException();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Failed to insert, index out of bound: " + index);
         }
        // check for zero positional index
        if (index == 0) {
            addToBeginning(data);
            return;
         }
        
        // if index is the same as the list size, add element as last
        if (index == getSize()) {
            add(data);
            return;
         }
        // If provided index is neither the head nor tail, we traverse the list and add data at the specified index position 
        Node<T> newNode = new Node<>(data);
        
        int i;
        Node<T> trav;
        Node<T> prev = null;
        
        for (i = 0, trav = head; i != index; i++) {
            prev = trav;
            trav = trav.next;
         }
        
        if (prev.next != null) {
            prev.next = newNode;
            newNode.next = trav;
         }
        size++;
    }
```
### isEmpty
1. START
2. If head = null 
   1. Return TRUE else FALSE
4. END
```java
  // method to check if the list is empty
  public boolean isEmpty() {
    return head == null;
  }
```

## Deletion Operation
### Delete at ending
1. START
2. Check if the list empty
   1. If empty, throw empty stack exception 
3. Traverse the list until the end
4. Grab the data at the end
5. Assign NULL to the second last element in the list
6. Decrease list size by 1
7. Return the grabbed data at step 4
8. END

```java
 public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        
        Node<T> trav = head;
        Node<T> prev = null;
        
        while (trav.next != null) {
            prev = trav;
            trav = trav.next;
        }
        
        T data = trav.data;
        
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
            trav = null;
        }
        --size;
        return data;
    }
    
```
### Deleting at an index position
1. START
2. Iterate until we find the current node at position in the list.
3. Assign the adjacent node of current node in the list to its previous node.
4. END
```java

```
## List Traversal
Iterate over the node list and return the data at each node.
```java
 @Override
 public String toString() {
    if (isEmpty()) return "[]";
    Node<T> trav = head;
    StringBuilder sb = new StringBuilder().append("[");
    while (trav != null) {
        sb.append(trav.data);
        if (trav.next != null) sb.append(", ");
        trav = trav.next;
    }
    return sb.append("]").toString();
}
```