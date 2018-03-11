import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javafx.scene.control.Menu;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUserWindow extends JFrame { //subclass

	private JPanel contentPane; 

	/**
	 * Allows user to select whether they are registering as a student or an employer
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUserWindow frame = new CreateUserWindow();
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
	public CreateUserWindow() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAre = new JLabel("Are you a..."); //label
		lblAre.setFont(new Font("AppleGothic", Font.PLAIN, 27));
		lblAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAre.setBounds(44, 129, 287, 41);
		contentPane.add(lblAre);
		
		JButton btnStudent = new JButton("Student?"); //student button, takes user to "create new student" panel
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				CreateNewStudent newStudent = new CreateNewStudent();
				newStudent.setVisible(true);
			}
		});
		btnStudent.setBounds(129, 215, 117, 29);
		contentPane.add(btnStudent);
		
		JButton btnEmployer = new JButton("Employer?"); //employer button, takes user to "create new employer" panel
		btnEmployer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				CreateNewEmployer newEmployer = new CreateNewEmployer();
				newEmployer.setVisible(true);
			}
		});
		btnEmployer.setBounds(129, 256, 117, 29);
		contentPane.add(btnEmployer);
		
		JButton btnBack = new JButton("Back"); //back button to go back to previous screen (menu). doesn't work yet
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnBack.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnBack.setBounds(6, 6, 62, 29);
		contentPane.add(btnBack);
	}

}
