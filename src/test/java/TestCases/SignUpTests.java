package TestCases;

import Base.GridBase;
import Base.TestBase;
import Pages.SignUpPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class SignUpTests extends TestBase {

    public SignUpPage signupPageOBJ;

    public String url = "https://automationexercise.com/";
    @BeforeMethod
    public void beforeMethod(){
        //openBrowser();
        signupPageOBJ = new SignUpPage(driver);
    }



    // login section
    By loginMailAddress = By.xpath("//*[@data-qa='login-email']");
    By loginPassword = By.xpath("//*[@data-qa='login-password']");
    By loginBTN = By.xpath("//*[text()='Login']");
    By loginMessageUser = By.xpath("//*[@class='nav navbar-nav']/li[10]/a");



    @Test
    public void testAssignment1(){

        signupPageOBJ.fillFirstData();

        signupPageOBJ.fillSecondSignUpScreenData("1" , "12" , "1900");

        Assert.assertEquals(signupPageOBJ.validateCreatedAccount() , "ACCOUNT CREATED!");
    }

    @Test
    public void testAssignment2()
    {
//        driver.findElement(loginAndSignUpBTN).click();
//        driver.findElement(loginMailAddress).sendKeys("newUser0.4173558129169189@gmail.com");
//        driver.findElement(loginPassword).sendKeys(password);
//        driver.findElement(loginBTN).click();
//        driver.findElement(loginMessageUser);
//        String currentLoginMessage = driver.findElement(loginMessageUser).getText();
//        System.out.println("current login message is: "+currentLoginMessage);
//        Assert.assertEquals(currentLoginMessage , "Logged in as Mohamed");
    }
//    @AfterMethod
//    public void afterMethod()
//    {
//        closeBrowser();
//    }

}
