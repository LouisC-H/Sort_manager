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

    extensions:
    use generics to ask them what number type they want to use
    Graphing =)
     */
    public static void main( String[] args )
    {
        OrderOfOperations orderOfOperations = new OrderOfOperations();
        orderOfOperations.coordinateOrderOfOperations();
    }
}
