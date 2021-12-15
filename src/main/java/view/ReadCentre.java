package view;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReadCentre {
    Scanner scan = new Scanner(System.in);
    PrintCentre printCentre = new PrintCentre();

    public ArrayList<Integer> chooseAlgorithm(Integer numAlgorithms){

        ArrayList<Integer> numArray = new ArrayList<>();

        String userInput = scan.nextLine();
        String[] splitInput = userInput.split(",");

        for (String numString : splitInput) {
            try {
                numArray.add(Integer.parseInt(numString));
            } catch (Exception e) {
                printCentre.pushToConsole(printCentre.wordsInChoice());
                numArray = this.chooseAlgorithm(numAlgorithms);
            }
        }

        numArray = checkAlgorithmNumbers(numArray, numAlgorithms);

        return numArray;
    }

    private ArrayList<Integer> checkAlgorithmNumbers(ArrayList<Integer> numArray, Integer numAlgorithms) {
        // Loop through user inputed numbers to check if any are out of bounds
        boolean integerOutOfBounds = false;
        for (Integer algorithmNumber: numArray) {
            if (algorithmNumber > numAlgorithms || algorithmNumber <= 0){
                integerOutOfBounds = true;
                break;
            }
        }
        // if any are, ask user for new input
        if (integerOutOfBounds){
            printCentre.pushToConsole(printCentre.invalidAlgorithmChoice(numAlgorithms));
            numArray = this.chooseAlgorithm(numAlgorithms);
        }

        return numArray;
    }

    public Integer chooseLength(){

        Integer chosenLength;
        String userInput = scan.nextLine();

        try {
            chosenLength = Integer.parseInt(userInput);
        } catch (Exception e) {
            printCentre.pushToConsole(printCentre.invalidArrayLengthChoice());
            chosenLength = this.chooseLength();
        }

        chosenLength = checkLength(chosenLength);

        return chosenLength;
    }

    private Integer checkLength(Integer userInput){
        if (0 < userInput && userInput <= Integer.MAX_VALUE){
            return userInput;
        } else {
            printCentre.pushToConsole(printCentre.invalidArrayLengthChoice());
            return chooseLength();
        }
    }

    public boolean queryYesNo(){
        boolean yesOrNo;
        String userInput = scan.nextLine();

        userInput = userInput.toUpperCase(Locale.ROOT);
        if (userInput.equals("Y") || userInput.equals("YES")){
            yesOrNo = true;
        } else if (userInput.equals("N")||userInput.equals("NO")) {
            yesOrNo = false;
        } else {
            printCentre.pushToConsole(printCentre.invalidYesNo());
            yesOrNo = queryYesNo();
        }

        return yesOrNo;
    }

    public ArrayList<Integer> spoofChooseAlgorithm(String spoofUserInput, Integer numAlgorithms){

        ArrayList<Integer> numArray = new ArrayList<>();

        String[] splitInput = spoofUserInput.split(",");

        for (String numString : splitInput) {
            try {
                numArray.add(Integer.parseInt(numString));
            } catch (Exception e) {
                printCentre.pushToConsole(printCentre.wordsInChoice());
                numArray = this.chooseAlgorithm(numAlgorithms);
            }
        }

        numArray = checkAlgorithmNumbers(numArray, numAlgorithms);

        return numArray;
    }

    public static void main(String[] args) {
        ReadCentre readCentre = new ReadCentre();
//        System.out.println(readCentre.chooseAlgorithm(3).toString());
        System.out.println(readCentre.chooseLength());
//        System.out.println(readCentre.queryPerformance());
    }
}
