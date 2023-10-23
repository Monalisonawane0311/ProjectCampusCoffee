package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverUtility extends WebTestBase {

    public static final long Page_LODE_TIME = 20;

    public static final long IMPLICIT_WAIT = 20;

    public static final long EXPLICIT_WAIT =20;
    public  static WebDriverWait wait;

    public static Actions actions;

    public static  Select select;
    public static JavascriptExecutor javascriptExecutor;

    public static void captureScreenshot(String filename){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(("./Screenshot/img.jpg"));
        try {
            FileUtils.copyFile(sourceFile,destFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Screenshot save Successfully");
    }

    public static void waitUntilElementToBeClickable(WebElement element){
       wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
       wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    //get the text of element
    public static String getTextOfElement(WebElement element){
        return element.getText();
    }

    // perform mouse hover action
    public static void mouseHoverToElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }
    // select the visible text in the Dropdown
    public static void dropDownSelectByVisibleText( WebElement element, String visibleText){
        select = new Select(element);
        select.selectByVisibleText(visibleText);

    }
    //select the value from Dropdown
    public static void dropDownSelectByValue(String valueText, WebElement element){
        select = new Select(element);
        select.selectByValue(valueText);

    }
    // select the index from Dropdown
    public static void dropDownSelectByIndex(int visibleIndex, WebElement element){
        select = new Select(element);
        select.selectByIndex(visibleIndex);

    }

    // perform scroll action by visible element at the end of page
    public static void scrollByVisibleText(WebElement element){
        javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", element);
    }

    // perform the scroll using offset
    public static void scroll(int xOffset, int yOffset)
    {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy("+xOffset  +","+yOffset +")");

    }
    // select the element
    public static boolean isSelectedMethod(WebElement element){
         return  element.isSelected();
    }
    //display the web element
    public static boolean isDisplayedMethod(WebElement element){
        return element.isDisplayed();

    }
    // enable the web element
    public static boolean isEnabledMethod(WebElement element){
        return element.isEnabled();

    }
    // take screenshot in the png format
    public static void newFileScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file,new File(System.getProperty("user.dir") + "/image.png"));
    }
    // send the text over the web element
    public static void sendKeysText(WebElement element, String textValue){
        element.sendKeys(textValue);
    }


}

