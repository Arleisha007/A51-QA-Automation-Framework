package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    //locators
    @FindBy(css = "[type ='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css= "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    //constructor method
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage clickSubmitBtn(){
        submitButtonLocator.click();
        return this;
    }
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    //Locators
    /*By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");

    By submitBtn = By.cssSelector("button[type='submit']");

    //helpers
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElement(submitBtn).click();
    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }*/
}
