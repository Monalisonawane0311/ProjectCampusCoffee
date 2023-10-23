package testClasses;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

import java.io.IOException;

public class HomeTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;

    HomeTest(){
        super();
    }
    @BeforeMethod
    public  void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(testName = "ConfirmUrl")
    public void confirmUrl(){
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://camposcoffe.com/";            //https://camposcoffee.com/
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "URL should be matched");
        softAssert.assertAll();

    }

    @Test(description = "Verify the Logo of Company are visible")
    public  void displayLogoOfCampusCoffee(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.displayedLogo(), "Logo should be Displayed");
        softAssert.assertAll();
    }

    @Test(description = "Verify the mouse hover action on Our Story")
    public void mouseAction() throws InterruptedException {
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.mouseHoverAction();
        String getTextOfHistory = homePage.textOfOurHistory();
        Assert.assertEquals(getTextOfHistory, "OUR HISTORY", "Title should be matched");
        System.out.println("complete the action");
    }
    @Test(description = "Verify the page is properly scroll down")
    public  void scrollDownPage() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.scrollDownPage();
        softAssert.assertTrue(homePage.displayedTermsAndConditions());
        Thread.sleep(2000);
        System.out.println("Scroll down the page");
        softAssert.assertAll();
    }

    @Test (description = " Screenshot of home page")
    public void screenshotTestCase() throws IOException {

        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.takeScreenshot();
        System.out.println(" Screenshot Successful");
    }

    @Test (description = " Verify the send text on search button")
    public void sendTextTestCase() throws InterruptedException {
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.sendTextOnSearch();
        boolean verifyTitle = driver.getTitle().equalsIgnoreCase("You searched for Coffee of the year - Campos Coffee");
        Assert.assertTrue(verifyTitle);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
