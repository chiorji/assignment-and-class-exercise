package queue;

import java.util.EmptyStackException;

public class LinkedListQueueDSA<T> {
    private final int capacity;
    private int size = 0;
    private Node<T> front = null;
    private Node<T> rear = null;
    
    // Constructor to create queue with default capacity
    public LinkedListQueueDSA() {
        this.capacity = 5;
    }
    
    // constructor to create a queue of defined capacity
    public LinkedListQueueDSA(int capacity) {
        this.capacity = capacity;
    }
    
    // Internal class to create Nodes
    private static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T value) {
            this.data = value;
            this.next = null;
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    public boolean isFull() {
        return getSize() == capacity;
    }
    
    // For fixed-size queue, check the slots remaining
    public int freeSlots() {
        return capacity - size;
    }
    
    // Retrieves the first element without deleting it
    public T peekFront() {
        if (isEmpty()) throw new EmptyStackException();
        return front.data;
    }
    
    public T peekBack() {
        if (isEmpty()) throw new EmptyStackException();
        return rear.data;
    }
    
    public void enqueue(T value) {
        if (isFull()) throw new StackOverflowError("Can not enqueue. No free slot.");
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        size++;
    }
    
    // Removes the first element from the queue
    public T dequeue() {
        if (isEmpty()) throw new EmptyStackException();
        // Grab data at the front
        T data = front.data;
        // move front pointer to the next
        front = front.next;
        // De-allocate memory
        if (front == null) rear = null;
        --size;
        return data;
    }
    
    // Remove n number of element from the front
    public void dequeue(int num) {
        if (isEmpty()) throw new EmptyStackException();
        if (num < 0 || num > size) {
            throw new IndexOutOfBoundsException("Index out of bound: " + num);
        }
        int i = 0;
        while (i < num) {
            dequeue();
            i++;
        }
    }
    
    public String getEnqueuedValues() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder().append("[");
        Node<T> trav = front;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) sb.append(", ");
            trav = trav.next;
        }
        return sb.append("]").toString();
    }
}
