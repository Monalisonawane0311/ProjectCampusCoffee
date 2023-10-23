package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;

public class LoginPage extends WebTestBase {

    @FindBy(id = "username")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(id = "rememberme")
    WebElement rememberCheckBox;

    @FindBy(xpath = "//a[text()='Click here']")
    WebElement clickHereToRegister;

    @FindBy(xpath = "//h2[@class ='account-title']")
    WebElement titlePage;

    @FindBy(xpath ="//ul[@class ='woocommerce-error']")
    WebElement errorText;

    @FindBy(xpath = "//a[text() = 'Terms & Conditions']")
    WebElement pageEndTermsConditions;

    @FindBy(xpath = "//a[text()='Lost your password?']")
    WebElement lostYourPasswordText;

    @FindBy(xpath = "//input[@id='user_login']")
    WebElement enterEmailId;
    @FindBy(xpath = "//input[@value='Reset password']")
    WebElement resetPassword;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password){
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
       // rememberCheckBox.click();
        DriverUtility.waitUntilElementToBeClickable(loginBtn);

    }

    public void clickOnForgetPassword(){
        DriverUtility.waitUntilElementToBeClickable(lostYourPasswordText);
        DriverUtility.sendKeysText(enterEmailId,"monali@gmail.com");
        DriverUtility.waitUntilElementToBeClickable(resetPassword);
    }

    public void setClickHereToRegister(){
        DriverUtility.waitUntilElementToBeClickable(clickHereToRegister);
    }

    public boolean displayedErrorMsg(){
        return DriverUtility.isDisplayedMethod(errorText);
    }


    public void scrollDownPage(){
        DriverUtility.scrollByVisibleText(pageEndTermsConditions);

    }



}

