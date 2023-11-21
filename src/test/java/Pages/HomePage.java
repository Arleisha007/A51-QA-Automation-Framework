package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage{
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOf(userAvatarIcon));
    }
    //Locators


    /*private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By playlistNameField = By.cssSelector("[name='name']");
    private By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    //Helpers
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
    }*/
}
