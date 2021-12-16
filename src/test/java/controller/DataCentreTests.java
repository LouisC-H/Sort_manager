package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DataCentreTests {

    DataCentre dataCentre = new DataCentre();

    @Nested
    @DisplayName("Check getter return type")
    class checkGetterReturnType {

        @Test
        @DisplayName("Getter return type - numberOfImplementedAlgorithms")
        void getterReturnTypeNumberOfImplementedAlgorithms() {
            Assertions.assertInstanceOf(Integer.class, dataCentre.getNumberOfAlgorithms());
        }

        @Test
        @DisplayName("Getter return type - queryPerformance")
        void getterReturnTypeQueryPerformance() {
            dataCentre.setQueryPerformance(true);
            Assertions.assertInstanceOf(Boolean.class, dataCentre.isQueryPerformance());
        }

        @Test
        @DisplayName("Getter return type - arrayLength")
        void getterReturnTypeArrayLength() {
            dataCentre.setArrayLength(5);
            Assertions.assertInstanceOf(Integer.class, dataCentre.getArrayLength());
        }

        @Test
        @DisplayName("Getter return type - unsortedArray")
        void getterReturnTypeUnsortedArray() {
            dataCentre.setUnsortedArray(new int[]{1, 2, 3});
            Assertions.assertInstanceOf(int[].class, dataCentre.getUnsortedArray());
        }

        @Test
        @DisplayName("Getter return type - sortedArrays")
        void getterReturnTypeSortedArrays() {
            dataCentre.initialiseSortedArrays(3,3);
            dataCentre.setSortedArraysRow(0,new int[]{1, 2, 3});
            Assertions.assertInstanceOf(int[].class, dataCentre.getSortedArrayRow(0));
        }

        @Test
        @DisplayName("Getter return type - algorithmList")
        void getterReturnTypeAlgorithmList() {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            dataCentre.setAlgorithmList(arrayList);
            Assertions.assertInstanceOf(ArrayList.class, dataCentre.getAlgorithmList());
        }

        @Test
        @DisplayName("Getter return type - timeTaken")
        void getterReturnTypeTimeTaken() {
            dataCentre.addToTimeTaken(9873);
            Assertions.assertInstanceOf(Integer.class, dataCentre.getSingleTimeTaken(0));
        }

        @Test
        @DisplayName("Getter return type - algorithmNames")
        void getterReturnTypeAlgorithmNames() {
            dataCentre.addToAlgorithmNames("Hand sort");
            Assertions.assertInstanceOf(String.class, dataCentre.getSingleAlgorithmName(0));
        }
    }

    @Nested
    @DisplayName("Check getter/setter exact return value")
    class checkGetterSetterExactReturnValue {
        @Test
        @DisplayName("Getter return value - numberOfImplementedAlgorithms")
        void getterReturnTypeNumberOfImplementedAlgorithms() {
            Assertions.assertEquals(3, dataCentre.getNumberOfAlgorithms());
        }

        @Test
        @DisplayName("Getter return value - queryPerformance")
        void getterReturnTypeQueryPerformance() {
            dataCentre.setQueryPerformance(true);
            Assertions.assertEquals(true, dataCentre.isQueryPerformance());
        }

        @Test
        @DisplayName("Getter return value - arrayLength")
        void getterReturnTypeArrayLength() {
            dataCentre.setArrayLength(5);
            Assertions.assertEquals(5, dataCentre.getArrayLength());
        }

        @Test
        @DisplayName("Getter return value - unsortedArray")
        void getterReturnTypeUnsortedArray() {
            int[] intArray = {1, 2, 3};
            dataCentre.setUnsortedArray(intArray);
            Assertions.assertArrayEquals(intArray, dataCentre.getUnsortedArray());
        }

        @Test
        @DisplayName("Getter return value - sortedArrays")
        void getterReturnTypeSortedArrays() {
            int[] intArray = {1, 2, 3};
            dataCentre.initialiseSortedArrays(3,3);
            dataCentre.setSortedArraysRow(0, intArray);
            Assertions.assertArrayEquals(intArray, dataCentre.getSortedArrayRow(0));
        }

        @Test
        @DisplayName("Getter return value - algorithmList")
        void getterReturnTypeAlgorithmList() {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            dataCentre.setAlgorithmList(arrayList);
            Assertions.assertEquals(arrayList, dataCentre.getAlgorithmList());
        }

        @Test
        @DisplayName("Getter return value - timeTaken")
        void getterReturnTypeTimeTaken() {
            Long time = 9873L;
            dataCentre.addToTimeTaken(time);
            Assertions.assertEquals(time, dataCentre.getSingleTimeTaken(0));
        }

        @Test
        @DisplayName("Getter return value - algorithmNames")
        void getterReturnTypeAlgorithmNames() {
            String string = "Hand sort";
            dataCentre.addToAlgorithmNames(string);
            Assertions.assertInstanceOf(String.class, dataCentre.getSingleAlgorithmName(0));
        }
    }
}
