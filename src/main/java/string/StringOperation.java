package string;

import java.util.stream.Collectors;

public class StringOperation {

    public String distinctSort(String str){
        return str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());
    }
}
