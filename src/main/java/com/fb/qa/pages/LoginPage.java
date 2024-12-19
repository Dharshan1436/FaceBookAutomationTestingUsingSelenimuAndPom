package com.fb.qa.pages;

import com.fb.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage  extends TestBase {

    // Page Factory -OR
    @FindBy(name="email")
    WebElement emailId;

    @FindBy(name="pass")
    WebElement password;

    @FindBy(name="login")
    WebElement loginBtn;



    @FindBy(xpath = "//img[@class=\"fb_logo _8ilh img\"]")
     WebElement fbLog;

    //Initializing the page Object
    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public  String  validateLoginPageTitle(){
        return driver.getTitle();
    }

    public Boolean validateFaceBookImage(){
      return   fbLog.isDisplayed();

    }

    public  void Login(String emailId,String password) throws InterruptedException {
        this.emailId.sendKeys(emailId);
        this.password.sendKeys(password);
        this.loginBtn.click();
        Thread.sleep(15000);

    }

    public  void multipleUserLogin(String emailId,String password) {
        this.emailId.sendKeys(emailId);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }
}
