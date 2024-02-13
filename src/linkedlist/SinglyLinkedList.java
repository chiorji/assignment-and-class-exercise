package linkedlist;

import java.util.EmptyStackException;

public class SinglyLinkedList<T> {
    private int size = 0;
    private Node<T> head = null;
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Add element to the beginning of the list
    public void addToBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }
    
    public void addToEnding(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = newNode;
        }
        size++;
    }
    
    public void add(T data) {
        addToEnding(data);
    }
    
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
        /*  Provided index is neither the head nor tail, traverse
         *  the list and add element at the specified index position
         */
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
    
    public T popFirst() {
        if (isEmpty()) throw new EmptyStackException();
        T data = head.data;
        head = head.next;
        --size;
        return data;
    }
    
    public T popLast() {
        return pop();
    }
    
    public T popAtIndex(int index) {
        if (index > getSize()) throw new IllegalArgumentException();
        if (index == 0) return popFirst();
        if (index == getSize()) return popLast();
        
        int i;
        Node<T> trav;
        Node<T> prev = null;
        
        for (i = 0, trav = head; i != index; i++) {
            prev = trav;
            trav = trav.next;
        }
        
        T data = trav.data;
        prev.next = trav.next;
        trav = null;
        --size;
        return data;
    }
    
    // Retrieves the first element in the list
    public T peekFirst() {
        if (isEmpty()) throw new EmptyStackException();
        return head.data;
    }
    
    
    // Retrieves the last element in the list
    public T peekLast() {
        if (isEmpty()) throw new EmptyStackException();
        Node<T> trav = head;
        while (trav.next != null) {
            trav = trav.next;
        }
        return trav.data;
    }
    
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        if (size == 1) return peekFirst();
        return peekLast();
    }
    
    
    // Checks if the list has a particular data
    private int indexOf(T elem) {
        if (isEmpty()) throw new IllegalArgumentException("Empty list");
        Node<T> trav = head;
        while (trav != null) {
            if (trav.data == elem) {
                return 1;
            }
            trav = trav.next;
        }
        return -1;
    }
    
    // Returns true if the element is in the list, else false
    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
    
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
    
}
