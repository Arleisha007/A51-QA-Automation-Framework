package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators using Selenium Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailTxtField;
    @FindBy(css = "[type='password']")
    WebElement passwordTxtField;
    @FindBy(css = "[type='submit']")
    WebElement submitLoginButton;


    //Locators
    By emailField = By.cssSelector("input[type='email']");
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
    }

    //Helper methods using Page Factory

    public void provideEmailToLogin(String email){
        emailTxtField.sendKeys(email);
    }
    public void providePasswordToLogin(String password){
        passwordTxtField.sendKeys(password);
    }
    public void clickSubmitBtnToLogin(){
        submitLoginButton.click();
    }
}
