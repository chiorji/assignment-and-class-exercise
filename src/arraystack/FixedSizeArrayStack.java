package arraystack;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class FixedSizeArrayStack<T> {
    private final T[] stack;
    private int top = -1;
    private int MAX_CAPACITY = 0;
    
    public FixedSizeArrayStack() {
        MAX_CAPACITY = 5;
        stack = (T[]) new Object[5];
    }
    
    public FixedSizeArrayStack(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.MAX_CAPACITY = capacity;
        stack = (T[]) new Object[capacity];
    }
    
    public int getSize() {
        return top + 1; // makes our top value zero based
    }
    
    public boolean isFull() {
        return top == MAX_CAPACITY;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void push(T value) {
        if (isFull()) throw new StackOverflowError("Stack overflow");
        top = top + 1;
        stack[top] = value;
    }
    
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T value = stack[top];
        top = top - 1;
        return value;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder().append("[");
        // make a temp variable to hold our top value
        int temp = top;
        while (temp > -1) {
            sb.append(stack[temp]);
            if (temp != 0) sb.append(", ");
            temp = temp - 1;
        }
        return sb.append("]").toString();
    }
}
