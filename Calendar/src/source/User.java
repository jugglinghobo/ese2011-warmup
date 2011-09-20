package source;

public class User {
	private Calendar calendar;
	private String name;
	
	public User() {
		this.calendar = new Calendar(this);
	}

}
