package view;

import org.junit.jupiter.api.*;

public class PrintCentreTests {

    PrintCentre printCentre = new PrintCentre();

    @Nested
    @DisplayName("Check that they all return Strings")
    class checkThatTheyAllReturnStrings {

        @Test
        @DisplayName("Does it return a string? - inviteAlgorithmChoice")
        void doesItReturnAStringInviteAlgorithmChoice() {
            Assertions.assertInstanceOf(String.class, printCentre.inviteAlgorithmChoice());
        }

        @Test
        @DisplayName("Does it return a string? - invalidAlgorithmChoice")
        void doesItReturnAStringInvalidAlgorithmChoice() {
            Assertions.assertInstanceOf(String.class, printCentre.invalidAlgorithmChoice(1));
        }

        @Test
        @DisplayName("Does it return a string? - inviteArrayLengthChoice")
        void doesItReturnAStringInviteArrayLengthChoice() {
            Assertions.assertInstanceOf(String.class, printCentre.inviteArrayLengthChoice());
        }

        @Test
        @DisplayName("Does it return a string? - invalidArrayLengthChoice")
        void doesItReturnAStringInvalidArrayLengthChoice() {
            Assertions.assertInstanceOf(String.class, printCentre.invalidArrayLengthChoice());
        }

        @Test
        @DisplayName("Does it return a string? - inviteComparePerformance")
        void doesItReturnAStringInviteComparePerformance() {
            Assertions.assertInstanceOf(String.class, printCentre.inviteComparePerformance());
        }

        @Test
        @DisplayName("Does it return a string? - invalidComparePerformance")
        void doesItReturnAStringInvalidComparePerformance() {
            Assertions.assertInstanceOf(String.class, printCentre.invalidComparePerformance());
        }

        @Test
        @DisplayName("Does it return a string? - returnUnsorted")
        void doesItReturnAStringReturnUnsorted() {
            int[] unsortedArray = {2,1,3};
            Assertions.assertInstanceOf(String.class, printCentre.returnUnsorted(unsortedArray));
        }

        @Test
        @DisplayName("Does it return a string? - returnSorted")
        void doesItReturnAStringReturnSorted() {
            int[] sortedArray = {1,2,3};
            Assertions.assertInstanceOf(String.class, printCentre.returnSorted("Hand sorted",sortedArray));
        }

        @Test
        @DisplayName("Does it return a string? - returnTime")
        void doesItReturnAStringReturnTime() {
            Assertions.assertInstanceOf(String.class, printCentre.returnTime(97384659));
        }

        @Test
        @DisplayName("Does it return a string? - endProgramme")
        void doesItReturnAStringEndProgramme() {
            Assertions.assertInstanceOf(String.class, printCentre.endProgramme());
        }

        @Test
        @DisplayName("Does it return a string? - wordsInChoice")
        void doesItReturnAStringWordsInChoice() {
            Assertions.assertInstanceOf(String.class, printCentre.wordsInChoice());
        }

    }

    @Test
    @DisplayName("push 'Hello World' to console")
    void pushHelloWorldToConsole() {
        printCentre.pushToConsole("Hello World");
    }

    @Test
    @DisplayName("Inserting custom maximum integers in invalidAlgorithmChoice")
    void insertingCustomMaximumIntegersInInvalidAlgorithmChoice() {
        String expectedString = "Sorry, I didn't get that, please try again. Input a number between 1 and 5";
        Assertions.assertEquals(printCentre.invalidAlgorithmChoice(5), expectedString);
    }

    @Test
    @DisplayName("Displaying unsorted array")
    void displayingUnsortedArray() {
        int[] unsortedArray = {2,1,3};
        String expectedString = "Unsorted: [2, 1, 3]";
        Assertions.assertEquals(printCentre.returnUnsorted(unsortedArray), expectedString);
    }

    @Test
    @DisplayName("Displaying sorted array and algorithm")
    void displayingSortedArrayAndAlgorithm() {
        int[] sortedArray = {1,2,3};
        String expectedString = "Hand sorted: [1, 2, 3]";
        Assertions.assertEquals(printCentre.returnSorted("Hand sorted", sortedArray), expectedString);
    }

    @Test
    @DisplayName("Displaying time taken")
    void displayingTimeTaken() {
        String expectedString = "Time taken: 28975 ns";
        Assertions.assertEquals(printCentre.returnTime(28975),expectedString);
    }
}
