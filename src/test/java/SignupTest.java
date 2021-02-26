import POM.HomePageObjects;
import Utilities.Base;
import Utilities.Utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class SignupTest {

    WebDriver driver;
    HomePageObjects pom;
    Logger log;

    @BeforeTest
    public void setUp() throws IOException {
        log = LogManager.getLogger(SignupTest.class.getName());
        DOMConfigurator.configure("log4J.xml");
        log.info("**********Log4j.xml File has been Configured********");


        driver = Base.initialiseDriver();
        log.info("WebDriver has  Initialised");
        log.info("WebBrowser has Invoked");


        pom = new HomePageObjects(driver);
        log.info("Initialising the Page WebElements");

        ITestListnerForSignup.getLog(log);
        log.info("********ITestListener Starts Logging*********");

    }

    @Test(priority = 1)
    public void baseURLNavigation() {

        String QaURL = Base.getBaseURL();
        driver.get(QaURL);
        boolean b = driver.getCurrentUrl().equals(QaURL);

        log.assertLog(b, "Current URL is not equal to the Base URL");
        Assert.assertTrue(b);

    }


    @Test(priority = 2, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void selectTitle(String title) {

        Select select = new Select(pom.getTitle());
        select.selectByVisibleText(title);
        boolean b = title.equals(select.getFirstSelectedOption().getText());
        log.assertLog(b, "Test Case Failed because title is Not selected");
        Assert.assertTrue(false);

    }

    @Test(priority = 3, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void EnterFirstName(String firstname) {

        pom.getFirst_Name().sendKeys(firstname);

    }

    @Test(priority = 4, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void EnterLastName(String lastname) {

        pom.getLast_Name().sendKeys(lastname);


    }

    @Test(priority = 5, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void ValidPhoneNumberTest(String phoneNumber) {

        pom.getPhone_Number().sendKeys(phoneNumber);


    }


    @Test(priority = 6, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void EnterPassword(String password) {

        pom.getPassword().sendKeys(password);


    }

    @Test(priority = 7, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void EnterConfirmPassword(String confirmPassword) {

        pom.getConfirm_Password().sendKeys(confirmPassword);


    }

    @Test(priority = 8)
    public void clickCalender() {
        log.assertLog(pom.getCalender().isEnabled(), "Calender is Not Enabled");
        log.assertLog(pom.getCalender().isDisplayed(), "Calender is Not Displayed");

        pom.getCalender().click();
    }


    @Test(priority = 9, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void selectYear(String year) {

        List<WebElement> years = pom.getYears();
        Utils.selectValue(years, year);


    }

    @Test(priority = 10, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void selectMonth(String month) {

        List<WebElement> months = pom.getMonths();
        Utils.selectValue(months, month);


    }

    @Test(priority = 11, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void selectDate(String date) {

        List<WebElement> Days = pom.getDays();
        Utils.selectValue(Days, date);


    }

    @Test(priority = 12, dataProvider = "getDataForSingleUser", dataProviderClass = DataProviderTestNG.class)
    public void enterEmail(String email) {

        pom.getEmail().sendKeys(email);


    }

    @Test(priority = 13)
    public void clickCheckBox() {

        boolean b = pom.getCheckbox().isEnabled();
        log.assertLog(b, "Check Box is not Enabled");
        pom.getCheckbox().click();
        Assert.assertTrue(pom.getCheckbox().isSelected());

    }

    @Test(priority = 14)
    public void refreshPage() {

        driver.navigate().refresh();
        Properties p = Base.getSystemProperty();
        if (p.getProperty("browser").equals("chrome")) {
            driver.switchTo().alert().accept();

        }

    }

    @AfterTest
    public void teardown() {
        driver.quit();

    }


}
