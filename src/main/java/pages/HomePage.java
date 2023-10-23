package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testbase.WebTestBase;
import utility.DriverUtility;

import java.io.IOException;
import java.util.List;

public class HomePage extends WebTestBase {

    @FindBy(xpath = "//li[@class = 'user-controls__ul__li user-controls__ul__li--account']")
    WebElement loginElement;

    @FindBy(xpath = "//button[@title ='Close']")
    WebElement closedFirstAd;

    @FindBy(xpath = "//a[@class ='newsletter__close newsletter__trigger']")
    WebElement closedSecondAd;

    @FindBy(id = "Layer_1")
    WebElement campusCoffeeLogo;

    @FindBy(xpath = "//a[text()='Our Story']")
    WebElement ourStoryCursorMoving;

    @FindBy(xpath = "//a[text()='History']")
    WebElement historyCursorMoving;

    @FindBy(xpath = "//h1[text()='our history']")
    WebElement ourHistoryTitle;

    @FindBy(xpath = "//ul[@class='sub-menu']//li//a']")
    List<WebElement> allOptions;

    @FindBy(xpath = "//li[@class ='user-controls__ul__li user-controls__ul__li--cart']")
    WebElement cartBox;

    @FindBy(xpath="//a[text()='Shop']")
    WebElement shopText;

    @FindBy(xpath = "//a[text()='Coffee']")
    WebElement coffeeText;


    @FindBy(xpath = "//a[text() = 'Terms & Conditions']")
    WebElement pageEndTermsConditions;

    @FindBy(xpath = "//form[@id='search']")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@id='s']")
    WebElement searchInputText;
    @FindBy(xpath = "//input[@id='searchsubmit']")
    WebElement submitSearch;

    public  HomePage(){
        PageFactory.initElements(driver, this);
    }

    public void setClosedFirstAd(){
        DriverUtility.waitUntilElementToBeClickable(closedFirstAd);
    }

    public void closedSecondAd(){
        DriverUtility.waitUntilElementToBeClickable(closedSecondAd);
    }

    public void clickOnLoginButton(){
        DriverUtility.waitUntilElementToBeClickable(loginElement);
    }

     public boolean displayedLogo(){
        return DriverUtility.isDisplayedMethod(campusCoffeeLogo);

    }

    public void mouseHoverAction() throws InterruptedException {
        DriverUtility.mouseHoverToElement(ourStoryCursorMoving);
        Thread.sleep(2000);
        DriverUtility.mouseHoverToElement(historyCursorMoving);
        DriverUtility.waitUntilElementToBeClickable(historyCursorMoving);

    }

    public void mouseHoverActionOnShop() throws InterruptedException {
        DriverUtility.mouseHoverToElement(shopText);
        Thread.sleep(2000);
        DriverUtility.mouseHoverToElement(coffeeText);
        DriverUtility.waitUntilElementToBeClickable(coffeeText);

    }

    public void sendTextOnSearch() throws InterruptedException {
        DriverUtility.waitUntilElementToBeClickable(searchBtn);
        //Thread.sleep(3000);
        DriverUtility.sendKeysText(searchInputText, "Coffee of the year");
      //  Thread.sleep(3000);
        DriverUtility.waitUntilElementToBeClickable(submitSearch);
    }

    public void scrollDownPage(){
        DriverUtility.scrollByVisibleText(pageEndTermsConditions);
    }

    public boolean displayedTermsAndConditions(){
        return DriverUtility.isDisplayedMethod(pageEndTermsConditions);
    }

    public String textOfOurHistory(){
        return DriverUtility.getTextOfElement(ourHistoryTitle);
    }
    public void clickOnCart(){
             DriverUtility.waitUntilElementToBeClickable(cartBox);
    }
    public void takeScreenshot() throws IOException {
        DriverUtility.newFileScreenshot();
    }

}
