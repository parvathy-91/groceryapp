package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import testscripts.BaseClass;
import utilities.ExtentReportUtility;

public class Listeners extends BaseClass implements ITestListener {

	ExtentTest test; // represents a single test in the report.
	ExtentReports extent = ExtentReportUtility.createExtentReports();

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// ensures that the report is threadsafe when
																		// test run in parallel

	public void onTestStart(ITestResult result) {// it invokes when a test starts

		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {// it invokes when a test will sucess

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {// it invokes when a test becomes fail

		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {// to catch exceptions when test fails
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) {// it invokes when test skips
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		// String testMethodName = result.getMethod().getMethodName();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {// it invokes when test failed but met a
																			// sucess percent

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {// it invokes when the test fails due to timeout

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {// called at the start of test context

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) { // Called at the end of the test context.

		ITestListener.super.onFinish(context);
		extent.flush();// save and write all the collected logs and test details into the final report
	}
}
