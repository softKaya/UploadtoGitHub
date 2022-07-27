package com.planittesting.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage<ContactPage>{

    public ContactPage(WebDriver driver) {
        super(driver);
       // this.driver = driver;
    }

    // public ContactPage setEmail(String email) {
    //     //Basically find the email field and send values in
    //     driver.findElement(By.id("email")).sendKeys(email);
    //     return this;
    // }

    //Adjust this later, looks a bit weird
    //But lets try this, lets do bulk processing :D
    public ContactPage setContactFormValues(String anyForename, String anyEmail, String anyMessage) {
        driver.findElement(By.id("forename")).sendKeys(anyForename);
        driver.findElement(By.id("email")).sendKeys(anyEmail);
        driver.findElement(By.id("message")).sendKeys(anyMessage);
        driver.findElement(By.className("btn-contact")).click();
        return this;
    }

    public ContactPage setForename(String forename) {
        driver.findElement(By.id("forename")).sendKeys(forename);
        return this;
    }

    //I think we have incorrect return for this that will not allow us to chain
    public ContactPage setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public ContactPage setMessage(String message) {
        driver.findElement(By.id("message")).sendKeys(message);
        return this;
    }

    //Problematic code so far
    private String getErrorText(String id) {
        var elements = driver.findElements(By.id(id));
        if (elements.isEmpty()) {
            return "";
        }
        return  elements.get(0).getText();
    }

    public String getEmailError() {
        return getErrorText("email-err");
    }

    public String getEmailFieldError() {
        return getErrorText("email-err");
        // return driver.findElement(emailErrorIdBy).getText();
    }

    public String getForeNameFieldError() {
        return getErrorText("forename-err");
        //return driver.findElement(forenameErrorIdBy).getText();
    }

    public String getMessageFieldError() {
        return getErrorText("message-err");
    }

    public ContactPage clickSubmitButton() {
        driver.findElement(By.className("btn-contact")).click();
        return this; //(Kaya) or new ContactPage(driver);
    }

    public String getSuccessMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(d -> d.findElement(By.className("alert-success"))).getText();
    }

}
