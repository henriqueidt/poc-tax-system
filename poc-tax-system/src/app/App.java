package app;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import abstracts.State;
import abstracts.Vehicle;
import vehicles.EletricCar;


public class App {
    private static int id = 1;
    static String STATES_PACKAGE = "states";


    public static State getState(String stateAbbr) {
        try {
            String className = STATES_PACKAGE + ".State" + stateAbbr;

            // Usign reflection to get the class
            Class<?> stateClass = Class.forName(className);

            // Using reflection to get the class constructor
            Constructor<?> constructor = stateClass.getConstructor();

            // Instantiate the state
            Object state = constructor.newInstance();
            // Using explicit cast here to return a State type
            return (State) state;

            /* 
            * ClassNotFoundException - If the class is not found
            * NoSuchMethodException - If trying to access a method from the class that doesn't exist
            * IllegalAccessException - If trying to access a method that it doesn't have access (will this be thrown if I call a private method?)
            * InstantiationException - Thrown if trying to instantiate a class, but the class is an abstract class, an interface, an array class, a primitive type, or void
            * InvocationTargetException - If the invoked method or constructor throws an exception, it is wrapped by InvocationTargetException which is thrown
            */
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your state abbr?");
        String stateAbbr = scanner.nextLine();
        State state = getState(stateAbbr);
        
        if(state != null) {
            System.out.println("What is your car model?");
            String carModel = scanner.nextLine();

            System.out.println("What is your car original price?");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a valid value: ");
                scanner.next(); // Remove the invalid input
            }
            double carValue = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("What is the model year?");
            String carYear = scanner.nextLine();

            Vehicle car = new EletricCar(carModel, id++, carValue);
            double taxedPrice = car.calculateTaxedPrice(carYear, state);

            System.out.print("The car price with taxes for this state is: " + taxedPrice + "\n");
        }

    }
}
