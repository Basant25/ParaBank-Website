package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RequestLoanPage;

public class RequestLoanTest extends BaseTest {

    @Test
    public void validateRequestLoan() {
        new LoginPage(driver).login("nn", "55")
                .applyLoanOption()
                .requestLoan("5000", "4545");

        boolean isConfirmMsgDisplayed = driver.findElement(RequestLoanPage.confirmationMsg()).isDisplayed();
        Assert.assertTrue(isConfirmMsgDisplayed);
    }

    @Test
    public void invalidRequest(){

        new LoginPage(driver).login("nn", "55")
                .applyLoanOption()
                .requestLoan("5000", "5000");

        boolean isConfirmMsgDisplayed = driver.findElement(RequestLoanPage.errorMsg()).isDisplayed();
        Assert.assertTrue(isConfirmMsgDisplayed);

    }

}


