package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.model.components.LoginDialog;

//All functionalities here will be available on other pages so long as they extend from here
//This is hard to understand :D
public class BasePage<CurrentPage extends BasePage<CurrentPage>> {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactPage clickContactMenu() {
        driver.findElement(By.cssSelector("#nav-contact a")).click();
        //This is how you return a ContactPage
        return new ContactPage(driver);
    }

    @SuppressWarnings("unchecked")
    public LoginDialog<CurrentPage> clickLoginMenu() {
        driver.findElement(By.cssSelector("#nav-login a")).click();
        // This will take in 2 parameters.  
        // The rootelement of the component that we are currently working on.
        // And the CurrentPage that we are currently on
        return new LoginDialog<CurrentPage>(driver.findElement(By.className("popup")), (CurrentPage) this);
    }

    public String getCurrentUser() {
        return driver.findElement(By.className("user")).getText();
    }
}
