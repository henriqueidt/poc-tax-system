package app.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import abstracts.State;
import app.App;
import states.StateRS;

public class AppTest {
  @Test
  @DisplayName("getState should return an instance of StateRS if RS is passed as parameter")
  public void testGetStateRS() {
    State state = App.getState("RS");
    Assert.assertTrue(state instanceof StateRS);
  }

  @Test
  @DisplayName("getState should return null if the abbreviation of a state that does not exist is passed as parameter")
  public void testGetStateNull() {
  State state = App.getState("OI");
    Assert.assertNull(state);
  }
}
