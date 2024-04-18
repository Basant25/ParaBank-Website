package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    //Elements
    private final  By registerButton= By.linkText("Register");
    private final By firstnameField= By.id("customer.firstName");
    private final By lastnameField= By.id("customer.lastName");
    private final By addressField= By.id("customer.address.street");
    private final By cityField= By.id("customer.address.city");
    private final  By stateField = By.id("customer.address.state");
    private final  By zipCodeField= By.id("customer.address.zipCode");
    private final  By phoneField= By.id("customer.phoneNumber");
    private final  By ssnField= By.id("customer.ssn");
    private final  By usernameField= By.id("customer.username");
    private final  By passwordField= By.id("customer.password");
    private final  By confirmPassField= By.id("repeatedPassword");
    private final By submitButton = By.xpath("(//input[@type=\"submit\"])[2]");

//    private final  By errorRegister = By.id("customer.address.state.errors");


    public static By emptyField (String targetElement){
        return By.id("customer."+ targetElement +".errors");
    }


    //Actions
    public RegisterPage register(){
        driver.findElement(registerButton).click();

        return this;
    }



    public HomePage signingUp(String firstname, String lastname, String address, String city,String state, String ZipCode, String phone, String SSN, String username, String password, String confirmPassword){
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(ZipCode);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(ssnField).sendKeys(SSN);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPassField).sendKeys(confirmPassword);
        driver.findElement(submitButton).click();

        return new HomePage(driver);
    }

}
