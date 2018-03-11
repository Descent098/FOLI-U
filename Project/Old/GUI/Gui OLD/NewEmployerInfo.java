import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class NewEmployerInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployerInfo frame = new NewEmployerInfo();
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
	public NewEmployerInfo() {
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
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblCompanyName.setBounds(45, 112, 117, 16);
		contentPane.add(lblCompanyName);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblPosition.setBounds(45, 172, 61, 16);
		contentPane.add(lblPosition);
		
		JLabel lblHiring = new JLabel("Currently hiring?");
		lblHiring.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblHiring.setBounds(45, 232, 117, 16);
		contentPane.add(lblHiring);
		
		JLabel lblNumber = new JLabel("Phone Number");
		lblNumber.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblNumber.setBounds(45, 292, 93, 16);
		contentPane.add(lblNumber);
		
		textField = new JTextField();
		textField.setBounds(192, 107, 130, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 166, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String[] hiringBool = {"Yes", "No"};
		JComboBox hiring = new JComboBox(hiringBool);
		hiring.setBounds(192, 227, 130, 27);
		hiring.setSelectedItem(null);
		contentPane.add(hiring);
		
		textField_2 = new JTextField();
		textField_2.setBounds(192, 286, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				MainPage homePage = new MainPage();
				homePage.setVisible(true);
			}
		});
		btnFinish.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnFinish.setBounds(129, 386, 117, 29);
		contentPane.add(btnFinish);

	}
}
