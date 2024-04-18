package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
    private static final By accountOpened = By.xpath("(//h1[text()=\"Account Opened!\"])[1]");


    //Getter
    public static By AccountOpened(){
        return accountOpened;
    }

    //Actions

    public CreateAccountPage SetSelect(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select select=new Select(driver.findElement(accountType));
        select.selectByIndex(0);
        Select select2=new Select(driver.findElement(deposit));
        select2.selectByIndex(0);
        driver.findElement(openAccountButton).click();

        return this;

    }

    }

