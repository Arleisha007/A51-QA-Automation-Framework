import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletedPlaylistSuccessMsg = "Deleted playlist \"AutoTestL19.\"";
        String BaseURL = null;
        navigateToLoginPage(BaseURL);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistSuccessMsg(), expectedDeletedPlaylistSuccessMsg);

    }
    public void openPlaylist() throws InterruptedException{
        WebElement emptyPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5) > a"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistBtn.click();
        Thread.sleep(2000);
    }
    public String getDeletedPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
