package Base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class GridBase {

    public static ChromeOptions ChromeOption(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU acceleration
        options.addArguments("--no-sandbox"); // Disable sandbox for Docker environments
        return options; //
    }

    public static FirefoxOptions fOptions ()
    {
        FirefoxOptions opts = new FirefoxOptions();
        opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        opts.addArguments("--headless"); // Run in headless mode
        opts.addArguments("--disable-gpu"); // Disable GPU acceleration
        opts.addArguments("--no-sandbox"); // Disable sandbox for Doc

        return opts;
    }
    //public static WebDriver driver;
    public ThreadLocal<RemoteWebDriver> driver = null;


    @BeforeClass
    @Parameters(value= {"browser"})
    public void openBrowser(String browser) throws URISyntaxException, MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName" , browser);
        driver.set(new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), capabilities));
        //driver = new ChromeDriver(ChromeOption());
        //String targetUrl = "http://localhost:4444";


//        if(isRemote){
//            if(browser.equalsIgnoreCase("chrome")){
//                try {
//                    //driver = new RemoteWebDriver(new URL(targetUrl) , ChromeOption());
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(browser.equalsIgnoreCase("firefox")){
//                try {
//                    //driver = new RemoteWebDriver(new URL(targetUrl) , fOptions());
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        }

        getDriver().get("https://automationexercise.com/");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void closeBrowser()
    {

        getDriver().quit();
        driver.remove();
    }



}
