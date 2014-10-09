
public class BuddyInfo {

	private String name;
	private String address;
	private String phone;
	
	public BuddyInfo(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString(){
		return name + ", " + address + ", " + phone;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof BuddyInfo){
			if(((BuddyInfo) obj).name.equals(getName()) &&
			((BuddyInfo) obj).address.equals(getAddress()) &&
			((BuddyInfo) obj).phone.equals(getPhone())){
				return true;
			}
		}
		return false;
		}
}
