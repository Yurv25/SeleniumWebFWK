package Utility;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.util.List;

public class WebActions extends BaseTest {

    public void clickElement(By selector){
        driver.findElement(selector).click();
    }
    //testing my commit
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

    public void scrollToAnElement(By selector, String text){
        //driver.findElement(selector).;
        WebElement element = driver.findElement(selector);
        actions.scrollToElement(element).perform();
    }
    public void selectDropdownByValue(By selector, String value){
        WebElement element = driver.findElement(selector);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectDropdownByIndex(By selector, int index){
        WebElement element = driver.findElement(selector);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public WebElement getElement(By selector){
        return driver.findElement(selector);
    }

    public List<WebElement> getElements(By selector){
        return driver.findElements(selector);
    }


    public void switchFrame(int index){
        driver.switchTo().frame(index);
    }

    public void leaveFrame(){
        driver.switchTo().defaultContent();
    }
    public void waitForVisibility(){

    }
}
