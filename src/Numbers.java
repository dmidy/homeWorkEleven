import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Numbers {
    private final String[] arrNumb = {"1, 2, 0", "4, 5"};

    public String getSortedNumbers() {
        List<Integer> allNumbers = new ArrayList<>();

        for (String str : arrNumb) {
            Matcher matcher = Pattern.compile("-?\\d+").matcher(str);
            while (matcher.find()) {
                allNumbers.add(Integer.parseInt(matcher.group()));
            }
        }

        Collections.sort(allNumbers);

        return allNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
