# Sort Manager

This project was created for the week 3 project as part of Sparta Global's java engineering course.
It is designed to allow users to compare and contrast different sorting algorithms.


## Table of contents
* [Functionality](#functionality)
* [Implemented sorting algorithms](#implemented-sorting-algorithms)
* [Known bugs](#known-bugs)
* [Notes for contributors](#notes-for-contributors)


## Functionality

1. When launched, the sort manager will query the user as to which sorting algorithms they wish to implement.
2. Next, the user is prompted to input the length of the array to be sorted.
3. Finally, the program will ask whether or not they want the speed of these algorithms to be tested.

## Implemented sorting algorithms

- [Binary tree sort](https://blog.penjee.com/wp-content/uploads/2015/11/binary-search-tree-sorted-array-animation.gif)
- [Merge sort](https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif)
- [Bubble sort](https://upload.wikimedia.org/wikipedia/commons/0/06/Bubble-sort.gif)
- [Default java array sort (dual-pivot quicksort) ](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#sort(int[]))

## Known bugs

 1. When a binary tree sort is carried out after a BubbleSort (3) or DefaultSort (4), and the list size is relatively large
(5000 is about the largest you can safely go), the code throws up a StackOverflow error. 

## Notes for contributors

1. If seeking to add to the number of sorting algorithms, the only external files that should need to be modified is
the SortableAlgorithmHub.
