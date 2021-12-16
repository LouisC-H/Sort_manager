package controller;

import logging.MyLogger;
import model.ArrayGenerator;
import model.Sortable;
import model.SortableFactory;
import view.PrintCentre;
import view.ReadCentre;
import controller.DataCentre;

import java.util.logging.Level;

public class OrderOfOperations {

    private PrintCentre printCentre = new PrintCentre();
    private ReadCentre readCentre = new ReadCentre();
    private DataCentre dataCentre = new DataCentre();
    private ArrayGenerator arrayGenerator = new ArrayGenerator();

    public void coordinateOrderOfOperations(){
        MyLogger.setup();
        MyLogger.log(Level.INFO,"The sort manager has been launched");
        coordinateUserQueryPhase();
        MyLogger.log(Level.INFO,"The user has inputted their decisions, beginning calculations");
        fireUpModel();
        MyLogger.log(Level.INFO,"The calculations have finished, beginning to return the results to the user");
        coordinateModelReturnPhase();
        MyLogger.log(Level.INFO,"The sort manager has finished");
    }

    private void coordinateUserQueryPhase(){
        //User is presented with a number of sort algorithms to choose from
        printCentre.pushToConsole(printCentre.inviteAlgorithmChoice());
        //Decision is given via the command line
        MyLogger.log(Level.CONFIG,"Asking the user to choose their algorithms");
        dataCentre.setAlgorithmList(readCentre.chooseAlgorithm(dataCentre.getNumberOfImplementedAlgorithms()));
        //The program will then ask for the length of an array again via the command line
        printCentre.pushToConsole(printCentre.inviteArrayLengthChoice());
        //Decision is given via the command line
        MyLogger.log(Level.CONFIG,"Asking the user to choose their array length");
        dataCentre.setArrayLength(readCentre.chooseLength());
        //Query if user wants to see the performance of algorithms
        printCentre.pushToConsole(printCentre.invitePerformanceTest());
        //Decision is given via the command line
        MyLogger.log(Level.CONFIG,"Asking the user whether or not they'd like to see the performance details");
        dataCentre.setQueryPerformance(readCentre.queryYesNo());
    }

    private void fireUpModel(){
        // Generate random unsorted array
        MyLogger.log(Level.FINE,"Generating unsorted array");
        dataCentre.setUnsortedArray(arrayGenerator.generateRandomArray(dataCentre.getArrayLength()));
        dataCentre.initialiseSortedArrays(dataCentre.getNumberOfChosenAlgorithms(), dataCentre.getArrayLength());
        // For each algorithm requested by the user...
        MyLogger.log(Level.FINE,"Beginning to iterate over chosen sorting algorithms");
        for (int i = 0; i < dataCentre.getNumberOfChosenAlgorithms(); i++) {
            // ...instantiate a sorting algorithm object ...
            Integer sortingAlgorithmNumber = dataCentre.getAlgorithmList().get(i);
            Sortable sortingAlgorithm = SortableFactory.getSortingAlgorithm(sortingAlgorithmNumber);
            // ... then use it to sort the array.
            dataCentre.setSortedArraysRow(i, sortingAlgorithm.returnSortedArray(dataCentre.getUnsortedArray()));
            dataCentre.addToTimeTaken(sortingAlgorithm.returnTimeTaken());
            dataCentre.addToAlgorithmNames(sortingAlgorithm.getAlgorithmName());
            MyLogger.log(Level.FINE,"Finished " + dataCentre.getSingleAlgorithmName(i));
        }
    }

    private void coordinateModelReturnPhase(){
        //Print the unsorted randomly generated array
        MyLogger.log(Level.FINE,"Showing unsorted array");
        printCentre.pushToConsole(printCentre.returnUnsorted(dataCentre.getUnsortedArray()));
        /*
        Begin output loop
        Print the sort algorithm to be used
        Print the sorted array after the algorithm has been executed
        Decision point (Logic)
        -> Print the time taken
        -> Return to top of loop
        -> End output loop
         */
        for (int i = 0; i < dataCentre.getNumberOfChosenAlgorithms(); i++) {
            MyLogger.log(Level.FINE,"Showing array sorted using " + dataCentre.getSingleAlgorithmName(i));
            printCentre.pushToConsole(printCentre.returnSorted(dataCentre.getSingleAlgorithmName(i), dataCentre.getSortedArrayRow(i)));
            if (dataCentre.isQueryPerformance()){
                MyLogger.log(Level.FINE,"Showing performance metric");
                printCentre.returnTime(dataCentre.getSingleTimeTaken(i));
            }
        }
        // Announce end of programme
        printCentre.pushToConsole(printCentre.endProgramme());
        // inquire as to whether use wants to start again
        MyLogger.log(Level.CONFIG,"Asking the user whether they want to start again");
        if (readCentre.queryYesNo()){
            coordinateOrderOfOperations();
        }
    }
}
