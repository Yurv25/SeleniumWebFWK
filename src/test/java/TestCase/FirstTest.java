package TestCase;

import Base.BaseTest;
import Pages.LoginPage;
import Utility.WebActions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest extends BaseTest {

    LoginPage login = new LoginPage();

    @Test
    public void LoginTest() throws InterruptedException {
        //Thread.sleep(5000);
        //driver.findElement(By.linkText("Sign in")).click();
       try {
           wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(loc.getProperty("sign_link"))))).click();
           login.enterUsername(By.id(loc.getProperty("email_field")),"yuricryp@gmail.com");
           //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("email_field")))).sendKeys("yuricryp@gmail.com");
           driver.findElement(By.id(loc.getProperty("next_button"))).click();
           wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(loc.getProperty("pwd_field"))))).sendKeys("Mypass25");


       }
       catch (StaleElementReferenceException e){
           wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(loc.getProperty("pwd_field"))))).sendKeys("Mypass25");
       }
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(loc.getProperty("next_sign_button"))))).click();

        Thread.sleep(3000);
    }
}
