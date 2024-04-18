package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BillPayPage;
import pages.FinishPage;
import pages.LoginPage;

public class BillPayTest extends BaseTest{

    String PayeeName= ("BS");
    String Address= ("faisal");
    String City= ("cairo");
    String State= ("egy");
    String ZipCode= ("5555");
    String Phone= ("015854121");
    String Account= ("888");
    String VerifyAccount= ("888");
    String Amount= ("5000");

    //Data

    @DataProvider(name = "testData")
    public Object[][] mdata() {
        return new Object[][]{

                {PayeeName, Address, City, State, ZipCode, Phone, Account, VerifyAccount, Amount, true},
                {"",Address, City, State, ZipCode, Phone, Account, VerifyAccount, Amount, false},

        };

    }

    //TestCases


    @Test(dataProvider = "testData")
    public void validateBillPay( String PayeeName, String Address, String City,  String State, String ZipCode, String Phone, String Account, String VerifyAccount,String Amount, boolean expectedResult){
        new LoginPage(driver).login("bosy","55")
                .billPayOption()
                .billPay(PayeeName,Address,City,State,ZipCode,Phone,Account,VerifyAccount,Amount);


        if (expectedResult){
            boolean isConfirmMessageDisplayed = driver.findElement(FinishPage.PaymentComplete()).isDisplayed();
            Assert.assertTrue(isConfirmMessageDisplayed);
        }

        else{
            boolean isErrorDisplayed = driver.findElement( BillPayPage.ErrorMsg()).isDisplayed();
            Assert.assertTrue(isErrorDisplayed);

        }


//        boolean isPaymentCompleted = driver.findElement(BillPayPage.PaymentComplete()).isDisplayed();
//        Assert.assertTrue(isPaymentCompleted);

    }

    }

