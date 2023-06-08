package main;

import org.testng.annotations.Test;

public class main {
	
	@Test()
	public static void test() throws Exception {

		String userEmail = "inichocos@gmail.com";

		String Password = "Inichoco420";

		login.userLogin(userEmail, Password);
 
		String name = "Blockchain";

		String country = "Australia";

		sendRequest.searchPeople(name, country);

		int pageCount = 1;

		sendRequest.sendConnectRequest(pageCount);

	}
}
