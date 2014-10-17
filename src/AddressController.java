import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class AddressController {
	private AddressBookGUI gui;
	private DefaultListModel<BuddyInfo> model;
	
	public AddressController(final AddressBookGUI gui, final DefaultListModel<BuddyInfo> model){
		this.gui = gui;
		this.model = model;
		
		this.gui.newBuddyInfoListener(new newBuddyInfoListener());
		this.gui.addBuddyInfoListener(new addBuddyItemListener());
		this.gui.displayBuddyInfoListener(new displayItemListener());
		this.gui.removeBuddyInfoListener(new removeBuddyListener());
		this.gui.quitBuddyInfoListener(new quitItemListener());
		this.gui.saveBuddyInfoListener(new saveItemListener());
		this.gui.changeBuddyInfoListener(new changeItemListener());
		
	}
	
	
		class newBuddyInfoListener implements ActionListener{

			@Override
			 public void actionPerformed(ActionEvent e)
	         { 
	         	if("New".equals(e.getActionCommand())){
         	gui.getBuddyScreen().setModel(model);
         }
	         }
         
     };
     
 		class removeBuddyListener implements ActionListener{

 		@Override
 		 public void actionPerformed(ActionEvent e)
        { 
        	if("Remove".equals(e.getActionCommand())){		
     		model.removeElementAt(0);
		}
        }
        
     
 	};
 	
 		class changeItemListener implements ActionListener{

 		@Override
 		 public void actionPerformed(ActionEvent e)
        { 
        	if("Change".equals(e.getActionCommand())){
			gui.setSize(200, 200);
     		gui.getBuddyScreen().setModel(model);
     		gui.setVisible(true);
		}
        }
     
 	};
 
     
     class displayItemListener implements ActionListener{
         public void actionPerformed(ActionEvent e)
         { 
         	if("Display".equals(e.getActionCommand())){
         		gui.getBuddyScreen().setModel(model);
         	}
         }
         
     };
     
     class addBuddyItemListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if("Add".equals(e.getActionCommand())){
					BuddyInfo buddy = new BuddyInfo("", "", "");
					String name = JOptionPane.showInputDialog("Please enter your name");
					buddy.setName(name);
					
					String address = JOptionPane.showInputDialog("Enter your address");
					buddy.setAddress(address);
					
					String phone = JOptionPane.showInputDialog("Enter your phone number");
					buddy.setPhone(phone);
					
					model.addElement(buddy);
				}
				
			}
     	
     };
     
     class saveItemListener implements ActionListener{
     	public void actionPerformed(ActionEvent e){
     		if("Save".equals(e.getActionCommand())){
     			String data = gui.getBuddyScreen().getToolTipText();
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
     		    JOptionPane.showOptionDialog(gui,
     		    "Success!","Save",JOptionPane.PLAIN_MESSAGE,
     		    JOptionPane.QUESTION_MESSAGE,null,options,
     		    options[0]);
     		}
     	}
     };
     
     class quitItemListener implements ActionListener {
         public void actionPerformed(ActionEvent e)
         { 
         gui.dispose();
         System.exit(1);
         }
         
     }
	}   

