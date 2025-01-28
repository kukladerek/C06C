
public class Burner {
	
	public enum Temperature {
		
		BLAZING("BLAZING"),
        HOT("HOT"),
        WARM("WARM"),
        COLD("COLD");
		
		private String decription;
		
		public void Temperture(String description) {
			this.decription = description;
		}
		
		Temperature myTemperature;
		
		
	}
}
