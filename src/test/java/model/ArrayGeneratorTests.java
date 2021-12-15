package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayGeneratorTests {
    ArrayGenerator arrayGenerator = new ArrayGenerator();

    @Test
    @DisplayName("check correct array size")
    void checkCorrectArraySize() {
        int[] tenArray = arrayGenerator.generateRandomArray(10);
        Assertions.assertEquals(10, tenArray.length);
//        System.out.println(Arrays.toString(tenArray));
    }
}
