package main;

public class main {

	public static void main(String[] args) throws Exception {

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
