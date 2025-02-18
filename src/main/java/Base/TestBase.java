package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    public static ChromeOptions ChromeOption(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU acceleration
        options.addArguments("--no-sandbox"); // Disable sandbox for Docker environments
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        File extensionFilePath = new File("C:\\Users\\mhefela\\Downloads\\AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx");
//        options.addExtensions(extensionFilePath);
        return options; //
    }
    public static WebDriver driver;


    public void openBrowser(String url , Boolean isRemote)
    {
        driver = new ChromeDriver(ChromeOption());
        String targetUrl = "http://localhost:4444";
        FirefoxOptions opts = new FirefoxOptions();

        if(isRemote){
        try {
            driver = new RemoteWebDriver(new URL(targetUrl) , opts);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }






    public void closeBrowser()
    {
        driver.quit();
    }



}
