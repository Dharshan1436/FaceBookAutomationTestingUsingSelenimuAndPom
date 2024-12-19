package com.fb.qa.base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static com.fb.qa.util.TestUtil.IMPLICIT_WAIT;
import static com.fb.qa.util.TestUtil.PAGE_LOAD_TIMEOUT;

public class TestBase {
    public static Logger log = Logger.getLogger(TestBase.class);
    public static WebDriver driver;
    public static Properties prop;


public ExtentReports extent= new ExtentReports();
public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Extent.html");





    public TestBase() throws IOException {
        prop=new Properties();
        FileInputStream ip = new   FileInputStream("C:\\Users\\dhars\\IdeaProjects\\FaceBookTestAutomation\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
        prop. load(ip);
    }
    public static void initialization(){
        log.info("Browser Name : "+prop.getProperty("Browser"));
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
           driver.get(prop.getProperty("url"));
    }
}
