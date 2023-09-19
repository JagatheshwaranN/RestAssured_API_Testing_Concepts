package miniwork.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager implements ITestListener {

    private ExtentSparkReporter extentSparkReporter;
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    String reportName;

    public void onStart(ITestContext testContext){

        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        reportName = "Test_Report_"+timeStamp+".html";
        extentSparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);
        extentSparkReporter.config().setDocumentTitle("PetStore Test Report");
        extentSparkReporter.config().setReportName("PetStore User Module API Automation Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Application", "PetStore User Module API");
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Environment", "QA");
    }

    public void onTestSuccess(ITestResult iTestResult){

        extentTest = extentReports.createTest(iTestResult.getName());
        extentTest.createNode(iTestResult.getName());
        extentTest.assignCategory(iTestResult.getMethod().getGroups());
        extentTest.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult iTestResult){

        extentTest = extentReports.createTest(iTestResult.getName());
        extentTest.createNode(iTestResult.getName());
        extentTest.assignCategory(iTestResult.getMethod().getGroups());
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, iTestResult.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult iTestResult){

        extentTest = extentReports.createTest(iTestResult.getName());
        extentTest.createNode(iTestResult.getName());
        extentTest.assignCategory(iTestResult.getMethod().getGroups());
        extentTest.log(Status.SKIP, "Test Skipped");
        extentTest.log(Status.SKIP, iTestResult.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext){

        extentReports.flush();
    }
}
