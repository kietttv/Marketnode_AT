package project.com.reports;

import project.com.constants.ConstantGlobal;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantGlobal.EXTENT_REPORT_PATH);
        reporter.config().setReportName("Extent Report | " + ConstantGlobal.AUTHOR);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Cucumber Selenium Java | " + ConstantGlobal.AUTHOR);
        extentReports.setSystemInfo("Author", ConstantGlobal.AUTHOR);
        return extentReports;
    }
}
