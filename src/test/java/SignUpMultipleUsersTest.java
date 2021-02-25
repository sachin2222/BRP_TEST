import POM.HomePageObjects;
import Utilities.Base;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class SignUpMultipleUsersTest {

    WebDriver driver;
    HomePageObjects pom;

    @BeforeSuite
    public void InitialiseBrowser() throws IOException {
        driver = Base.initialiseDriver();

    }

    @BeforeClass
    public void InitialisePageObjects() {
        pom = new HomePageObjects(driver);


    }

    @Test(priority = 1)
    public void baseURLNavigation() {
        String QaURL = Base.getBaseURL();
        driver.get(QaURL);
        Assert.assertEquals(driver.getCurrentUrl(), QaURL);

    }

    @Test(priority = 2, dataProvider = "getData", dataProviderClass =DataProviderTestNG.class)
    public void signupTest(String title, String firstName, String LastName, String phone, String pwd, String confirmpwd, String year, String month, String date, String email) {

        Select select = new Select(pom.getTitle());
        select.selectByValue(title);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), title);

        pom.getFirst_Name().sendKeys(firstName);
        pom.getLast_Name().sendKeys(LastName);
        pom.getPhone_Number().sendKeys(phone);
        pom.getPassword().sendKeys(pwd);

        pom.getConfirm_Password().sendKeys(confirmpwd);

        pom.getCalender().click();
        List<WebElement> years = pom.getYears();
        List<WebElement> months = pom.getMonths();
        List<WebElement> Days = pom.getDays();

        Utils.selectValue(years, year);
        Utils.selectValue(months, month);
        Utils.selectValue(Days, date);

        pom.getEmail().sendKeys(email);
        pom.getCheckbox().click();
        driver.navigate().refresh();
        driver.switchTo().alert().accept();

    }
}
