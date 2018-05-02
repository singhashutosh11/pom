package com.cfsa.qa.asserts;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cfsa.qa.pages.ClientPage;
import com.cfsa.qa.pages.DashboardPage;
import com.cfsa.qa.tests.TestFrameWork;
import com.cfsa.qa.utils.FileHandeling;
import com.cfsa.qa.utils.Log;

public class NewClientAsserts extends TestFrameWork {

	public void verifyClientCancelBtn() throws Exception {

		DashboardPage dp = PageFactory
				.initElements(driver, DashboardPage.class);
		dp.clickOnClientButton();

		Thread.sleep(5000);

		ClientPage clientPage = PageFactory.initElements(driver,
				ClientPage.class);
		clientPage.enterClientName();
		clientPage.selectIndustry("Consumer & Industrial Products");
		clientPage.selectSector("Aerospace & Defense");
		clientPage.selectGeography("Global");
		clientPage.enterBusinessUnit("Deloitte Consulting Unit");
		clientPage.clickOnCancel();
		dp = PageFactory.initElements(driver, DashboardPage.class);
		Assert.assertTrue(dp.clientNameIsDisplayed("Deloitte"));

	}

	public void verifyCreationOfNewClient() throws Exception {
		// try{
		DashboardPage dp = PageFactory
				.initElements(driver, DashboardPage.class);
		dp.clickOnClientButton();

		Thread.sleep(3000);

		ClientPage clientPage = PageFactory.initElements(driver,
				ClientPage.class);
		clientPage.enterClientName();
		clientPage.selectIndustry("Consumer & Industrial Products");
		Thread.sleep(3000);
		clientPage.selectSector("Aerospace & Defense");
		clientPage.selectGeography("Global");
		// clientPage.selectGeography("Country Specific");
		// clientPage.selectMultipleValues(new
		// String[]{"Afghanistan","Aland Islands"});
		clientPage.enterBusinessUnit("Deloitte Consulting Unit");
		Thread.sleep(3000);
		clientPage.clickOnSaveClientInfo();
		Thread.sleep(3000);
		dp = PageFactory.initElements(driver, DashboardPage.class);
		Assert.assertTrue(dp.clientNameIsDisplayed("Deloitte"));

		// }catch(Exception e){
		// Log.errorLog(null, e);
		// }

	}

	public void verifySelectIndustryDropdownValues() throws Exception {

		DashboardPage dp = PageFactory
				.initElements(driver, DashboardPage.class);
		dp.clickOnClientButton();

		Thread.sleep(5000);

		ClientPage clientPage = PageFactory.initElements(driver,
				ClientPage.class);
		clientPage.enterClientName();

		List<String> industry = clientPage.getAllIndustryList();
		System.out.println(industry);
		String industryDropdownValues = FileHandeling
				.getConfigValue("industryList");
		String[] industryArr = industryDropdownValues.split(":");
		int length = industry.size();
		System.out.println(length);
		System.out.println(industryArr.length);

		for (int i = 0, j = 0; i <= length - 1 & j <= industryArr.length - 1; i++, j++) {
			String industryListValue = industry.get(i);
			String industryArrValue = industryArr[j];
			Assert.assertEquals(industryListValue, industryArrValue);
		}

	}

