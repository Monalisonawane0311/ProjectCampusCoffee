package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class MyAccountTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    MyAccountTest(){
        super();
    }

    @BeforeMethod
    public  void setUp(){
        initialization();
        homePage= new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Verify the account is log out successfully")
    public void successfullyLogout(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        myAccountPage.getLogoutText();
        String logoutNextPage = myAccountPage.getTextOfAfterLogout();
        softAssert.assertEquals(logoutNextPage, "Sorry, you have been blocked","Successfully Logout and land on Home page");
        softAssert.assertAll();
    }

    @Test(description = "Check whether check box is selected or not in the address")
    public void selectCheckBoxBillingAddress() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertTrue(myAccountPage.selectCheckBoxBillingAddres());
        softAssert.assertAll();

    }

    @Test(description = "Check whether address save successfully")
    public void saveAddressSuccessfully() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertTrue(myAccountPage.checkSaveAddress());
        softAssert.assertAll();

    }
    @Test (description = "Verify the check box is selected ")
    public void checkBoxSelected() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertTrue(myAccountPage.setAddBillingAddress());
        softAssert.assertAll();
    }

    @Test(description = "Verify the enabled the save button in billing address")
    public void enabledMethod() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertTrue(myAccountPage.checkEnabledField());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}


