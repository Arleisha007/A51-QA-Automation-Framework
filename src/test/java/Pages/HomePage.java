package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators

    By userAvatarIcon = By.cssSelector("img.avatar");

    private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By playlistNameField = By.cssSelector("[name='name']");
    private By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    //Helpers
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }





    public void doubleClickPlayList(){
        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String playlistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();
    }
}
