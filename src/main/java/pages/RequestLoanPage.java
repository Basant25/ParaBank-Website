package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RequestLoanPage {
    private WebDriver driver;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;

    }

    //Elements
    private final By loanAmountField = By.id("amount");
    private final By downPaymentField = By.id("downPayment");
    private final By fromAccountField = By.id("fromAccountId");
    private final By applyButton = By.xpath("(//input[@type=\"submit\"])[1]");



    public static By errorMsg(){
        return By.xpath("//p[text()=\"You do not have sufficient funds for the given down payment.\"]");
    }


    //Actions
    public RequestLoanPage requestLoan(String loanAmount, String downPayment){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(loanAmountField).sendKeys(loanAmount);
        driver.findElement(downPaymentField).sendKeys(downPayment);
        Select select = new Select(driver.findElement(fromAccountField));
        select.selectByIndex(0);
        driver.findElement(applyButton).click();

        return this;
    }
}

