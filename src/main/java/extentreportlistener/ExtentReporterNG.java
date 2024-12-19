package extentreportlistener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fb.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReporterNG extends TestBase implements ITestListener {
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;

	public ExtentReporterNG() throws IOException {
	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark= new ExtentSparkReporter("C:\\Users\\dhars\\IdeaProjects\\FaceBookTestAutomation"+"/myReport.html");
		extent.attachReporter(spark);
		spark.config().setDocumentTitle(" FaceBook Automation");
		spark.config().setReportName("ExtentReport Face Book");
		spark.config().setTheme(Theme.DARK);

		extent.setSystemInfo("Tester Name ","DHARSHAN");
		extent.setSystemInfo("os","Windows11");
		extent.setSystemInfo("browser","Chrome");

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test case Passed is : "+result.getMethod().getMethodName());
	}



	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		TakesScreenshot ts=(TakesScreenshot)driver;
		String sfile=ts.getScreenshotAs(OutputType.BASE64);
		File Sfile=ts.getScreenshotAs(OutputType.FILE);
		File dfile=new File("C:\\Users\\dhars\\IdeaProjects\\FaceBookTestAutomation\\src\\main\\java\\com\\fb\\qa\\ScreenShot\\"+ result.getMethod().getMethodName() + ".png");
		try {
			FileHandler.copy(Sfile, dfile);
		}catch(IOException e){
			e.printStackTrace();
		}
		test.log(Status.FAIL,"Test case Failed is : "+result.getMethod().getMethodName()+" screen shot has been taken").addScreenCaptureFromBase64String(sfile	);


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case Skipped is : "+result.getMethod().getMethodName());
	}



	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}