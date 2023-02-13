package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public WebElement waitForEditAndCreateDialogueToBeVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }

    public WebElement waitForDeleteDialogueToBeVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-dialog')]//header[contains(@class, 'warning')]")));
    }

    public WebElement getSaveButtonFromDialogue() {
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getDeleteButtonFromDialogue() {
        return driver.findElement
                (By.xpath("//div[2]/button[2]"));
    }
    public void waitUntilRowsAppears(int rows){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"),rows));
    }
    public WebElement getCellByColumnAndRow(int row, int column){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
    }

    public WebElement getEditButtonFromRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]//button[@id='edit']"));
    }

    public WebElement getDeleteButtonFromRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]//button[@id='delete']"));
    }
}
