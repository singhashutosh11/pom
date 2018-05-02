package com.cfsa.qa.tests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.cfsa.qa.utils.FileHandeling;
import com.cfsa.qa.utils.Log;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class TestFrameWork implements ITestListener {

	protected static WebDriver driver;
	protected static InternetExplorerDriverService service;
	protected static JavascriptExecutor jse;

	// public String browserName = FileHandeling.getConfigValue("browser");

	@BeforeMethod
	public void openBroswer() throws Exception {

		 PropertyConfigurator.configure(System.getProperty("user.dir")
		 + "/src/log4j.properties");
		String browserName = FileHandeling.getConfigValue("browser");
		// open broswer logics for opening broswer Firefox or chrome after
		// reading config
		if (browserName.equalsIgnoreCase("chrome")) {
			// start chrome driver instance
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//			capabilities.setCapability("chrome.binary", "/Applications/Chrome.app/Contents/MacOS/applet Google Chrome.app/");
			System.setProperty("webdriver.chrome.driver", System.getProperty("/Applications/Chrome.app/Contents/MacOS/applet Google Chrome.app/"));
			driver = new ChromeDriver();
			//Log.InfoLog("Chrome Browser opened.");

		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			// start firefox driver instance
			// FirefoxBinary binary = new FirefoxBinary(new File(
			// "C:/Program Files (x86)/Mozilla Firefox/firefox.exe"));
			// ProfilesIni profile = new ProfilesIni();
			// FirefoxProfile ffprofile = profile.getProfile("default");
			//
			// driver = new FirefoxDriver(binary, ffprofile);
			// Log.InfoLog("Firefox Browser opened.");
			// PropertyConfigurator.configure(System.getProperty("user.dir")
			// + "\\log4j.properties");

			System.setProperty("webdriver.gecko.driver","/Users/ashutoks/Downloads/CFSA-master/Chrome/geckodriver");
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability("marionette", true);
			ProfilesIni profile= new ProfilesIni();
			driver = new FirefoxDriver();
			jse = (JavascriptExecutor) driver;
			//Log.InfoLog("firefox Browser opened.");
			System.out.println("F opened");
		}

	}

	@AfterMethod
	public void closeBroswer() {
		System.out.println("driver closed");
		//driver.quit();
		//Log.InfoLog("Browser Closed");
	}

	public void onTestStart(ITestResult iTestResult) {

	}

	public void onTestSuccess(ITestResult iTestResult) {

	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("check check");
		String path = System.getProperty("user.dir")
				+ "/TestOutput/ScreenShots";
		String testMethodNameAndTestClassName = iTestResult.getMethod()
				.getMethodName()
				+ "("
				+ iTestResult.getTestClass().getName()
				+ ")";
		DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String fileName = testMethodNameAndTestClassName +"_"+date+ ".jpg";

		try {
			// FileUtils.copyFile(scrFile, new
			// File(path,"screenshot_"+date+".jpg"));
			FileUtils.copyFile(scrFile, new File(path, fileName));
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult iTestResult) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onStart(ITestContext iTestContext) {

	}

	public void onFinish(ITestContext iTestContext) {

	}

}
