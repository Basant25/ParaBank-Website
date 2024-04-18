package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class UpdateInfoPage {

    private final WebDriver driver;

    public UpdateInfoPage (WebDriver driver) {
        this.driver = driver;
    }

    //Elements
   private final By firstnameField= By.id("customer.firstName");
   private final By lastnameField=By.id("customer.lastName");
   private final By addressField=By.id("customer.address.street");
   private final By cityField= By.id("customer.address.city");
   private final By stateField= By.id("customer.address.state");
   private final By zipCodeField= By.id("customer.address.zipCode");
   private final By phoneField= By.id("customer.phoneNumber");
   private final By updateButton= By.xpath("(//input[@type=\"submit\"])[1]");


    //Error
    public static By error(){
        return By.xpath("//span[text()=\"First name is required.\"]");
    }


    //Actions
    public UpdateInfoPage updateContactInfo(String firstname, String lastname, String address, String city, String state, String code, String phone){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(code);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(updateButton).click();

        return this;
    }


}
