package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        var messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("Add to Thread Local message.");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}