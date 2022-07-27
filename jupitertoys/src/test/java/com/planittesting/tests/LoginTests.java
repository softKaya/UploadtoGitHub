package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;

public class LoginTests extends BaseTest{
    
    @Test
    public void doYourThing() {
        var homePage = new HomePage(driver).clickLoginMenu().setUsername("someone").setPassword("letmein").clickLoginButton();

        assertEquals("someone", homePage.getCurrentUser());
    }
}
