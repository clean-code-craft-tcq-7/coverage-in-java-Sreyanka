package TypewiseAlert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BreachAnalyzerTest {
   
	public static String assertBreachAnalyzerMessage(CoolingType coolingType, double temperatureInC) {
		BreachAnalyzer.classifyTemperatureBreach(coolingType,temperatureInC);
		BreachType breachType=BreachAnalyzer.inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
		return breachType.getMessage();
		
	}
	
	 @Test
	    public void assertBreachTester()
	    {
	      assertTrue(assertBreachAnalyzerMessage(CoolingType.PASSIVE_COOLING, 23) == BreachType.NORMAL.getMessage());
	      assertTrue(assertBreachAnalyzerMessage(CoolingType.HI_ACTIVE_COOLING, 46) == BreachType.TOO_HIGH.getMessage());
	      assertTrue(assertBreachAnalyzerMessage(CoolingType.MED_ACTIVE_COOLING, 42) == BreachType.TOO_HIGH.getMessage());
	      assertTrue(assertBreachAnalyzerMessage(CoolingType.HI_ACTIVE_COOLING, -10) == BreachType.TOO_LOW.getMessage());
	      assertFalse(assertBreachAnalyzerMessage(CoolingType.HI_ACTIVE_COOLING, 41) == BreachType.TOO_HIGH.getMessage());
	   
}
}
