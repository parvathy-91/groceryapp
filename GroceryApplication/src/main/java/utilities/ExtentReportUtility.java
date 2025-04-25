package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();   //ExtentReports is a class and creating an object
	public synchronized static ExtentReports createExtentReports() {    //to ensure thread safety becaue of parallel testing-synchronized

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //it handles the creation and configuration of html report
		                                                                                                //folder name and path of file
		
		reporter.config().setReportName("Grocery Application"); //set the title of the report 
		extentReports.attachReporter(reporter);   //Links the ExtentSparkReporter (which generates the file) to the ExtentReports instance.
		extentReports.setSystemInfo("Organization", "Obsqura");  //add system level infm to the reporter
		extentReports.setSystemInfo("Name", "Parvathy ");
		return extentReports;   //return the report
	}

}
