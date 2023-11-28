import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{

    @Test
    public void loginValidEmailPassword(){

        //Steps
        String BaseURL = null;
        navigateToLoginPage(BaseURL);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        // WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }

}
