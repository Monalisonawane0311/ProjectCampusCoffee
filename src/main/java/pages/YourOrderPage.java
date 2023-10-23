package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;

public class YourOrderPage extends WebTestBase {
    YourOrderPage(){
        PageFactory.initElements(driver,this);
    }


}
