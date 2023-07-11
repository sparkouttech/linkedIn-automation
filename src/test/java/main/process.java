package main;

import java.util.List;

public class process {

    // Login to the linked in

    public static void callBack(String userEmail, String Password, String searchingKeyWord, String Country,
            int waitingTime, int pageCount, int waitperUser) throws Exception {

        login.userLogin(userEmail, Password);

        // Search the details with a location

        sendRequest.searchPeople(searchingKeyWord, Country);

        // Export the user profile link with a sheet

        List<List<Object>> peopleDetails = sendRequest.sendConnectRequest(pageCount, waitingTime, waitperUser);

        String sheetName = writeSheet.sheetName(searchingKeyWord, Country);

        writeSheet.createnewSeparatesheet(sheetName);

        writeSheet.importUserdetails(peopleDetails, sheetName);

    }

}
