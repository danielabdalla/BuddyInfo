import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

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
	
	public void testExport() {
		book.addBuddy(buddy);
		book.export();
		File file = new File("M:/git/BuddyInfo/export.txt");
		assertTrue(file.exists());
	}
	
	public void testExportImportData() {
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		try {
			book.importFromText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String output = myOut.toString();
		assertEquals(buddy.toString().trim(), output.trim());
	}
	
	public void testImportToNewAddressBook() {	
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		try {
			book.importFromText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String output = myOut.toString();
		BuddyInfo buddy1 = BuddyInfo.importData(output);
		book.addBuddy(buddy1);
		assertEquals(book.getSize(),1);
	}

	public void testExportSerializable() {
		book.addBuddy(buddy);
		try {
			book.exportSerializable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File("M:/git/BuddyInfo/export1.txt");
		assertTrue(file.exists());
	}
	
	public void testExportImportDataSerializable() {
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		try {
			book.importSerializable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String output = myOut.toString();
		assertEquals(buddy.toString().trim(), output.trim());
	}
	
	public void testImportToNewAddressBookSerializable() throws ClassNotFoundException {	
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		try {
			book.importSerializable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String output = myOut.toString();
		BuddyInfo buddy1 = BuddyInfo.importData(output);
		book.addBuddy(buddy1);
		assertEquals(book.getSize(),1);
	}

}
