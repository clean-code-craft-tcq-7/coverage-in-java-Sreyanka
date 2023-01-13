package TypewiseAlert;

public enum EnumBreachType {
	      NORMAL("Temperature is normal"),
	      TOO_LOW("Hi, the temperature is too low"),
	      TOO_HIGH("Hi, the temperature is too high");

	public String message;
	
		EnumBreachType(String message) {
			this.message=message;
		}
 public String getMessage() {
	 return message;
 }

};
