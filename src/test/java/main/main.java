package main;

import org.testng.annotations.Test;

public class main {
	
	@Test()
	public static void test() throws Exception {

		String userEmail = "";

		String Password = "";

		login.userLogin(userEmail, Password);
 
		String name = "Blockchain";

		String country = "Australia";

		sendRequest.searchPeople(name, country);

		int pageCount = 1;

		sendRequest.sendConnectRequest(pageCount);

	}
}
