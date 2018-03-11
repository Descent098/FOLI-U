import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CreateNewEmployer extends JFrame {

	private JPanel contentPane;
	private JTextField fullName;
	private JTextField setUsername;
	private JTextField Username;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewEmployer frame = new CreateNewEmployer();
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
	public CreateNewEmployer() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("AppleGothic", Font.PLAIN, 18));
		lblSignUp.setBounds(134, 25, 107, 32);
		contentPane.add(lblSignUp);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblFullName.setBounds(45, 112, 80, 16);
		contentPane.add(lblFullName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblUsername.setBounds(45, 232, 80, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblPassword.setBounds(45, 292, 61, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(45, 352, 113, 16);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblEmail.setBounds(45, 172, 61, 16);
		contentPane.add(lblEmail);
		
		fullName = new JTextField();
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
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				NewEmployerInfo employerInfo = new NewEmployerInfo();
				employerInfo.setVisible(true);
			}
		});
		btnContinue.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnContinue.setBounds(129, 429, 117, 29);
		contentPane.add(btnContinue);
	}

}
