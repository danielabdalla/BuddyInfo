import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//Test edit made from site

//Branch change test
public class AddressBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		return buddies.toString().replace(",","").replace("]", "").replace("[","").trim();	
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
	
	public void exportSerializable() throws IOException{
		FileOutputStream stream = new FileOutputStream("export1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(stream);
		oos.writeObject(this);
		stream.close();
		oos.close();
	}
	
	public void importSerializable() throws IOException, ClassNotFoundException {
		FileInputStream stream = new FileInputStream("export1.txt");
		ObjectInputStream ois = new ObjectInputStream(stream);
		AddressBook book = (AddressBook) ois.readObject();
		System.out.print(book.displayAddressBook());
		stream.close();
		ois.close();
	}
	
	public void importFromText() throws IOException{
		BufferedReader read = null;
		
		File file = new File("export.txt");
		try {
			read = new BufferedReader(new FileReader(file));
			String line;
			while((line = read.readLine()) != null){
				if (!line.equals("")) // don't write out blank lines
			    {
					System.out.println(line);
			    }
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toXML(){
		String xml = "";
		xml += "<AddressBook>\n";
		for(BuddyInfo b : buddies){
			xml += "\t<BuddyInfo>\n"
			 + "\t\t<name> " + b.getName() + " </name>\n"
			 + "\t\t<address> " + b.getAddress() + " </address>\n"
			 + "\t\t<phone> " + b.getPhone() + " </phone>\n"
			 + "\t</BuddyInfo>\n";
		}
		xml += "</AddressBook>";
		return xml;
	}
	
	public void exportToXML(){
		String xml = toXML();
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("export.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			writer.write(xml);
			}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void importFromXMLFileDOM() throws Exception{
		File f = new File("export.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = factory.newDocumentBuilder();
		Document doc = d.parse(f);
		
		System.out.println("Root: " + doc.getDocumentElement().getNodeName());
		
		NodeList lst = doc.getDocumentElement().getChildNodes();
		for(int i = 0; i < lst.getLength(); i++){
			Node n = lst.item(i);
			System.out.println("Child: " + n.getNodeName() + " ===> " + n.getTextContent());
		}
	}
	
	public static void main(String args[]){
		String data = "";
		AddressBook book = new AddressBook();
		BuddyInfo buddy1 = new BuddyInfo("sd","ads","asd");
		BuddyInfo buddy2 = new BuddyInfo("sd","ads","asd");
		book.addBuddy(buddy1);
		book.addBuddy(buddy2);
		System.out.print(book.toXML());
		book.exportToXML();
		try {
			book.importFromXMLFileDOM();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Scanner in = new Scanner(System.in);
		data = in.next();
		BuddyInfo buddy3 = BuddyInfo.importData(data);
		book.addBuddy(buddy3);
		book.export();
		try {
			book.exportSerializable();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		in.close();
		
		try {
			book.importFromText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
		
		try {
			book.importSerializable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
}
