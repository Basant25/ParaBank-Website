package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BillPayPage {
    private final WebDriver driver;
    public BillPayPage (WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    private final By payeeNameField = By.xpath("//input[@name=\"payee.name\"]");
    private final By addressField = By.xpath("//input[@name=\"payee.address.street\"]");
    private final By cityField = By.xpath("//input[@name=\"payee.address.city\"]");
    private final By stateField = By.xpath("//input[@name=\"payee.address.state\"]");
    private final By zipCodeField = By.xpath("//input[@name=\"payee.address.zipCode\"]");
    private final By phoneField = By.xpath("//input[@name=\"payee.phoneNumber\"]");
    private final By account = By.xpath("//input[@name=\"payee.accountNumber\"]");
    private final By verifyAccount = By.xpath("//input[@name=\"verifyAccount\"]");
    private final By amountField = By.xpath("//input[@name=\"amount\"]");
    private final By fromAccount =By.name("fromAccountId");
    private final By sendPaymentButton = By.xpath("(//input[@type=\"submit\"])[1]");



    public static By ErrorMsg(){
        return By.className("error");
    }



    //Actions
    public BillPayPage billPay(String PayeeName, String Address, String City, String State, String ZipCode, String Phone, String Account, String VerifyAccount, String Amount){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(payeeNameField).sendKeys(PayeeName);
        driver.findElement(addressField).sendKeys(Address);
        driver.findElement(cityField).sendKeys(City);
        driver.findElement(stateField).sendKeys(State);
        driver.findElement(zipCodeField).sendKeys(ZipCode);
        driver.findElement(phoneField).sendKeys(Phone);
        driver.findElement(account).sendKeys(Account);
        driver.findElement(verifyAccount).sendKeys(VerifyAccount);
        driver.findElement(amountField).sendKeys(Amount);
        Select select2=new Select(driver.findElement(fromAccount));
        select2.selectByIndex(0);
        driver.findElement(sendPaymentButton).click();

        return this;
    }

}
