import controller.OrderOfOperations;

/**
 * Hello world!
 *
 */
public class App 
{

    /*
    extensions:

    go back over and check to add more tests
    add docstrings
    extensive logging (multiple file outputs?)
    use generics to ask them what number type they want to use
    set up code so that it can very easily be extended with new sorting algorithms
    Graphing =)

    More confidence, clean code
     */
    public static void main( String[] args )
    {
        OrderOfOperations orderOfOperations = new OrderOfOperations();
        orderOfOperations.coordinateOrderOfOperations();
    }
}
