import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuPage { //"main" class

	private JFrame menu; //menu frame

	/**
	 * Launch the application. Menu/startup screen.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage window = new MenuPage(); //window for menu
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPage() { //constructor that initializes menu
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menu = new JFrame(); //frame for menu
		menu.setResizable(false);
		menu.setForeground(Color.PINK);
		menu.getContentPane().setBackground(Color.WHITE);
		menu.setBounds(100, 100, 375, 559); //size 375x559
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		
		JButton btnNewUser = new JButton("New User"); //new user button
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //action, when button is clicked, changes to "new user" frame
				menu.setVisible(false);
				CreateUserWindow creatingUser = new CreateUserWindow();
				creatingUser.setVisible(true);
			}
		});
		btnNewUser.setBounds(129, 215, 117, 29); //button location
		menu.getContentPane().add(btnNewUser);
		
		JButton btnReturningUser = new JButton("Returning User"); //returning user button
		btnReturningUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //action, when button is clicked, changes to "returning user" frame
				menu.setVisible(false);
				ReturningUserWindow returningUser = new ReturningUserWindow();
				returningUser.setVisible(true);
			}
		});
		btnReturningUser.setBounds(129, 256, 117, 29);
		menu.getContentPane().add(btnReturningUser);
		
		JLabel lblNewLabel = new JLabel("Welcome to Foli-U"); //title, user cannot interact with this
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("AppleGothic", Font.PLAIN, 27));
		lblNewLabel.setBounds(44, 129, 287, 41);
		menu.getContentPane().add(lblNewLabel);
	}
}