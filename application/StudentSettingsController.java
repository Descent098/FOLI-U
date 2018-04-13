package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;

public class StudentSettingsController {

	/**
	 * controller for the student settings page settingspage.fxml
	 * takes user info from database and displays it here, allows user to edit their info
	 */
	@FXML
	private Label studentFirstName;
	@FXML
	private Label studentLastName;
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
	private Label studentEmail;
	@FXML
	private Label studentNumber;
	@FXML
	private Label studentType;
	@FXML 
	private Label studentGPA;
	
	//edit buttons for student information, saves to database when "save" button is pressed
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
	private Button editUni;
	@FXML
	private Button editDegree;
	@FXML
	private Button editYear;
	@FXML
	private Button editEmail;
	@FXML
	private Button editPhone;
	@FXML
	private Button editType;
	@FXML
	private Button editGPA;
	@FXML
	private Button editDOB;
	@FXML
	private Button calculateGPA;
	
	//saves changes made to database
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
	//HashMap<String, User> data = db.getDatabase();
	Student tempStudent = (Student)((db.getDatabase()).get(Storage.UID)); //retrieve the student from the hashmap within the database class while casting it

	/*
	 * initializes all labels with student information
	 * called automatically at the beginning of each instance of class
	 */
	@FXML
	public void initialize() {
		studentFirstName.setText(tempStudent.getFirstName());
		studentLastName.setText(tempStudent.getLastName());
		studentCity.setText(tempStudent.getCity());
		studentProvince.setText(tempStudent.getProvince());
		studentCountry.setText(tempStudent.getCountry());
		studentUni.setText(tempStudent.getUniversity());
		studentDegree.setText(tempStudent.getDegree());
		studentType.setText(tempStudent.getStudentType());
		String year = Integer.toString(tempStudent.getProgramYear());
		studentYear.setText(year);
		studentNumber.setText(tempStudent.getPhoneNumber());
		studentEmail.setText(tempStudent.getEmail());
		if (tempStudent.getGPA() == null) {
			studentGPA.setText("No info");
		}
		else {
		String GPA = Double.toString(tempStudent.getGPA());
		studentGPA.setText(GPA);
		}
	}
	
	/*
	 * edit student first name
	 * opens new window with text field
	 */
	public void editFirstName(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit First Name");
		dialog.setContentText("First Name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			//if user leaves input blank, keeps old first name
			studentFirstName.setText(tempStudent.getFirstName());
		}
		else {
			//updates label with new first name to be saved to database later
			studentFirstName.setText(text.get());
		}
	}
	
	/*
	 * edit student last name
	 */
	public void editLastName(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Last Name");
		dialog.setContentText("Last Name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			studentLastName.setText(tempStudent.getLastName());
		}
		else {
			studentLastName.setText(text.get());
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
			studentCity.setText(tempStudent.getCity());
		}
		else {
			studentCity.setText(text.get());
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
			studentProvince.setText(tempStudent.getProvince());
		}
		else {
			studentProvince.setText(text.get());
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
			studentCountry.setText(tempStudent.getCountry());
		}
		else {
			studentCountry.setText(text.get());
		}
	}
	
	/*
	 * edit university
	 */
	public void editUni(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit University");
		dialog.setContentText("University name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			studentUni.setText(tempStudent.getUniversity());
		}
		else {
			studentUni.setText(text.get());
		}
	}
	
	/*
	 * edit degree
	 */
	public void editDegree(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Degree");
		dialog.setContentText("Degree name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			studentDegree.setText(tempStudent.getDegree());
		}
		else {
			studentDegree.setText(text.get());
		}
	}
	
	/*
	 * edit year of study
	 */
	public void editYear(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Year");
		dialog.setContentText("Year of study:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			studentYear.setText(Integer.toString(tempStudent.getProgramYear()));
		}
		else {
			studentYear.setText(text.get());
		}
	}
	
	/*
	 * edit degree type
	 */
	public void editType(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Degree Type");
		dialog.setContentText("Degree type:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			studentType.setText(tempStudent.getStudentType());
		}
		else {
			studentType.setText(text.get());
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
			studentNumber.setText(tempStudent.getPhoneNumber());
		}
		else if (!text.get().matches("(\\d{3}-){1,2}\\d{4}")) { //check for phone number. \\d = only digits allowed, {3} == three characters, etc.
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid phone number!");
			alert.showAndWait();
		}
		else {
			studentNumber.setText(text.get());
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
			studentEmail.setText(tempStudent.getEmail());
		}
		else if (!text.get().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid email address!");
			alert.showAndWait();
		}
		else {
			studentEmail.setText(text.get());
		}
	}
	
