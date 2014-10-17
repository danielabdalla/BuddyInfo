import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

//Test edit made from site

//Branch change test
public class AddressBook implements ListModel<BuddyInfo> {
	private DefaultListModel<BuddyInfo> buddies;


	public AddressBook() {
		buddies = new DefaultListModel<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo buddy){
		if(buddy != null){
			buddies.addElement(buddy);
		}
	}
	
	public void removeBuddy(BuddyInfo buddy){
		buddies.removeElement(buddy);
	}
	
	public String displayAddressBook(){
		return buddies.toString();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public BuddyInfo getElementAt(int index) {
		return buddies.get(index);
	}

	@Override
	public int getSize() {
		return buddies.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
	}
		
}
