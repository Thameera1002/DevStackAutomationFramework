package com.devstack.automation.testbase;

import com.devstack.automation.reporter.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logPass(result.getMethod().getMethodName()+" Passed.");
    }

    public void onTestFailure(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.logSkip(result.getMethod().getMethodName()+" Skipped."+result.getThrowable().getMessage());
    }

    public void onStart(ITestContext context) {
        ExtentReportManager.initReport();
    }

    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }
}
