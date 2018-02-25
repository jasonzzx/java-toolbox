package string;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringOperation {

    public String distinctSort(String str){
        return str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());
    }

    public String splitAndRejoin(String str, String delimiter, String key){
        return Pattern.compile(delimiter)
                .splitAsStream(str)
                .filter(s -> s.contains(key))
                .sorted()
                .collect(Collectors.joining(delimiter));
    }
}
