import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Convert {
    public static void main(String[] args) {
        // 1D: String, char, int, boolean,
        // 1D: []
        // List (ArrayList, LinkedList), Queue, Stack
        // Set (HashSet, TreeSet)
        // Map (HashMap)

        // String <-> char[]
        char[] charArray = "hello".toCharArray();
        String str = String.valueOf(charArray);
        System.out.println(str);

        // int <-> String
        int intVal = Integer.parseInt("100");
        String intStr = String.valueOf(intVal);
        System.out.println(intStr);

        // int array sort
        int[] arr = { 4, 3, 1, 2, 5 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // asc
        // desc
        int[] descArr = IntStream.of(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(descArr));
    }
}
