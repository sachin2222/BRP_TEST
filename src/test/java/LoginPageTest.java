import POM.LoginPageObjects;
import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest {

    WebDriver driver;
    LoginPageObjects pom;

    @BeforeSuite
    public void InitialiseBrowser() throws IOException {
        driver = Base.initialiseDriver();

    }

    @BeforeClass
    public void InitialisePageObjects() {
        pom = new LoginPageObjects(driver);


    }

    @Test(priority = 1)
    public void baseURLNavigation() {
        String baseURL = Base.getBaseURL();
        driver.get(baseURL);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);

    }

    @Test(priority = 2, dataProvider = "getInvalidUserData")
    public void invalidUserLoginTest(String username, String Password) {
        pom.getUsername().sendKeys(username);
        pom.getPassword().sendKeys(Password);
        pom.getlogin().click();

        pom.getUsername().clear();
        pom.getPassword().clear();


    }
    @DataProvider
    public Object[][] getInvalidUserData() {

      String[][] data=new String[2][2];
      data[0][0]="user1";
      data[0][1]="pwd1";

      data[1][0]="user2";
      data[1][1]="pwd2";
      return data;

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
