package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 10)
    @Description("Visits the signup page")
    public void visitsTheSignupPage(){
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page.");
    }
    @Test(priority = 20)
    @Description("Check input types")
    public void checkInputTypes(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getEmailField().
                getAttribute("type"),
                "email",
                "Wrong email type.");
        Assert.assertEquals(signupPage.getPasswordField().
                        getAttribute("type"),
                "password",
                "Wrong password type.");
        Assert.assertEquals(signupPage.getConfirmPasswordField().
                        getAttribute("type"),
                "password",
                "Wrong confirm password type.");
    }
    @Test(priority = 30)
    @Description("Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page.");
        signupPage.getNameField().sendKeys("Another User");
        signupPage.getEmailField().sendKeys("admin@admin.com");
        signupPage.getPasswordField().sendKeys("12345");
        signupPage.getConfirmPasswordField().sendKeys("12345");
        signupPage.getSignMeUpButton().click();

        messagePopUpPage.waitUntilMessagePopUpIsVisible();

        Assert.assertEquals(messagePopUpPage.popUpText(),
                "E-mail already exists",
                "Proper message is not displayed, it should be 'E-mail already exists'.");

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page.");
    }
    @Test(priority = 40)
    @Description("Signup")
    public void signup(){
        navPage.getSignUpButton().click();
        signupPage.getNameField().sendKeys("Mladen Dimitrijevic");
        signupPage.getEmailField().sendKeys("mladen.dimitrijevic@itbootcamp.rs");
        signupPage.getPasswordField().sendKeys("12345");
        signupPage.getConfirmPasswordField().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForVerifyYourAccountPopUp();
        Assert.assertEquals(messagePopUpPage.verifyPopUpDialogueText(),
                "IMPORTANT: Verify your account",
                "Proper message is not displayed, it should be 'IMPORTANT: Verify your account'.");
        messagePopUpPage.getCloseButtonVerifyPopUp().click();

        navPage.getLogoutButton().click();

    }
}
