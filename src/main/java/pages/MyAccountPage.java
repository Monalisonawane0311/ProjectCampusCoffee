package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;

public class MyAccountPage extends WebTestBase {

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    @FindBy(xpath = "//a[text() ='Logout']")
    WebElement logoutText;

    @FindBy(xpath = "//a[text()='Confirm and log out']")
    WebElement confirmAndLogoutText;

    @FindBy(xpath = "//h1[text()='Sorry, you have been blocked']")
    WebElement afterLogoutPage;

    @FindBy(xpath = "//a[text()='Addresses']")
    WebElement addressText;
    @FindBy(xpath = "//h3[text()='Billing address']//following::a[text()='Add'][1]")
    WebElement addBillingAddress;
    @FindBy( xpath = "//input[@id='billing_first_name']")
    WebElement firstNameBillingField;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement lastNameBillingField;

    @FindBy(xpath = "//p[@id='billing_company_field']")
    WebElement billingCompanyField;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement streetAddressField;
    @FindBy(id ="billing_city")
    WebElement suburbCityField;
    @FindBy(id = "billing_postcode")
    WebElement postCodeField;
    @FindBy(id = "billing_phone")
    WebElement phoneNumberField;

    @FindBy(id = "billing_state")
    WebElement stateFieldDropDown;

    @FindBy(xpath = "//option[text()='Australian Capital Territory']")
    WebElement firstDropDownValue;

    @FindBy(xpath =" //input[@id='billing_autocomplete_off']")
    WebElement checkBoxOfAddress;

    @FindBy(xpath = "//button[text()='Save address']")
    WebElement saveAddressBtn;


    public MyAccountPage(){
        PageFactory.initElements(driver, this);
    }

    public String textOfMyAccount(){
       return DriverUtility.getTextOfElement(myAccountText);
    }

    public void getLogoutText(){
        DriverUtility.waitUntilElementToBeClickable(logoutText);
        DriverUtility.waitUntilElementToBeClickable(confirmAndLogoutText);
        //confirmAndLogoutText.click();

    }

    public  boolean checkSaveAddress() throws InterruptedException {
        DriverUtility.waitUntilElementToBeClickable(addressText);
        DriverUtility.waitUntilElementToBeClickable(addBillingAddress);
        DriverUtility.sendKeysText(firstNameBillingField, "Monali");
        DriverUtility.sendKeysText(lastNameBillingField, "csdc");
        DriverUtility.scroll(0,150);
       // DriverUtility.sendKeysText(billingCompanyField, "Campos Coffee");
        DriverUtility.sendKeysText(streetAddressField, "MG Road");
        DriverUtility.sendKeysText(suburbCityField,"ACBD");
        DriverUtility.dropDownSelectByVisibleText(stateFieldDropDown,  "Australian Capital Territory" );
        DriverUtility.sendKeysText(postCodeField, "1234585");
        DriverUtility.sendKeysText(phoneNumberField, "123456789");
        Thread.sleep(4000);
        DriverUtility.waitUntilElementToBeClickable(checkBoxOfAddress);
        return DriverUtility.isSelectedMethod(checkBoxOfAddress);

    }

    public boolean checkEnabledField(){
        DriverUtility.waitUntilElementToBeClickable(addressText);
        DriverUtility.waitUntilElementToBeClickable(addBillingAddress);
        return  DriverUtility.isEnabledMethod(saveAddressBtn);
    }

    public boolean selectCheckBoxBillingAddres() throws InterruptedException {
        DriverUtility.waitUntilElementToBeClickable(addressText);       // click on address text
        DriverUtility.waitUntilElementToBeClickable(addBillingAddress);     //click on billing address in account page
        Thread.sleep(3000);
        DriverUtility.scroll(0,150);
        DriverUtility.waitUntilElementToBeClickable(checkBoxOfAddress);     //click on check box
        Thread.sleep(3000);
        return DriverUtility.isSelectedMethod(checkBoxOfAddress);           //check whether check box is selected or not

    }


    public boolean setAddBillingAddress() throws InterruptedException {
        DriverUtility.waitUntilElementToBeClickable(addressText);
        DriverUtility.waitUntilElementToBeClickable(addBillingAddress);
        Thread.sleep(3000);
        DriverUtility.dropDownSelectByVisibleText(stateFieldDropDown,  "Australian Capital Territory" );
        Thread.sleep(3000);
        return DriverUtility.isSelectedMethod(firstDropDownValue);
    }

    public String getTextOfAfterLogout(){
        return DriverUtility.getTextOfElement(afterLogoutPage);
    }


}
