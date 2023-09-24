import java.util.*;


public class Main {
    public static void main(String[] args) {

        String[] names = {"Gomer", "Marge", "Bart", "Lisa", "Apy", "Bob", "Mo"};

        List<String> nameFilter = new ArrayList<>(Arrays.asList(names));

        for (int i = 0; i < nameFilter.size(); i += 2) {
            System.out.println((i + 1) + ". " + nameFilter.get(i));
        }

        Collections.addAll(nameFilter);
        Collections.sort(nameFilter);
        Collections.reverse(nameFilter);

        System.out.println(" ");

        String[] nameArray = nameFilter.toArray(new String[0]);

        for (String word : nameArray) {
            System.out.println(word.toUpperCase());
            }

        System.out.println(" ");

        Numbers numbers1 = new Numbers();
        String sortedNumbers = numbers1.getSortedNumbers();
        System.out.println(sortedNumbers);
        };
    }