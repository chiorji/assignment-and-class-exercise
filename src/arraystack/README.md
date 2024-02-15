# Stack with a fixed size

```java

@SuppressWarnings("unchecked")
public class FixedSizeArrayStack<T> {
    private final T[] stack;
    private int top = -1;
    private int MAX_CAPACITY = 0;
    
    // constructor with default capacity
    public FixedSizeArrayStack() {
        MAX_CAPACITY = 5;
        stack = (T[]) new Object[5];
    }
    // constructor with program defined capacity
    public FixedSizeArrayStack(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.MAX_CAPACITY = capacity;
        stack = (T[]) new Object[capacity];
    }
}
```

### PUSH
1. START
2. Check if the stack is full
   1. If TRUE, produce error and exit
3. Point the `top` to the next empty slot in the array
4. Add element to the next empty slot
5. END

```java
 public void push(T value) {
        if (isFull()) throw new StackOverflowError("Stack overflow");
        top = top + 1;
        stack[top] = value;
    }
```

### POP
1. START
2. Check if the stack is empty
3. If TRUE, produce error and exit
4. Grab the value at the top position
5. Decrement `top` by 1
6. Return the value grabbed at step 4 above
7. END

```java
 public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T value = stack[top];
        top = top - 1;
        return value;
    }
```

### Traversing the stack
```java
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
```

### Testing our implementation
```java
public class ArrayStackTest {
    public static void main(String[] args) {
        // Initialize with a fixed size 
        FixedSizeArrayStack<Integer> stack = new FixedSizeArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Size: " + stack.getSize()); // 6
        System.out.println("Stack: " + stack.toString()); // [6, 5, 4, 3, 2, 1]
        
        // Remove the top-most element in the stack
        Integer popped = stack.pop();
        
        System.out.println("Popped: " + popped); // 6
        System.out.println("Size: " + stack.getSize()); // 5
        System.out.println("Stack: " + stack.toString()); // [5, 4, 3, 2, 1]
       
       // Create a stack of the String type with a fixed size of 3
       FixedSizeArrayStack<String> strStack = new FixedSizeArrayStack<>(3);
       strStack.push("Hello World!");
       strStack.push("Stack with a fixed size");
       strStack.push("Here comes the end!");

       System.out.println("Size: " + strStack.getSize()); // 3
       System.out.println("String Stack: " + strStack.toString()); // [Here comes the end!, Stack with a fixed size, Hello World!]
       strStack.push("Would error, no empty slot in the stack"); // ArrayIndexOutOfBoundsException
    }
}
```