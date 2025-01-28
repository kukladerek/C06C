
public enum Setting {
	
	OFF("---"),
    LOW("--+"),
    MEDIUM("-++"),
    HIGH("+++");

	private String rep;
	
	Setting(String rep) {
		// TODO Auto-generated constructor stub
		this.rep = rep;
	}
	
	@Override
	public String toString() {
		return this.rep;
	}
	
}
