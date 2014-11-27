import java.io.Serializable;

public class BuddyInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String phone;
	private int age;
	
	public BuddyInfo(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public BuddyInfo(BuddyInfo buddy){
		this(buddy.getName(), buddy.getAddress(), buddy.getPhone());
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
		return name + "$" + address + "$" + phone;
	}
	
	public String greeting(){
		return "Hello " + name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public boolean isOver18(){
		if(age >= 18){
			return true;
		}
		return false;
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
	
	public static BuddyInfo importData(String data){
		String[] buddy = data.split("\\p{Punct}");
		return new BuddyInfo(buddy[0],buddy[1],buddy[2]);
	}
	
}
