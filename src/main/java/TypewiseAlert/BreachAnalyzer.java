package TypewiseAlert;

public class BreachAnalyzer {
	
	public static EnumBreachType inferBreach(double value, double lowerLimit, double upperLimit) {
		EnumBreachType result;
	    if(value < lowerLimit) {
	     result=EnumBreachType.TOO_LOW;
	    }
	    else if(value > upperLimit) {
	       result=EnumBreachType.TOO_HIGH;
	    }
	    else {
	     result=EnumBreachType.NORMAL;
	  }
	    return result;
	}

	  public static EnumBreachType classifyTemperatureBreach( CoolingType coolingType, double temperatureInC) {
	    return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
	  }
}
