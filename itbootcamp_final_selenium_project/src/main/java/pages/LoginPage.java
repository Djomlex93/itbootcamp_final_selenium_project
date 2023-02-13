package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public void welcomeMessage(){
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[1]/div[2]/h1")));
    }
}
