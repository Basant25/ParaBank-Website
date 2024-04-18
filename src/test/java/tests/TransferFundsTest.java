package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransferFundsPage;


public class TransferFundsTest extends BaseTest{

    @Test
    public void validateTransferFunds(){
        new LoginPage(driver).login("jj","55")
                .transfer()
                .setTransferFunds("5000");


        boolean isTransferCompleted= driver.findElement(TransferFundsPage.TransferComplete()).isDisplayed();
        Assert.assertTrue(isTransferCompleted);

    }
}
