package com.hybridpro.initiate;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xmlbeans.impl.store.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hybridpro.filereader.PropertyReader;



public class Base {
	
	public Logger logger;
	PropertyReader prop = new PropertyReader();
	public WebDriver driver;
    DesiredCapabilities capability = new DesiredCapabilities();

    public ExtentHtmlReporter extentHtmlReporter;
	public ExtentTest extentTest;
	public ExtentReports extentReports;
    
    public String getBrowser()
    {
        String browsername = prop.getBrowserName();
        return browsername;
    }
    
    @BeforeClass
    public void BrowserSetUp()
    {
    	extentHtmlReporter = new ExtentHtmlReporter("extent.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentTest = extentReports.createTest(getClass().getSimpleName());
    	
        String BrowserName = getBrowser();  
        if (BrowserName.equals("Chrome"))
        {
            
            	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Server/chromedriver.exe");
            	driver = new ChromeDriver();
                driver.manage().window().maximize();
        }
              else if(BrowserName.equals("Firefox"))
              {
            	System.setProperty("webdriver.gecko.driver", "./src/main/resources/Server/geckodriver.exe");
            	driver = new FirefoxDriver();
            	driver.manage().window().maximize();
              }
                else if(BrowserName.equals("IE"))
                {
                capability.setCapability("EnableNativeEvents", false);
                capability.setCapability("ignoreZoomSetting", true);
                System.setProperty("webdriver.ie.driver", "./src/main/resources/Server/IEDriverServer.exe");
                driver= new InternetExplorerDriver();
                driver.manage().window().maximize();
                }
            
        logger = Logger.getLogger("HYBRIDPRO");
    	PropertyConfigurator.configure("Log4j.properties");
        }

    
    public String getEnvironment()
    {
        String environment = prop.getEnvironment();
        return environment;


    }

    public void GetUrl(String buName)
    {
    	String applicationurl=prop.getAppliactionUrl();
        try
        {
            if(buName.equalsIgnoreCase("ADMIN"))
            {
                String EnvironmentName = getEnvironment();
                if (EnvironmentName.equals("UAT"))
                {
                    driver.get(applicationurl);
                }
                else if (EnvironmentName.equals("STAGING"))
                {
                	driver.get(applicationurl);
                }
                else if (EnvironmentName.equals("PROD"))
                {
                	driver.get(applicationurl);
                }
                else if (EnvironmentName.equals("DEV"))
                {
                	driver.get(applicationurl);
                }
            }
            else if(buName.toUpperCase().contains("PROOFGALLERY"))
            {
                String EnvironmentName = getEnvironment();
                if (EnvironmentName.equals("UAT"))
                {
                	driver.get(applicationurl);
                }
                else if (EnvironmentName.equals("STAGING"))
                {
                	driver.get(applicationurl);
                }
                else if (EnvironmentName.equals("PROD"))
                {
                	driver.get(applicationurl);
                }
                else if (EnvironmentName.equals("DEV"))
                {
                	driver.get(applicationurl);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("GetUrl failed due to " + e);

        }
    }
    
    public void logReport(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(Status.ERROR, result.getName()+" Failed");
			extentTest.log(Status.ERROR, result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP, result.getName()+" Skipped");
			extentTest.log(Status.SKIP, result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.INFO, result.getName()+"PASSED");
		}
	}

    @AfterClass
    public void CleanUp()
    {
        driver.quit();
        extentReports.flush();
    }


}
