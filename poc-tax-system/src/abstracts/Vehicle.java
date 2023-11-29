package abstracts;
public abstract class Vehicle {
  protected String model;
  protected int id;
  protected double price;

  public abstract double calculateTaxedPrice(String year, State state);
}
