package source;

import java.util.ArrayList;


public class UserInterface {
	ArrayList<User> users = new ArrayList<User>();
	private User loggedIn;
	
	public UserInterface() {
		promptMenu();
	}

	public void promptMenu() {
		displayMenuOptions();
		int option = Input.promptIntInput("");
		switch(option) {
		//log in
		case 0: {
			userLogIn();
		} break;
		// add new user
		case 1: {
			addNewUser();
		} break;
		// list users
		case 2: {
			displayUsers();
		} break;
		case 3: {
			displayPublicEvents();
		}
		}
		promptMenu();
	}

	private void userLogIn() {
		String username = Input.promptStringInput("please enter your username: \n");
		if (this.users.isEmpty()) {
			System.out.println("You are not a registered User. Please go away!");
		} else {
			for (User u : this.users) {
				if (username.equals(u.getName())) {
					String password = Input.promptStringInput("Please enter your password: \n");
					if (password.equals(u.getPassword())) {
						this.loggedIn = u;
						loggedIn.promptMenu();
					} else {
						System.out.println("Wrong Password");
					}
				}
			}
		}
	}

	private void addNewUser() {
		String username = Input.promptStringInput("please enter your username: \n");
		String password = Input.promptStringInput("Please enter your password: \n");
		User newUser = new User(username, password, this);
		this.users.add(newUser);
		System.out.println("User " + newUser + " added.\n");
	}
	
	private void displayMenuOptions() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n********\n");
		buffer.append("iCal 2.0\n");
		buffer.append("********\n");
		buffer.append("0: Log in\n");
		buffer.append("1. Add new User\n");
		buffer.append("2. List Users\n");
		buffer.append("3: Display public Events");
		System.out.println(buffer.toString());
	}
	
	public void displayUsers() {
		if (this.users.isEmpty()) {
			System.out.println("There are currently no users registered.\n");
		} else {
			int i = 0;
			System.out.println("registered Users: \n");
			for (User u : this.users) {
				System.out.println(i + ": " + u.toString());
				i++;
			}
		}
	}
	
	public void displayPublicEvents() {
		for (User user : this.users) {
			user.displayPublicEvents();
		}
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public static void main(String[] args) {
		new UserInterface();
	}
}
