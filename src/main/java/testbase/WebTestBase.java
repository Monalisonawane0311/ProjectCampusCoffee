package testbase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.DriverUtility;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    public static Properties prop;

    public static WebDriver driver;

    public WebTestBase() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        String browserName = prop.getProperty("browserName");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.getProperty("WebDriver.chrome.driver", System.getProperty("user.dir") +"src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.getProperty("WebDriver.gecko.driver", System.getProperty("user.dir")+ "src/main/resources/driver/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            System.getProperty("WebDriver.edge.driver", System.getProperty("user.dir")+ "src/main/resources/driver/msedge.exe");
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Please select the correct browser");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DriverUtility.Page_LODE_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DriverUtility.IMPLICIT_WAIT));
    }

   /* public void captureScreenshot(String filename){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(("./Screenshot/img.jpg"));
        try {
            FileUtils.copyFile(sourceFile,destFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Screenshot save Successfully");
    }*/


}
