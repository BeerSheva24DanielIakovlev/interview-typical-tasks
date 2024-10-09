package telran.interview;

import java.util.HashSet;
import java.util.Set;

public class InterviewTasks {
    //     /**
    //      * 
    //      * @param array
    //      * @param sum
    //      * @return true if a given array comprises of two number, summing of which gives the value equaled to a given "sum" value
    //      */

    public static boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> seenNumbers = new HashSet<>();
        boolean res = false;
        for (int number : array) {
            int complement = sum - number;
            if (seenNumbers.contains(complement)) {
                res = true;
            }
            seenNumbers.add(number);
        }
        return res;
    }
}