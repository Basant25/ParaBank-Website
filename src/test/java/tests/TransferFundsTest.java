package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FinishPage;
import pages.LoginPage;
import pages.TransferFundsPage;


public class TransferFundsTest extends BaseTest{

    @Test
    public void validateTransferFunds(){
        new LoginPage(driver).login("bosy","55")
                .transfer()
                .setTransferFunds("5000");

        boolean isTransferCompleted= driver.findElement(FinishPage.TransferComplete()).isDisplayed();
        Assert.assertTrue(isTransferCompleted);
    }

    @Test
    public void validateInvalidTransfer(){
        new LoginPage(driver).login("bosy","55")
                .transfer()
                .setTransferFunds("");

        boolean isErrorDisplayed= driver.findElement(TransferFundsPage.errorTransfer()).isDisplayed();
        Assert.assertTrue(isErrorDisplayed);
    }

}
