package controller;

import view.PrintCentre;
import view.ReadCentre;
import controller.DataCentre;

public class OrderOfOperations {

    private PrintCentre printCentre = new PrintCentre();
    private ReadCentre readCentre = new ReadCentre();
    private DataCentre dataCentre = new DataCentre();

    public void coordinateOrderOfOperations(){
        coordinateUserQueryPhase();
        fireUpModel();
        coordinateModelReturnPhase();
    }

    private void coordinateUserQueryPhase(){
        //User is presented with a number of sort algorithms to choose from
        printCentre.pushToConsole(printCentre.inviteAlgorithmChoice());
        //Decision is given via the command line
        dataCentre.setAlgorithmList(readCentre.chooseAlgorithm(dataCentre.getNumberOfImplementedAlgorithms()));
        //The program will then ask for the length of an array again via the command line
        printCentre.pushToConsole(printCentre.inviteArrayLengthChoice());
        //Decision is given via the command line
        dataCentre.setArrayLength(readCentre.chooseLength());
        //Query if user wants to see the performance of algorithms
        printCentre.pushToConsole(printCentre.invitePerformanceTest());
        //Decision is given via the command line
        dataCentre.setQueryPerformance(readCentre.queryYesNo());
    }
    private void fireUpModel(){

    }

    private void coordinateModelReturnPhase(){
        //Print the unsorted randomly generated array
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
        for (int i = 0; i < dataCentre.getAlgorithmList().size(); i++) {
            printCentre.pushToConsole(printCentre.returnSorted(dataCentre.getSingleAlgorithmName(i), dataCentre.getSortedArrayRow(i)));
            if (dataCentre.isQueryPerformance()){
                printCentre.returnTime(dataCentre.getSingleTimeTaken(i));
            }
        }
        // Announce end of programme
        printCentre.pushToConsole(printCentre.endProgramme());
        // inquire as to whether use wants to start again
        if (readCentre.queryYesNo()){
            coordinateOrderOfOperations();
        }
    }
}
