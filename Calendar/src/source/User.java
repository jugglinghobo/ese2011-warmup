package source;

import java.util.ArrayList;

public class User {
	private Calendar calendar;
	private String name;
	private String password;
	private UserInterface ui;
	
	public User(String name, String password, UserInterface ui) {
		this.name = name;
		this.password = password;
		this.ui = ui;
		this.calendar = new Calendar(this);
	}
	
	public void promptMenu() {
		displayMenuOptions();
		int option = Input.promptIntInput("");
		switch(option) {
		//logout
		case 0: {
			logOut();
		} break;
		// add new event
		case 1: {
			Event newEvent = new Event();
			System.out.println("Successfully created new Event: " + newEvent.toString());
			if (newEvent.isPublic()) {
				System.out.println("this is a public event");
			}
			calendar.addEvent(newEvent);
		} break;
		// display my events
		case 2: {
			calendar.displayEvents();
		} break;
		//display public events from other user
		case 3: {
			displayOtherUserEvents();
		} break;
		//display all public events
		case 4: {
			ui.displayPublicEvents();
		} break;
		}
		promptMenu();
		
	}

	private void displayOtherUserEvents() {
		ui.displayUsers();
		ArrayList<User> users = ui.getUsers();
		int user = Input.promptIntInput("Please choose the User whose public events you would like to see");
		while (0 > user || user > users.size()) {
			user = Input.promptIntInput("Please choose the User whose public events you would like to see");
		}
		User chosenUser = users.get(user);
		chosenUser.displayPublicEvents();
		
	}

	private void logOut() {
		ui.promptMenu();
	}

	private void displayMenuOptions() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("***********************\n");
		buffer.append("iCal 2.0 Ð " + toString() + "\n");
		buffer.append("***********************\n");
		buffer.append("0: Log out\n");
		buffer.append("1. Add new Event\n");
		buffer.append("2. Display my Events\n");
		buffer.append("3: Display public Events from another User\n");
		buffer.append("4: Display all public Events\n");
		System.out.println(buffer.toString());
	}

	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String toString() {
		return this.name;
	}

	public void displayPublicEvents() {
		if (!calendar.getEvents().isEmpty()) {
			System.out.println(toString() + "'s public events: ");
			for (Event event : calendar.getEvents()) {
				if (event.isPublic()) {
					System.out.println(event.toString());
				}
			}
		}
	}

}
