package model;

import model.ArrayArrayListConversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListConversionTests {

    @Test
    @DisplayName("Single int Array to ArrayList")
    void singleIntArrayToArrayList() {
        int[] singleIntArray = {1};
        ArrayList<Integer> singleIntegerArrayList = new ArrayList<>();
        singleIntegerArrayList.add(1);
        Assertions.assertEquals(singleIntegerArrayList, ArrayArrayListConversion.intArrayToArrayList(singleIntArray));
    }

    @Test
    @DisplayName("Complex Array to ArrayList test")
    void complexArrayToArrayListTest() {
        int[] intArray = {-4,6,1,543,-3465,213,55,1,0};
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(-4,6,1,543,-3465,213,55,1,0));
        Assertions.assertEquals(integerArrayList,ArrayArrayListConversion.intArrayToArrayList(intArray));
    }

    @Test
    @DisplayName("Single int ArrayList to array")
    void singleIntArrayListToArray() {
        int[] singleIntArray = {1};
        ArrayList<Integer> singleIntegerArrayList = new ArrayList<>();
        singleIntegerArrayList.add(1);
        Assertions.assertArrayEquals(singleIntArray,ArrayArrayListConversion.intArrayListToArray(singleIntegerArrayList));
    }

    @Test
    @DisplayName("Complex Arraylist to Array test")
    void complexArraylistToArrayTest() {
        int[] intArray = {-4,6,1,543,-3465,213,55,1,0};
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(-4,6,1,543,-3465,213,55,1,0));
        Assertions.assertArrayEquals(intArray,ArrayArrayListConversion.intArrayListToArray(integerArrayList));
    }
}
