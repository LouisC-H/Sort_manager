package controller;

import logging.MyLogger;
import model.ArrayGenerator;
import model.Sortable;
import model.SortableAlgorithmHub;
import view.PrintCentre;
import view.ReadCentre;

import java.util.logging.Level;

public class OrderOfOperations {

    private PrintCentre printCentre = new PrintCentre();
    private ReadCentre readCentre = new ReadCentre();
    private DataCentre dataCentre = new DataCentre();
    private ArrayGenerator arrayGenerator = new ArrayGenerator();

    public void coordinateOrderOfOperations(){
        /*
        Coordinates the whole program. Split into three phases: the user interaction,
        the backend calculation and the output loop
         */
        MyLogger.setup();
        MyLogger.log(Level.INFO,"The sort manager has been launched");
        userInteraction();
        MyLogger.log(Level.INFO,"The user has inputted their decisions, beginning calculations");
        backendCalculations();
        MyLogger.log(Level.INFO,"The calculations have finished, beginning to return the results to the user");
        outputLoop();
        MyLogger.log(Level.INFO,"The sort manager has finished");
    }

    private void userInteraction(){
        /*
        Step 1: The user is presented with a number of sort algorithms to choose from
        Step 2: The program will then ask for the length of an array again via the command line
        Step 3: Query if user wants to see the performance of algorithms
         */
        printCentre.pushToConsole(printCentre.inviteAlgorithmChoice());
        MyLogger.log(Level.CONFIG,"Asking the user to choose their algorithms");
        dataCentre.setAlgorithmList(readCentre.chooseAlgorithm(dataCentre.getNumberOfAlgorithms()));

        printCentre.pushToConsole(printCentre.inviteArrayLengthChoice());
        MyLogger.log(Level.CONFIG,"Asking the user to choose their array length");
        dataCentre.setArrayLength(readCentre.chooseLength());

        printCentre.pushToConsole(printCentre.invitePerformanceTest());
        MyLogger.log(Level.CONFIG,"Asking the user whether or not they'd like to see the performance details");
        dataCentre.setQueryPerformance(readCentre.queryYesNo());
    }

    private void backendCalculations(){
        /*
        Step 4: Generate random unsorted array
        Step 5: For each algorithm requested by the user instantiate a sorting algorithm object, then use it to sort the array.
         */
        MyLogger.log(Level.FINE,"Generating unsorted array");
        dataCentre.setUnsortedArray(arrayGenerator.generateRandomArray(dataCentre.getArrayLength()));
        dataCentre.initialiseSortedArrays(dataCentre.getNumberOfChosenAlgorithms(), dataCentre.getArrayLength());

        MyLogger.log(Level.FINE,"Beginning to iterate over chosen sorting algorithms");
        for (int i = 0; i < dataCentre.getNumberOfChosenAlgorithms(); i++) {

            Integer sortingAlgorithmNumber = dataCentre.getAlgorithmList().get(i);
            Sortable sortingAlgorithm = SortableAlgorithmHub.getSortingAlgorithm(sortingAlgorithmNumber);
            MyLogger.log(Level.FINE,"Generated sorting algorithm from factory: " + sortingAlgorithm.getAlgorithmName());

            dataCentre.setSortedArraysRow(i, sortingAlgorithm.returnSortedArray(dataCentre.getUnsortedArray()));
            dataCentre.addToTimeTaken(sortingAlgorithm.returnTimeTaken());
            dataCentre.addToAlgorithmNames(sortingAlgorithm.getAlgorithmName());
            MyLogger.log(Level.FINE,"Finished all " + dataCentre.getSingleAlgorithmName(i) + " calculations");
        }
    }

    private void outputLoop(){
        /*
        Step 6: Print outputs
        Step 7: Announce end of program and inquire as to whether use wants to start again
         */
        MyLogger.log(Level.FINE,"Showing unsorted array");
        printCentre.pushToConsole(printCentre.returnUnsorted(dataCentre.getUnsortedArray()));

        for (int i = 0; i < dataCentre.getNumberOfChosenAlgorithms(); i++) {
            MyLogger.log(Level.FINE,"Showing array sorted using " + dataCentre.getSingleAlgorithmName(i));
            printCentre.pushToConsole(printCentre.returnSorted(dataCentre.getSingleAlgorithmName(i), dataCentre.getSortedArrayRow(i)));
            if (dataCentre.isQueryPerformance()){
                MyLogger.log(Level.FINE,"Showing performance metric");
                printCentre.pushToConsole(printCentre.returnTime(dataCentre.getSingleTimeTaken(i)));
            }
        }

        printCentre.pushToConsole(printCentre.endProgramme());
        MyLogger.log(Level.CONFIG,"Asking the user whether they want to start again");
        if (readCentre.queryYesNo()){
            coordinateOrderOfOperations();
        }
    }
}
