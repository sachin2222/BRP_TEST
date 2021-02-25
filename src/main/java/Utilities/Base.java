package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {


    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver initialiseDriver() throws IOException {

        prop = new Properties();
        FileInputStream fin = new FileInputStream("C:\\Users\\ss26370\\IdeaProjects\\RealTimeProject\\src\\main\\resources\\Data.properties");
        prop.load(fin);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ss26370\\IdeaProjects\\RealTimeProject\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver(options);


        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ss26370\\IdeaProjects\\RealTimeProject\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();


        } else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\ss26370\\IdeaProjects\\RealTimeProject\\Drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();


        }

        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        return driver;

    }

    public static String getBaseURL() {
        String url = prop.getProperty("url");
        return url;


    }
    public static Properties getSystemProperty(){
        return prop;

    }


}
