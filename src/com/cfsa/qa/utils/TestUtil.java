package com.cfsa.qa.utils;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class TestUtil {
	// true - Y
	// false - N
	/**
	 * Function to check whether test case can be executed or not.
	 * @testCase - Name of the testCase
	 * @Xls_Reader - Xls_Reader object
	 */
	public static boolean isTestCaseExecutable(String testCase, XlsReader xls){
		/* iterate through the rows of Test Cases sheet from 2nd row till testCase
		name is equal to the value in TCID column.*/
		for(int rNum=2; rNum<=xls.getRowCount("Test Cases"); rNum++){
			//Checks whether testCase(passes value) name is equals to the value in TCID
			if(testCase.equals(xls.getCellData("Test Cases", "TCID", rNum))){
				// check runmode is equals to Y/N. Returns true if Y else return false
				if(xls.getCellData("Test Cases", "Runmode", rNum).equals("Y"))
					return true;
				else
					return false;
			}				
		}		
		return false;		
	}
	
	/**
	 * Method to skip the test case based on RunMode value
	 * 
	 * @param methodName, data
	 * @return flag
	 */
	public static boolean isExecutable(String methodName,
			Hashtable<String, String> data, XlsReader xls) {

		boolean flag = false;

		// Skips the test case if runmode is set to N
		if (!TestUtil.isTestCaseExecutable(methodName, xls)) {

			Log.InfoLog("Skipping the test '" + methodName
					+ "' as testcase Runmode is set to: NO");
			flag = true;
		}

		if (flag == false) {
			// Skips the testcase based on the runmode in Test Data sheet
			if (!data.get("RunMode").equals("Y")) {
				Log.InfoLog("Skipping the execution of '"
						+ methodName
						+ "' as Runmode of test data is set to: NO");
				flag = true;
			}
		}

		return flag;
	}
	
	/**
	 * Function to get data from xls sheet in 2 dimensional array
	 * @param testCase - testCase name
	 * @param xls - Xls_Reader Object
	 * @return 2 dimensional array
	 */
	public static Object[][] getData(String testCase, XlsReader xls, String sheetName){
		Log.InfoLog("******getData*******: "+testCase);
		System.out.println("******getData*******: "+testCase);
		// find the test in xls
		// find number of cols in test
		// number of rows in test
		// put the data in hashtable and put hashtable in object array
		// return object array		
		int testCaseStartRowNum=0;
		//iterate through all rows from the sheet Test Data
		for(int rNum=1; rNum<=xls.getRowCount(sheetName); rNum++){
			//to identify testCase starting row number
			if(testCase.equals(xls.getCellData(sheetName, 0, rNum))){
				testCaseStartRowNum = rNum;
				break;
			}
		}
		Log.InfoLog("Test Starts from row -> "+ testCaseStartRowNum);
		System.out.println("Test Starts from row -> "+ testCaseStartRowNum);				
		// total cols
		int colStartRowNum=testCaseStartRowNum+1;
		int cols=0;
		//Get the total number of columns for which test data is present
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		System.out.println("Total cols in test -> "+ cols);		
		// rows
		int rowStartRowNum=testCaseStartRowNum+2;
		int rows=0;
		//Get the total number of rows for which test data is present
		while(!xls.getCellData(sheetName, 0, (rowStartRowNum+rows)).equals("")){
			rows++;
		}
		System.out.println("Total rows in test -> "+ rows);
		Object[][] data = new Object[rows][1];
		Hashtable<String,String> table=null;		
		// print the test data
		for(int rNum=rowStartRowNum;rNum<(rows+rowStartRowNum);rNum++){
			table=new Hashtable<String,String>();
				for(int cNum=0;cNum<cols;cNum++){
					table.put(xls.getCellData(sheetName, cNum, colStartRowNum), xls.getCellData(sheetName, cNum, rNum));
					System.out.print(xls.getCellData(sheetName, cNum, rNum)+" - ");
				}
				data[rNum-rowStartRowNum][0]=table;
		}
		return data;// dummy								
	}
	
	/**
	 * Function to get start row number
	 * @param xls - Xls_Reader Object
	 * @param xls - row number
	 */
	public static int startRow(XlsReader xls, int rowNum){
		String testCaseStartRow= null;
		testCaseStartRow = xls.getCellData("Test Cases", 3, rowNum);
		int testCaseStartRowNum = Integer.parseInt(testCaseStartRow);
			return testCaseStartRowNum;
	}
	/**
	 * Function to get End row number
	 * @param xls - Xls_Reader Object
	 * @param xls - row number
	 */
	public static int endRow(XlsReader xls, int rowNum){
		String testCaseEndRow= null;
		testCaseEndRow = xls.getCellData("Test Cases", 4, rowNum);
		int testCaseEndRowNum = Integer.parseInt(testCaseEndRow);
			return testCaseEndRowNum;
	}
	@DataProvider(name = "parameter")
	public static Object [] []createDataSet(){

		return new Object[][] {

				{	"ashu", 35},
				{ "ashu1", 37},
		};

	}
}

