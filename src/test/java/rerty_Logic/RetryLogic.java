package rerty_Logic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	int counter = 0;
    int maxRetry = 2;

    public boolean retry(ITestResult result) {

        if (counter < maxRetry) {

            counter++;
            return true;

        }

        return false;
    }
}
