package com.cfsa.qa.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.cfsa.qa.asserts.NewClientAsserts;
import com.cfsa.qa.utils.FileHandeling;
import com.cfsa.qa.utils.Log;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ClientTest extends TestFrameWork {
	@Test
	public void testVerifyCreateNewClient() throws Exception {

		System.out.println("<---------testVerifyCreateNewClient----------->");
		Log.InfoLog("testVerifyCreateNewClient started");
		new Login().toCFSA();
		NewClientAsserts newclientAssertsObj = new NewClientAsserts();
		newclientAssertsObj.verifyCreationOfNewClient();
		Log.InfoLog("testVerifyCreateNewClient completed.");

	}

	@Test
	public void testVerifyClientCancelBtn() throws Exception {

		System.out.println("<---------testVerifyClientCancelBtn----------->");
		Log.InfoLog("testVerifyClientCancelBtn started");
		new Login().toCFSA();
		NewClientAsserts newclientAssertsObj = new NewClientAsserts();
		newclientAssertsObj.verifyClientCancelBtn();
		Log.InfoLog("testVerifyClientCancelBtn completed.");
	}
	
	@Test
	public void testVerifySelectIndustryDropdownValues() throws Exception {
		
		System.out.println("<---------testVerifySelectIndustryDropdownValues----------->");
		Log.InfoLog("testVerifySelectIndustryDropdownValues started");
		new Login().toCFSA();
		NewClientAsserts newclientAssertsObj = new NewClientAsserts();
		newclientAssertsObj.verifySelectIndustryDropdownValues();
		
		Log.InfoLog("testVerifySelectIndustryDropdownValues completed.");
		
	}
	
	@Test
	public void testVerifyCountrySpecificMultiSelectValues() throws Exception {
		
		System.out.println("<---------testVerifyCountrySpecificMultiSelectValues----------->");
		Log.InfoLog("testVerifyCountrySpecificMultiSelectValues started");
		new Login().toCFSA();
		NewClientAsserts newclientAssertsObj = new NewClientAsserts();
		newclientAssertsObj.VerifyCountrySpecificMultiSelectValues();
		Log.InfoLog("testVerifyCountrySpecificMultiSelectValues completed.");
	}
		
@Test
public void testVerifySelectsectorDropdownValues() throws Exception {
	
	System.out.println("<---------testVerifySelectsectorDropdownValues----------->");
	Log.InfoLog("testVerifySelectsectorDropdownValues started");
	String IndustryName;
	new Login().toCFSA();
	String IndustryListValues = FileHandeling.getConfigValue("industryList");
	String[] IndustryListArr=IndustryListValues.split(":");
	NewClientAsserts newclientAssertsObj = new NewClientAsserts();
	for (int i=0 ; i<IndustryListArr.length;i++)
	{
		IndustryName=(IndustryListArr[i].trim());	
		System.out.println("Verifying the Sector dropdown values for the Industry --> "+IndustryName);
		newclientAssertsObj.verifySelectSectorDropdownValues(IndustryName);
		System.out.println("");
		Thread.sleep(5000);
	}

	Log.InfoLog("testVerifySelectsectorDropdownValues completed.");
	}
}
