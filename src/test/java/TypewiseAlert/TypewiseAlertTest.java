
package TypewiseAlert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypewiseAlertTest {
	private final ByteArrayOutputStream AlertMessage = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(AlertMessage));
	}

	@After
	public void cleanUpStreams() {
	  System.setOut(null);
	}
	
	
	@Test
    public void assertRaiseAlert()
    {
      assertTrue(EnumAlert.raiseAlert(EnumBreachType.TOO_HIGH));
      assertTrue(EnumAlert.raiseAlert(EnumBreachType.TOO_LOW));
      assertFalse(EnumAlert.raiseAlert(EnumBreachType.NORMAL));
}
	
	public void assertController(EnumBreachType breachType) {
		EnumAlert.sendToController(breachType);
		assertTrue(AlertMessage.toString().contains(breachType.toString()));
		AlertMessage.reset();
	}
	
	
	@Test
	public void assertSendController() {
		assertController(EnumBreachType.TOO_HIGH);
		assertController(EnumBreachType.TOO_LOW);
		assertController(EnumBreachType.NORMAL);	
	}
	
	
	public void assertEmailcontent(EnumBreachType breachType) {
		EnumAlert.sendToEmail(breachType);
		assertTrue(AlertMessage.toString().contains(breachType.getMessage()));
		AlertMessage.reset();
	}
	
	@Test
	
	public void assertSendEmail() {
		assertEmailcontent(EnumBreachType.TOO_HIGH);
		assertEmailcontent(EnumBreachType.TOO_LOW);
	}
}
