package model;

import model.sortingAlgorithms.BinaryTreeSort;
import model.sortingAlgorithms.BubbleSort;

public class SortableFactory {
    public static Sortable getSortingAlgorithm(Integer algorithmNumber){
        return switch (algorithmNumber) {
            case 1 -> new BubbleSort();
//            case 2 -> new MergeSort();
            case 3 -> new BinaryTreeSort();
            default -> null;
        };
    }
}
