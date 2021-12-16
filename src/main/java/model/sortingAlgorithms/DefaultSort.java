package model.sortingAlgorithms;

import model.Sortable;

import java.util.Arrays;

public class DefaultSort implements Sortable {

    private long beginSort;
    private long endSort;

    @Override
    public int[] returnSortedArray(int[] unsortedArray) {
        this.beginSort = System.nanoTime();
        Arrays.sort(unsortedArray);
        this.endSort = System.nanoTime();
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
