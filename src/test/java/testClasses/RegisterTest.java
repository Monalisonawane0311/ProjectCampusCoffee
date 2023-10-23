package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import testbase.WebTestBase;

public class RegisterTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public MyAccountPage myAccountPage;

   RegisterTest(){
       super();
   }
    @BeforeMethod
    public  void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        myAccountPage = new MyAccountPage();

    }

    @Test(description = "Verify display error msg without entering email and password field")
    public  void verifyRegisterWithoutEmailAndPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.setClickHereToRegister();
        registerPage.register(" ", " ");
        softAssert.assertTrue(registerPage.displayErrorMsg() ,"getting an error msg");
        softAssert.assertAll();
    }

    @Test(description = "Verify successfully register with entering email and password field")
    public  void verifyRegisterEmailAndPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.setClickHereToRegister();
        registerPage.register("admin@gmail.com ", "admin");
        String myAccountPageText = myAccountPage.textOfMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Register Successfully");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
