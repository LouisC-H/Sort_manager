package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayArrayListConversion {

        public static int[] intArrayListToArray(ArrayList<Integer> integerArrayList){

            // create a new int array that's the same size as the  ArrayList
            int arraySize = integerArrayList.size();
            int[] intArray = new int[arraySize];
            // populate array
            for (int i = 0; i < arraySize; i++) {
                intArray[i] = integerArrayList.get(i);
            }

            return intArray;
        }

        public static ArrayList<Integer> intArrayToArrayList(int[] intArray){

            ArrayList<Integer> integerArrayList = new ArrayList<>();

            for (int number: intArray) {
                integerArrayList.add(number);
            }

            return integerArrayList;
        }
}
