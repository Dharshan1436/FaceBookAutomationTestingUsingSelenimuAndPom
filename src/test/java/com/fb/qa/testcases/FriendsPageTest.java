package com.fb.qa.testcases;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.FriendsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
//@Listeners(com.fb.qa.testcases.listner.FaceBookListners.class)
public class FriendsPageTest extends TestBase {
    public FriendsPageTest() throws IOException {
    }
FriendsPage friendsPage;
    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        initialization();
        log.info("Test stated ....................");
        friendsPage = new FriendsPage();
        friendsPage.Login(prop.getProperty("emailId"), prop.getProperty("password"));
        friendsPage.friendsPage();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Description(" Friends Page Title validate")
    @Feature("Friends Page : 5")
    @Story("Friends page title")
    public void FriendsPageTitleTest() {
        log.info("FriendsPageTitle");
        String title = friendsPage.validateFriendsPageTitle();
        Assert.assertEquals(title, "Friends | Facebook");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description(" friendRequestPage validate")
    @Feature("Friends Page : 5")
    @Story("friendRequest page ")
    public void friendRequestPageTest() throws InterruptedException {
        log.info("friendRequestPage...");
        friendsPage.friendRequestPage();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.MINOR)
    @Description( "friends  suggestions Page validate")
    @Feature("Friends Page : 5")
    @Story("Friends suggestion Page")
    public void suggestionsPageTest() throws InterruptedException {
        log.info("Friends suggestionsPage");
       friendsPage.suggestionsPage();
    }


    @Test(priority = 4)
    @Severity(SeverityLevel.MINOR)
    @Description("allFriendsPage validate")
    @Feature("Friends Page : 5")
    @Story("allFriendsPage ")
    public void allFriendsPageTest() throws InterruptedException {
        log.info("allFriendsPage...");
        friendsPage.allFriendsPage();
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Description(" birthdaysPage validate")
    @Feature("Friends Page : 5")
    @Story("birthdaysPage ")
    public void birthdaysPageTest() throws InterruptedException {
        log.info("birthdaysPage.....");
        friendsPage.birthdaysPage();
    }

    @AfterClass
    public void tearDown() {
        log.info("Test completed ....................................");
        driver.quit();

    }
}
