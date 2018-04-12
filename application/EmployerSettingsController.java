package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import users.Employer;
import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import utilityUsers.EmployerJohnDoe;

public class EmployerSettingsController {

	/**
	 * controller for the employer settings page settingsemployer.fxml
	 * takes user info from database and displays it here, allows user to edit their info
	 */
	@FXML
	private Label employerFirstName;
	@FXML
	private Label employerLastName;
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
	
	//edit buttons to edit all information
	@FXML
	private Button editFirstName;
	@FXML
	private Button editLastName;
	@FXML
	private Button editCity;
	@FXML
	private Button editProvince;
	@FXML
	private Button editCountry;
	@FXML
	private Button editCompany;
	@FXML
	private Button editHiring;
	@FXML
	private Button editEmail;
	@FXML
	private Button editPhone;
	@FXML
	private Button saveChanges;


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
	//gets employer user from database
	Employer tempEmployer = (Employer)((db.getDatabase()).get(Storage.employerName));


	/*
	 * initializes labels with user information when instance of controller is created
	 * displays all to user
	 */
	@FXML
	public void initialize() {
		employerFirstName.setText(tempEmployer.getFirstName());
		employerLastName.setText(tempEmployer.getLastName());
		employerCity.setText(tempEmployer.getCity());
		employerProvince.setText(tempEmployer.getProvince());
		employerCountry.setText(tempEmployer.getCountry());
		employerCompany.setText(tempEmployer.getCompanyName());
		employerHiring.setText(tempEmployer.getOfferingJobs());
		employerNumber.setText(tempEmployer.getPhoneNumber());
		employerEmail.setText(tempEmployer.getEmail());

	}
	
	/*
	 * edits user first name
	 * saves new name to database once "save" button is pressed
	 */
	public void editFirstName(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit First Name");
		dialog.setContentText("First Name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			//if user leaves text field blank, then keep old first name
			employerFirstName.setText(tempEmployer.getFirstName());
		}
		else {
			//set label to new first name to be saved to database later
			employerFirstName.setText(text.get());
		}
	}
	
	/*
	 * edit last name
	 */
	public void editLastName(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Last Name");
		dialog.setContentText("Last Name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerLastName.setText(tempEmployer.getLastName());
		}
		else {
			employerLastName.setText(text.get());
		}
	}
	
	/*
	 * edit city
	 */
	public void editCity(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit City");
		dialog.setContentText("City:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerCity.setText(tempEmployer.getCity());
		}
		else {
			employerCity.setText(text.get());
		}
	}

	/*
	 * edit province
	 */
	public void editProvince(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Province");
		dialog.setContentText("Province:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerProvince.setText(tempEmployer.getProvince());
		}
		else {
			employerProvince.setText(text.get());
		}
	}
	
	/*
	 * edit country
	 */
	public void editCountry(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Country");
		dialog.setContentText("Country:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerCountry.setText(tempEmployer.getCountry());
		}
		else {
			employerCountry.setText(text.get());
		}
	}
	
	/*
	 * edit company
	 */
	public void editCompany(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Company");
		dialog.setContentText("Company name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerCompany.setText(tempEmployer.getCompanyName());
		}
		else {
			employerCompany.setText(text.get());
		}
	}
	
	/*
	 * edit hiring 
	 */
	public void editHiring(ActionEvent event) throws IOException {
		List<String> choices = new ArrayList<>();
		choices.add("Yes");
		choices.add("No");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("Yes", choices);
		dialog.setTitle("Edit Hiring");
		dialog.setContentText("Currently hiring:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.get().isEmpty()) {
			employerHiring.setText(tempEmployer.getOfferingJobs());
		}
		else {
			employerHiring.setText(result.get());
		}
	}
	
	/*
	 * edit phone number
	 */
	public void editNumber(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		Alert alert = new Alert(AlertType.ERROR);
		dialog.setTitle("Edit Phone Number");
		dialog.setContentText("Phone number:");
		dialog.getEditor().setPromptText("000-000-0000");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerNumber.setText(tempEmployer.getPhoneNumber());
		}
		else if (!text.get().matches("(\\d{3}-){1,2}\\d{4}")) { //check for phone number. \\d = only digits allowed, {3} == three characters, etc.
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid phone number!");
			alert.showAndWait();
		}
		else {
			employerNumber.setText(text.get());
		}
	}
	
	/*
	 * edit email address
	 */
	public void editEmail(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		Alert alert = new Alert(AlertType.ERROR);
		dialog.setTitle("Edit Email");
		dialog.setContentText("Email address:");
		dialog.getEditor().setPromptText("johndoe@gmail.com");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			employerEmail.setText(tempEmployer.getEmail());
		}
		else if (!text.get().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid email address!");
			alert.showAndWait();
		}
		else {
			employerEmail.setText(text.get());
		}
	}
	
	/*
	 * save button, saves all changed made into database 
	 */
	public void saveButton(ActionEvent event) throws IOException {
		
		HashMap<String, User> data = db.getDatabase();
		//Student tempStudent = new Student(data.get(Storage.UID));
		Employer tempEmployer = (Employer)data.get(Storage.employerName); //?
		
		//sets all user information
		tempEmployer.setFirstName(employerFirstName.getText());
		tempEmployer.setLastName(employerLastName.getText());
		tempEmployer.setCity(employerCity.getText());
		tempEmployer.setProvince(employerProvince.getText());
		tempEmployer.setCountry(employerCountry.getText());
		tempEmployer.setCompanyName(employerCompany.getText());
		tempEmployer.setOfferingJobs(employerHiring.getText());
		tempEmployer.setEmail(employerEmail.getText());
		tempEmployer.setPhoneNumber(employerNumber.getText());
		
		//saves to database
		f.fileSave(db.getDatabase());
	}


	/*
	 * changes pages in main application
	 */
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