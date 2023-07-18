import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Que {
    public static void main(String [] args) {

        // PriorityQueue =================================================

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println();
        // DeQueue =================================================

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        deque.offerLast(4);
        deque.offerLast(5);
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());



    }
}
