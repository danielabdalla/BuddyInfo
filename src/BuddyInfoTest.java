import junit.framework.TestCase;


public class BuddyInfoTest extends TestCase {

	private BuddyInfo buddy;
	private BuddyInfo buddyCopy;
	
	protected void setUp() throws Exception {
		buddy = new BuddyInfo("Dan", "2323", "12112");
		buddyCopy = new BuddyInfo(buddy);
		buddy.setAge(21);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	public void testBuddyInfo() {
		assertEquals("Verifying buddy creation", "Dan, 2323, 12112", buddy.toString());
	}
	

	public void testGetName() {
		assertEquals("Verifying name", "Dan", buddy.getName());
	}

	public void testSetName() {
		buddy.setName("Sam");
		assertEquals("Verifying name", "Sam", buddy.getName());
	}

	public void testGetAddress() {
		assertEquals("Verifying address", "2323", buddy.getAddress());
	}

	public void testSetAddress() {
		buddy.setAddress("21");
		assertEquals("Verifying address set", "21", buddy.getAddress());
	}

	public void testGetPhone() {
		assertEquals("Verifying phone", "12112", buddy.getPhone());
	}

	public void testSetPhone() {
		buddy.setPhone("212 121 1212");
		assertEquals("Verifying phone set", "212 121 1212", buddy.getPhone());
	}

	public void testToString() {
		assertEquals("Verifying buddy creation", "Dan, 2323, 12112", buddy.toString());
	}

	public void testEqualsObject() {
		assertEquals(buddy, buddyCopy);
	}
	
	public void testGetAge(){
		assertEquals("Verifying age", buddy.getAge(), 21);
	}
	
	public void testSetAge(){
		buddy.setAge(19);
		assertEquals("Verifying age", buddy.getAge(), 19);
	}
	
	public void testIsOver18(){
		assertTrue(buddy.isOver18());
	}

}
