package main;

public class Main {

	public static void main(String args[]) throws Exception {

		// Login credentials for Linked-In

		String userEmail = "";

		String Password = "";

		// Search the details with a location

		String searchingKeyWord = "";

		String Country = "";

		// Wating time in sec, If you need a 2 min wating time, Just give 120

		int waitingTime = 1;

		// How many pages you want to send a request. One page contain 10 user details

		int pageCount = 1;

		// Waiting time per User

		int waitperUser = 2;

		process.callBack(userEmail, Password, searchingKeyWord, Country, waitingTime, pageCount, waitperUser);

	}
}
