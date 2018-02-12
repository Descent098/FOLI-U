import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateNewStudent extends JFrame { 

	private JPanel contentPane;
	private JTextField fullName;
	private JTextField setUsername;
	private JTextField Username;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;

	/**
	 * Creates new student user, takes name + username + password + email information
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewStudent newStudent = new CreateNewStudent();
					newStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateNewStudent() {
		setForeground(Color.LIGHT_GRAY); //panel info 
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up"); //title
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("AppleGothic", Font.PLAIN, 18));
		lblSignUp.setBounds(134, 25, 107, 32);
		contentPane.add(lblSignUp);
		
		JLabel lblFullName = new JLabel("Full Name"); //"full name" text
		lblFullName.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblFullName.setBounds(45, 112, 80, 16);
		contentPane.add(lblFullName);
		
		JLabel lblUsername = new JLabel("Username"); //"username" text
		lblUsername.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblUsername.setBounds(45, 232, 80, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password"); //"password" text
		lblPassword.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblPassword.setBounds(45, 292, 61, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password"); //"confirm password" text
		lblConfirmPassword.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(45, 352, 113, 16);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email"); //"email" text
		lblEmail.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblEmail.setBounds(45, 172, 61, 16);
		contentPane.add(lblEmail);
		
		fullName = new JTextField(); //variables 
		fullName.setBounds(192, 106, 130, 26);
		contentPane.add(fullName);
		fullName.setColumns(10);
		
		setUsername = new JTextField();
		setUsername.setBounds(192, 166, 130, 26);
		contentPane.add(setUsername);
		setUsername.setColumns(10);
		
		Username = new JTextField();
		Username.setBounds(192, 226, 130, 26);
		contentPane.add(Username);
		Username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 286, 130, 26);
		contentPane.add(passwordField);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(192, 346, 130, 26);
		contentPane.add(passwordConfirm);
		
		JButton btnContinue = new JButton("Continue"); //button for continue, moves onto "new student info" panel
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //should add if statement(s) to confirm that info is entered correctly
				
				contentPane.setVisible(false); //if true then move onto next panel
				NewStudentInfo studentInfo = new NewStudentInfo();
				studentInfo.setVisible(true);
			}
		});
		btnContinue.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnContinue.setBounds(129, 429, 117, 29);
		contentPane.add(btnContinue);
	}
}