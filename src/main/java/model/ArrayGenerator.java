package model;

import logging.MyLogger;

import java.util.Random;
import java.util.logging.Level;

public class ArrayGenerator {
    /*
    Generates the random array to be sorted
     */

    public int[] generateRandomArray(int arraySize){

        Random random = new Random();
        int[] dummyArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int randomInt = getRandomInt(random);
            dummyArray[i] = randomInt;
        }

        MyLogger.log(Level.FINER,"Random array with length " + arraySize + " generated: " + dummyArray);

        return  dummyArray;
    }

    private int getRandomInt(Random random) {
        int randomInt = random.nextInt(Integer.MAX_VALUE);

        // 50% chance to be negative
        if (!random.nextBoolean()){
            randomInt *= -1;
        }
        return randomInt;
    }
}
