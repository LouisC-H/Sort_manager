package controller;

import logging.MyLogger;
import model.SortableAlgorithmHub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class DataCentre {
    /*
    Store and return data to coordinate the rest of the program
     */

    private final Integer numberOfAlgorithms;

    private boolean queryPerformance;
    private Integer arrayLength;
    private Integer numberOfChosenAlgorithms;
    private int[] unsortedArray;
    private int[][] sortedArrays;
    private ArrayList<Integer> algorithmList = new ArrayList<>();
    private final ArrayList<Long> timeTaken = new ArrayList<>();
    private final ArrayList<String> algorithmNames = new ArrayList<>();

    public DataCentre() {
        this.numberOfAlgorithms = SortableAlgorithmHub.numberOfSortAlgorithms;
        MyLogger.log(Level.FINER,"The program currently implements this many algorithms: " + this.numberOfAlgorithms);
    }

    public void initialiseSortedArrays(Integer rows, Integer columns) {
        this.sortedArrays = new int[rows][columns];
        MyLogger.log(Level.FINER,"Sorted array data storage matrix initialised with " + rows + " rows and " + columns + " columns.");
    }

    //Getters
    public Integer getNumberOfAlgorithms() {
        MyLogger.log(Level.FINEST,"Number of algorithms accessed: " + numberOfAlgorithms.toString());
        return numberOfAlgorithms;
    }

    public Boolean isQueryPerformance() {
        MyLogger.log(Level.FINEST,"queryPerformance boolean accessed: " + queryPerformance);
        return queryPerformance;
    }

    public Integer getArrayLength() {
        MyLogger.log(Level.FINEST,"Array length accessed: " + arrayLength.toString());
        return arrayLength;
    }

    public Integer getNumberOfChosenAlgorithms() {
        MyLogger.log(Level.FINEST,"Number of Algorithms accessed: " + numberOfChosenAlgorithms.toString());
        return numberOfChosenAlgorithms;
    }

    public int[] getUnsortedArray() {
        MyLogger.log(Level.FINEST,"Unsorted array accessed");
        return unsortedArray;
    }

    public ArrayList<Integer> getAlgorithmList() {
        MyLogger.log(Level.FINEST,"Algorithm list accessed: " + algorithmList.toString());
        return algorithmList;
    }

    public int[] getSortedArrayRow(int i) {
        MyLogger.log(Level.FINEST,"Row #" + i + " of sorted array matrix accessed");
        return sortedArrays[i];
    }

    public Long getSingleTimeTaken(int i) {
        MyLogger.log(Level.FINEST,"Time taken #" + i + " accessed: " + timeTaken.get(i).toString());
        return timeTaken.get(i);
    }

    public String getSingleAlgorithmName(int i) {
        MyLogger.log(Level.FINEST,"Algorithm name #" + i + " accessed: " + algorithmNames.get(i));
        return this.algorithmNames.get(i);
    }

    //Setters
    public void setQueryPerformance(boolean queryPerformance) {
        MyLogger.log(Level.FINER,"queryPerformance boolean set to " + queryPerformance);
        this.queryPerformance = queryPerformance;
    }

    public void setArrayLength(Integer arrayLength) {
        MyLogger.log(Level.FINER,"Array length set to " + arrayLength.toString());
        this.arrayLength = arrayLength;
    }

    public void setUnsortedArray(int[] unsortedArray) {
        MyLogger.log(Level.FINER,"Unsorted array set");
        this.unsortedArray = unsortedArray;
    }

    public void setSortedArraysRow(int i, int[] sortedArray) {
        MyLogger.log(Level.FINER,"Row #" + i + " of sorted array matrix set");
        this.sortedArrays[i] = sortedArray;
    }

    public void setAlgorithmList(ArrayList<Integer> algorithmList) {
        MyLogger.log(Level.FINER,"Algorithm list set to " + algorithmList);
        this.algorithmList = algorithmList;
        MyLogger.log(Level.FINER,"Number of chosen algorithms set to " + algorithmList.size());
        this.numberOfChosenAlgorithms = algorithmList.size();
    }

    public void addToTimeTaken(long timeTaken) {
        MyLogger.log(Level.FINER,"Added the latest algorithm's time taken to the list: " + timeTaken);
        this.timeTaken.add(timeTaken);
    }

    public void addToAlgorithmNames(String algorithmName) {
        MyLogger.log(Level.FINER,"Added the latest algorithm's name to the list: " + algorithmName);
        this.algorithmNames.add(algorithmName);
    }

}
