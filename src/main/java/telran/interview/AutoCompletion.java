package telran.interview;

import java.util.*;

public class AutoCompletion {
    private final Set<String> wordsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return wordsSet.add(word);
    }

    public String[] getVariants(String prefix) {
        List<String> variants = new ArrayList<>();
        for (String word : wordsSet) {
            if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
                variants.add(word);
            }
        }
        return variants.toArray(new String[0]);
    }
}
