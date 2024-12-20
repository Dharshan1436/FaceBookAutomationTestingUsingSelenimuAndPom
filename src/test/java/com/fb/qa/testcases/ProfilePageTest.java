package com.fb.qa.testcases;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.ProfileUpdatePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

//@Listeners(com.fb.qa.testcases.listner.FaceBookListners.class)
public class ProfilePageTest extends TestBase {
    ProfileUpdatePage profileUpdatePage;
    public ProfilePageTest() throws IOException {
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException, AWTException {
        initialization();
        log.info("Test stated ....................");
        profileUpdatePage = new ProfileUpdatePage();
        profileUpdatePage.Login(prop.getProperty("emailId"), prop.getProperty("password"));
        profileUpdatePage.profilePage();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Description("User Login the Application and profile page check valid title or not")
    @Feature("profile page : 4")
    @Story("profile Page Tittle    ")
    public void profilePageTitleTest() {
        log.info(" profilePageTitle .....");
        String title = profileUpdatePage.validateProfilePageTitle();
        Assert.assertEquals(title, "Facebook");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and bio page validate")
    @Feature("profile page : 4")
    @Story("bio Page  validate   ")
    public void bioPageTest() throws InterruptedException {
        log.info("bioPage..............");
        profileUpdatePage.BioPage(prop.getProperty("bio"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and above page validate")
    @Feature("profile page : 4")
    @Story("above Page Tittle    ")
    public void aboutPageTest() throws InterruptedException {
        log.info("aboutPage..................");
        profileUpdatePage.AboutPage();
    }


    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and photos page validate")
    @Feature("profile page : 4")
    @Story("photos Page Tittle    ")
    public void photosPageTest() throws InterruptedException {
        log.info("photosPage............");
        profileUpdatePage.photosPage();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login the Application and video page validate")
    @Feature("profile page : 4")
    @Story("video Page Tittle    ")
    public void videosPageTest() throws InterruptedException {
        log.info("videosPage......");
        profileUpdatePage.videosPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("Test completed ....................................");
    }
}
