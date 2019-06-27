package Test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestNG {

	@Test
	@Parameters({"Name1","Name2"})
	public void test1(@Optional("Jatinder") String Name1,@Optional("Kumar") String Name2) {
		System.out.println("Name : " + Name1+" | Name 2 "+Name2);
	}
}
