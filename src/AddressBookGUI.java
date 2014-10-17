
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class AddressBookGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<BuddyInfo> model;
	private JList<BuddyInfo> buddyScreen;
	private JMenuItem newItem;
	private JMenuItem addBuddyItem;
	private JMenuItem removeBuddyItem;
	private JMenuItem changeBuddyItem;
	private JMenuItem saveItem;
	private JMenuItem displayItem;
	private JMenuItem quitItem;
	
	public AddressBookGUI(){
		model = new DefaultListModel<BuddyInfo>();
		buddyScreen = new JList<BuddyInfo>(model);
		JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu buddyMenu = new JMenu("BuddyInfo");
        addBuddyItem = new JMenuItem("Add", 'A');
        buddyMenu.add(addBuddyItem);
        removeBuddyItem = new JMenuItem("Remove", 'R');
        buddyMenu.add(removeBuddyItem);
        changeBuddyItem = new JMenuItem("Edit", 'E');
        buddyMenu.add(changeBuddyItem);
        newItem = new JMenuItem("New", 'N');
        fileMenu.add(newItem);
        saveItem = new JMenuItem("Save", 'S');
        fileMenu.add(saveItem);
        displayItem = new JMenuItem("Display", 'D');
        fileMenu.add(displayItem);
        quitItem = new JMenuItem("Quit", 'Q');
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        menuBar.add(buddyMenu);
        setJMenuBar(menuBar);
        
        this.getContentPane().add(buddyScreen);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JFrame getJFrame(){
		return this;
	}
	
	public void newBuddyInfoListener(ActionListener l){
		newItem.addActionListener(l);
	}
	
	public void addBuddyInfoListener(ActionListener l){
		addBuddyItem.addActionListener(l);
	}
	
	public void removeBuddyInfoListener(ActionListener l){
		removeBuddyItem.addActionListener(l);
	}
	
	public void saveBuddyInfoListener(ActionListener l){
		saveItem.addActionListener(l);
	}
	
	public void quitBuddyInfoListener(ActionListener l){
		quitItem.addActionListener(l);
	}
	
	public void displayBuddyInfoListener(ActionListener l){
		displayItem.addActionListener(l);
	}
	
	public void changeBuddyInfoListener(ActionListener l){
		changeBuddyItem.addActionListener(l);
	}
	
	public JList<BuddyInfo> getBuddyScreen(){
		return buddyScreen;
	}
	
}
