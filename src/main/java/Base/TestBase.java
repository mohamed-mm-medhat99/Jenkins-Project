package Base;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TestBase {
    public WebDriver driver;
    public String browserName;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException, URISyntaxException {
        this.browserName = browser;
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
