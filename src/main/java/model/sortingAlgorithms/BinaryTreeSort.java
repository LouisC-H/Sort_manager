package model.sortingAlgorithms;

import model.Sortable;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BinaryTreeSort implements Sortable {
    private Node rootNode;
    private int beginSort;
    private int endSort;

    private void constructTree(final int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            if (i==0) {
                this.rootNode = new Node(unsortedArray[i]);
            } else {
                addElement(unsortedArray[i]);
            }
        }
    }

    private void addElement(final int element){
        addNodeToTree(rootNode,element);
    }

    private void addNodeToTree(Node currentNode, final int element){
        // Iterate recursively through the tree till you find space for new node
        if (element <= currentNode.getValue()){
            // If the new node is smaller, place it to the right
            if (currentNode.isLeftChildEmpty()){
                currentNode.setLeftChild(new Node(element));
            } else {
                addNodeToTree(currentNode.getLeftChild(), element);
            }
        } else if (element > currentNode.getValue()) {
            // If the new node is smaller, place it to the left
            if (currentNode.isRightChildEmpty()){
                currentNode.setRightChild(new Node(element));
            } else {
                addNodeToTree(currentNode.getRightChild(), element);
            }}
    }

    @Override
    public int[] returnSortedArray(int[] unsortedArray) {

        this.constructTree(unsortedArray);

        this.beginSort = LocalDateTime.now().getNano();
        ArrayList<Integer> runningIntArrayList =  new ArrayList<>();

        runningIntArrayList = recurseThroughArray(rootNode, runningIntArrayList);

        int[] runningIntArray = convertToIntArray(runningIntArrayList);

        this.endSort = LocalDateTime.now().getNano();
        return runningIntArray;
    }

    @Override
    public Integer returnTimeTaken() {
        return this.endSort - this.beginSort;
    }

    @Override
    public String getAlgorithmName() {
        return "BinaryTreeSort";
    }

    private ArrayList<Integer> recurseThroughArray(Node node, ArrayList<Integer> runningIntArray){

        if(!node.isLeftChildEmpty()){
            //If there is a node to the left, step into it
            runningIntArray = recurseThroughArray(node.getLeftChild(), runningIntArray);
        }
        //Once there are no more nodes to the left, record the node's value
        runningIntArray.add(node.getValue());

        if (!node.isRightChildEmpty()) {
            //If there is a node to the right, step into it
            runningIntArray = recurseThroughArray(node.getRightChild(), runningIntArray);
        }

        return runningIntArray;
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

    private class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }

        private Node getLeftChild() {
            return leftChild;
        }

        private Node getRightChild() {
            return rightChild;
        }

        private void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        private void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        private boolean isLeftChildEmpty(){
            if (leftChild == null){
                return true;
            } else {
                return false;
            }
        }

        private boolean isRightChildEmpty(){
            if (rightChild == null){
                return true;
            } else {
                return false;
            }
        }
    }
}
