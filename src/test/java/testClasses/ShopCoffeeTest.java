package testClasses;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopCoffeePage;
import testbase.WebTestBase;

public class ShopCoffeeTest extends WebTestBase {

    public  HomePage homePage;
    public LoginPage loginPage;
    public ShopCoffeePage shopCoffeePage;

    ShopCoffeeTest(){
        super();
    }
    @BeforeMethod
    public  void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        shopCoffeePage = new ShopCoffeePage();
    }

    @Test (description = "Verify the add the item in cart successfully")
    public void shopCoffeeOnCart() throws InterruptedException {
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnCart();
        Assert.assertTrue(shopCoffeePage.itemIsAddedInTheCart());
        System.out.println("Add the item in the cart successfully");
    }

    @Test (description = "Verify the increment quantity of the item in cart successfully")
    public void checkIncrementSign() throws InterruptedException {
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnCart();
        Assert.assertTrue(shopCoffeePage.checkIncrementSignInYourOrderPage());
        System.out.println("Increment Sign Works Properly");
    }

    @Test (description = "Verify the decrement quantity of the item in cart successfully")
    public void checkDecrementSign() throws InterruptedException {
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnCart();
        Assert.assertTrue(shopCoffeePage.checkDecrementSignInYourOrderPage());
        System.out.println("decrement Sign Works Properly");
    }
    @Test (description = "Verify the enabled the Redeem Button")
    public void sendTextOnCouponTextBox() throws InterruptedException {
        homePage.setClosedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnCart();
        Assert.assertTrue(shopCoffeePage.sendTextOnCoupon());
        System.out.println("Enabled the redeem button");
    }



    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
