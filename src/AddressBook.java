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

	public int getSize() {
		return buddies.size();
	}
	
	public void clear(){
		buddies.clear();
	}
	
}
