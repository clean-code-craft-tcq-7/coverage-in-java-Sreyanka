package TypewiseAlert;

public class TypewiseAlert 
{
    public static void checkAndAlert(EnumAlert alertTarget, BatteryCharacter batteryChar, double temperatureInC) {

		EnumBreachType breachType = BreachAnalyzer.classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
 
		if(alertTarget==EnumAlert.TO_CONTROLLER) {
			EnumAlert.sendToController(breachType);
		}else {
			EnumAlert.sendToEmail(breachType);
		}
	
	}
}
