package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage {
    private final WebDriver driver;
    public FinishPage (WebDriver driver) {
        this.driver = driver;
    }

    public static By PaymentComplete(){
        return By.xpath("(//input[@type=\"submit\"])[1]");
    }

    public static By AccountOpened(){
        return By.xpath("(//h1[text()=\"Account Opened!\"])[1]");
    }

    public static By confirmationMsg(){
        return By.xpath("//p[text()=\"Congratulations, your loan has been approved.\"]");
    }

    public static By TransferComplete (){
        return By.xpath("//h1[text()=\"Transfer Complete!\"]");
    }

    public static By dataUpdated (){
        return By.xpath("//h1[text()=\"Profile Updated\"]");

    }

}

