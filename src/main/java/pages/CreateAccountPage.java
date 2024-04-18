package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage {
    private final WebDriver driver;
    public CreateAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    private final By accountType = By.id("type");
    private final By deposit = By.id("fromAccountId");
    private final By openAccountButton = By.xpath("//input[@value=\"Open New Account\"]");


    //Actions

    public CreateAccountPage SetSelect(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountType));
        Select select=new Select(driver.findElement(accountType));
        select.selectByIndex(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deposit));
        Select select2=new Select(driver.findElement(deposit));
        select2.selectByIndex(0);
        driver.findElement(openAccountButton).click();
        driver.findElement(openAccountButton).click();
        driver.findElement(openAccountButton).click();
        driver.findElement(openAccountButton).click();

        return this;

    }

    }

