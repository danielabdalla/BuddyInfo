import javax.swing.DefaultListModel;


public class Main {
	public static void main(String[] args){
		
		//Instantiating the MVCs to run the program
		DefaultListModel model = new DefaultListModel();
		AddressBookGUI view = new AddressBookGUI();
		AddressController controller = new AddressController(view, model);
		
		view.setSize(400, 400);
		view.setVisible(true);
	}
}
