
public class Burner {
	
	public enum Temperature {
		
		BLAZING("BLAZING"),
        HOT("HOT"),
        WARM("WARM"),
        COLD("COLD");
		
		private String description;
		
		Temperature(String description) {
			// TODO Auto-generated constructor stub
			this.description = description;
		}
		
		@Override
		public String toString() {
			return this.description;
		}
		
	}
	
	// Class Variables
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer = 0;
	// Signifies time for change after button press
	public static final int TIME_DURATION = 2;
	
	public int getTimer() {
		return timer;
	}


	public Burner() {
		super();
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
	}


	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	
	public void plusButton() {
		// Reset timer
		timer = TIME_DURATION;
		// Increase Setting by 1 if needed
		switch (mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case HIGH:
			// No change needed
			return;
		}
	}
	
	public void minusButton() {
		// Reset timer
		timer = TIME_DURATION;
		// Decrease setting by 1 level if needed
		switch (mySetting) {
		case OFF:
			// No change needed
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			return;
		}
	}
	
	
	public void updateTemperature() { // Nested conditionals to make sure the time change affects burner temperatures
	    if (timer > 0) { // Update time if needed
	    	timer--; 
	    }
	    if (timer == 0) { // If the time has been simulated, execute changes
			switch(myTemperature) {
			case COLD -> {
		        if (mySetting != Setting.OFF) {
		            myTemperature = Temperature.WARM;
		            timer = TIME_DURATION;
		        }
		    }
		    case WARM -> {
		        if (mySetting == Setting.MEDIUM || mySetting == Setting.HIGH) {
		            myTemperature = Temperature.HOT;
		            timer = TIME_DURATION;
		        }
		        if (mySetting == Setting.OFF) {
		        	myTemperature = Temperature.COLD;
		        }
		    }
		    case HOT -> {
		        if (mySetting == Setting.HIGH) {
		            myTemperature = Temperature.BLAZING;
		        }
		        else if (mySetting != Setting.MEDIUM) {
		        	myTemperature = Temperature.WARM;
		        }
		    }
		    case BLAZING -> {
		    	if (mySetting != Setting.HIGH) {
		    		myTemperature = Temperature.HOT;
		    	}
		    }
			}
	    }
	}
	
	public boolean display() {
		// To check if any is blazing temperature to turn on the red light
		boolean burnerAlert = false;
		// Print is dependent on the temperature
		switch (myTemperature) {
			case COLD -> System.out.println("[" + mySetting + "]....." + "cooool");
			case WARM -> System.out.println("[" + mySetting + "]....." +"warm");
			case HOT -> System.out.println("[" + mySetting + "]....." +"CAREFUL");
			case BLAZING -> System.out.println("[" + mySetting + "]....." +"VERY HOT! DON'T TOUCH");
		}
		// Search if any Temperature is blazing to signal an alert
		switch (myTemperature) {
			case COLD:
				break;
			case WARM:
				break;
			case HOT: 
				break;
			case BLAZING:
				burnerAlert = true;
				break;
		}
		return burnerAlert;
	}
 	
}
