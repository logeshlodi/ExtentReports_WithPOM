package extentreports;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();
 
    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Reference", "SW Test Academy");
        extentReports.setSystemInfo("Author", "Logesh V");
        return extentReports;
    }
}