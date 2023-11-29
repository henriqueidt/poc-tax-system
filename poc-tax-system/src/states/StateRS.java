package states;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import abstracts.State;

public class StateRS extends State {
  private double tax = 0.5;
  
  public StateRS() {}

  public double getStateTaxFor2000() {
    return 0.1;
  }

  public double getStateTaxFor2001() {
    return 0.2;
  }

  public double getStateTaxFor2002() {
    return 0.3;
  }

  // @Override annotation provides a compile-time check if the method doesn't correctly override the superclass method
  @Override
  public double getStateTax(String year) {
    String methodName = "getStateTaxFor" + year;

    try {
      // Gets the specific method by name from the class
      Method method = StateRS.class.getDeclaredMethod(methodName);
      /* 
       * Using explicit type cast (double) here.
       * The invoke() method of the class Method returns an Object by default, because it needs to accomodate the return types of various methods
       * That's why we need to tell the compiler here that the method invocation will return a double using explicit cast
       * We pass `this`(the class) as parameter, so invoke knows which is the object from which to call the method
       */
      return (double) method.invoke(this);
      /* 
       * NoSuchMethodException - If the method is not found within the class
       * IllegalAccessException - If trying to access a method that it doesn't have access (will this be thrown if I call a private method?)
       * InvocationTargetException - If the invoked method throws an exception, it is wrapped by InvocationTargetException which is thrown
       */
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      /* 
       * let's assume that only NoSuchMethodException will be thrown in this case,
       * which means that the state doesn't have special rules for the given year, therefore it returns the default tax
       */
      return tax;
    }
  }
}
