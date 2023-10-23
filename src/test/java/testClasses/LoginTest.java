package testClasses;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    LoginTest(){
        super();

    }
    @BeforeMethod
    public  void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();

    }

    @Test(description= "Verify with valid username and valid password ")
    public  void verifyLoginWithValidUsernameAndPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String myAccountPageText = myAccountPage.textOfMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
    }

    @Test(description= "Verify with Invalid username and valid password ")
    public  void verifyLoginWithInvalidUsernameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("invalidUsername"), prop.getProperty("password"));
        softAssert.assertTrue(loginPage.displayedErrorMsg());
        System.out.println("Invalid username and valid password test case");
        softAssert.assertAll();
    }

    @Test(description= "Verify with valid username and Invalid password ")
    public  void verifyLoginWithValidUsernameAndInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("invalidPassword"));
        softAssert.assertTrue(loginPage.displayedErrorMsg());
        System.out.println("Valid username and invalid password test case");
        softAssert.assertAll();
    }

    @Test(description= "Verify with Invalid username and Invalid password ")
    public  void verifyLoginWithInvalidUsernameAndInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("invalidUsername"), prop.getProperty("invalidPassword"));
        softAssert.assertTrue(loginPage.displayedErrorMsg());
        System.out.println("Invalid username and invalid password test case");
        softAssert.assertAll();
    }

    @Test(description= "Verify forgot password ")
    public  void verifyForgotPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.clickOnForgetPassword();
        boolean verifyTitle = driver.getTitle().equalsIgnoreCase("My Account - Campos Coffee");
        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
