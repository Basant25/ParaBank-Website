package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FinishPage;
import pages.LoginPage;
import pages.RequestLoanPage;

public class RequestLoanTest extends BaseTest {

    @Test
    public void validateRequestLoan() {
        new LoginPage(driver).login("bosy", "55")
                .applyLoanOption()
                .requestLoan("5000", "4254");

        boolean isConfirmMsgDisplayed = driver.findElement(FinishPage.confirmationMsg()).isDisplayed();
        Assert.assertTrue(isConfirmMsgDisplayed);
    }

    @Test

    public void validateInvalidRequest() {
        new LoginPage(driver).login("bosy", "55")
                .applyLoanOption()
                .requestLoan("100000000", "100000000");

        boolean isErrorDisplayed = driver.findElement(RequestLoanPage.errorMsg()).isDisplayed();
        Assert.assertTrue(isErrorDisplayed);

    }
}


