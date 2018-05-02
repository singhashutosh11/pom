package com.cfsa.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public  abstract class Page {

    private final long TIMEOUT_IN_SECONDS = 60L;
    protected Wait wait;
    protected WebDriver driver;
    public abstract void waitForPageToLoad();
    
    public Page(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        this.driver = driver;
        waitForPageToLoad();
    }
    public void setText(WebElement webElement, String inputText) {
        if (inputText == null) return;
        webElement.clear();
        webElement.click();
        webElement.click();
        if (!inputText.isEmpty()) {
            webElement.sendKeys(inputText);
        } else {
            webElement.sendKeys(" ");
            webElement.clear();
        }
    }

    public void selectRadioButton(WebElement radioButtons, String valueToSelect) {

        List<WebElement> radioButtonOptions = radioButtons.findElements(By.tagName("button"));
        for (WebElement option : radioButtonOptions) {
            if (option.getText().equals(valueToSelect)) {
                option.click();

                break;
            }
        }
    }


    protected WebElement waitFindElementByXpath(String xPath) {
        return waitFindElement(By.xpath(xPath));
    }

    protected WebElement waitFindElement(By by) {
        long timeoutMs = TIMEOUT_IN_SECONDS * 1000;
        List<WebElement> w = driver.findElements(by);
        long timeSlice = 200;
        while (timeoutMs > 0 && w.isEmpty()) {
            timeoutMs -= timeSlice;
            try {
                Thread.sleep(timeSlice);
            } catch (InterruptedException e) {
            }
            w = driver.findElements(by);
        }

        if (w.isEmpty()) throw new NoSuchElementException("Element " + by.toString() + " not found!");

        return w.get(0);
    }

    protected String getText(WebElement webElement)
    {
    	return webElement.getText(); 
    }
    
    protected boolean isDisplayed(WebElement webElement)
    {
    	try{
    		if(webElement.isDisplayed())
    			return true;
    		else
    			return false;
    	}catch(Exception ex)
    	{
    		return false;
    	}
    	
    }
    
    public boolean isEnabled(WebElement webElement) {
    	
		try{
			if(webElement.isEnabled())
				return true;
			else return false;
			
		}catch(Exception e){
			return false;
		}
	}

}//end of class
