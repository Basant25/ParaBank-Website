package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TransferFundsPage {
    private final WebDriver driver;

    public TransferFundsPage (WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    private final By amountField= By.id("amount");
    private final By fromAccountField= By.id("fromAccountId");
    private final By toAccountField= By.id("toAccountId");
    private final By transferButton= By.xpath("(//input[@type=\"submit\"])[1]");


    public static By errorTransfer(){
        return By.id("amount.errors");
    }


    //Actions
    public TransferFundsPage setTransferFunds(String amount) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        Select select = new Select(driver.findElement(fromAccountField));
        select.selectByIndex(0);
        Select select2 = new Select(driver.findElement(toAccountField));
        select2.selectByIndex(0);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(amountField)).click().sendKeys(amount).build().perform();
        driver.findElement(transferButton).click();

        return this;

    }
}
