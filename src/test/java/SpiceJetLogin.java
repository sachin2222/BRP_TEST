import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class SpiceJetLogin {


    WebDriver driver;

    @Test
    public void openURL() throws IOException {
     driver=    Base.initialiseDriver();
     driver.get("https://www.spicejet.com/");

    }




}
