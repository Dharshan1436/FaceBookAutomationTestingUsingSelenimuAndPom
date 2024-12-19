package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.fb.qa.base.TestBase.driver;

public class CreateNewAccountPage {

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(id = "day")
    WebElement day;

    @FindBy(id = "month")
    WebElement month;

    @FindBy(id = "year")
    WebElement year;

    @FindBy(xpath = "//input[@value='2']")
    WebElement  male;

    @FindBy(name= "reg_email__")
    WebElement r_email;

    @FindBy(id = "password_step_input")
    WebElement r_pass;

    @FindBy(name = "websubmit")
    WebElement sige_up;

    @FindBy(xpath = "//img[@class=\"fb_logo _agiv img\"]")
    WebElement fbLog;

    @FindBy(xpath = "//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")
    WebElement createNewAccountBtn;

    public CreateNewAccountPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    //Actions:
    public void ChangToCreatePage(){
        this.createNewAccountBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public  String  validateCreateNewAccountPageTitle() {

        return driver.getTitle();
    }

    public Boolean validateFaceBookImage()  {

        return   fbLog.isDisplayed();

    }
    public  void  signUp(String firstname,String lastName,String day,String month,String year,String r_email,String r_pass) throws InterruptedException {

       this.firstName.sendKeys(firstname);
       this.lastName.sendKeys(lastName);
       this.day.sendKeys(day);
       this.month.sendKeys(month);
       this.year.sendKeys(year);
       this.male.click();
       this.r_email.sendKeys(r_email);
       this.r_pass.sendKeys(r_pass);
       this.sige_up.click();
       Thread.sleep(10000);

    }
}
