package com.fb.qa.testcases;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.TestUtil;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

//@Listeners(com.fb.qa.testcases.listner.FaceBookListners.class)
public class LoginPageTest extends TestBase {
   LoginPage loginPage;
   String SheetName ="LoginData";

    public LoginPageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public  void setUp() throws IOException, InterruptedException {
        initialization();
        log.info("Test stated ....................");
         loginPage = new LoginPage();


    }
    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Description("User Login the Application and check valid title or not")
    @Feature("Login: 1")
    @Story("validate facebook title")
        public void loginPageTitleTest(){
           String title= loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Facebook – log in or sign up");
        }

@Test(priority = 2)
@Severity(SeverityLevel.MINOR)
@Description("User Login the Application and check valid image or not")
@Feature("Login: 1")
@Story("validate facebook image")
public void fbLogoImageTest(){
       Boolean flag = loginPage.validateFaceBookImage();
       log.info("validate facebook image .....................");
       Assert.assertTrue(flag);


}
   @Test(priority = 3)
   @Severity(SeverityLevel.BLOCKER)
   @Description("User Login the Application ")
   @Feature("Login: 1")
   @Story("The User enter the valid name and password then login the Application")
   public  void loginTest() throws InterruptedException {
        log.info("Login Test Method Running .......");
      loginPage.Login(prop.getProperty("emailId"),prop.getProperty("password"));
   }
   @DataProvider
   public Object[][] getLoginTestData(){
        Object data[][] =TestUtil.getTestData(SheetName);
        return data;
   }
@Test(dataProvider = "getLoginTestData",priority =4 )
@Severity(SeverityLevel.BLOCKER)
@Description("User Login the Application with multiple users ")
@Feature("Login: 1")
@Story("The User enter the valid name and password then login the Application")
   public void multipleUserLoginTest(String emailId,String password){
    log.info(" multipleUserLogin Test Method Running .......");
        loginPage.multipleUserLogin(emailId,password);
    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    @AfterMethod
    public void teatDown(){
        driver.quit();
        log.info("Test completed ....................................");
    }

}
