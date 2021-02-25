import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {


    public static ExtentReports getExtReporter(){
        String path=System.getProperty("user.dir") +"\\Reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Report");
        reporter.config().setDocumentTitle("TEST REPORTS");

        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester","sachin sharma");
        return extentReports;

    }
}
