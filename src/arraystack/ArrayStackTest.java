package arraystack;

public class ArrayStackTest {
    public static void main(String[] args) {
        FixedSizeArrayStack<Integer> stack = new FixedSizeArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Stack: " + stack.toString());
        
        Integer popped = stack.pop();

        System.out.println("Popped: " + popped);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Stack: " + stack.toString());
        
        FixedSizeArrayStack<String> strStack = new FixedSizeArrayStack<>(3);
        strStack.push("Hello World!");
        strStack.push("Stack with a fixed size");
        strStack.push("Here comes the end!");
        
        System.out.println("Peek: " + strStack.peek());
        System.out.println("Size: " + strStack.getSize());
        System.out.println("String Stack: " + strStack.toString());
        strStack.push("Would error, no empty slot in the stack");
    }
}
