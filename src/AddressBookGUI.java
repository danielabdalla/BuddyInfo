import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class AddressBookGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private AddressBook addressbook;
	private final JFrame frame;
	private JTextArea buddyScreen;
	
	public AddressBookGUI(){
		frame = new JFrame();
	
		JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu buddyMenu = new JMenu("BuddyInfo");
        JMenuItem addBuddyItem = new JMenuItem("Add", 'A');
        buddyMenu.add(addBuddyItem);
        JMenuItem newItem = new JMenuItem("New", 'N');
        fileMenu.add(newItem);
        JMenuItem saveItem = new JMenuItem("Save", 'S');
        fileMenu.add(saveItem);
        JMenuItem displayItem = new JMenuItem("Display", 'D');
        fileMenu.add(displayItem);
        JMenuItem quitItem = new JMenuItem("Quit", 'Q');
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        menuBar.add(buddyMenu);
        setJMenuBar(menuBar);
                               
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            	addressbook = new AddressBook();
           
            	buddyScreen = new JTextArea(5,20);
            	buddyScreen.setText("Test");
            	frame.setSize(200, 200);
            	buddyScreen.setEditable(false);
            	buddyScreen.setVisible(true);
            	frame.getContentPane().add(buddyScreen);
            	frame.setVisible(true);
            }
            
        });
        
        displayItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            	if("Display".equals(e.getActionCommand())){
            		buddyScreen.setText(addressbook.displayAddressBook());
                }
            }
            
        });
        
        addBuddyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("Add".equals(e.getActionCommand())){
					BuddyInfo buddy = new BuddyInfo("", "", "");
					String name = JOptionPane.showInputDialog("Please enter your name");
					buddy.setName(name);
					
					String address = JOptionPane.showInputDialog("Enter your address");
					buddy.setAddress(address);
					
					String phone = JOptionPane.showInputDialog("Enter your phone number");
					buddy.setPhone(phone);
					
					addressbook.addBuddy(buddy);
				}
				
			}
        	
        });
        
        saveItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		if("Save".equals(e.getActionCommand())){
        			String data = buddyScreen.getText();
        			BufferedWriter out = null;
					try {
						out = new BufferedWriter(new FileWriter("myFile.txt"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			try {
						out.write(data);
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
        			Object[] options = {"OK"};
        		    JOptionPane.showOptionDialog(frame,
        		    "Success!","Save",JOptionPane.PLAIN_MESSAGE,
        		    JOptionPane.QUESTION_MESSAGE,null,options,
        		    options[0]);
        		}
        	}
        });
        
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            dispose();
            System.exit(1);
            }
            
        });
	
	}   
	
	public AddressBook getAddressBook()
	{
		return addressbook;
	}
	

	public static void main(String[] args) {
		AddressBookGUI buddyWindow = new AddressBookGUI();
		buddyWindow.setTitle("Address Book");
		buddyWindow.setSize(400, 300);
		buddyWindow.setVisible(true);
		buddyWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
