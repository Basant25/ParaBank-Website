package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    private final By usernameField = By.xpath("//input[@name=\"username\"]");
    private final By passwordField = By.xpath("//input[@name=\"password\"]");
    private final By loginButton = By.xpath("//input[@class=\"button\"]");


    //Getter
    public static By ErrorLogin (){
        return By.xpath("//h1[text()=\"Error!\"]");
    }


    //Actions
    public HomePage login(String username, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        return new HomePage(driver);

    }

}
