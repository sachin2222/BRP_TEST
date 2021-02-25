import Utilities.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ITestListnerForSignup implements ITestListener {


    static Logger ILOg;
    ExtentReports extentReports;
    ExtentTest test;

    public static void getLog(Logger log) {
        ILOg = log;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        String path = System.getProperty("user.dir") + "\\Reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Report");
        reporter.config().setDocumentTitle("TEST REPORTS");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "sachin sharma");

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getMethod().getMethodName());
        ILOg.info(iTestResult.getName() + ":STARTED");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "Test Passed");
        ILOg.info(iTestResult.getName() + ": PASSED");


    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.log(Status.FAIL, "Test case Failed");
        test.fail(iTestResult.getThrowable());

        ILOg.error(iTestResult.getName() + ": FAILED");
        ILOg.error(" Priority of " + iTestResult.getMethod().getMethodName() + " Test Method is " + iTestResult.getMethod().getPriority());
        String exception = iTestResult.getThrowable().getMessage();
        if (exception != null) {
            ILOg.error(exception);
        }

        try {
            WebDriver driver = (WebDriver) iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
            Base.takeScreenShot(iTestResult.getMethod().getMethodName(), driver);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP,"Test Case Skipped");
        ILOg.error(iTestResult.getName() + ": SKIPPED");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();

    }
}
