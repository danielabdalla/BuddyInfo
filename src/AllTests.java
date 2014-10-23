import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {
 
	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.saorsa.nowplaying.tests");
		suite.addTest(new TestSuite(AddressBookTest.class));
		suite.addTest(new TestSuite(BuddyInfoTest.class));
		return suite;
	}
}
