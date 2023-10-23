package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;

public class RegisterPage extends WebTestBase {

    @FindBy(id = "reg_email")
    WebElement emailTextBox;

    @FindBy(id = "reg_password")
    WebElement passwordTextBox;

    @FindBy(name = "mailchimp_woocommerce_newsletter")
    WebElement checkBoxOfCampusCoffeeNewsletter;

    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement errorTextMsg;

    @FindBy(name = "register")
    WebElement registerBtn;

    public RegisterPage(){
        PageFactory.initElements(driver, this);
    }

    public void register(String userName, String password){
        emailTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
        DriverUtility.waitUntilElementToBeClickable(registerBtn);

    }

    public boolean displayErrorMsg(){
        return DriverUtility.isDisplayedMethod(errorTextMsg);
                //errorTextMsg.isDisplayed() && errorTextMsg.getText().equals("Error: Please provide a valid email address.");
    }




}
