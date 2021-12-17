package model.sortingAlgorithms;

import model.ArrayGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BinaryTreeSortTest {

    private BinaryTreeSort binaryTreeSort;
    private ArrayGenerator arrayGenerator = new ArrayGenerator();

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

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000, 1000000, 10000000})
    @DisplayName("Probing max array size")
    void probingArrayMaxSize(int ints) {
        binaryTreeSort.returnSortedArray(arrayGenerator.generateRandomArray(ints));
    }

    @Test
    @DisplayName("Does time taken return a long?")
    void doesTimeTakenReturnALong() {
        int[] exampleUnsortedArray = {5,-1,2,55,24893,-44};
        binaryTreeSort.returnSortedArray(exampleUnsortedArray);
        Assertions.assertInstanceOf(Long.class, binaryTreeSort.returnTimeTaken());
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
