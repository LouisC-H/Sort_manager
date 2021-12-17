import controller.OrderOfOperations;

/**
 * Hello world!
 *
 */
public class App 
{

    /*
    Question for markers: Is there some way to re-use tests across multiple classes? I've found that I
    can get away with using essentially identical tests for each class that implements Sortable (ie
    each sorting algorithm), which is nice but if I know anything about coding it's that if you're
    repeating yourself, there's always an alternative solution to make things even more streamlined
    solution.

    KNOWN BUG: when if a binary tree sort is carried out AFTER a BubbleSort (3) or DefaultSort (4), and the list size is relatively large
    (5000 is about the largest you can safely go), the code throws up a StackOverflow error. Normally the tree sort can handle much, much larger
    numbers (Note: using logging, we can see that the tree sorter doesn't seem to get stuck or anything??)

    extensions:

    go back over and check to add more tests
    extensive logging (multiple file outputs?)
    set up code so that it can very easily be extended with new sorting algorithms
    use generics to ask them what number type they want to use
    Graphing =)

    More confidence, clean code
     */
    public static void main( String[] args )
    {
        OrderOfOperations orderOfOperations = new OrderOfOperations();
        orderOfOperations.coordinateOrderOfOperations();
    }
}
