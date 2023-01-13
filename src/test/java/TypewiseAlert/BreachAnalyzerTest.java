package TypewiseAlert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BreachAnalyzerTest {
   
	public static String assertBreachAnalyzerMessage(EnumCoolingType coolingType, double temperatureInC) {
		BreachAnalyzer.classifyTemperatureBreach(coolingType,temperatureInC);
		EnumBreachType breachType=BreachAnalyzer.inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
		return breachType.getMessage();
		
	}
	
	 @Test
	    public void assertBreachTester()
	    {
	      assertTrue(assertBreachAnalyzerMessage(EnumCoolingType.PASSIVE_COOLING, 23) == EnumBreachType.NORMAL.getMessage());
	      assertTrue(assertBreachAnalyzerMessage(EnumCoolingType.HI_ACTIVE_COOLING, 46) == EnumBreachType.TOO_HIGH.getMessage());
	      assertTrue(assertBreachAnalyzerMessage(EnumCoolingType.MED_ACTIVE_COOLING, 42) == EnumBreachType.TOO_HIGH.getMessage());
	      assertTrue(assertBreachAnalyzerMessage(EnumCoolingType.HI_ACTIVE_COOLING, -10) == EnumBreachType.TOO_LOW.getMessage());
	      assertFalse(assertBreachAnalyzerMessage(EnumCoolingType.HI_ACTIVE_COOLING, 41) == EnumBreachType.TOO_HIGH.getMessage());
	   
}
}
