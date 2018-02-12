package integer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class IntArray {

    public static int sum(int[] array){
        return Arrays.stream(array).sum();
    }

    public static int multiple(int[] array){
        return Arrays.stream(array).reduce(1, (x, y) -> x * y);
    }

    public static int max(int[] array){
        return Arrays.stream(array).max().getAsInt();
    }

    public static int min(int[] array){
        return Arrays.stream(array).min().getAsInt();
    }

    public static int[] sortAscendant(int[] array){
        return IntStream.of(array).boxed().sorted().mapToInt(i -> i).toArray();
    }

    public static int[] sortDescendant(int[] array){
        return IntStream.of(array).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }
}
