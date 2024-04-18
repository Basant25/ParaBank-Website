package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class UpdateInfoTest extends BaseTest{
    String firstname = ("Basant5");
    String lastname = ("Sayed");
    String address = ("Faisal");
    String city = ("Cairo");
    String state = ("Egypt");
    String zipCode = ("1234");
    String phone = ("01055555");

    //Data

    @DataProvider(name = "testData")
    public Object[][] mdata() {
        return new Object[][]{
                {firstname, lastname, address, city, state, zipCode, phone, true},
                {"", lastname, address, city, state, zipCode, phone, false},

        };

    }

    //TestCases

    @Test(dataProvider = "testData")
    public void verifyUpdateInfo(String firstname,String lastname, String address, String city, String state, String zipCode, String phone, boolean
            expectedResult) {
        new LoginPage(driver).login("bosy","55").updateProfile()
                .updateContactInfo(firstname,lastname,address, city, state,zipCode, phone);




        if (expectedResult){
            boolean isConfirmMessageDisplayed = driver.findElement(FinishPage.dataUpdated()).isDisplayed();
            Assert.assertTrue(isConfirmMessageDisplayed);
        }

        else{
            boolean isErrorDisplayed = driver.findElement(UpdateInfoPage.error()).isDisplayed();
            Assert.assertTrue(isErrorDisplayed);

        }

    }
}
