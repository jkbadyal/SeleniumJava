package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
public class testNGRetryFailTest {
	@Test
	public void test1() {
		System.out.println("test 1");
	}
	@Test(retryAnalyzer = testNGRetryListener.class)
	public void test2() {
		System.out.println("test 2");
		int i= 1/0;
	}
	@Test
	public void test3() {
		System.out.println("test 3");
	}
	@Test
	public void test4() {
		System.out.println("test 4");
		Assert.assertTrue(false);
	}
	@Test
	public void test5() {
		System.out.println("test 5");
	}
}
