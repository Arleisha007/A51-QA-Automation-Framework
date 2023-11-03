import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist()  {
        String expectedDeletedPlaylistSuccessMsg = "Deleted playlist \"AutoTestL19.\"";
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistSuccessMsg(), expectedDeletedPlaylistSuccessMsg);

    }
    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(5) > a")));
        //WebElement emptyPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5) > a"));
        emptyPlaylist.click();

    }
    public void clickDeletePlaylistBtn()  {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        //WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistBtn.click();
    }

    public String getDeletedPlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}