	/*
	 * edit GPA
	 */
	public void editGPA(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		Alert alert = new Alert(AlertType.ERROR);
		dialog.setTitle("Edit GPA");
		dialog.setContentText("GPA:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		if (text.get().isEmpty()) {
			studentGPA.setText(Double.toString(tempStudent.getGPA()));
		}
		//if GPA is not in the correct range
		else if (Double.parseDouble(text.get()) < 0 || Double.parseDouble(text.get()) > 4.3) {
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid GPA!");
			alert.showAndWait();
		}
		else {
			studentGPA.setText(text.get());
		}
	}
	
	/*
	 * calculates GPA
	 */
	public void calculateGPA(ActionEvent event) throws IOException {
		TextInputDialog gpa = new TextInputDialog();
		//same as in new student controller
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		//gets number of courses
		TextField numOfCourses = new TextField();
		numOfCourses.setPromptText("0");
		Button numCoursesButton = new Button("Enter");
		
		grid.add(new Label("Enter number of courses: "), 0, 0);
		grid.add(numOfCourses, 1, 0);
		grid.add(numCoursesButton, 2, 0);
		
		gpa.getDialogPane().setContent(grid);
		gpa.setTitle("GPA Calculator");
		
		ArrayList<TextField> course = new ArrayList<TextField>();
		ArrayList<TextField> weightForCourse = new ArrayList<TextField>();
		
		//makes text fields for each course, adds text field to array lists to access later
		numCoursesButton.setOnAction((ActionEvent)->{
			for (int i = 0; i < Integer.parseInt(numOfCourses.getText()); i++) {
				TextField courseNumber = new TextField();
				courseNumber.setPromptText("Grade for class");
				TextField weightNumber = new TextField();
				weightNumber.setPromptText("Weight for class");
				grid.add(new Label("Class" + " " + (i + 1)), 0, i + 1);
				course.add(courseNumber);
				weightForCourse.add(weightNumber);
				grid.add(courseNumber, 1, i + 1);
				grid.add(weightNumber, 2, i + 1);
				gpa.getDialogPane().setContent(grid);
				gpa.getDialogPane().getScene().getWindow().sizeToScene();
			}
	    });
		
		//looks at each text field in array lists and calculates GPA
		Optional<String> result = gpa.showAndWait();
		if (result.isPresent()) {
			double GPA = 0.0;
			double weightTotal = 0.0;
			for (int i = 0; i < course.size(); i++) {
				double grade = Double.parseDouble(course.get(i).getText());
				double weight = Double.parseDouble(weightForCourse.get(i).getText());
				GPA += (grade*weight);
				weightTotal += weight;	
			}
			GPA /= weightTotal;
			//rounds GPA to 2 decimal points
			double roundedGPA = Math.round(GPA * 100.0) / 100.0;
			studentGPA.setText(Double.toString(roundedGPA));
		}
	}
	
	/*
	 * saves changes made into database
	 */
	public void saveButton(ActionEvent event) throws IOException {
		
		HashMap<String, User> data = db.getDatabase();
		//Student tempStudent = new Student(data.get(Storage.UID));
		Student tempStudent = (Student)data.get(Storage.UID); //?
		
		//updates database to have same information as on the labels
		tempStudent.setFirstName(studentFirstName.getText());
		tempStudent.setLastName(studentLastName.getText());
		tempStudent.setCity(studentCity.getText());
		tempStudent.setProvince(studentProvince.getText());
		tempStudent.setCountry(studentCountry.getText());
		tempStudent.setUniversity(studentUni.getText());
		tempStudent.setDegree(studentDegree.getText());
		String year = studentYear.getText();
		tempStudent.setProgramYear(Integer.parseInt(year));
		tempStudent.setEmail(studentEmail.getText());
		tempStudent.setPhoneNumber(studentNumber.getText());
		tempStudent.setGPA(Double.parseDouble(studentGPA.getText()));
		
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