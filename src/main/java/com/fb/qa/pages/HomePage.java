package com.fb.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;


public class HomePage extends LoginPage {


 @FindBy(xpath ="(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z\"])[2]")
WebElement message;

 @FindBy(xpath = "(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z\"])[3]")
 WebElement notification;

 @FindBy(linkText = "Dharshan P L")
 WebElement openProfile;

    @FindBy(linkText = "Friends")
    WebElement friends;

    @FindBy(linkText = "Video")
    WebElement videos;

    @FindBy(xpath = "//a[@aria-label=\"Facebook\"]")
    WebElement fbLogo;

    //Initializing the page Object
    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);

    }

    //Actions:
    public  String  validateLoginPageTitle(){
        return driver.getTitle();
    }

    public Boolean validateFaceBookLogo(){
        return   fbLogo.isDisplayed();
    }

    public  void messagePage() throws InterruptedException {
        this.message.click();
        Thread.sleep(5000);
        this.message.click();

    }
    public  void notificationPage() throws InterruptedException {
        this.notification.click();
        Thread.sleep(5000);
        this.notification.click();

    }
    public  void profilePage() throws InterruptedException {
        this.openProfile.click();
        Thread.sleep(5000);


    }
    public  void friendsPage() throws InterruptedException {
        this.friends.click();
        Thread.sleep(5000);


    }
    public  void videosPage() throws InterruptedException {
        this.videos.click();
        Thread.sleep(5000);

    }




}
