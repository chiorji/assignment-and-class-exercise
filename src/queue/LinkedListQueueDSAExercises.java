package queue;

public class LinkedListQueueDSAExercises {
    public static void main(String[] args) {
        LinkedListQueueDSA<Integer> q = new LinkedListQueueDSA<>(100);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        
        Integer front = q.peekFront();
        Integer back = q.peekBack();
        
        System.out.println("Queue: " + q.getEnqueuedValues());
        System.out.println("Size: " + q.getSize());
        System.out.println("Peek Front: " + front);
        System.out.println("Peek Back: " + back);
        System.out.println("Free slots: " + q.freeSlots());
        
        System.out.println(("---------------"));
        
        Integer dq = q.dequeue();
        System.out.println("Dequeue " + dq);
        q.dequeue(2);
        
        front = q.peekFront();
        back = q.peekBack();
        
        System.out.println("Queue: " + q.getEnqueuedValues());
        System.out.println("Size: " + q.getSize());
        System.out.println("Peek Front: " + front);
        System.out.println("Peek Back: " + back);
        System.out.println("Free slots: " + q.freeSlots());
        System.out.println("Is empty queue: " + q.isEmpty());
        
        LinkedListQueueDSA<String> sq = new LinkedListQueueDSA<>();
        sq.enqueue("Hello world!");
        sq.enqueue("Nice to meet y'all");
        System.out.println(sq.getEnqueuedValues());
    }
}
