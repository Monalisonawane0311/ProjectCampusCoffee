package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;
import utility.DriverUtility;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class ShopCoffeePage extends WebTestBase {

    @FindBy(xpath = "//select[@class='sort-select__select']")
    WebElement dropDownElement;

    @FindBy(xpath = "//div[@class='product-card__image']//img[@alt='Campos Superior Blend']")
    WebElement camposCoffeeItem;

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement closeAdvertiseInShopPurchase;

    @FindBy(xpath = "//select[@class='pa_weight']")
    WebElement pleaseSelectDropDown;

    @FindBy(xpath = "//option[text()= '250g']")
    WebElement bagSizeWeight;

    @FindBy(xpath = "//label[@class= 'button-group__label pa_grind']")
    WebElement wholeBeansItem;

    @FindBy(xpath = "//a[@class= 'quantity-input__icon quantity-input__icon--plus']")
    WebElement incrementSign;

    @FindBy(xpath = "//a[@class= 'button add-to-cart__button button--primary']")
    WebElement addItemInTheCart;

    @FindBy(xpath =  "//a[text()='Checkout']")
    WebElement checkoutElement;

    @FindBy(xpath = "//h3[text()='Your order']")
    WebElement yourOrderHeaderOnNextPage;

    @FindBy(xpath = "//a[@data-direction='increment']")
    WebElement incrementSignOnYourOrderPage;

    @FindBy(xpath = "//a[@data-direction='decrement']")
    WebElement decrementSignOnYourOrderPage;

    @FindBy(name = "cart[98052f898786a567fea5373f4db14681][qty]")
    WebElement quantityElement;

    @FindBy(xpath= "//div[@class='coupon__input']//following::input[@class='coupon__input__field'][3]")
    WebElement couponCodeText;

    @FindBy(xpath = "//a[text()='Redeem']")
    WebElement redeemBtn;

    public  ShopCoffeePage(){
        PageFactory.initElements(driver, this);
    }

    // Item  add in the cart
    public boolean itemIsAddedInTheCart () throws InterruptedException {
            DriverUtility.mouseHoverToElement(camposCoffeeItem);
            DriverUtility.waitUntilElementToBeClickable(camposCoffeeItem);
            DriverUtility.scroll(0,150);
            Thread.sleep(5000);
            DriverUtility.waitUntilElementToBeClickable(closeAdvertiseInShopPurchase);
            DriverUtility.dropDownSelectByVisibleText(pleaseSelectDropDown, "250g");
            DriverUtility.scroll(0,250);
            DriverUtility.waitUntilElementToBeClickable(wholeBeansItem);
            DriverUtility.scroll(0,250);
            DriverUtility.waitUntilElementToBeClickable(addItemInTheCart);
            Thread.sleep(2000);
            DriverUtility.waitUntilElementToBeClickable(checkoutElement);
            return DriverUtility.isDisplayedMethod(yourOrderHeaderOnNextPage);

    }
    // check the increment quantity of the item
    public boolean checkIncrementSignInYourOrderPage () throws InterruptedException {
        //DriverUtility.mouseHoverToElement(camposCoffeeItem);
        DriverUtility.waitUntilElementToBeClickable(camposCoffeeItem);
        DriverUtility.scroll(0,150);
        Thread.sleep(5000);
        DriverUtility.waitUntilElementToBeClickable(closeAdvertiseInShopPurchase);
        DriverUtility.dropDownSelectByVisibleText(pleaseSelectDropDown, "250g");
        DriverUtility.scroll(0,250);
        DriverUtility.waitUntilElementToBeClickable(wholeBeansItem);
        DriverUtility.scroll(0,250);
        DriverUtility.waitUntilElementToBeClickable(addItemInTheCart);
        Thread.sleep(2000);
        DriverUtility.waitUntilElementToBeClickable(checkoutElement);
        DriverUtility.mouseHoverToElement(incrementSignOnYourOrderPage);
        DriverUtility.waitUntilElementToBeClickable(incrementSignOnYourOrderPage);
        return DriverUtility.isDisplayedMethod(quantityElement);

    }

    // check the decrement quantity of the item
    public boolean checkDecrementSignInYourOrderPage () throws InterruptedException {
        //DriverUtility.mouseHoverToElement(camposCoffeeItem);
        DriverUtility.waitUntilElementToBeClickable(camposCoffeeItem);
        DriverUtility.scroll(0,150);
        Thread.sleep(5000);
        DriverUtility.waitUntilElementToBeClickable(closeAdvertiseInShopPurchase);
        DriverUtility.dropDownSelectByVisibleText(pleaseSelectDropDown, "250g");
        DriverUtility.scroll(0,250);
        DriverUtility.waitUntilElementToBeClickable(wholeBeansItem);
        DriverUtility.scroll(0,250);
        DriverUtility.waitUntilElementToBeClickable(addItemInTheCart);
        Thread.sleep(2000);
        DriverUtility.waitUntilElementToBeClickable(checkoutElement);
        DriverUtility.mouseHoverToElement(incrementSignOnYourOrderPage);
        DriverUtility.waitUntilElementToBeClickable(incrementSignOnYourOrderPage);
        DriverUtility.waitUntilElementToBeClickable(decrementSignOnYourOrderPage);
        Thread.sleep(2000);
        return DriverUtility.isDisplayedMethod(quantityElement);

    }

    // check the enabled the redeem button
    public boolean sendTextOnCoupon () throws InterruptedException {
        //DriverUtility.mouseHoverToElement(camposCoffeeItem);
        DriverUtility.waitUntilElementToBeClickable(camposCoffeeItem);
        DriverUtility.scroll(0,150);
        Thread.sleep(5000);
        DriverUtility.waitUntilElementToBeClickable(closeAdvertiseInShopPurchase);
        DriverUtility.dropDownSelectByVisibleText(pleaseSelectDropDown, "250g");
        DriverUtility.scroll(0,250);
        DriverUtility.waitUntilElementToBeClickable(wholeBeansItem);
        DriverUtility.scroll(0,250);
        DriverUtility.waitUntilElementToBeClickable(addItemInTheCart);
        Thread.sleep(2000);
        DriverUtility.waitUntilElementToBeClickable(checkoutElement);
        DriverUtility.sendKeysText(couponCodeText, "abcdefg");
        Thread.sleep(2000);
        return DriverUtility.isEnabledMethod(redeemBtn);

    }





}