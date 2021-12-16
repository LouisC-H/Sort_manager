package model.sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTreeSortTest {

    private BinaryTreeSort binaryTreeSort;

    @BeforeEach
    void setup(){
        binaryTreeSort = new BinaryTreeSort();
    }

    @Test
    @DisplayName("Does the sorting algorithm work?")
    void doesTheSortingAlgorithmWork() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        int[] exampleSortedArray = {-44, -1, 2, 5, 55, 24893};
        Assertions.assertArrayEquals(exampleSortedArray, binaryTreeSort.returnSortedArray(exampleUnsortedArray));
    }

    @Test
    @DisplayName("Does it work for an array of length 1?")
    void doesItWorkForAnArrayOfLength1() {
        int[] SingleValueArray= {42};
        Assertions.assertArrayEquals(SingleValueArray, binaryTreeSort.returnSortedArray(SingleValueArray));

    }

    @Test
    @DisplayName("Does time taken return an int?")
    void doesTimeTakenReturnAnInt() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        binaryTreeSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertInstanceOf(Integer.class, binaryTreeSort.returnTimeTaken());
    }

    @Test
    @DisplayName("Is time taken greater than or equal to 0?")
    void isTimeTakenGreaterThan0() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        binaryTreeSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertTrue(binaryTreeSort.returnTimeTaken() >= 0);
    }

    @Test
    @DisplayName("Does it return a string for its name")
    void doesItReturnAStringForItsName() {
        Assertions.assertInstanceOf(String.class, binaryTreeSort.getAlgorithmName());
    }

}
