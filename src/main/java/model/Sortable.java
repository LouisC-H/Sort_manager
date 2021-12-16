package model;

public interface Sortable {

    int[] returnSortedArray(int[] unsortedArray);
    Integer returnTimeTaken();
    String getAlgorithmName();

//    no idea if this would work??

//    int beginSort = 0;
//    int endSort = 0;
//    default Integer returnTimeTaken(){return this.endSort - this.beginSort;};
}
