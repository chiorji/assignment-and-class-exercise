package stack;

import stack.SinglyLinkedListStackDSA;

public class StackDSATester {
    public static void main(String[] args) {
        // singly linked list stack implementation
        SinglyLinkedListStackDSA<Integer> linkedListStack = new SinglyLinkedListStackDSA<>();
        linkedListStack.push(10);
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
//        System.out.println("Peek: " + linkedListStack.peek());
//        System.out.println("Peek First: " + linkedListStack.peekFirst());
        
//        Integer popped = linkedListStack.pop();
//        linkedListStack.pop();
//        linkedListStack.pop();
//        linkedListStack.pop();
//        linkedListStack.pop();
        linkedListStack.clearStackEntry();
        
//        System.out.println("Popped: " + popped);
        
        System.out.println("Stack: " + linkedListStack.getStackEntry());
        System.out.println("Size: " + linkedListStack.getSize());
    }
}
