package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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


    public void openBrowser(String URL)
    {
        driver = new ChromeDriver(ChromeOption());
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }






    public void closeBrowser()
    {
        driver.quit();
    }



}
