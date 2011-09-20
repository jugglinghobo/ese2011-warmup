package source;

import java.util.Date;

public class Event {
	
	private Calendar calendar;
	private Date startingDate;
	private Date endingDate;
	private boolean isPrivate;

	public Event(Calendar calendar) {
		this.calendar = calendar;
	}

}
