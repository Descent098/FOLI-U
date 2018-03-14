package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NewStudentController {

	//new student or employer page
	@FXML
	private TextField enterFirstName;
	@FXML
	private TextField enterLastName;
	@FXML
	private TextField enterUsername;
	@FXML
	private TextField enterPassword;
	@FXML
	private TextField confirmPassword;
	@FXML
	private Button continueNewStudent;
	@FXML
	private Button continueNewEmployer;
	@FXML
	private TextField cityName;
	@FXML
	private ChoiceBox<String> provinceName;
	@FXML
	private ChoiceBox<String> countryName;

	//continue new student
	@FXML
	private ChoiceBox<String> universityName;
	@FXML
	private ChoiceBox<String> degree;
	@FXML
	private ChoiceBox<String> yearOfStudy;
	@FXML
	private DatePicker dateOfBirth;
	@FXML
	private Button finishNewStudent;
	@FXML
	private RadioButton calculateGPA;
	@FXML
	private RadioButton dontCalculateGPA;
	@FXML
	private ToggleGroup gpaGroup;

	//back buttons
	@FXML
	private Button backToMenu;
	@FXML
	private Button backToNewUser;
	@FXML
	private Button backToStudent;

	//new student button clicked

	@FXML
	public void initialize() {
		System.out.println("student controller");
	}

	@FXML
	public void continueButtonClickedStudent(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
				//will add if statement to make sure username isn't already taken
				//will add if statements to check other fields as well
				//if user leaves fields blank, displays error to user
        if (enterFirstName.getText().isEmpty() || enterLastName.getText().isEmpty() || enterUsername.getText().isEmpty() || enterPassword.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }
				//if the user chooses a username that is too short/long
        else if (enterUsername.getText().length() < 3 || enterUsername.getText().length() > 20) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Your username must be longer than 3 characters!");
        		alert.showAndWait();
        }
				//if the passwords do not match
				else if (!enterPassword.getText().equals(confirmPassword.getText())) {
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Passwords do not match!");
						alert.showAndWait();
				}
				//continues onto next page
        else {

//        		demoStudent.setFullName(enterFullName.getText());
//        		System.out.println(demoStudent.getFullName());

        		Stage stage;
        		Parent root;
        		stage = (Stage) continueNewStudent.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("continuenewstudent.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

	@FXML
	public void finishButtonClickedStudent(ActionEvent event) throws IOException {

		Alert alert = new Alert(AlertType.ERROR);
		Alert gpa = new Alert(AlertType.INFORMATION);
				//if user user leaves fields blank
        if (cityName.getText().isEmpty() || provinceName.getSelectionModel().isEmpty() || countryName.getSelectionModel().isEmpty() ||
        		universityName.getSelectionModel().isEmpty() || degree.getSelectionModel().isEmpty() || yearOfStudy.getSelectionModel().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }
        else {
//        		demoStudent.setCity(cityName.getText());
//        		demoStudent.setProvince(provinceName.getSelectionModel().getSelectedItem().toString());
//        		demoStudent.setCountry(countryName.getSelectionModel().getSelectedItem().toString());
//        		demoStudent.setUniversity(universityName.getSelectionModel().getSelectedItem().toString());
//			demoStudent.setDegree(degree.getSelectionModel().getSelectedItem().toString());
//			System.out.println(demoStudent.getCountry());
//			System.out.println(demoStudent.getProvince());
//			System.out.println(demoStudent.getUniversity());

						//if user chooses to calculate GPA
        		if (calculateGPA.isSelected()) {
							//add code for calculating GPA later
        			gpa.setTitle("Information Dialog");
        			gpa.setHeaderText("Look, an Information Dialog");
        			gpa.setContentText("GPA Calculator!");
        			gpa.showAndWait();
        		}
						//otherwise, sign up is completed
        		else {

        			Stage stage;
        			Parent root;
        			stage = (Stage) finishNewStudent.getScene().getWindow();
        			root = FXMLLoader.load(getClass().getResource("home.fxml"));

        			Scene scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();
        		}
        }

	}
	
	@FXML
	public void backButtonClickedNewUser(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToNewUser.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newuserpage.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void backButtonClicked(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToMenu.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void backButtonClickedStudent(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToStudent.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newstudent.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
