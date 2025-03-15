package Base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver localDriver = null;
    static ThreadLocal<RemoteWebDriver> gridDriver = new ThreadLocal<>();
    public static Properties properties = new Properties();

    static {
        try{
            FileInputStream configFile = new FileInputStream("./src/test/TestConfig/configs.Properties");
            properties.load(configFile);
        } catch (Exception e) {
            throw new RuntimeException("Failed To read from Config file");
        }
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException, URISyntaxException {
        String executionMode = properties.getProperty("ExecutionMode");

        if(executionMode.equalsIgnoreCase("grid")){
            return getGridDriver(browser);
        }else{
            return getLocalDriver(browser);
        }
    }

    public static WebDriver getLocalDriver(String browser) {
        if (localDriver == null) {
            localDriver = createLocalDriver(browser);
        }
        return localDriver;
    }

    public static WebDriver getGridDriver(String browser) throws MalformedURLException, URISyntaxException {
        if (gridDriver.get() == null) {
            gridDriver.set(createGridDriver(browser));
        }
        return gridDriver.get();
    }

    public static WebDriver createLocalDriver(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static RemoteWebDriver createGridDriver(String browser) throws URISyntaxException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);

        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");  // New headless mode
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            return new RemoteWebDriver(new URI(properties.getProperty("GridURL")).toURL(), capabilities);
        }
        return new RemoteWebDriver(new URI(properties.getProperty("GridURL")).toURL(), capabilities);
    }

    public static void quitDriver() {
        String executionMode = properties.getProperty("ExecutionMode").toLowerCase();

        if (executionMode.equals("grid")) {
            if (gridDriver.get() != null) {
                gridDriver.get().quit();
                gridDriver.remove();
            }
        } else {
            if (localDriver != null) {
                localDriver.quit();
                localDriver = null;
            }
        }
    }

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
}
