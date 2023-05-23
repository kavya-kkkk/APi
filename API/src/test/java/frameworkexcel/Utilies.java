package frameworkexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utilies {
	
	
	 public static String[][] ReadXL(String filePath, String sheetName) throws EncryptedDocumentException, IOException
{
		 File file = new File("C:\\Users\\desktop\\eclipse\\API\\report\\exceldata.xlsx");

	        // Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(file);

	        // Create an object of Workbook interface to process the excel file
	        Workbook workbook = WorkbookFactory.create(inputStream);

	        // Get the first worksheet from the excel file
	        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

	        // Iterate over each row in the worksheet
	        for (Row row : sheet) {
	            // Iterate over each cell in the row
	            for (Cell cell : row) {
	                // Print the cell value
	                switch (cell.getCellType()) {
	                    case STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        break;
	                    case NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    case BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue() + "\t");
	                        break;
	                    default:
	                        System.out.print("" + "\t");
	                }
	            }
	            System.out.println();
	        }

	        // Close the workbook and the input stream
	        workbook.close();
	        inputStream.close();
			return null;
	    }

		
	/* public static String[][]   writeXLSheets(String filepath, String sheet, int sheeto, String[][] data)
	 {
		 

		 Workbook workbook = new XSSFWorkbook();
		 Sheet sheet1 = workbook.createSheet("Sheet1");

		 int rownum = 0;
		 File jsonArray;
		for (int i = 0; i < jsonArray.length(); i++) {
		 JSONObject jsonObject = (JSONObject) jsonArray.getJSONObject(i);
		 Row row = sheet1.createRow(rownum++);
		 int cellnum = 0;
		 for (String key : jsonObject.keySet()) {
		 Cell cell = row.createCell(cellnum++);
		 Object obj = jsonObject.get(key);
		 if (obj instanceof String) {
		 cell.setCellValue((String) obj);
		 } else if (obj instanceof Integer) {
		 cell.setCellValue((Integer) obj);
		 } else if (obj instanceof Boolean) {
		 cell.setCellValue((Boolean) obj);
		 }
		 }
		 }

		 FileOutputStream out = new FileOutputStream(filepath);
		 workbook.write(out);
		 out.close();
		 System.out.println("Excel written successfully to " + filepath);
		 }
*/		 }
		 
		 
		 
		 
		 
		 
		 
		 return null;
		 //The method 
	 }
	        
	    }

	
	
	
	

