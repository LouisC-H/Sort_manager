package model.sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeSortTests {

    private MergeSort mergesort = new MergeSort();

    @Test
    @DisplayName("Does the sorting algorithm work?")
    void doesTheSortingAlgorithmWork() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        int[] exampleSortedArray = {-44, -1, 2, 5, 55, 24893};
        Assertions.assertArrayEquals(exampleSortedArray, mergesort.returnSortedArray(exampleUnsortedArray));
    }

    @Test
    @DisplayName("Does it work for an array of length 1?")
    void doesItWorkForAnArrayOfLength1() {
        int[] SingleValueArray= {42};
        Assertions.assertArrayEquals(SingleValueArray, mergesort.returnSortedArray(SingleValueArray));

    }

    @Test
    @DisplayName("Does time taken return an int?")
    void doesTimeTakenReturnAnInt() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        mergesort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertInstanceOf(Integer.class, mergesort.returnTimeTaken());
    }

    @Test
    @DisplayName("Is time taken greater than or equal to 0?")
    void isTimeTakenGreaterThan0() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        mergesort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertTrue(mergesort.returnTimeTaken() >= 0);
    }

    @Test
    @DisplayName("Does it return a string for its name")
    void doesItReturnAStringForItsName() {
        Assertions.assertInstanceOf(String.class, mergesort.getAlgorithmName());
    }
}
