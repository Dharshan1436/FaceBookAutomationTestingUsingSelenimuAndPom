package com.fb.qa.testcases;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
//@Listeners(com.fb.qa.testcases.listner.FaceBookListners.class)
public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPageTest loginPageTest;
    public HomePageTest() throws IOException {
        super();
    }


    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        log.info("Test stated ....................");
        homePage = new HomePage();
        homePage.Login(prop.getProperty("emailId"),prop.getProperty("password"));


    }
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and loginPageTitle validate")
    @Feature("Home page : 3")
    @Story("Home Page Tittle    ")
    public void loginPageTitleTest(){
        log.info("Login page title ..");
        String title= homePage.validateLoginPageTitle();
        Assert.assertEquals(title,"Facebook");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and fbLogoImage validate")
    @Feature("Home page : 3")
    @Story("fbLogoImage Page Tittle    ")
    public void fbLogoImageTest(){
        log.info("fbLogoImage.....");
        Boolean flag = homePage.validateFaceBookLogo();
        Assert.assertTrue(flag);


    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and messagePage validate")
    @Feature("Home page : 3")
    @Story("messagePage    ")
    public  void messagePageTest() throws InterruptedException {
        log.info("Message page running.......");
       homePage.messagePage();
    }


    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and notificationPage validate")
    @Feature("Home page : 3")
    @Story("notificationPage    ")
    public  void notificationPageTest() throws InterruptedException {
        log.info("notificationPage");
        homePage.notificationPage();
    }


    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and profilePages validate")
    @Feature("Home page : 3")
    @Story("profilePages    ")
    public  void profilePagesTest() throws InterruptedException {
        log.info("profilePages");
        homePage.profilePage();
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and friendsPage validate")
    @Feature("Home page : 3")
    @Story("friendsPage ")
    public  void friendsPageTest() throws InterruptedException {
        log.info("friendsPage");
        homePage.friendsPage();
    }


    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and videosPage validate")
    @Feature("Home page : 3")
    @Story("videosPage    ")
    public  void videosPageTest() throws InterruptedException {
        log.info("videosPage");
        homePage.videosPage();
    }

    @AfterMethod
    public void teatDown(){
        log.info("Test completed ....................................");
        driver.quit();
    }
}
