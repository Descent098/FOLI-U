package application;

import java.io.IOException;
import java.util.Optional;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import users.Employer;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import utilityUsers.EmployerJohnDoe;

public class EmployerSettingsController {

	/**
	 * controller for the student settings page
	 * takes user info from database and displays it here, allows user to edit their info
	 */
	@FXML
	private Label employerName;
	@FXML
	private Label employerUsername;
	@FXML
	private Label employerPassword;
	@FXML
	private Label employerCity;
	@FXML
	private Label employerProvince;
	@FXML
	private Label employerCountry;
	@FXML
	private Label employerCompany;
	@FXML
	private Label employerEmail;
	@FXML
	private Label employerNumber;
	@FXML
	private Label employerHiring;


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



	//loading the file, and grabbing the current student out of it to use
	private FileIO f = new FileIO();
	private Database db = new Database(f.fileLoad());
	//HashMap<String, User> data = db.getDatabase();
	Employer tempEmployer = (Employer)((db.getDatabase()).get(Storage.employerName));



	@FXML
	private EmployerJohnDoe johnDoe = new EmployerJohnDoe();

	@FXML
	public void initialize() {
		employerName.setText(tempEmployer.getFirstName() + " " + tempEmployer.getLastName());
		employerCity.setText(tempEmployer.getCity());
		employerProvince.setText(tempEmployer.getProvince());
		employerCountry.setText(tempEmployer.getCountry());
		employerCompany.setText(tempEmployer.getCompanyName());
		employerHiring.setText(tempEmployer.getOfferingJobs());
		employerNumber.setText(tempEmployer.getPhoneNumber());
		employerEmail.setText(tempEmployer.getEmail());

	}


	public void changePage(ActionEvent event) throws IOException {
		//if home button clicked or if no button specified (default home)
		if (event.getTarget() == home || event.getTarget() == null) {
			Stage stage;
			Parent root;
    			stage = (Stage) home.getScene().getWindow();
    			root = FXMLLoader.load(getClass().getResource("homeemployer.fxml"));

    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
		}
		//if search button clicked
		else if (event.getTarget() == search) {
			Stage stage;
			Parent root;
			stage = (Stage) search.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("searchemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		//if settings button clicked
		}
		else if (event.getTarget() == settings) {
			Stage stage;
			Parent root;
			stage = (Stage) settings.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("settingsemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		//if profile button clicked
		else if (event.getTarget() == myProfile) {
			Stage stage;
			Parent root;
			stage = (Stage) myProfile.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("profileemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
}