package Pages;

import Base.PageBase;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends PageBase {
    public WebDriver driver;

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //locators
    By loginAndSignUpBTN = By.xpath("//a[@href='/login']");
    By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    By signUpMailField = By.xpath("//input[@data-qa='signup-email']");
    By signUpBTN = By.xpath("//button[@data-qa='signup-button']");
    By signUpTitleCheckBox = By.xpath("//input[@id='id_gender1']");
    By signUpPasswordField = By.xpath("//input[@id='password']");
    By birthDayField = By.xpath("//select[@id='days']"); //click

    By birthMonthField = By.xpath("//select[@id='months']"); //click
    By birthYearField = By.xpath("//select[@id='years']"); //click
    By firstNameField = By.xpath("//input[@id='first_name']");
    By lastNameField = By.xpath("//input[@id='last_name']");
    By Address = By.xpath("//input[@id='address1']");
    By countryField = By.xpath("//select[@id='country']");
    By SelectedCountryField = By.xpath("//select[@id='country']//option[@value='Canada']");//click
    By state = By.xpath("//input[@id='state']");
    By city = By.xpath("//input[@id='city']");
    By zipCode = By.xpath("//input[@id='zipcode']");
    By mobileNumber = By.xpath("//input[@id='mobile_number']");
    By createAccountBTN = By.xpath("//*[text()='Create Account']");
    By createdMSG = By.xpath("//h2[@data-qa='account-created']/b");
    By continueBTN = By.xpath("//a[@data-qa='continue-button']");
    By signOutBTN = By.xpath("//a[@href='/logout']");

    //data
    String  signUpName = "Mohamed";
    String Email = "newUser"+Math.random()+"@gmail.com";
    String password = "123321123321";
    String address = "Egypt,Cairo,Maadi";
    String stateName = "Cairo";
    String CityName = "Maadi";
    String zipCodeValue = "212231";
    String mobileNumberValue = "12223432";


    public void selectBirthDate(String day , String month , String year)
    {
        Allure.step("Start selecting date of birth");
        By selectedBirthDay= By.xpath("//select[@id='days']//option[@value='"+day+"']");
        By selectedBirthMonth= By.xpath("//select[@id='months']//option[@value='"+month+"']");
        By selectedBirthYears= By.xpath("//select[@id='years']//option[@value='"+year+"']");

        driver.findElement(birthDayField).click();
        driver.findElement(selectedBirthDay).click();
        driver.findElement(birthMonthField).click();
        driver.findElement(selectedBirthMonth).click();
        driver.findElement(birthYearField).click();
        driver.findElement(selectedBirthYears).click();
    }
    public void fillFirstData()
    {
        Allure.step("Start filling first data");
        fluentWait(driver,10 , 2 ,loginAndSignUpBTN);
        driver.findElement(loginAndSignUpBTN).click();
        driver.findElement(signUpNameField).sendKeys(signUpName);
        Allure.step("email validation");
        driver.findElement(signUpMailField).sendKeys(Email);
        System.out.println("Newly Created E-Mail: " +Email);
        driver.findElement(signUpBTN).click();
    }

    public void fillSecondSignUpScreenData(String day , String month , String year)
    {
        Allure.step("Start filling second data");
        driver.findElement(signUpTitleCheckBox).click();
        driver.findElement(signUpPasswordField).sendKeys(password);

        selectBirthDate(day,month,year);

        driver.findElement(firstNameField).sendKeys(signUpName);
        driver.findElement(lastNameField).sendKeys(signUpName);
        driver.findElement(Address).sendKeys(address);
        Allure.step("Start clicking country field");
        driver.findElement(countryField).click();
        driver.findElement(SelectedCountryField).click();
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(city).sendKeys(CityName);
        driver.findElement(zipCode).sendKeys(zipCodeValue);
        driver.findElement(mobileNumber).sendKeys(mobileNumberValue);
        driver.findElement(createAccountBTN).click();
    }

    public String validateCreatedAccount()
    {
        String accountCreatedMSG = driver.findElement(createdMSG).getText();
        driver.findElement(continueBTN).click();
        driver.findElement(signOutBTN).click();
        return accountCreatedMSG;
    }

    public String compare()
    {
        String[] nums = {"1","2","3","4","5","6","7","8"};

        String currentNumber = "8";
        String matchedNumber = "not found";

        for (int i = 0 ; i<nums.length ; i++){
            if(nums[i].equals(currentNumber)){
                System.out.println("current index : "+i+" equlas expected number :"+currentNumber+".");
                matchedNumber = nums[i];
            }else {
                System.out.println("no match");
            }
        }
        return matchedNumber;
    }
}
