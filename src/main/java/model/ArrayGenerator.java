package model;

import logging.MyLogger;

import java.util.Random;
import java.util.logging.Level;

public class ArrayGenerator {

    public int[] generateRandomArray(int arraySize){
        Random random = new Random();


        int[] dummyArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int randomInt = random.nextInt(Integer.MAX_VALUE);

            // 50% chance to be negative
            if (!random.nextBoolean()){
                randomInt *= -1;
            }
            dummyArray[i] = randomInt;
        }

        MyLogger.log(Level.FINER,"Random array length " + arraySize + ": " + dummyArray);

        return  dummyArray;
    }
}
