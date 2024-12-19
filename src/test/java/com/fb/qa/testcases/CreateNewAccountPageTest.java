package com.fb.qa.testcases;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.CreateNewAccountPage;
import com.fb.qa.util.TestUtil;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

//@Listeners(com.fb.qa.testcases.listner.FaceBookListners.class)
public class CreateNewAccountPageTest extends TestBase {
   CreateNewAccountPage createNewAccountPage;
    String SheetName ="SignUpData";
    public CreateNewAccountPageTest() throws IOException {

    }


    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        log.info("Test stated ....................");
        createNewAccountPage = new CreateNewAccountPage();
        createNewAccountPage.ChangToCreatePage();
    }


    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Description(" Create Account page title validate")
    @Feature("SingUp : 2")
    @Story("CreateNewAccount page title")
    public void CreateNewAccountPagesTest(){
        log.info("CreateNewAccount page title");
        String title= createNewAccountPage.validateCreateNewAccountPageTitle();
        Assert.assertEquals(title,"Sign up for Facebook");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.MINOR)
    @Description(" Create Account page image  validate")
    @Feature("SingUp : 2")
    @Story("CreateNewAccount page title")
    public void fbLogoImageTest(){
        log.info("fbLogoImage ");
        Boolean flag = createNewAccountPage.validateFaceBookImage();
        Assert.assertTrue(flag);


    }


    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description(" Create Account singUp validate")
    @Feature("SingUp : 2")
    @Story("SingUp page")
    public  void signUpTest() throws InterruptedException {
        log.info("SingUp page ");
         createNewAccountPage.signUp(prop.getProperty("firstName"),prop.getProperty("lastName"),prop.getProperty("day"),prop.getProperty("month"),prop.getProperty("year"),prop.getProperty("r_email"),prop.getProperty("r_pass"));
    }

    @DataProvider
    public Object[][] getLoginTestData(){
        Object data[][] = TestUtil.getTestData(SheetName);
        return data;
    }


    @Test(dataProvider = "getLoginTestData",priority =4 )
    @Severity(SeverityLevel.CRITICAL)
    @Description(" Create Account validate")
    @Feature("SingUp : 2")
    @Story("CreateNewAccount with multiple user page ")
    public void multipleSignUpTest(String firstName,String lastName,String day,String month,String year,String emailId,String password) throws InterruptedException {
        log.info("multipleSignUp ");
        createNewAccountPage.signUp(firstName,lastName,day,month,year,emailId,password);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void teatDown(){
        log.info("Test completed ....................................");
        driver.quit();
    }
}
