package main;

import java.util.List;

import org.testng.annotations.Test;

public class main {

	@Test()
	public static void test() throws Exception {

		// Login to the linked in

		String userEmail = "";

		String Password = "";

		login.userLogin(userEmail, Password);

		// Search the details with a location

		String searchingKeyWord = "";

		String Country = "";

		sendRequest.searchPeople(searchingKeyWord, Country);

		// Wating time in min, For ex if you need a 2 min break, Just give 2

		int waitingTime = 2;

		// How many pages you want to send a request. One page contain 10 user details

		int pageCount = 1;

		// Export the user profile link with a sheet

		List<String> peopleDetails = sendRequest.sendConnectRequest(pageCount, waitingTime);

		exportSheet.writeDetails(peopleDetails);

	}
}
