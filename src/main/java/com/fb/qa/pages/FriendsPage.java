package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class FriendsPage extends HomePage{
    public FriendsPage() throws IOException {
    }

    @FindBy (linkText = "Friend Requests")
    WebElement friends_request;

    @FindBy (linkText = "Suggestions")
    WebElement suggestions;

    @FindBy (linkText = "All friends")
    WebElement all_friends;

    @FindBy (linkText = "Birthdays")
    WebElement birthdays;

    public  String  validateFriendsPageTitle(){
        return driver.getTitle();
    }



    public  void friendRequestPage() throws InterruptedException {
        friends_request.click();
        Thread.sleep(5000);
        driver.navigate().back();

    }
    public  void suggestionsPage() throws InterruptedException {
        suggestions.click();
        Thread.sleep(5000);
        driver.navigate().back();

    }
    public  void allFriendsPage() throws InterruptedException {
        all_friends.click();
        Thread.sleep(5000);
        driver.navigate().back();

    }
    public  void  birthdaysPage() throws InterruptedException {
        birthdays.click();
        Thread.sleep(5000);
        driver.navigate().back();

    }



}
