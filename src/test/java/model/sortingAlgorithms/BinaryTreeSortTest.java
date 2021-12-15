package model.sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTreeSortTest {

    private BinaryTreeSort binaryTreeSort;

    @Test
    @DisplayName("Does the sorting algorithm work?")
    void doesTheSortingAlgorithmWork() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        int[] exampleSortedArray = {-44, -1, 2, 5, 55, 24893};
        binaryTreeSort = new BinaryTreeSort();
        Assertions.assertArrayEquals(exampleSortedArray, binaryTreeSort.returnSortedArray(exampleUnsortedArray));
    }

    @Test
    @DisplayName("Does time taken return an int?")
    void doesTimeTakenReturnAnInt() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertInstanceOf(Integer.class, binaryTreeSort.returnTimeTaken());
    }

}
