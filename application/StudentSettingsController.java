package application;

import java.io.IOException;
import java.util.Optional;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import users.Student;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import utilityUsers.JohnDoe;

public class StudentSettingsController {

	/**
	 * controller for the student settings page
	 * takes user info from database and displays it here, allows user to edit their info
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
	private Label studentEmail;
	@FXML
	private Label studentNumber;
	@FXML
	private Label studentType;
	@FXML 
	private Label studentGPA;
	
	@FXML
	private Button editName;
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



	@FXML
	private JohnDoe johnDoe = new JohnDoe();

	@FXML
	public void initialize() {
		studentName.setText(tempStudent.getFirstName() + " " + tempStudent.getLastName());
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

	}
	
	public void editName(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Name");
		dialog.setContentText("Full name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		tempStudent.setFirstName(text.get().substring(0, 1));
		tempStudent.setLastName(text.get().substring(1));
		studentName.setText(text.get());
	}
	
	public void editCity(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit City");
		dialog.setContentText("City:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentCity.setText(text.get());
	}

	public void editProvince(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Province");
		dialog.setContentText("Province:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentProvince.setText(text.get());
	}
	
	public void editCountry(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Country");
		dialog.setContentText("Country:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentCountry.setText(text.get());
	}
	
	public void editUni(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit University");
		dialog.setContentText("University name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentUni.setText(text.get());
	}
	
	public void editDegree(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Degree");
		dialog.setContentText("Degree name:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentDegree.setText(text.get());
	}
	
	public void editYear(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Year");
		dialog.setContentText("Year of study:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentYear.setText(text.get());
	}
	
	public void editType(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Degree Type");
		dialog.setContentText("Degree type:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentType.setText(text.get());
	}
	
	public void editDOB(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Birthday");
		dialog.setContentText("Date of birth:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentDOB.setText(text.get());
	}
	
	public void editNumber(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Phone Number");
		dialog.setContentText("Phone number:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentNumber.setText(text.get());
	}
	
	public void editEmail(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit Email");
		dialog.setContentText("Email address:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentEmail.setText(text.get());
	}
	
	public void editGPA(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit GPA");
		dialog.setContentText("GPA:");
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		studentGPA.setText(text.get());
	}
	
	public void calculateGPA(ActionEvent event) throws IOException {
		TextInputDialog gpa = new TextInputDialog();
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));


		TextField numOfCourses = new TextField();
		numOfCourses.setPromptText("0");
		Button numCoursesButton = new Button("Enter");
		TextField firstCourse = new TextField();
		firstCourse.setPromptText("0");
		Button firstCourseButton = new Button("Enter");
		TextField secondCourse = new TextField();
		secondCourse.setPromptText("0");
		Button secondCourseButton = new Button("Enter");

		grid.add(new Label("Enter number of courses: "), 0, 0);
		grid.add(numOfCourses, 1, 0);
		grid.add(numCoursesButton, 2, 0);
		grid.add(new Label("Enter First Class: "), 0, 1);
		grid.add(firstCourse, 1, 1);
		grid.add(firstCourseButton, 2, 1);
		grid.add(new Label("Enter Second Class: "), 0, 2);
		grid.add(secondCourse, 1, 2);
		grid.add(secondCourseButton, 2, 2);

		gpa.getDialogPane().setContent(grid);
		gpa.setTitle("GPA Calculator");

		Optional<String> result = gpa.showAndWait();
		if (!result.get().isEmpty()){
		    System.out.println("1");
		}
	}
	
	public void saveButton(ActionEvent event) throws IOException {
		tempStudent.setFirstName(studentName.getText().substring(0, 1));
		tempStudent.setLastName(studentName.getText().substring(1));
		tempStudent.setCity(studentCity.getText());
		tempStudent.setProvince(studentProvince.getText());
		tempStudent.setCountry(studentCountry.getText());
		tempStudent.setUniversity(studentUni.getText());
		tempStudent.setDegree(studentDegree.getText());
		String year = studentYear.getText();
		tempStudent.setProgramYear(Integer.parseInt(year));
		tempStudent.setEmail(studentEmail.getText());
		tempStudent.setPhoneNumber(studentNumber.getText());
		String gpa = studentGPA.getText();
		tempStudent.setGPA(Double.parseDouble(gpa));
		
		f.fileSave(db.getDatabase());
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