package Test;

import org.testng.annotations.Test;
@Test(groups="allTest")
public class GroupsTestNG {
	@Test(groups= "one")
	public void test1() {
		System.out.println("Test 1");
	}
	@Test(groups= {"two"})
	public void test2() {
		System.out.println("Test 2");
	}
	@Test(groups= {"three"})
	public void test3() {
		System.out.println("Test 3");
	}
	@Test(groups="four")
	public void test4() {
		System.out.println("Test 4");
	}
	public void test5() {
		System.out.println("Test 5");
	}
}
