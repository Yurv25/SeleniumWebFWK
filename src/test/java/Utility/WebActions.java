package Utility;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebActions extends BaseTest {

    public void clickElement(By selector){
        driver.findElement(selector).click();
    }

    public void type(By selector, String text){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).sendKeys(text);
        }
        catch (StaleElementReferenceException e){
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).sendKeys(text);
        }
    }

    public void down(By selector, String text){
        driver.findElement(selector).sendKeys(Keys.ARROW_DOWN);
    }
    public void up(By selector, String text){
        driver.findElement(selector).sendKeys(Keys.ARROW_UP);
    }

    public void enter(By selector, String text){
        driver.findElement(selector).sendKeys(Keys.RETURN);
    }

    public void scrollToElement(By selector, String text){
        //driver.findElement(selector).;
    }
    public WebElement getElement(By selector){
        return driver.findElement(selector);
    }

    public List<WebElement> getElements(By selector){
        return driver.findElements(selector);
    }
}
