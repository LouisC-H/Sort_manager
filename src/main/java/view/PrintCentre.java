package view;

import logging.MyLogger;
import model.SortableAlgorithmHub;

import java.util.Arrays;
import java.util.logging.Level;

public class PrintCentre {

    // only exists to allow other functions to be tested
    public void pushToConsole(String toPrint){
        MyLogger.log(Level.FINEST,"Printing message to console window: " + toPrint);
        System.out.println(toPrint);
    }

    public String inviteAlgorithmChoice(){
        return "Which algorithm would you like to use? \n" +
                "If you would like to compare more than one, please separate each choice with a comma \n"
                + SortableAlgorithmHub.namesOfSortAlgorithms;
    }

    public String wordsInChoice(){
        return "Sorry, I didn't get that, please try again. Don't use any extra characters";
    }

    public String invalidAlgorithmChoice(Integer numAlgorithms){
        return "Sorry, I didn't get that, please try again. Input only number between 1 and " + numAlgorithms.toString();
    }

    public String inviteArrayLengthChoice(){
        return "How long an array would you like to sort? \n" +
                "Please answer with a single integer";
    }

    public String invalidArrayLengthChoice(){
        return "Sorry, I didn't get that, please try again. Input a single number between 1 and 5000";
    }

    public String invitePerformanceTest(){
        return "Would you like to test the speed of the algorithm(s) selected?\n" +
                "Please answer with Y (yes) or N (no)";
    }

    public String invalidYesNo(){
        return "Sorry, I didn't get that, please try again. Input Y (yes) or N (no)";
    }

    // output loop printing
    public String returnUnsorted(int[] intArray){
        return "Unsorted: " + Arrays.toString(intArray);
    }

    public String returnSorted(String sortingAlgorithm, int[] intArray){
        return sortingAlgorithm + ": " + Arrays.toString(intArray);
    }

    public String returnTime(Long timeTaken){
        return "Time taken: " + timeTaken.toString() + " ns";
    }

    public String endProgramme(){
        return "Thank you for using SortManager\u2122. Would you like to start again?\n" +
                "Please answer with Y (yes) or N (no)";
    }
}
