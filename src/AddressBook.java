import java.util.ArrayList;


public class AddressBook {
	private ArrayList<BuddyInfo> buddies;


	public AddressBook() {
		buddies = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo buddy){
		buddies.add(buddy);
	}
	
	public void removeBuddy(BuddyInfo buddy){
		buddies.remove(buddy);
	}
	
	public static void main(String args[]){
		System.out.println("Address book");
		BuddyInfo buddy = new BuddyInfo("Dan", "Canada", "123456");
		AddressBook addressbook = new AddressBook();
		addressbook.addBuddy(buddy);
		addressbook.removeBuddy(buddy);
	}
}