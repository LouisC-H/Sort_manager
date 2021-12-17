package model;

import model.sortingAlgorithms.BinaryTreeSort;
import model.sortingAlgorithms.BubbleSort;
import model.sortingAlgorithms.DefaultSort;
import model.sortingAlgorithms.MergeSort;

public class SortableAlgorithmHub {
//    By slightly extending the basic factory design pattern, the code has been refactored so
//    that this is the only class that should need altering in the event that any new sorting
//    algorithms are to be added. I understand that this breaks S(olid).

    public final static int numberOfSortAlgorithms = 4;

    public final static String namesOfSortAlgorithms = "1. Binary Tree Sort \n" +
            "2. Merge Sort \n" +
            "3. Bubble Sort \n" +
            "4. Default Sort";

    public static Sortable getSortingAlgorithm(Integer algorithmNumber){
        return switch (algorithmNumber) {
            case 3 -> new BubbleSort();
            case 2 -> new MergeSort();
            case 1 -> new BinaryTreeSort();
            case 4 -> new DefaultSort();
            default -> null;
        };
    }
}
