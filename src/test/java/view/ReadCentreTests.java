package view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ReadCentreTests {

    ReadCentre readCentre = new ReadCentre();

    @Test
    @DisplayName("User inputs single digit number")
    void userInputsSingleDigitNumber() {
        ArrayList<Integer> numArray = new ArrayList<>();
        numArray.add(1);
        Assertions.assertEquals(readCentre.spoofChooseAlgorithm("1", 5),numArray);
    }

    @Test
    @DisplayName("User inputs multiple numbers separated by commas")
    void userInputsMultipleNumbersSeparatedByCommas() {
        ArrayList<Integer> numArray = new ArrayList<>();
        numArray.add(1);
        numArray.add(2);
        numArray.add(3);
        numArray.add(4);
        Assertions.assertEquals(readCentre.spoofChooseAlgorithm("1,2,3,4", 5),numArray);
    }

//    @Test
//    @DisplayName("User inputs multi-digit negative number")
//    void userInputsMultiDigitNegativeNumber() {
//        ArrayList<Integer> numArray = new ArrayList<>();
//        numArray.add(-239751);
//        Assertions.assertEquals(readCentre.spoofChooseAlgorithm("-239751", 5),numArray);
//    }

//    @Test
//    @DisplayName("check single in-bounds user number")
//    void checkSingleInBoundsUserNumber() {
//        ArrayList<Integer> numArray = new ArrayList<>();
//        numArray.add(1);
//        Assertions.assertEquals(numArray, readCentre.checkAlgorithmNumbers(numArray,1));
//    }
//
//    @Test
//    @DisplayName("multiple in-bounds user numbers")
//    void multipleInBoundsUserNumbers() {
//        ArrayList<Integer> numArray = new ArrayList<>();
//        numArray.add(1);
//        numArray.add(2);
//        numArray.add(3);
//        Assertions.assertEquals(numArray, readCentre.checkAlgorithmNumbers(numArray,5));
//    }

}
