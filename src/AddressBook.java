import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
		return buddies.toString().replace(",","")
				.replace("]", "")
				.replace("[","")
				.trim();
	}

	public int getSize() {
		return buddies.size();
	}
	
	public void clear(){
		buddies.clear();
	}
	
	public void export(){
		String data = displayAddressBook();
		String[] list = data.split(" ");
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter("export.txt"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				for(String s : list){
					out.write(s);
					out.newLine();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public void importFromText() throws IOException{
		BufferedReader read = null;
		
		File file = new File("export.txt");
		try {
			read = new BufferedReader(new FileReader(file));
			String line;
			while((line = read.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		String data = "";
		AddressBook book = new AddressBook();
		BuddyInfo buddy1 = new BuddyInfo("sd","ads","asd");
		BuddyInfo buddy2 = new BuddyInfo("sd","ads","asd");
		book.addBuddy(buddy1);
		book.addBuddy(buddy2);
		Scanner in = new Scanner(System.in);
		data = in.next();
		BuddyInfo buddy3 = BuddyInfo.importData(data);
		book.addBuddy(buddy3);
		book.export();
		in.close();
		System.out.println("");
		try {
			book.importFromText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
