package vehicles;

import abstracts.State;
import abstracts.Vehicle;

public class EletricCar extends Vehicle {

  public EletricCar(String model, int id, double price) {
    this.model = model;
    this.id = id;
    this.price = price;
  }

  @Override
  public double calculateTaxedPrice(String year, State state) {
    Double tax = state.getStateTax(year);
    return price + price * tax;
  }
}
