import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        String expectedAddedSongToPlaylistSuccessMsg = "Added 1 song into \"AutoLesson 17.\"";
        String BaseURL = null;
        navigateToLoginPage(BaseURL);
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Wait for 2 seconds
        Thread.sleep(2000);
        //Search for song
        searchSong("Tunnel of Lights");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedAddedSongToPlaylistSuccessMsg);
    }

    public void searchSong(String name) throws InterruptedException{
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));

       // WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys(name);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        //WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void selectFirstSong() throws InterruptedException{
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper tr.song-item")));
        //WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item"));
        firstSong.click();
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='add-to-btn']")));
        //WebElement addToButton = driver.findElement(By.cssSelector("button[data-test='add-to-btn']"));
        addToButton.click();
    }

    public void choosePlaylist() throws InterruptedException{
         WebElement playlist =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'AutoLesson 17')]")));
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'AutoLesson 17')]"));
        playlist.click();
    }

    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}


