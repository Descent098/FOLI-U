
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturningUserWindow extends JFrame {

	private JPanel contentPane;
	private JTextField addUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturningUserWindow frame = new ReturningUserWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReturningUserWindow() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your");
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setFont(new Font("AppleGothic", Font.PLAIN, 27));
		lblPleaseEnterYour.setBounds(44, 129, 287, 41);
		contentPane.add(lblPleaseEnterYour);
		
		addUsername = new JTextField();
		addUsername.setBounds(177, 196, 130, 26);
		contentPane.add(addUsername);
		addUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblUsername.setBounds(74, 201, 69, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblPassword.setBounds(74, 261, 61, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 255, 130, 26);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = addUsername.getText();
				String password = passwordField.getText();
				
				if (username.contains("username") && password.contains("password")) {
					addUsername.setText(null);
					passwordField.setText(null);
					contentPane.setVisible(false);
					MainPage mainpage = new MainPage();
					mainpage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login", "Login Error", JOptionPane.ERROR_MESSAGE);
					addUsername.setText(null);
					passwordField.setText(null);
				}
				
			}
		});
		btnLogin.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnLogin.setBounds(129, 318, 117, 29);
		contentPane.add(btnLogin);
	}
}
