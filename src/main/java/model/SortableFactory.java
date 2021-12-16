package model;

import model.sortingAlgorithms.BinaryTreeSort;
import model.sortingAlgorithms.BubbleSort;
import model.sortingAlgorithms.MergeSort;

public class SortableFactory {
    public static Sortable getSortingAlgorithm(Integer algorithmNumber){
        return switch (algorithmNumber) {
            case 1 -> new BubbleSort();
            case 2 -> new MergeSort();
            case 3 -> new BinaryTreeSort();
            default -> null;
        };
    }
}
