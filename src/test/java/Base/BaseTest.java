package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;

    public static WebDriverWait wait;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileInputStream fr;
    public static FileInputStream fr1;
    @BeforeEach
    public void setUp() throws FileNotFoundException {
        if(driver==null){
             fr = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
             fr1 = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");
            try {
                prop.load(fr);
                loc.load(fr1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(prop.getProperty("testurl"));
    }

    @AfterEach
    public void tearDown(){
            driver.quit();
    }
}
