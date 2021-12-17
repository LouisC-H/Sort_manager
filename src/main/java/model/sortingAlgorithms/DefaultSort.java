package model.sortingAlgorithms;

import logging.MyLogger;
import model.Sortable;

import java.util.Arrays;
import java.util.logging.Level;

public class DefaultSort implements Sortable {

    private long beginSort;
    private long endSort;

    @Override
    public int[] returnSortedArray(int[] unsortedArray) {

        MyLogger.log(Level.FINE,"Beginning " + this.getAlgorithmName());
        this.beginSort = System.nanoTime();

        Arrays.sort(unsortedArray);

        this.endSort = System.nanoTime();
        MyLogger.log(Level.FINE,"Ending " + this.getAlgorithmName() + ". Time taken: " + this.returnTimeTaken());

        return unsortedArray;
    }

    @Override
    public long returnTimeTaken() {
        return this.endSort - this.beginSort;
    }

    @Override
    public String getAlgorithmName() {
        return "DefaultSort";
    }
}
