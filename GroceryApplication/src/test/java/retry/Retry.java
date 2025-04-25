package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private static final Logger LOG = LogManager.getLogger("Retry.class");// logger is initialized to track and log test
																			// retry attempts using log4j
	private static final int maxTry = 1;// max no of retry attempts

	private int count = 0;// tracks how many times retry has been attempted

	@Override
	public boolean retry(final ITestResult iTestResult) { // iTestResult is a method which is called automatically when
															// a test case fails
		if (!iTestResult.isSuccess()) {
			if (this.count < maxTry) {
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
				this.count++;
				return true;// indicates a retry attempt
			}
		}
		return false;
	}

	public String getResultStatusName(final int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}

}
