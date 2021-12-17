package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SortingAlgorithmHubTests {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("Does each correct input number return a Sortable object?")
    void doesEachCorrectInputNumberReturnAnObject(Integer ints) {
        Assertions.assertInstanceOf(Sortable.class, SortableAlgorithmHub.getSortingAlgorithm(ints));
    }

    @Test
    @DisplayName("Do two identical input numbers return the same objects?")
    void doTwoIdenticalInputNumbersReturnTheSameObjects() {
        Assertions.assertEquals(SortableAlgorithmHub.getSortingAlgorithm(0), SortableAlgorithmHub.getSortingAlgorithm(0));
    }

    @Test
    @DisplayName("Do two different input numbers return different objects?")
    void doTwoDifferentInputNumbersReturnDifferentObjects() {
        Assertions.assertNotEquals(SortableAlgorithmHub.getSortingAlgorithm(0), SortableAlgorithmHub.getSortingAlgorithm(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-234,0,11,Integer.MAX_VALUE})
    @DisplayName("Does it return null if an out of bound number is used?")
    void doesItReturnNullIfAnOutOfBoundNumberIsUsed(Integer ints) {
        Assertions.assertNull(SortableAlgorithmHub.getSortingAlgorithm(ints));
    }
}
