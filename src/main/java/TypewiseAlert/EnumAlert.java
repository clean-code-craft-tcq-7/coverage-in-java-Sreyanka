package TypewiseAlert;

public enum EnumAlert {
	TO_CONTROLLER, TO_EMAIL;
	
	public static boolean raiseAlert(EnumBreachType breachType) {
		return breachType!=EnumBreachType.NORMAL;
	}

	public static void sendToController(EnumBreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%d : %s\n", header, breachType);
	}

	public static void sendToEmail(EnumBreachType breachType) {
		String recepient = "sreyanka@gmail.com";
		if(raiseAlert(breachType))
			System.out.printf("To: %s\n", recepient);
			System.out.println(breachType.getMessage());
		}
	}
