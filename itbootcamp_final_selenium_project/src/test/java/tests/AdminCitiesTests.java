package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @Test(priority = 10)
    @Description("Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.getLoginButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Wrong URL, not on /admin/cities page.");

    }
    @Test(priority = 20)
    @Description("Checks input types for create/edit new city")
    public void checkInputTypes(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditAndCreateDialogueToBeVisible();
        Assert.assertEquals(citiesPage.getInputName().getAttribute("type"),
                "text",
                "Wrong city name input type.");
    }
    @Test(priority = 30)
    @Description("Create new city")
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditAndCreateDialogueToBeVisible();
        citiesPage.getInputName().sendKeys("Mladen Dimitrijevic's city");
        citiesPage.getSaveButtonFromDialogue().click();
       //fali popup


    }
}
