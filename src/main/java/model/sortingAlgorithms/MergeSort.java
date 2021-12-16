package model.sortingAlgorithms;

import model.ArrayArrayListConversion;
import model.Sortable;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MergeSort implements Sortable {
    private long beginSort;
    private long endSort;

    @Override
    public int[] returnSortedArray(int[] unsortedArray) {

        this.beginSort = LocalDateTime.now().getNano();

        ArrayList<Integer> runningIntArrayList =  ArrayArrayListConversion.intArrayToArrayList(unsortedArray);

        runningIntArrayList = recursiveSplit(runningIntArrayList);

        int[] runningIntArray = ArrayArrayListConversion.intArrayListToArray(runningIntArrayList);

        this.endSort = LocalDateTime.now().getNano();
        return runningIntArray;
    }

    private ArrayList<Integer> recursiveSplit(ArrayList<Integer> unsortedArray){
        //Step 0: Check if we've reached the deepest point of the recursion
        int arrayLength = unsortedArray.size();
        if (unsortedArray.size() == 1){
            return unsortedArray;
        }
        //Step 1: Split the ArrayList in half and recurse into each one
        int halfArray = (int) Math.ceil(arrayLength / 2);
        ArrayList<Integer> leftHalfSplit = new ArrayList<>(unsortedArray.subList(0, halfArray));
        leftHalfSplit = recursiveSplit(leftHalfSplit);
        ArrayList<Integer> rightHalfSplit = new ArrayList<>(unsortedArray.subList(halfArray, arrayLength));
        rightHalfSplit = recursiveSplit(rightHalfSplit);

        //Step 2: Thanks to the recursion of the previous step, both halves should be sorted by the time
        // the programme returns to this layer of the stack. We must now sort this layer.

        return recursiveMergeSort(leftHalfSplit,rightHalfSplit);
    }

    private ArrayList<Integer> recursiveMergeSort(ArrayList<Integer> leftHalfSplit, ArrayList<Integer> rightHalfSplit) {

        ArrayList<Integer> sortedArray =  new ArrayList<>();

        // Comparing the first integers of both lists, remove the smallest one and add it to the end of sortedArray
        while (!leftHalfSplit.isEmpty() && !rightHalfSplit.isEmpty()){
            if (leftHalfSplit.get(0) >= rightHalfSplit.get(0)){
                sortedArray.add(rightHalfSplit.remove(0));
            } else if (rightHalfSplit.get(0) > leftHalfSplit.get(0)){
                sortedArray.add(leftHalfSplit.remove(0));
            }
        }

        // Once one list is empty, add anything remaining in the other to the end of sortedArray
        if (leftHalfSplit.isEmpty()){
            sortedArray.addAll(rightHalfSplit);
        }
        if (rightHalfSplit.isEmpty()){
            sortedArray.addAll(leftHalfSplit);
        }

        return sortedArray;
    }

    @Override
    public long returnTimeTaken() {
        return this.endSort - this.beginSort;
    }

    @Override
    public String getAlgorithmName() {
        return "MergeSort";
    }

    private int[] convertToIntArray(ArrayList<Integer> runningIntArray){
        // create a new int array that's the same size as the  ArrayList
        int arraySize = runningIntArray.size();
        int[] intArray = new int[arraySize];
        // populate array
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = runningIntArray.get(i);
        }

        return intArray;
    }
}
