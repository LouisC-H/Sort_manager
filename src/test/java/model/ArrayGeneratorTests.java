package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayGeneratorTests {
    ArrayGenerator arrayGenerator = new ArrayGenerator();

    @Test
    @DisplayName("Does it return an array?")
    void doesItReturnAnArray() {
        int[] tenArray = arrayGenerator.generateRandomArray(10);
        Assertions.assertInstanceOf(int[].class, tenArray);
    }

    @Test
    @DisplayName("Is the array different each time?")
    void isTheArrayDifferentEachTime() {
        int[] hundredArray = arrayGenerator.generateRandomArray(100);
        int[] hundredArray2 = arrayGenerator.generateRandomArray(100);
        Assertions.assertFalse(Arrays.equals(hundredArray, hundredArray2));
    }

    @Test
    @DisplayName("check correct array size")
    void checkCorrectArraySize() {
        int[] tenArray = arrayGenerator.generateRandomArray(10);
        Assertions.assertEquals(10, tenArray.length);
    }

    @Test
    @DisplayName("Does it throw an error if called with a negative number?")
    void doesItThrowAnErrorIfCalledWithANegativeNumber() {
        Assertions.assertThrows(RuntimeException.class, () -> arrayGenerator.generateRandomArray(-10));
    }

}
