package states.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import states.StateSP;

public class StateSPTest {
  @Test
  @DisplayName("getStateTax should return 0.11 for year 2000")
  public void test2000() {
    StateSP rs = new StateSP();

    double expected = 0.11;
    double result = rs.getStateTax("2000");

    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("getStateTax should return 0.22 for year 2001")
  public void test2001() {
    StateSP rs = new StateSP();

    double expected = 0.22;
    double result = rs.getStateTax("2001");

    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("getStateTax should return 0.33 for year 2002")
  public void test2003() {
    StateSP rs = new StateSP();

    double expected = 0.33;
    double result = rs.getStateTax("2002");

    Assert.assertEquals(expected, result, 0.01d);
  }

  @Test
  @DisplayName("getStateTax should return the default tax(0.5) for a year that's not on any implementation")
  public void test1950() {
    StateSP rs = new StateSP();

    double expected = 1.0;
    double result = rs.getStateTax("1950");

    Assert.assertEquals(expected, result, 0.01d);
  }
}
