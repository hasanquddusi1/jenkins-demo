package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * Test Next Generation is a java testing  framework. Very similar to junit it allows for more custom test suites and
 * more intuitive ordering of our tests. Annotation driven
 */
public class TestNGBasics {
	
	
	/*
	 * We have options for setting up test bed in Testng just as we do in other  testing framework
	 */
	
	@BeforeClass
	public static void BeforeClass() {
		//This method runs once before all of tests in the test class. It provides one-time setup.
		System.out.println("Before Class");
	}
	
	@BeforeTest
	public void beforeEachTest() {
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void beforeEachTestMethod() {
		System.out.println("Before Method");
		
	}
	
	@BeforeGroups(groups = {"group1"})
	public void BeforeGroups() {
		System.out.println("Before Groups");
		
	}
	
	@BeforeSuite
	public void BeforeSuite() {
		/*
		 * group your testng tests under suites. This will run once before a suite of tests as defined in your testng.xml file
		 */
		System.out.println("Before Suite");
	}
	
//	if you dont want to run the test then do (enabled = false)
	@Test(enabled = false)
	public void disabledTest() {
		
	}
	
//	test can be in multiple groups
	@Test(groups = {"group1"})
	public void thisIsATest() {
		//Test logic goes here for this test case
		System.out.println("Test!!!! in GROUP 1");
	}
	
	
	
	@Test(groups = {"group2"})
	public void testInAnotherGroup() {
		System.out.println("This is test in an another group = GROUP2");
	}
	
	/*
	 * This test will be fed data from the Dataprovider we created below. This test will run once for each set of data provider
	 */
	@Test
//	dataProvider = "dummyUsers"
//	public void dataDrivenTest(String firstName, String lastName, int age) {
//		//pass in some parameters
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(age);
//	}
	
	
	
	
	
	/*
	 * options for tear down
	 * 
	 */
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
		
	}
	
	@AfterGroups(groups = {"group2"})
	public void afterGroups() {
		System.out.println("After group");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	
	//testng provides support for data-driven testing. It allows us to run a test around a set of data. test 
	//runs multiple times once for each set of data @DataProvider annotation
	
	/*
	 * A method that returns a multidimensional array (array of array) Each array within our containing array contains a
	 * set of data which a test should be run around
	 * 
	 * you can have multiple dataproviders
	 */
//	@DataProvider(name ="dummyUsers")
//	public Object[][] provideData(){
//		//dummy data below, feed this to the test method
//		Object testData[][] = new Object[][] {
//			{"Hassan", "Quddusi", 1337 },
//			{"Kevin", "Childs", 1337},
//			{"Christina", "Russ", 1337}
//			};
//		
//		return testData;
//	}
//	

}
