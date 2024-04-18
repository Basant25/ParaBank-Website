package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {


    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    private final By openNewAccount = By.xpath("//a[text()=\"Open New Account\"]");
    private final By transferFunds = By.xpath("//a[text()=\"Transfer Funds\"]");
    private final By requestLoan=By.xpath("//a[text()=\"Request Loan\"]");
    private final By billPay= By.xpath("//a[text()=\"Bill Pay\"]");
    private final By updateInfo= By.xpath("//a[text()=\"Update Contact Info\"]");



    public static By ConfirmRegister() {
        return By.xpath("//p[text()=\"Your account was created successfully. You are now logged in.\"]");
    }


    public static By HeaderPanel() {
        return By.xpath("//div[@id=\"headerPanel\"]");
    }


    //Actions
    public CreateAccountPage newAccount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(openNewAccount).click();

        return new CreateAccountPage(driver);

    }

    public TransferFundsPage transfer() {
        driver.findElement(transferFunds).click();

        return new TransferFundsPage(driver);
    }

    public RequestLoanPage applyLoanOption(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(requestLoan).click();

        return new RequestLoanPage (driver);


    }

    public BillPayPage billPayOption(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(billPay).click();

        return new BillPayPage (driver);

    }

    public UpdateInfoPage updateProfile(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(updateInfo).click();

        return new UpdateInfoPage(driver);

    }

}
