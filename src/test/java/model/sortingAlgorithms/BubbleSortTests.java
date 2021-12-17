package model.sortingAlgorithms;

import model.ArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BubbleSortTests {

    private BubbleSort bubbleSort = new BubbleSort();
    private ArrayGenerator arrayGenerator = new ArrayGenerator();

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

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000, 200000, 500000, 1000000})
    @DisplayName("Probing max array size")
    void probingArrayMaxSize(int ints) {
        bubbleSort.returnSortedArray(arrayGenerator.generateRandomArray(ints));
    }

    @Test
    @DisplayName("Does time taken return a long?")
    void doesTimeTakenReturnALong() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        bubbleSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertInstanceOf(Long.class, bubbleSort.returnTimeTaken());
    }

    @Test
    @DisplayName("Is time taken greater than or equal to 0?")
    void isTimeTakenGreaterThan0() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        bubbleSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertTrue(bubbleSort.returnTimeTaken() >= 0);
    }

    @Test
    @DisplayName("Does it return a string for its name")
    void doesItReturnAStringForItsName() {
        Assertions.assertInstanceOf(String.class, bubbleSort.getAlgorithmName());
    }
}
