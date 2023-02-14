package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
    @Test(priority = 10)
    @Description("Set locale to Spanish")
    public void setLocaleToES() {
        navPage.getChooseLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Página de aterrizaje"),
                "Header doesn't contain 'Página de aterrizaje'.");
    }

    @Test(priority = 20)
    @Description("Set locale to English")
    public void setLocaleToEN() {
        navPage.getChooseLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Landing"),
                "Header doesn't contain 'Landing'.");
    }
    @Test(priority = 30)
    @Description("Set locale to Chinese")
    public void setLocaleToCN() {
        navPage.getChooseLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("首页"),
                "Header doesn't contain '首页'.");
    }

    @Test(priority = 40)
    @Description("Set locale to French")
    public void setLocaleToFR() {
        navPage.getChooseLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Page d'atterrissage"),
                "Header doesn't contain 'Page d'atterrissage'.");
    }

    @Test(priority = 50)
    @Description("Set locale to Ukraine")
    public void setLocaleToUA() {
        navPage.getChooseLanguageButton().click();
        navPage.getUkraineLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Лендінг"),
                "Header doesn't contain 'Лендінг'.");
    }

}
