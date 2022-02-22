import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class CollectionTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueueAse = new PriorityQueue<>();
        priorityQueueAse.add(3);
        priorityQueueAse.add(1);
        priorityQueueAse.add(2);
        priorityQueueAse.add(4);
        System.out.println(priorityQueueAse);
        System.out.println(priorityQueueAse.peek());
        System.out.println(priorityQueueAse.remove(2));
        System.out.println(priorityQueueAse);

        PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueueDesc.add(3);
        priorityQueueDesc.add(1);
        priorityQueueDesc.add(2);
        priorityQueueDesc.add(4);
        System.out.println(priorityQueueDesc);
        System.out.println(priorityQueueDesc.peek());
        System.out.println(priorityQueueDesc.remove(2));
        System.out.println(priorityQueueDesc);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println(treeSet);
    }
}
