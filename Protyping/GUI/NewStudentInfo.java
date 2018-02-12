import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewStudentInfo extends JFrame {

	private JPanel contentPane;
	private JTextField studentIDText; //text field where user enters their ID
	private JTextField gpaText; //text field where user enters GPA

	/**
	 * Continues creating new student user, takes university information
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudentInfo frame = new NewStudentInfo();
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
	public NewStudentInfo() {
		setForeground(Color.LIGHT_GRAY);
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
		
		JLabel lblUniversity = new JLabel("University"); //"university" text
		lblUniversity.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblUniversity.setBounds(45, 112, 80, 16);
		contentPane.add(lblUniversity);
		
		JLabel lblMajor = new JLabel("Major"); //"major" text
		lblMajor.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblMajor.setBounds(45, 232, 80, 16);
		contentPane.add(lblMajor);
		
		JLabel lblYear = new JLabel("Year of Study"); //"year" text
		lblYear.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblYear.setBounds(45, 292, 93, 16);
		contentPane.add(lblYear);
		
		JLabel lblGPA = new JLabel("GPA"); //"gpa" text, optional (can be calculated later in app)
		lblGPA.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblGPA.setBounds(45, 352, 46, 16);
		contentPane.add(lblGPA);
		
		JLabel lblID = new JLabel("Student ID"); //"student ID" text
		lblID.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lblID.setBounds(45, 172, 61, 16);
		contentPane.add(lblID);

		String[] yearList = {"1", "2", "3", "4", "5", "6"}; //"year" options for combo box, can be changed/expanded later
		JComboBox year = new JComboBox(yearList);
		year.setSelectedItem(null); //default selection is nothing
		year.setBounds(192, 287, 130, 26);
		contentPane.add(year);
		
		studentIDText = new JTextField(); 
		studentIDText.setBounds(192, 166, 130, 26);
		contentPane.add(studentIDText);
		studentIDText.setColumns(10);
		
		gpaText = new JTextField();
		gpaText.setBounds(192, 346, 130, 26);
		contentPane.add(gpaText);
		gpaText.setColumns(10);
		
		String[] majorList = {"Computer Science", "Engineering", "Business", "Art", "Nursing"}; //"major" options for combo box, can be changed/expanded later
		JComboBox major = new JComboBox(majorList);
		major.setSelectedItem(null);
		major.setBounds(192, 227, 130, 26);
		contentPane.add(major);
		
		String[] uniList = {"University of Calgary", "Mount Royal"}; //"university options", can be changed/expanded later
		JComboBox universities = new JComboBox(uniList);
		universities.setSelectedItem(null);
		universities.setBounds(192, 107, 130, 27);
		contentPane.add(universities);
		
		JButton btnFinish = new JButton("Finish"); //finish button, moves onto "main page" panel (end of signup screen, enters actual app itself)
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //should include if statement(s) to make sure info is entered correctly
				contentPane.setVisible(false);
				MainPage homePage = new MainPage();
				homePage.setVisible(true);
			}
		});
		btnFinish.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnFinish.setBounds(129, 429, 117, 29);
		contentPane.add(btnFinish);
		
		JLabel lbloptional = new JLabel("(optional)"); //"optional" text
		lbloptional.setForeground(new Color(192, 192, 192));
		lbloptional.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		lbloptional.setBounds(77, 352, 61, 16);
		contentPane.add(lbloptional);
		
	}
}
