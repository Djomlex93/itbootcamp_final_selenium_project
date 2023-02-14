package tests;

import org.openqa.selenium.Keys;
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
        messagePopUpPage.waitForPopUpSavedOrDeleted();
        Assert.assertTrue(messagePopUpPage.popUpSavedOrDeletedText().contains("Saved successfully"),
                "Proper message is not displayed, it should contain 'Saved successfully'.");

    }
    @Test(priority = 40)
    @Description("Edit city")
    public void editCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Mladen Dimitrijevic's city");
        citiesPage.waitUntilRowsAppears(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getInputName().click();
        citiesPage.getInputName().sendKeys(Keys.CONTROL + "a");
        citiesPage.getInputName().sendKeys(Keys.BACK_SPACE);
        citiesPage.getInputName().sendKeys("Mladen Dimitrijevic's city Edited");
        citiesPage.getSaveButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpSavedOrDeleted();
        Assert.assertTrue(messagePopUpPage.popUpSavedOrDeletedText().contains("Saved successfully"),
                "Proper message is not displayed, it should contain 'Saved successfully'.");

    }
    @Test(priority = 50)
    @Description("Search city")
    public void searchCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Mladen Dimitrijevic's city Edited");
        citiesPage.waitUntilRowsAppears(1);
        Assert.assertTrue(citiesPage.getCellByColumnAndRow(1, 2).getText().contains("Mladen Dimitrijevic's city Edited"),
                "Wrong city name.");
    }
    @Test(priority = 60)
    @Description("Delete city")
    public void deleteCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Mladen Dimitrijevic's city Edited");
        citiesPage.waitUntilRowsAppears(1);
        Assert.assertTrue(citiesPage.getCellByColumnAndRow(1, 2).getText().contains("Mladen Dimitrijevic's city Edited"),
                "Wrong city name.");
        citiesPage.getDeleteButtonFromRow(1).click();
        Thread.sleep(3000);
        citiesPage.waitForDeleteDialogueToBeVisible();
        citiesPage.getDeleteButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpSavedOrDeleted();
        Assert.assertTrue(messagePopUpPage.popUpSavedOrDeletedText().contains("Deleted successfully"),
                "Proper message is not displayed, it should contain 'Deleted successfully'.");


    }
}
