package model.sortingAlgorithms;

import logging.MyLogger;
import model.ArrayArrayListConversion;
import model.Sortable;

import java.util.ArrayList;
import java.util.logging.Level;

public class BinaryTreeSort implements Sortable {

    private Node rootNode;
    private long beginSort;
    private long endSort;

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

        MyLogger.log(Level.FINE,"Beginning " + this.getAlgorithmName());
        this.beginSort = System.nanoTime();
        this.constructTree(unsortedArray);
        MyLogger.log(Level.FINE,"Binary tree has been constructed, containing this many nodes: " + unsortedArray.length);

        ArrayList<Integer> runningIntArrayList =  new ArrayList<>();
        runningIntArrayList = recurseThroughArray(rootNode, runningIntArrayList);

        int[] runningIntArray = ArrayArrayListConversion.intArrayListToArray(runningIntArrayList);

        this.endSort = System.nanoTime();
        MyLogger.log(Level.FINE,"Ending " + this.getAlgorithmName() + ". Time taken: " + this.returnTimeTaken());

        return runningIntArray;
    }

    @Override
    public long returnTimeTaken() {
        return this.endSort - this.beginSort;
    }

    @Override
    public String getAlgorithmName() {
        return "BinaryTreeSort";
    }

    private ArrayList<Integer> recurseThroughArray(Node node, ArrayList<Integer> runningIntArray){
//        MyLogger.log(Level.FINEST,"Node of value " + node.value);

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
            return leftChild == null;
        }

        private boolean isRightChildEmpty(){
            return rightChild == null;
        }
    }
}
