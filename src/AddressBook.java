import java.util.ArrayList;

//Test edit made from site

//Branch change test
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
	
	public String displayAddressBook(){
		return buddies.toString();
	}
		
	public static void main(String args[]){
		System.out.println("Address book");
		BuddyInfo buddy = new BuddyInfo("Dan", "Canada", "123456");
		BuddyInfo buddy2 = new BuddyInfo("Bob", "Canada", "4839483");
		AddressBook addressbook = new AddressBook();
		addressbook.addBuddy(buddy);
		addressbook.addBuddy(buddy2);
		System.out.println(addressbook.displayAddressBook());
		addressbook.removeBuddy(buddy);
	}
}
