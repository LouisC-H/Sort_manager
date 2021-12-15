package controller;

import java.util.ArrayList;

public class DataCentre {

    private  Integer numberOfImplementedAlgorithms = 3;

    private boolean queryPerformance;
    private Integer arrayLength;
    private int[] unsortedArray;
    private int[][] sortedArrays;
    private ArrayList<Integer> algorithmList = new ArrayList<>();
    private ArrayList<Integer> timeTaken = new ArrayList<>();
    private ArrayList<String> algorithmNames = new ArrayList<>();

    public void initialiseSortedArrays(Integer rows,Integer columns) {
        this.sortedArrays = new int[rows][columns];
    }

    //Getters
    public Integer getNumberOfImplementedAlgorithms() {
        return numberOfImplementedAlgorithms;
    }

    public Boolean isQueryPerformance() {
        return queryPerformance;
    }

    public Integer getArrayLength() {
        return arrayLength;
    }

    public int[] getUnsortedArray() {
        return unsortedArray;
    }

    public int[] getSortedArrayRow(int i) {
        return sortedArrays[i];
    }

    public ArrayList<Integer> getAlgorithmList() {
        return algorithmList;
    }

    public Integer getSingleTimeTaken(int i) {
        return timeTaken.get(i);
    }

    public String getSingleAlgorithmName(int i) {
        return algorithmNames.get(i);
    }

    //Setters
    public void setQueryPerformance(boolean queryPerformance) {
        this.queryPerformance = queryPerformance;
    }

    public void setArrayLength(Integer arrayLength) {
        this.arrayLength = arrayLength;
    }

    public void setUnsortedArray(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public void setSortedArraysRow(int i, int[] sortedArray) {
        this.sortedArrays[i] = sortedArray;
    }

    public void setAlgorithmList(ArrayList<Integer> algorithmList) {
        this.algorithmList = algorithmList;
    }

    public void addToTimeTaken(Integer timeTaken) {
        this.timeTaken.add(timeTaken);
    }

    public void addToAlgorithmNames(String algorithmName) {
        this.algorithmNames.add(algorithmName);
    }

}
