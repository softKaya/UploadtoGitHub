package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.planittesting.model.data.ContactData;
import com.planittesting.model.pages.HomePage;

public class ContactTests extends BaseTest {

    // @Test
    // public void verifyIncorrectEmailError() {
    //     //The email and expected there are just contextual help
    //     var contactPage = new HomePage(driver).clickContactMenu().setEmail("notanemail");
    //     assertEquals("Please enter a valid email", contactPage.getEmailError());
    // }

    // @Test
    // public void verifySubmitErrors() {
        
    //     var contactPageUnderTest = new HomePage(driver).clickContactMenu().setContactFormValues("", "", "");
    //     assertEquals("Forename is required", contactPageUnderTest.getForeNameFieldError());
    //     //You did not follow instructions here.  I think there is no need to enter values yet, just validate the page after clicking Submit
    //     assertEquals("Email is required", contactPageUnderTest.getEmailFieldError());
    //     assertEquals("Message is required", contactPageUnderTest.getMessageFieldError());
    // }

    // @Test
    // public void verifySubmitErrorsV2() {
    //     var contactPageUnderTest = new HomePage(driver).clickContactMenu();
    //     //How do you do chaining here? Hmmm
    //     contactPageUnderTest.setForename("");
    //     contactPageUnderTest.setEmail("");
    //     contactPageUnderTest.setMessage("");
    //     contactPageUnderTest.clickSubmitButton();

    //     assertEquals("Forename is required", contactPageUnderTest.getForeNameFieldError());
    //     //You did not follow instructions here.  I think there is no need to enter values yet, just validate the page after clicking Submit
    //     assertEquals("Email is required", contactPageUnderTest.getEmailFieldError());
    //     assertEquals("Message is required", contactPageUnderTest.getMessageFieldError());
    // }

    //Kaya just remove below, replace it with generic @Test
    @Test
    //@CsvSource(value = { "Angry,Spider,angryspider@yahoo.com,0414933510,Angry" })
    public void validateRequiredFieldErrorsRemoval() {
        var contactPage = new HomePage(driver).
        clickContactMenu().
        clickSubmitButton().
        setForename("Angry").
        setEmail("angryspider@yahoo.com").
        setMessage("Angry Spider");

        assertEquals("", contactPage.getForeNameFieldError());
        assertEquals("", contactPage.getEmailFieldError());
        assertEquals("", contactPage.getMessageFieldError());
    }

    @Test
    //@CsvFileSource(resources = "./data/contactData.csv")
    public void validateContactFormSubmission() {
        var message = new HomePage(driver)
        .clickContactMenu()
        .setEmail("angryspider@yahoo.com")
        .setForename("Angry")
        .setMessage("Any Message")
        .clickSubmitButton()
        .getSuccessMessage();

        assertEquals("Thanks Angry, we appreciate your feedback.", message);
    }

}
