package com.hybridpro.commonutility;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hybridpro.initiate.Base;

public class Interactions extends Base
{

	
	WebDriver driver;
	String pageLoadStatus = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;  
    public Interactions(WebDriver driver)
    {
        this.driver = driver;
    }
	
    
    public void waitTime(int seconds) throws InterruptedException
    {
        try { seconds = seconds * 1000; }
        catch (Exception e)
        { seconds = 1000; }
        Thread.sleep(seconds);
    }
    
    public void waitForPageToLoad()
    {

    	WebDriverWait wait = new WebDriverWait(driver, 300);
    	pageLoadStatus = (String)js.executeScript("return document.readyState");
    }
    
    
    public void goToURL(String url)
    {
        driver.navigate().to(url);
    }
    public void back()
    {
        driver.navigate().back();
    }
    public void Refresh()
    {
        driver.navigate().refresh();
    }
    
    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }
    
    public void Type(By by, String value)
    {
        driver.findElement(by).sendKeys(value);
    }
    public void Type(By by, String value, int waittimeinsecs) throws InterruptedException
    {
        waitTime(waittimeinsecs);
        driver.findElement(by).sendKeys(value);
    }
    public void Clear(By by)
    {
        driver.findElement(by).clear();
    }
    public void Clear(By by, int waittimeinsecs)
    {
    	driver.findElement(by).clear();
    }
    public void TypeClear(By by, String value,WebDriver driver)
    {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(value);
    }
    
    
    
    
    
    
    public void ScrollBy(int scroll)
    {
    	js.executeScript("window.scrollBy(0,1000)");

    }
    
    public void scrollToViewElement(By by)
    {
    	WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
  //Scroll up to element to be visible
    public void scrollToViewElement(WebElement element)
    {
        js.executeScript("arguments[0].scrolSlIntoView(true);", element);
    }
    
    //Scroll upto element to be visible
    public void ScrollToViewelement(By by)
    {
        js.executeScript("arguments[0].scrolSlIntoView(true);", by);
    }
    
    //Scroll to bottom of page
    public void ScrollToBottomOfPage()
    {
       js.executeScript("window.scrollTo(0, document.body.clientHeight);");
    }
    //Scroll to top of page
    public void ScrollToTopOgPage()
    {
        js.executeScript("window.scrollTo(0, 0)");
    }
    
    
    
    
    
  //Get single element
    public WebElement getElement(By by)
    {
        return driver.findElement(by);
    }
    //Get single element
    public WebElement getElement(By by, int waittimeinsecs)
    {
        return driver.findElement(by);
    }
    //Get Multiple elements
    public List<WebElement> getElements(By by)
    {
        return  driver.findElements(by);
    }

    //Check element is displayed or not
    public boolean IsElementDisplayed(By by) throws Exception
    {
        try
        {
        	boolean displayed = driver.findElement(by).isDisplayed();
            return displayed;
        }
        catch(Exception e)
        {
            throw new Exception("ELEMENTNOTDISPLAYED");
        }
    }
    // Element is enabled or not
    public boolean IsElementEnabled(By by) throws Exception
    {
        try
        {
        	boolean enabled = driver.findElement(by).isEnabled();
            return enabled;
        }
        catch(Exception e)
        {
            throw new Exception("ELEMENTNOTENABLED");
        }
    }
    //Element is selected or not
    public boolean IsElementSelected(By by) throws Exception
    {
        try
        {
        	boolean selected = driver.findElement(by).isSelected();
            return selected;
        }
        catch(Exception e)
        {
            throw new Exception("ELEMENTNOTSELECTED");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    
    
    
    
    
    
    
  
	public void waitVisible(By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitVisible(By by,int timeinsec)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeinsec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	
	public void waitVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitVisible(WebElement element,int timeinsec)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeinsec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
		
	public void waitExist(By by)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitExistsForMultipleElements(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitExistsForNestedElements(By locator,By nestedlocator)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator, nestedlocator));
	}
	
	public void waitExistsForNestedElements(WebElement element,By subelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(subelement, subelement));
	}
		
	public void waitTillNotVisible(By by,int timeinsec)
	{
		boolean stillExists = true;
        while (stillExists)
        {
            try
            {
            	waitVisible(by,timeinsec);
            }
            catch(Exception e)
            {
                stillExists = false;
            }
        }
	}
	
	public WebElement waitUntilElementClickable(WebElement element)
    {
        try
        {
        	WebDriverWait wait = new WebDriverWait(driver,300);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Element : '" + element + "' was not found in current context page.");
            throw e;
        }
    }
	
	public void waitUntilElementClickable(By by)
	{
		try
        {
        	WebDriverWait wait = new WebDriverWait(driver,300);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Element : '" + by + "' was not found in current context page.");
            throw e;
        }
	}
	
	public boolean waitUntilStalenessOfElement(WebElement element, int timeinsec)
    {
        try
        {
        	WebDriverWait wait = new WebDriverWait(driver,300);
            return wait.until(ExpectedConditions.stalenessOf(element));
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element is still not attached to current DOM");
            return false;
        }
    }
	
	/*Click*/
	public void click(By by)
	{
		driver.findElement(by).click();
	}
	
	public void ClickAndWait(By by,int timeinsec) throws InterruptedException
	{
		waitTime(timeinsec);
        driver.findElement(by).click();
	}
	
	 public void doubleClick(By by) throws InterruptedException
     {
         WebElement element = driver.findElement(by);
         Actions action = new Actions(driver);
         action.moveToElement(element);
         action.doubleClick();
         action.build().perform();
         waitTime(4);
     }
	
	public void JsClick(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		js.executeScript( "arguments[0].click();", element );
	}
	
	
	
	/*Alert Handler*/
	public boolean acceptAlert()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert Was Present");
            return true;
        }
        catch(Exception e)
        {
        	System.out.println("No Alert Found");
            return false;
        }
    }
	
	public boolean dismissAlert()
    {
        try
        {
        	Alert alert = driver.switchTo().alert();
            alert.dismiss();
            System.out.println("Alert Was Present");
            return true;
        }
        catch(Exception e)
        {
        	System.out.println("No Alert Found");
            return false;
        }
    }
	
	public String getAlertText()
    {
        try
        {
        	Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            System.out.println("Alert Was Present");
            return text;
        }
        catch(Exception e)
        {
            System.out.println("No Alert Found");
            return null;
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
