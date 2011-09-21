package source;

import java.util.Date;

public class Event {
	
	private Date startingDate;
	private Date endingDate;
	private boolean isPublic;
	private String eventInformation;
	private String eventTitle;

	public Event() {
		initEvent();
	}

	private void initEvent() {
		this.eventTitle = Input.promptStringInput("Please enter a Title for this Event\n");
		this.eventInformation = Input.promptStringInput("Please enter the Event description: \n");
		this.startingDate = Input.promptDate("Please enter the start Date of this Event: \n");
		this.endingDate = Input.promptDate("Please enter the end Date of this Event: \n");
		this.isPublic = Input.promptBoolean("would you like to make this Event public? Y/N :\n");
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n" + this.eventTitle.toUpperCase() + "\n\n");
		buffer.append(this.startingDate + " -- ");
		buffer.append(this.endingDate + "\n\n");
		buffer.append(this.eventInformation + "\n\n");
		return buffer.toString();
	}
	
	public String getEventTitle() {
		return this.eventTitle;
	}

	public boolean isPublic() {
		return this.isPublic;
	}

}
