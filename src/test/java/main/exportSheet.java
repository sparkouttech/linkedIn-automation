package main;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class exportSheet {

	public static Workbook workbook = new XSSFWorkbook();

	public static void writeDetails(List<String> arrayList) {

		String filePath = "peoples-details.xlsx"; // Path to the output file

		try {

			Sheet sheet = workbook.createSheet("Peoples profile link");

			int rowCount = 0;

			for (String value : arrayList) {

				Row row = sheet.createRow(rowCount++);

				Cell cell = row.createCell(0);
				// Write values to the first column
				cell.setCellValue(value);

			}

			// Write the workbook to the file
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {

				workbook.write(fileOutputStream);

				System.out.print("Details");

			} catch (IOException e) {

				// Error occurred while writing the sheet file.

				e.printStackTrace();

			}

		} catch (Exception e) {

			// Error occurred while creating the sheet file.

			e.printStackTrace();

		}
	}

}
