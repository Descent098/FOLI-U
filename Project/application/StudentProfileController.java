package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class StudentProfileController {
	
	/**
	 * controller for the student profile page
	 * tkaes user info from database and displays it here
	 */
	@FXML
	private Label studentName;
	@FXML
	private Label studentUsername;
	@FXML
	private Label studentPassword;
	@FXML
	private Label studentCity;
	@FXML
	private Label studentProvince;
	@FXML
	private Label studentCountry;
	@FXML
	private Label studentUni;
	@FXML
	private Label studentDegree;
	@FXML
	private Label studentYear;
	@FXML
	private Label studentDOB;
	@FXML
	private Label studentID;
	
	
	@FXML
	private Stack<Scene> pages;
	@FXML
	private Button home;
	@FXML
	private Button settings;
	@FXML
	private Button search;
	@FXML
	private Button myProfile;
	
	@FXML
	private TextArea aboutMe;
	
	@FXML
	private JohnDoe johnDoe = new JohnDoe();
	
	/**
	 * automatically called at end of instance creation, sets labels to display users information
	 */
	@FXML
	public void initialize() {
		studentName.setText(johnDoe.getFirstName() + " " + johnDoe.getLastName());
		studentCity.setText(johnDoe.getCity());
		studentCountry.setText(johnDoe.getCountry());
		studentUni.setText(johnDoe.getUniversity());
		studentDegree.setText(johnDoe.getDegree());
		studentID.setText(johnDoe.getUID());
	}
	
	
	public void changePage(ActionEvent event) throws IOException {
		//if home button clicked or if no button specified (default home)
		if (event.getTarget() == home || event.getTarget() == null) {
			Stage stage;
			Parent root;
    			stage = (Stage) home.getScene().getWindow();
    			root = FXMLLoader.load(getClass().getResource("home.fxml"));

    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
		}
		//if search button clicked
		else if (event.getTarget() == search) {
			Stage stage;
			Parent root;
			stage = (Stage) search.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("searchpage.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		//if settings button clicked
		}
		else if (event.getTarget() == settings) {
			Stage stage;
			Parent root;
			stage = (Stage) settings.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("settingspage.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		//if profile button clicked
		else if (event.getTarget() == myProfile) {
			Stage stage;
			Parent root;
			stage = (Stage) myProfile.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("profilepage.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
}
