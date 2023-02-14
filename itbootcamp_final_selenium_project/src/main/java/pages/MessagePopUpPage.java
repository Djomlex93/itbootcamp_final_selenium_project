package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitUntilMessagePopUpIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div/div[1]/ul/li")));
    }

    public String popUpText() {
        return driver.findElement(By.xpath("//div/div[1]/ul/li")).getText();
    }
    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//div[1]/button"));
    }
    public void waitForVerifyYourAccountPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("dlgVerifyAccount")));
    }
    public String verifyPopUpDialogueText() {
        return driver.findElement(By.className("dlgVerifyAccount")).getText();
    }
    public WebElement getCloseButtonVerifyPopUp() {
        return driver.findElement(By.xpath("//div/div/div[3]/button"));
    }
    public void waitForPopUpSavedOrDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[2]/div/div[3]/div/div/div/div/div[1]")));
    }

    public String popUpSavedOrDeletedText() {
        return driver.findElement
                (By.xpath("//div[2]/div/div[3]/div/div/div/div/div[1]")).getText();
    }
}
