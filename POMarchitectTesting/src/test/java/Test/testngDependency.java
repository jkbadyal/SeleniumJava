package Test;

import org.testng.annotations.Test;

public class testngDependency {
	@Test(dependsOnMethods = {"test2","test3"})
	public void test1() {
		System.out.println("Inside test1");
	}
	@Test(dependsOnMethods = {"test4"})
	public void test2() {
		System.out.println("Inside test2");
	}
	@Test(dependsOnMethods = {"test4"})
	public void test3() {
		System.out.println("Inside test3");
	}
	@Test
	public void test4() {
		System.out.println("Inside test4");
	}
}
