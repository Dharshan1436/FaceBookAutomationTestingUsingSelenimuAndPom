package com.fb.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ProfileUpdatePage extends HomePage {
    JavascriptExecutor js;
    public ProfileUpdatePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()=\"Edit bio\"]")
    WebElement bio;

    @FindBy(linkText = "About")
    WebElement about;

    @FindBy(xpath = "//textarea")
    WebElement bio_enterMessage;

    @FindBy(xpath = "//span[text()='Save']")
    WebElement bio_Save;

    @FindBy(linkText = "Photos")
    WebElement photos;

    @FindBy(linkText = "Videos")
    WebElement videos;



    public String validateProfilePageTitle() {
        return driver.getTitle();
    }

    public void BioPage(String bioMessage) throws InterruptedException {
         js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 200)");
            Thread.sleep(3000);
        bio.click();
        Thread.sleep(3000);
        bio_enterMessage.sendKeys(bioMessage);
        Thread.sleep(3000);
        bio_Save.click();

    }

    public void AboutPage() throws InterruptedException {
        about.click();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");

        Thread.sleep(5000);
    }

    public void photosPage() throws InterruptedException {
        photos.click();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        Thread.sleep(5000);
    }

    public void videosPage() throws InterruptedException {
        videos.click();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        Thread.sleep(5000);
    }
}
