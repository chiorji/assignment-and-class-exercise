package linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        
        list.add(20);
        list.add(10);
        list.add(3);
        list.add(73);
       /* System.out.println("List: " + list.toString());
        list.insertAtIndex(2, 1);
        System.out.println("List: " + list.toString());
        
        list.insertAtIndex(277, 3);
        System.out.println("size: " + list.getSize());
        list.insertAtIndex(207, 6);
        list.insertAtIndex(-207, 7);
        System.out.println("List: " + list.toString());

        list.pop();
        list.pop();
        list.pop();
       */
        System.out.println("size: " + list.getSize());
        System.out.println("List: " + list.toString());
        Integer popped = list.popAtIndex(2);
//        System.out.println("size: " + list.getSize());
//        System.out.println("Peek First: " + list.peekFirst());
//        System.out.println("Peek Last: " + list.peekLast());
        System.out.println("Popped: " + popped);
        System.out.println("size: " + list.getSize());
        System.out.println("List: " + list.toString());
        System.out.println("Contains: " + list.contains(2));
        System.out.println("Contains: " + list.contains(20));
    }
}
