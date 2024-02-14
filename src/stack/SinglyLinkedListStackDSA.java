package stack;

import java.util.EmptyStackException;

public class SinglyLinkedListStackDSA<T> {
    private int size = 0;
    private Node<T> head = null;
    
    // internal Node class to represent data
    private static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public int getSize() {
        return size;
    }
    
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
    
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        
        Node<T> current = head;
        Node<T> previous = null;
        
        if (getSize() == 1) {
            T data = current.data;
            head = null;
            size = 0;
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
    
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
    
    public T peekFirst(){
        if (isEmpty()) throw new EmptyStackException();
        return head.data;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void clearStackEntry() {
        if (isEmpty()) throw new EmptyStackException();
        head = null;
        size = 0;
    }
    
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
}
