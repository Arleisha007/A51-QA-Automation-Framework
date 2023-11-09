import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
        @Test
        public void loginValidEmailPasswordTestByPageFactory(){
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.provideEmailToLogin("demo@class.com");
            loginPage.providePasswordToLogin("te$t$tudent");
            loginPage.clickSubmitBtnToLogin();

            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }

}
