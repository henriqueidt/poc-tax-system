package states.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import states.StateRS;

public class StateRSTest {
  @Test
  @DisplayName("getStateTax should return 0.1 for year 2000")
  public void test2000() {
    StateRS rs = new StateRS();

    double expected = 0.1;
    double result = rs.getStateTax("2000");

    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("getStateTax should return 0.2 for year 2001")
  public void test2001() {
    StateRS rs = new StateRS();

    double expected = 0.2;
    double result = rs.getStateTax("2001");

    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("getStateTax should return 0.3 for year 2002")
  public void test2003() {
    StateRS rs = new StateRS();

    double expected = 0.3;
    double result = rs.getStateTax("2002");

    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("getStateTax should return the default tax(0.5) for a year that's not on any implementation")
  public void test1950() {
    StateRS rs = new StateRS();

    double expected = 0.5;
    double result = rs.getStateTax("1950");

    Assert.assertEquals(expected, result, 0.01d);
  }
}
