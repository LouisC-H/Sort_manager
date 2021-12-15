package model;

import model.sortingAlgorithms.BinaryTreeSort;

public class SortableFactory {
    public static Sortable getSortingAlgorithm(String algorithmName, int[] unsortedArray){
        return switch (algorithmName) {
//            case "BubbleSort" -> new BubbleSort();
//            case "MergeSort" -> new MergeSort();
            case "BinaryTreeSort" -> new BinaryTreeSort();
            default -> null;
        };
    }
}
