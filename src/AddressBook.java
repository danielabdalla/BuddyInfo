import java.util.ArrayList;

//Test edit made from site
public class AddressBook {
	private ArrayList<BuddyInfo> buddies;


	public AddressBook() {
		buddies = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo buddy){
		if(buddy != null){
			buddies.add(buddy);
		}
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
