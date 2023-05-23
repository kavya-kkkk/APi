package frameworkexcel;
import org.json.simple.JSONObject;

import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExcelRestApi {

	static String vCommand, vURI, vPayload;

	static String eCode, eBody, eTime;
	static String aBody;
	static int aCode;
	static long aTime;
	static Response resp = null;
	static JsonParser parser = new JsonParser();
	static JSONObject myJSON =new JSONObject();
	static RequestSpecification reqSpec;
	static String[][] xlData;
	static String xlFile, xlFile_Res;
	static String vResult;

	public static void main(String[] args) throws Exception {
// Organize FW flow
// 1. Read the excel tests into the code.
// JAR - Apache POI (Poor Obfuscation Interface)
// HSSF Horrible Spread Sheets Format
// 2. 2d Array to store the test details

		xlFile = "C:\\Users\\desktop\\eclipse\\API\\report\\exceldata.xlsx";
		xlFile_Res = "C:\\Trainings\\API_Mar2022\\Tests3_Res.xls";
		xlData = Utilies.ReadXL(xlFile, "TestCases");
		int vRows = xlData[0].length;
		System.out.println("Rows are " + vRows);
		// 3. Go through each row
		for (int i = 2; i < vRows; i++) {

			System.out.println("TCID : " + xlData[i][0]);

			// 4. If Execute is Y
			if (xlData[i][2].equals("Y")) {

				// 5. Identify command, URI, Payload
				vCommand = xlData[i][3];
				vURI = xlData[i][4];
				vPayload = xlData[i][5];
				RestAssured.baseURI = vURI;
				reqSpec = RestAssured.given();
				// 6. Execute Command
				//executeCommand();
				// 7. Verify Results
				// Expected Result :

				// 7. Verify Results // Expected Result :
				VerifyResult(i);

			}

			else {
				// Skip this TC and go to the next one.
				vResult = "Skipped";
				xlData[i][15] = vResult;
				System.out.println("Skipping");
			
		}
		}}
	/*
	 * // 8. Export results. Utilities.writeXLSheets(xlFile_Res, "TestCaseResults",
	 * 1, xlData); }
	 * 
	 * public static void executeCommand() throws Exception {
	 * System.out.println("Executing - " + vCommand); switch (vCommand) { case
	 * "GET": System.out.println("Inside Get"); resp = reqSpec.request(Method.GET);
	 * break; case "POST": myJSON = (JSONObject) parser.parse(vPayload);
	 * reqSpec.body (myJSON. toJSONString()); resp = reqSpec.request(Method.POST);
	 * break; case "DELETE" : // myJSON = (JSONObject) parser.parse(vPayload); //
	 * reqSpec.body (my JSON. toJSONString()); resp =
	 * reqSpec.request(Method.DELETE); break; case "PUT": myJSON =
	 * (JSONObject)parser.parse(vPayload); reqSpec.body (myJSON. toJSONString());
	 * resp = reqSpec.request(Method.PUT); break; case "PATCH": myJSON =
	 * (JSONObject) parser.parse(vPayload); reqSpec.body (myJSON.toJSONString());
	 * resp = reqSpec.request(Method.PATCH); break; default:
	 * System.out.println("command namme doesnt exist -"+ vCommand);); }
	 * 
	 * }
	 */
	public static void VerifyResult(int i) {
		eCode=xlData[i][7];
		eBody=xlData[i][8];
		eCode=xlData[i][9];
		
		aCode=resp.statusCode();
		aBody=resp.asString();
		aTime=resp.time();
		
		
		System.out.println("Response is >>"+ resp);
		System.out.println("Status Code is >>"+ resp.statusCode());
		System.out.println("Body is >>>"+ resp.asString());
		System.out.println("Time in ms is  >>>"+ resp.time());
		
		
		if (aCode==Integer.parseInt(eCode)){
			System.out.println("Status Match");
			vResult="pass";
		}
	
	else {
		System.out.println("Status Mis Match"); 
		vResult = "Fail";
		}
		if (aBody.equals(eBody)) 
		{
		System.out.println("Body Match"); 
		}
		else {
		System.out.println("Body Mis Match");
		}
		if (aTime<Long.parseLong (eTime)) {
		System.out.println("Time lesser than expected.");
		}
		else { 
			System.out.println("Time more than expected.");
		}
		System.out.println("--------------");
		System.out.println("--------------");
		xlData[i][11] = String.valueOf(aCode);
		xlData[i][12] = aBody;
		xlData[i][13] = String.valueOf(aTime);
		xlData[i][15] = vResult;
		}
		
	}
	

