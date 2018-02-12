import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane; //default page aka home
	MyProfile profilePage; //profile page
	Search searchPage; //search page
	Options optionsPage; //options page
	//can change + add different pages later depending on what we decide to do with app

	/**
	 * Main page of application. User can navigate between home/profile/search/options screens (with card layout)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		
		profilePage = new MyProfile();
		searchPage = new Search();
		optionsPage = new Options();
		
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		GridBagLayout layout = new GridBagLayout(); //makes this screen into a grid format
		//top part of page includes buttons for home, profile etc.
		//rest of page are the "cards" for each page (home, profile, etc.) that can be switched when you press corresponding buttons
		//if no button is pressed, default is home page. this means that the home page is the default page 
		//that comes up after you sign into the app
		layout.columnWidths = new int[]{0, 0, 0, 0, 0};
		layout.rowHeights = new int[]{0, 0, 0, 0};
		layout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(layout);
		
		GridBagConstraints p = new GridBagConstraints(); //constraints (size + location) for profile page when it is selected to be shown
		GridBagConstraints s = new GridBagConstraints(); //constraints for search page
		GridBagConstraints o = new GridBagConstraints(); //constraints for options page
		p.gridx = 0; //constraints info for profile, search, options
		p.gridy = 1;
		p.gridheight = 2;
		p.gridwidth = 4;
		p.insets = new Insets(0, 0, 0, 0);
		p.fill = GridBagConstraints.BOTH;
		contentPane.add(profilePage,p);
		s.gridx = 0;
		s.gridy = 1;
		s.gridheight = 2;
		s.gridwidth = 4;
		s.insets = new Insets(0, 0, 0, 0);
		s.fill = GridBagConstraints.BOTH;
		contentPane.add(searchPage,s);
		o.gridx = 0;
		o.gridy = 1;
		o.gridheight = 2;
		o.gridwidth = 4;
		o.insets = new Insets(0, 0, 0, 0);
		o.fill = GridBagConstraints.BOTH;
		contentPane.add(optionsPage,o);
		profilePage.setVisible(false); //all set to invisible (home page is default) until corresponding button selected
		searchPage.setVisible(false);
		optionsPage.setVisible(false);
		
		
		
		JButton btnHome = new JButton("Home"); //button that shows user home page
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilePage.setVisible(false);
				searchPage.setVisible(false);
				optionsPage.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnHome = new GridBagConstraints(); //location of home button
		gbc_btnHome.insets = new Insets(0, 0, 5, 5);
		gbc_btnHome.gridx = 0;
		gbc_btnHome.gridy = 0;
		contentPane.add(btnHome, gbc_btnHome);
		
		JButton btnMyProfile = new JButton("My Profile"); //button that shows user their profile page
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilePage.setVisible(true); //changes corresponding page to visible, everything else invisible
				searchPage.setVisible(false);
				optionsPage.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnMyProfile = new GridBagConstraints(); //location of profile button
		gbc_btnMyProfile.insets = new Insets(0, 0, 5, 5);
		gbc_btnMyProfile.gridx = 1;
		gbc_btnMyProfile.gridy = 0;
		contentPane.add(btnMyProfile, gbc_btnMyProfile);
		
		JButton btnSearch = new JButton("Search"); //button for search page
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilePage.setVisible(false);
				searchPage.setVisible(true);
				optionsPage.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints(); //location of search button
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 0;
		contentPane.add(btnSearch, gbc_btnSearch);
		
		JButton btnOptions = new JButton("Options"); //button for options page
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilePage.setVisible(false);
				searchPage.setVisible(false);
				optionsPage.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnOptions = new GridBagConstraints(); //location of options button
		gbc_btnOptions.insets = new Insets(0, 0, 5, 0);
		gbc_btnOptions.gridx = 3;
		gbc_btnOptions.gridy = 0;
		contentPane.add(btnOptions, gbc_btnOptions);
		
		JPanel panel = new JPanel(); //home page panel, is shown when everything else is invisble (no button is selected)
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
	}

}
