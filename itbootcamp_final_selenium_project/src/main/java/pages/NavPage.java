package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//a[@href='/home']"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("//a[@href='/about']"));
    }

    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//a[@href='/profile']"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));

    }

    public WebElement getCitiesLink() {
        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
    }

    public WebElement getUsersLink() {
        return driver.findElement(By.xpath("//a[@href='/admin/users']"));

    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//a[@href='/signup']"));

    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));

    }

    public WebElement getChooseLanguageButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));

    }
    public WebElement getEnglishLanguageButton(){
        return driver.findElement(By.id("list-item-73"));
    }
    public WebElement getSpanishLanguageButton(){
        return driver.findElement(By.id("list-item-75"));
    }
    public WebElement getFrenchLanguageButton(){
        return driver.findElement(By.id("list-item-77"));
    }
    public WebElement getChineseLanguageButton(){
        return driver.findElement(By.id("list-item-79"));
    }
    public WebElement getUkraineLanguageButton(){
        return driver.findElement(By.id("list-item-81"));
    }

}