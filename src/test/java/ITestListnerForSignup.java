import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ITestListnerForSignup implements ITestListener {


    static Logger ILOg;

    public static void getLog(Logger log) {
        ILOg = log;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ILOg.info(iTestResult.getName() + ":STARTED");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ILOg.info(iTestResult.getName() + ": PASSED");


    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ILOg.error(iTestResult.getName() + ": FAILED");
        ILOg.error(" Priority of " + iTestResult.getMethod().getMethodName()+ " Test Method is " + iTestResult.getMethod().getPriority());
        String exception = iTestResult.getThrowable().getMessage();
        if (exception != null) {
            ILOg.error(exception);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ILOg.error(iTestResult.getName() + ": SKIPPED");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {


    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
