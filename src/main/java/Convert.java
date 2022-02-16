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
        Arrays.sort(arr); //asc
        System.out.println(Arrays.toString(arr));
        int[] descArr = IntStream.of(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(descArr));

        // String to num[] with max min avg
        System.out.println("12345".chars().max().getAsInt() - '0');
        System.out.println("12345".chars().min().getAsInt() - '0');
        System.out.println((int)"12345".chars().average().getAsDouble() - '0');

        // List <-> array[] (primitive)
        int[] array = { 4, 3, 1, 2, 5 };
        List<Integer> intList = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(intList);
        int[] bArray = intList.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(bArray));

        // List <-> array[] (Object/String)
        String[] arrayStr = {"a", "b", "c"};
        List<String> strList = Arrays.asList(arrayStr); // can't do this with primitive array as above int[]
        System.out.println(strList);
        String[] bArrayStr = strList.toArray(String[]::new);
        System.out.println(Arrays.toString(bArrayStr));

        // List -> ArrayList/LinkedList
        ArrayList<Integer> arrayList = new ArrayList<>(intList);
        System.out.println(arrayList);
        LinkedList<String> linkedList = new LinkedList<>(strList);
        System.out.println(linkedList);

        // List operation
        arrayList.add(10);
        linkedList.add("e");
        linkedList.addLast("f");
        linkedList.addFirst("z");
        System.out.println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.getFirst();
        linkedList.getLast();
    }
}
