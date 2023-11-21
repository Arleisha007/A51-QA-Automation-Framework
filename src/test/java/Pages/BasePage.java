package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;


public class BasePage {

   protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    private int timeSeconds = 10;

    //constructor method
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        //actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeSeconds), this);
    }
    //reusable methods, inherited by other pages
    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    protected void contextClick(WebElement webElement) {
        actions.contextClick(findElement(webElement)).perform();
    }
    protected void doubleClick(WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }


    //public WebElement findElement(By locator){
    //    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   // }

   // public void click(By locator){
     //   findElement(locator).click();
    //}
  //  public void doubleClick(By locator){
    //    actions.doubleClick(findElement(locator)).perform();
  //  }
}
