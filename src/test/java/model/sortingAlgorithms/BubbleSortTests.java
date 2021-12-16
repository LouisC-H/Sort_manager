package model.sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTests {

    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    @DisplayName("Does the sorting algorithm work?")
    void doesTheSortingAlgorithmWork() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        int[] exampleSortedArray = {-44, -1, 2, 5, 55, 24893};
        Assertions.assertArrayEquals(exampleSortedArray, bubbleSort.returnSortedArray(exampleUnsortedArray));
    }

    @Test
    @DisplayName("Does it work for an array of length 1?")
    void doesItWorkForAnArrayOfLength1() {
        int[] SingleValueArray= {42};
        Assertions.assertArrayEquals(SingleValueArray, bubbleSort.returnSortedArray(SingleValueArray));

    }

    @Test
    @DisplayName("Does time taken return an int?")
    void doesTimeTakenReturnAnInt() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        bubbleSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertInstanceOf(Integer.class, bubbleSort.returnTimeTaken());
    }

    @Test
    @DisplayName("Is time taken greater than or equal to 0?")
    void isTimeTakenGreaterThan0() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        bubbleSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertTrue(bubbleSort.returnTimeTaken() >= 0);
    }
}
