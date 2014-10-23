import junit.framework.TestCase;


public class AddressBookTest extends TestCase {

	private AddressBook book;
	private BuddyInfo buddy;
	
	protected void setUp() throws Exception {
		book = new AddressBook();
		buddy = new BuddyInfo("Buddy", "23", "4334");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEmptyAddressBook() {
		assertTrue(book.getSize() == 0);
	}

	public void testAddBuddy() {
		book.addBuddy(buddy);
		assertEquals("Add a buddy to the addressbook", 1, book.getSize());
	}

	public void testRemoveBuddy() {
		book.addBuddy(buddy);
		book.removeBuddy(buddy);
		assertTrue(book.getSize() == 0);
	}

	public void testGetSize() {
		book.addBuddy(buddy);
		assertEquals("Add a buddy to the addressbook", 1, book.getSize());
	}
	
	public void testClear() {
		book.addBuddy(buddy);
		book.clear();
		assertEquals("Add a buddy to the addressbook", 0, book.getSize());
	}

}
