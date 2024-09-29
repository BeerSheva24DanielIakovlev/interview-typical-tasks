package telran.interview;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InterviewTasksTest {

    @Test
    void testHasSumTwoFound() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(InterviewTasks.hasSumTwo(array, 5));
    }

    @Test
    void testHasSumTwoNotFound() {
        int[] array = {1, 2, 3, 4, 5};
        assertFalse(InterviewTasks.hasSumTwo(array, 10));
    }

    @Test
    void testHasSumTwoEmptyArray() {
        int[] array = {};
        assertFalse(InterviewTasks.hasSumTwo(array, 5));
    }

    @Test
    void testHasSumTwoSingleElement() {
        int[] array = {1};
        assertFalse(InterviewTasks.hasSumTwo(array, 2));
    }

    @Test
    void testHasSumTwoNegativeNumbers() {
        int[] array = {-1, -2, 3, 7};
        assertTrue(InterviewTasks.hasSumTwo(array, 5));
    }
}



