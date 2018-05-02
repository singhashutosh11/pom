
package com.cfsa.qa.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public  class Log {
	
	
//	public Log(){
//	PropertyConfigurator.configure(System.getProperty("user.dir")
//			+ "\\log4j.properties");
//	}

	

	private static Logger APPLICATION_LOGS = Logger.getLogger(Log.class.getName());


    public static void errorLog(String errorMessage,Throwable t)
    {
        APPLICATION_LOGS.error(errorMessage,t);
    }
    public static void errorLog(String errorMessage)
    {
        APPLICATION_LOGS.error(errorMessage);
    }
    public static void InfoLog(String infoMessage)
    {
        APPLICATION_LOGS.info(infoMessage);
    }







//
//
//
//
//
//	protected static InternetExplorerDriverService service;
//	public static WebDriver driver = null;
//	protected static JavascriptExecutor jse;
//	protected static String browser = "";
//
//	public  SeleniumUtil() {
//		// TODO Auto-generated constructor stub
//
//		try{
//			PropertyConfigurator.configure(System.getProperty("user.dir")
//					+ "\\log4j.properties");
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//
//	@Parameters("browser")
//	@BeforeClass
//	public void setUp(String browser) throws Exception {
//
//		APPLICATION_LOGS.info("Browser is opening");
//
//
//		try {
//			if (browser.equalsIgnoreCase("FIREFOX")) {
//
//				// start firefox driver instance
//				FirefoxBinary binary = new FirefoxBinary(new File(
//						"C:/Program Files (x86)/Mozilla Firefox/firefox.exe"));
//				ProfilesIni profile = new ProfilesIni();
//				FirefoxProfile ffprofile = profile.getProfile("default");
//				driver = new FirefoxDriver(binary, ffprofile);
//				jse = (JavascriptExecutor) driver;
//
//			} else if (browser.equalsIgnoreCase("CHROME")) {
//				// start chrome driver instance
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir")
//								+ "\\lib\\chromedriver.exe");
//				driver = new ChromeDriver();
//				jse = (JavascriptExecutor) driver;
//
//			} else if (browser.equalsIgnoreCase("INTERNETEXPLORER")) {
//
//				// start Internet explorer driver instance
//				System.setProperty("webdriver.ie.driver",
//						System.getProperty("user.dir")
//								+ "\\lib\\IEDriverServer.exe");
//				service = new InternetExplorerDriverService.Builder()
//						.usingAnyFreePort()
//						.withLogLevel(InternetExplorerDriverLogLevel.TRACE)
//						.build();
//				try {
//					service.start();
//				} catch (IOException e) {
//					throw Throwables.propagate(e);
//
//				}
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}//end of setUp method
//
//	@AfterClass
//	public void tearDown() {
//		/*
//		 * if (browser.equalsIgnoreCase("INTERNET_EXPLORER")) {
//		 * Runtime.getRuntime().addShutdownHook(new Thread() {
//		 *
//		 * @Override public void run() { service.stop(); } }); }
//		 */
//
//		if (browser.equalsIgnoreCase("CHROME")) {
//			Runtime.getRuntime().addShutdownHook(new Thread() {
//
//				@Override
//				public void run() {
//					service.stop();
//				}
//			});
//		}
//		driver.close();
//		APPLICATION_LOGS.info("Browser closed.");
//	}// End tearDown
//
//	//This method sends the data into the textbox
//	public void sendkeys(WebDriver driver, String WebElement ){
//
//
//
//	}//end of sendkeys
	
}
