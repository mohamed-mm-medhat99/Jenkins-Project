package TestCases;

import Base.TestBase;
import Pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class thirdTest extends TestBase {
    public SignUpPage signupPageOBJ;
    @BeforeMethod
    public void beforeMethod(){
//        openBrowser("https://www.google.com" , false , "firefox");
//        signupPageOBJ = new SignUpPage(driver);
    }

    @Test
    public void TestOne(){
        System.out.println("Test method One");
    }

    @Test
    public void TestTwo(){
        String result = signupPageOBJ.compare();
        System.out.println("matched number found at index of : "+result);
    }
}
