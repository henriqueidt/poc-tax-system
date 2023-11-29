package states;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import abstracts.State;

public class StateSP extends State {
  private double tax = 1;
  
  public StateSP() {}

  public double getStateTaxFor2000() {
    return 0.11;
  }

  public double getStateTaxFor2001() {
    return 0.22;
  }

  public double getStateTaxFor2002() {
    return 0.33;
  }

  @Override
  public double getStateTax(String year) {
    String methodName = "getStateTaxFor" + year;

    try {
      Method method = StateSP.class.getDeclaredMethod(methodName);
      return (double) method.invoke(this);
      
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      
      return tax;
    }
  }
}
