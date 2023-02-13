package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    @Test(priority = 10)
    @Description("Visits the login page")
    public void visitTheLoginPage(){
        navPage.getChooseLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page.");
    }
    @Test(priority = 20)
    @Description("Check input types")
    public void checkInputTypes(){
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailField()
                        .getAttribute("type"),
                "email",
                "Wrong email type");
        Assert.assertEquals(loginPage.getPasswordField()
                        .getAttribute("type"),
                "password",
                "Wrong password type");
    }
    @Test(priority = 30)
    @Description("Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilMessagePopUpIsVisible();

        Assert.assertEquals(messagePopUpPage.popUpText(),
                "User does not exists",
                "Wrong error message for unsuccessfully login is displayed.");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page.");
    }
    @Test(priority = 40)
    @Description("Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilMessagePopUpIsVisible();

        Assert.assertEquals(messagePopUpPage.popUpText(),
                "Wrong password",
                "Wrong error message for wrong password login is displayed.");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page.");
    }
    @Test(priority = 50)
    @Description("Login")
    public void login(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginButton().click();
        loginPage.welcomeMessage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Wrong URL, not on home page.");
    }
    @Test(priority = 60)
    @Description("Logout")
    public void logout(){
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "Logout button is invisible.");
        navPage.getLogoutButton().click();
    }

}
