package telran.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InterviewTasks {

    public static boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        boolean res = false;
        for (int num : array) {
            if (seenNumbers.contains(sum - num)) {
                res = true;
            }
            seenNumbers.add(num);
        }
        return res;
    }

    public static int getMaxWithNegativePresentation(int[] array) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        int max = -1;
        for (int num : array) {
            if (seenNumbers.contains(-num)) {
                max = Math.max(max, Math.abs(num));
            }
            seenNumbers.add(num);
        }
        return max;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
        List<DateRole> result = new ArrayList<>();
        int currentIndex = 0;
        for (LocalDate date : dates) {
            while (currentIndex < rolesHistory.size() && !rolesHistory.get(currentIndex).date().isAfter(date)) {
                currentIndex++;
            }
            result.add(new DateRole(date, currentIndex > 0 ? rolesHistory.get(currentIndex - 1).role() : null));
        }
        return result;
    }

    public static boolean isAnagram(String word, String anagram) {
            boolean res = true;

        if (word.equals(anagram)) {
            res = false;
        }
        if (word.length() != anagram.length()) res = false;
    
        int[] frequency = new int[256];
        for (char c : word.toCharArray()) {
            frequency[c]++;
        }
        for (char c : anagram.toCharArray()) {
            if (--frequency[c] < 0) res = false;
        }
        return res;
    }
    
}
