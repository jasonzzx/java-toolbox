import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueueAse = new PriorityQueue<>();
        priorityQueueAse.add(3);priorityQueueAse.add(1);priorityQueueAse.add(2);priorityQueueAse.add(4);
        System.out.println(priorityQueueAse);
        System.out.println(priorityQueueAse.peek());
        System.out.println(priorityQueueAse.remove(2));

        PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueueDesc.add(3);priorityQueueDesc.add(1);priorityQueueDesc.add(2);priorityQueueDesc.add(4);
        System.out.println(priorityQueueDesc);
        System.out.println(priorityQueueDesc.peek());
        System.out.println(priorityQueueDesc.remove(2));

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);treeSet.add(1);treeSet.add(2);
        treeSet.remove(2);
        System.out.println(treeSet);

        Deque<Integer> deque = new LinkedList<>(); // FIFO / FILO
        deque.add(1);deque.add(2);deque.add(3);deque.add(4);deque.add(5);
        System.out.println(deque.pollFirst()); // 1
        System.out.println(deque.pollLast()); // 5
        System.out.println(deque.peekFirst()); // 2
        System.out.println(deque.peekLast()); // 4
        System.out.println(deque);

        Queue<Integer> queue = new LinkedList<>(); // FIFO
        queue.offer(1);queue.offer(2);queue.offer(3);
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2

        Stack<Integer> stack = new Stack<>(); // FILO
        stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);
        System.out.println(stack.pop()); // 5
        System.out.println(stack.pop()); // 4

    }
}
