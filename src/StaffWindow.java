import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;


public class StaffWindow {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffWindow window = new StaffWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StaffWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Staff Window");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		table = new JTable();
		panel.add(table);
	}
	
	private JTable getStaffData(){
		JTable staffTable = new JTable();
		String[] columnNames = {"Staff Number",
								"First Name",
								"Last Name",
								"Hire Date",
								"Street number",
								"Address",
								"Address 2",
								"Suburb",
								"State"};
		Object[][] data = {
				
								
								
		};
		return staffTable;
	}

}

