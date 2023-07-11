package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AddSheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.SheetProperties;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class writeSheet {

    public static Sheets sheetsService;

    private static String SPREADSHEET_ID = "1yVAuz6ToLMEMGP719Vrwum8dNAI23pZNGC51b0iffY8";

    public static String getTime() {

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Create a formatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Format the date and time as a string
        String currentDateTimeString = formatter.format(now);

        return currentDateTimeString;

    }

    public static String sheetName(String searchingKeyWord, String Country){

        String currentTime = getTime();

        String sheetName = searchingKeyWord + " in " + Country + " on " + currentTime;

        return sheetName;
    }

    public static void createnewSeparatesheet(String sheetName) {

        try {

            Sheets sheetsService = SheetsServiceUtil.getSheetsService();

            // Define properties of the new sheet
            SheetProperties newSheetProperties = new SheetProperties()
                    .setTitle(sheetName);

            // Create the new sheet
            Sheet newSheet = new Sheet().setProperties(newSheetProperties);

            Spreadsheet spreadsheet = sheetsService.spreadsheets().get(SPREADSHEET_ID).execute();

            List<Sheet> sheets = spreadsheet.getSheets();

            // Add the new sheet to the list of sheets
            List<Request> requests = new ArrayList<>();
            requests.add(new Request()
                    .setAddSheet(new AddSheetRequest()
                            .setProperties(newSheetProperties)));

            // Update the spreadsheet with the new sheet
            BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
                    .setRequests(requests);

            sheetsService.spreadsheets().batchUpdate(SPREADSHEET_ID, batchUpdateRequest).execute();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void importUserdetails(List<List<Object>> values, String sheetName) throws Exception {

        Sheets sheetsService = SheetsServiceUtil.getSheetsService();

        List<List<Object>> values1 = new ArrayList<>();

        for (List<Object> stringRow : values) {

            List<Object> objectRow = new ArrayList<>(stringRow);

            values1.add(objectRow);
        }

        BatchUpdateValuesRequest requestBody = new BatchUpdateValuesRequest();

        requestBody.setValueInputOption("USER_ENTERED");

        requestBody.setData(Arrays.asList(new ValueRange().setRange(sheetName + "!A1:C100").setValues(values)));

        sheetsService.spreadsheets().values().batchUpdate(SPREADSHEET_ID, requestBody).execute();
    }

}
