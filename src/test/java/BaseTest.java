import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public String url = "https://qa.koel.app/";

    public WebDriverWait wait;

     Actions actions;

     private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    @BeforeSuite
    static void setupClass() {
       // WebDriverManager.chromedriver().setup();
       //   WebDriverManager.firefoxdriver().setup();
          WebDriverManager.safaridriver().setup();

    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String BaseURL) throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateToLoginPage(BaseURL);
    }
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    /*@BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
          driver = pickBrowser(System.getProperty("browser"));
          wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          actions = new Actions(driver);
          driver.manage().window().maximize();
          navigateToLoginPage(BaseURL);
    }*/

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://169.254.105.91:4444";
        switch (browser){
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            //Selenium Grid
            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browser","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-safari": //gradle clean test -Dbrowser=grid-safari
                caps.setCapability("browserName","safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }


    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "arleisha.strauder";
        String authKey = "43H824kbpjoBxVgAN6EZ8YunDXKel9uETZJTEZazwJDZWntFCv";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "macOS Sonoma");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "119.0");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("build", "TestNG with Java");
        caps.setCapability("name", BaseTest.class.getName());
        caps.setCapability("plugin", "java-testNG");
        return new RemoteWebDriver(new URL("https://" +username+ ":" +authKey + hub), caps);
    }

    /*@AfterMethod
    public void closeBrowser(){
       driver.quit();
    }*/
    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void navigateToLoginPage(String BaseURL){
        driver.get(url);
    }

    public void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
       // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}