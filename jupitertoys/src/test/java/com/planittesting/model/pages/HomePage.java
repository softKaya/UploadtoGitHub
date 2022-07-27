package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage<HomePage>{

    public HomePage(WebDriver driver) {
        super(driver); 
    }

    public ContactPage clickContactMenu() {
        driver.findElement(By.cssSelector("#nav-contact a")).click();
        //How to return ContactPage
        return new ContactPage(driver);
    }

    public ShopPage clickShopMenu(){
        driver.findElement(By.cssSelector("#nav-shop a")).click();
        return new ShopPage(driver);
        
    }
}
