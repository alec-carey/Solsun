import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.Action;


public class Login {

	private JFrame frmSolsunMsLogin;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	private String username;
	private String password;
	private String url = "jdbc:oracle:thin:@Akira:1521:xe";
	private Connection connection = null;
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSolsunMsLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolsunMsLogin = new JFrame();
		frmSolsunMsLogin.setTitle("Solsun MS Login");
		frmSolsunMsLogin.setBounds(100, 100, 412, 404);
		frmSolsunMsLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSolsunMsLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		frmSolsunMsLogin.getContentPane().add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alec\\Dropbox\\ITC303\\Solsun\\img\\logo.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_1.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setAction(action_1);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_1.add(btnLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmSolsunMsLogin.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblDatabseStatus = new JLabel("Databse Status:");
		lblDatabseStatus.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_2.add(lblDatabseStatus);
		
		JLabel lblNewLabel_3 = new JLabel("Online");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_2.add(lblNewLabel_3);
		
		JMenuBar menuBar = new JMenuBar();
		frmSolsunMsLogin.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Options");
		menuBar.add(mnFile);
		
		JMenuItem mntmChangeDatabaseName = new JMenuItem("Databse name");
		mntmChangeDatabaseName.setAction(action);
		mnFile.add(mntmChangeDatabaseName);
	}

	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Change Database");
			putValue(SHORT_DESCRIPTION, "Changes the database name");
		}
		public void actionPerformed(ActionEvent e) {
			url = (String)JOptionPane.showInputDialog("New Connection String", "jdbc:oracle:thin:@Akira:1521:xe");
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 836373841230010602L;
		public SwingAction_1() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Logs into the database with selected username and password");
		}
		public void actionPerformed(ActionEvent e) {
			username = textField_1.getText();
			char[] input = passwordField.getPassword();
			password = new String(input);
			try {
				connection = DriverManager.getConnection(url, username, password);			
				JOptionPane.showMessageDialog(frmSolsunMsLogin, "Connected as: " + username);
				Arrays.fill(input,  '0');
				StaffWindow.main(null);			//this is bad
				frmSolsunMsLogin.dispose();		
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frmSolsunMsLogin, "Wrong username and password, try again");
			}

		}
	}
}
