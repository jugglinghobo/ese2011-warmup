package source;

import java.util.ArrayList;

public class Calendar {
	
	private User owner;
	private ArrayList<Event> events = new ArrayList<Event>();

	public Calendar(User owner) {
		this.owner = owner;
	}

	public void displayEvents() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n" + owner.getName() + " 's Calendar\n");
		if (this.events.isEmpty()) {
			System.out.println("You have no Events in your Calendar.\n");
		} else {
			for (Event e : this.events) {
				buffer.append(e.toString());
			}
		}
		System.out.println(buffer.toString());
	}

	public void addEvent(Event event) {
		this.events.add(event);
	}

	public ArrayList<Event> getEvents() {
		return this.events;
	}

	public User getOwner() {
		return this.owner;
	}
}
