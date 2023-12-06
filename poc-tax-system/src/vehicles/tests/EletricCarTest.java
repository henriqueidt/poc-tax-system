package vehicles.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import states.StateRS;
import states.StateSP;
import vehicles.EletricCar;

public class EletricCarTest {
  @Test
  @DisplayName("calculateTaxedPrice should return 1100 for price 1000, year 2000 and state RS")
  public void test2000RS() {
    EletricCar eletricCar = new EletricCar("Tesla", 1, 1000);
    double expected = 1100.00;
    double result = eletricCar.calculateTaxedPrice("2000", new StateRS());
    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("calculateTaxedPrice should return 2300 for price 2310, year 2001 and state SP")
  public void test2001SP() {
    EletricCar eletricCar = new EletricCar("Tesla", 1, 2310);
    double expected = 2818.2;
    double result = eletricCar.calculateTaxedPrice("2001", new StateSP());
    Assert.assertEquals(expected, result, 0.01d);
  }
}
