package stack;

import stack.SinglyLinkedListStackDSA;

public class StackDSATester {
    public static void main(String[] args) {
        /*FixedSizeArrayStackDSA stack = new FixedSizeArrayStackDSA(10);
        stack.push(10);
        stack.push(11);
        stack.push(50);
        stack.push(32);
        stack.push(76);
        
        System.out.println("Printing from stack");
        stack.printStack();
        
        System.out.println("Top-most element: " + stack.peek());
        
        System.out.println("Popping from stack");
        stack.popStack();
        
//        System.out.println("Top-most element: " + stack.peek());
        FixedSizeArrayStackDSA newStack = new FixedSizeArrayStackDSA();
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        newStack.printStack();
        */
        // singly linked list stack implementation
        SinglyLinkedListStackDSA<Integer> linkedListStack = new SinglyLinkedListStackDSA<>();
        linkedListStack.push(1);
        System.out.println("Pushed: " + linkedListStack.peek());
        linkedListStack.push(2);
        System.out.println("Pushed: " + linkedListStack.peek());
        linkedListStack.push(3);
        System.out.println("Pushed: " + linkedListStack.peek());
        linkedListStack.push(40);
        System.out.println("Pushed: " + linkedListStack.peek());
        linkedListStack.push(25);
        System.out.println("Pushed: " + linkedListStack.peek());
        
        System.out.println("Stack: " + linkedListStack.getStackEntry());
        System.out.println("Size: " + linkedListStack.getSize());
        System.out.println("Peek: " + linkedListStack.peek());
        
        Integer popped = linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        
        System.out.println("Popped: " + popped);
        
        System.out.println("Stack: " + linkedListStack.getStackEntry());
        System.out.println("Size: " + linkedListStack.getSize());
        System.out.println("Peek: " + linkedListStack.peek());
    }
}
