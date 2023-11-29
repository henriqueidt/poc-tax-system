package abstracts;
public abstract class State {
  // protected: Accessible within the class, its subclasses, and classes in the same package.
  protected double tax;

  public abstract double getStateTax(String year);
}
