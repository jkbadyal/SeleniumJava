package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("From Listener Start "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("From Listener Success "+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("From Listener Fail "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("From Listener Skip "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("From Listener Finish"+context.getName());

		
	}

	

}
