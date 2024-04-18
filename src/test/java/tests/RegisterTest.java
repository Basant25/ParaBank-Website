package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FinishPage;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    String firstname = ("Basant2566");
    String lastname = ("Sayed");
    String address = ("Faisal");
    String city = ("Cairo");
    String state = ("Egypt");
    String zipCode = ("1234");
    String phone = ("01055555");
    String SSN = ("55555");
    String username = ("bosy");
    String password = ("55");
    String confirmPassword = ("55");


    //Data

    @DataProvider(name = "testData")
    public Object[][] mdata() {
        return new Object[][]{
                {firstname, lastname, address, city, state, zipCode, phone, SSN, username, password, confirmPassword, "", true},
                {"", lastname, address, city, state, zipCode, phone, SSN, username, password, confirmPassword, "firstName", false},
                {firstname, "", address, city, state, zipCode, phone, SSN, username, password, confirmPassword, "lastName", false},
                {firstname, lastname, "", city, state, zipCode, phone, SSN, username, password, confirmPassword, "address.street", false}
        };

    }

    //TestCases

    @Test(dataProvider = "testData")
    public void verifyRegister(String firstname,String lastname, String address, String city, String state, String zipCode, String phone, String SSN, String username, String password, String confirmPassword, String targetName, boolean
            expectedResult) {
        new RegisterPage(driver)
                .register()
                .signingUp(firstname, lastname, address, city, state, zipCode, phone, SSN, username, password, confirmPassword);



        if (expectedResult){
            boolean isConfirmMessageDisplayed = driver.findElement(HomePage.ConfirmRegister()).isDisplayed();
            Assert.assertTrue(isConfirmMessageDisplayed);
        }

        else{
            boolean isErrorDisplayed = driver.findElement(RegisterPage.emptyField(targetName)).isDisplayed();
            Assert.assertTrue(isErrorDisplayed);

        }

    }
}

