package model.sortingAlgorithms;

import model.Sortable;

import java.time.LocalDateTime;
import java.util.Arrays;

public class BubbleSort implements Sortable {

    private int beginSort;
    private int endSort;

    @Override
    public int[] returnSortedArray(int[] unsortedArray) {

        this.beginSort = LocalDateTime.now().getNano();

        boolean isSorted = false;
        int arrayLength = unsortedArray.length;
        int digitStorage;

        while (!isSorted){
            //If no swaps are detected for a full for loop, declare array sorted and break while loop
            isSorted = true;
            //iterate over length-1
            for (int i = 0; i < arrayLength - 1; i++) {
                //get ith and (i+1)th numbers and compare
                if (unsortedArray[i] > unsortedArray[i+1]){
                    //if they need swapping, store one number, overwrite it, then overwrite the other
                    digitStorage = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i+1];
                    unsortedArray[i+1] = digitStorage;
                    isSorted = false;
                }
            }
        }
        this.endSort = LocalDateTime.now().getNano();
        return unsortedArray;
    }

    @Override
    public Integer returnTimeTaken() {
        return this.endSort - this.beginSort;
    }

    @Override
    public String getAlgorithmName() {
        return "BubbleSort";
    }
}