	public void VerifyCountrySpecificMultiSelectValues() throws Exception {

		DashboardPage dp = PageFactory
				.initElements(driver, DashboardPage.class);
		dp.clickOnClientButton();

		Thread.sleep(5000);

		ClientPage clientPage = PageFactory.initElements(driver,
				ClientPage.class);
		clientPage.enterClientName();
		clientPage.selectIndustry("Consumer & Industrial Products");
		Thread.sleep(5000);
		clientPage.selectSector("Aerospace & Defense");
		// clientPage.selectGeography("Global");
		clientPage.selectGeography("Country Specific");
		List<String> countries = clientPage.getAllCountrySpecificValues();
		System.out.println(countries);
		String countryListValues = FileHandeling.getConfigValue("countryList");
		String[] countryListArr = countryListValues.split(":");
		int length = countries.size();
		System.out.println(length);
		System.out.println(countryListArr.length);
		// for(int k=0; k<= countryListArr.length; k++){
		//
		// System.out.print(countryListArr[k]+",");
		// }
		for (int i = 0, j = 0; i <= length - 1 & j <= countryListArr.length - 1; i++, j++) {
			String countryListValue = countries.get(i).trim();
			String countryArrValue = countryListArr[j].trim();
			System.out.println("Actual:- " + countryListValue
					+ "      Expected:-" + countryArrValue);
			// Assert.assertEquals(countryArrValue, countryListValue);
			Assert.assertEquals("Verifying client country specific values", countryArrValue,
					countryListValue);
		}

	}
	
	public void ClickOnNewClient() throws Exception
	{	
		DashboardPage dp = PageFactory.initElements(driver, DashboardPage.class);
		dp.clickOnClientButton();
		Thread.sleep(5000);
		ClientPage clientPage = PageFactory.initElements(driver,ClientPage.class);
	}
	
	public void verifySelectSectorDropdownValues(String Industry) throws Exception {

		DashboardPage dp = PageFactory
				.initElements(driver, DashboardPage.class);
	
		if(Industry.equalsIgnoreCase("Consumer & Industrial Products"))
		{
			System.out.println("== Clicking on new client ==");
			dp.clickOnClientButton();
		}

		Thread.sleep(5000);

		ClientPage clientPage = PageFactory.initElements(driver,
				ClientPage.class);
			
		String SectorDropdownValues = null;
		
		switch(Industry)
		{
			case "Consumer & Industrial Products":
				System.out.println("Getting sector values for Industry "+Industry);
				SectorDropdownValues = FileHandeling.getConfigValue("ConsumerIndustry");
				break;
			case "Financial Services & Insurance":
				System.out.println("Getting sector values for Industry "+Industry);
				SectorDropdownValues = FileHandeling.getConfigValue("FinancialIndustry");
				break;
			case "Energy & Resources":
				System.out.println("Getting sector values for Industry "+Industry);
				SectorDropdownValues = FileHandeling.getConfigValue("EnergyIndustry");
				break;
			case "Life Sciences & Healthcare":
				System.out.println("Getting sector values for Industry "+Industry);
				SectorDropdownValues = FileHandeling.getConfigValue("LifeScienceIndustry");
				break;
			case "Public Sector":
				System.out.println("Getting sector values for Industry "+Industry);
				SectorDropdownValues = FileHandeling.getConfigValue("PublicSectorIndustry");
				break;
			case "Tech, Media & Telecom":
				System.out.println("Getting sector values for Industry "+Industry);
				SectorDropdownValues = FileHandeling.getConfigValue("TechMediaTelecomIndustry");
				break;
			default :
				System.out.println("Invalid Industry selected");
		}
        
		clientPage.selectIndustry(Industry);
    	Thread.sleep(5000);
		
		
		System.out.println("The configfile values read for INDUSTRY "+Industry+"are ---> "+SectorDropdownValues);
		
		List<String> sector = clientPage.getAllsectorList();
		System.out.println("The Sector dropdown values on the application are ---> "+sector);
		/*String sectorListValues = FileHandeling
				.getConfigValue(SectorDropdownValues);
		String[] industryArr = sectorListValues.split(":");
*/		
		String[] sectorArr = SectorDropdownValues.split(":");
		int length = sector.size();
		System.out.println(length);
		System.out.println(sectorArr.length);

		for (int i = 0, j = 0; i <= length - 1 & j <= sectorArr.length - 1; i++, j++) {
			String sectorListValue = sector.get(i).trim();
			String sectorArrValue = sectorArr[j].trim();
			System.out.println("Actual:- " + sectorListValue
					+ "      Expected:-" + sectorArrValue);			
			Assert.assertEquals(sectorListValue, sectorArrValue);
		}

	}		
		
}
