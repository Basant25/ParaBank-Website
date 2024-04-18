package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.FinishPage;
import pages.LoginPage;


public class NewAccountTest extends BaseTest{

    @Test
    public void validateCreateAccount(){
        new LoginPage(driver).login("bosy","55")
                .newAccount()
                .SetSelect();

        boolean isAccountCreated= driver.findElement(FinishPage.AccountOpened()).isDisplayed();
        Assert.assertTrue(isAccountCreated);

    }

}
