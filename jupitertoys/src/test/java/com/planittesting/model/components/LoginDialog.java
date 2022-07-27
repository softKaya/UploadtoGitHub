package com.planittesting.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//This is object typing, but I am not familiar with this. -> Need to study on this
public class LoginDialog<CurrentPage>{
    WebElement rootElement;
    CurrentPage page;

    public LoginDialog(WebElement rootElement, CurrentPage page) {
        this.rootElement = rootElement;
        this.page = page;
    }

    public LoginDialog<CurrentPage> setUsername(String username) {
        rootElement.findElement(By.id("loginUserName")).sendKeys(username);
        return this;
    }

    public LoginDialog<CurrentPage> setPassword(String password) {
        rootElement.findElement(By.id("loginPassword")).sendKeys(password);
        return this;
    }

    public CurrentPage clickLoginButton( ) {
        rootElement.findElement(By.className("btn-primary")).click();
        return this.page;
    }
}
