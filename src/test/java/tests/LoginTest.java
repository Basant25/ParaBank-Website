package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends BaseTest{

    @Test
    public void validLogin(){
        new LoginPage(driver).login("bebo","55");
        boolean isHeaderDisplayed = driver.findElement(HomePage.HeaderPanel()).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed);
    }

    @Test
    public void invalidLogin(){
        new LoginPage(driver).login("bebo","55");
        boolean isErrorDisplayed = driver.findElement(LoginPage.ErrorLogin()).isDisplayed();
        Assert.assertTrue(isErrorDisplayed);
    }

}
