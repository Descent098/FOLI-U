package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Stack;


public class Controller {

	//updates user database from input. not in use yet.
	//Student demoStudent;
	Student demoStudent = new Student();


	//user data from input
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

	//main page
	@FXML
	private Button newUser;
	@FXML
	private Button returningUser;

	//new user page
	@FXML
	private Button newStudent;

	//new employer page
	@FXML
	private Button newEmployer;

	//new student or employer page
	@FXML
	private TextField enterFullName;
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

	//continue new employer
	@FXML
	private TextField companyName;
	@FXML
	private ChoiceBox<String> field;
	@FXML
	private TextField emailAddress;
	@FXML
	private TextField phoneNumber;
	@FXML
	private ChoiceBox<String> lookingToHire;
	@FXML
	private Button finishNewEmployer;

	//back buttons
	@FXML
	private Button backToMenu;
	@FXML
	private Button backToNewUser;
	@FXML
	private Button backToStudent;
	@FXML
	private Button backToEmployer;

	//returning user page
	@FXML
	private Button signIn;
	@FXML
	private TextField username;
	@FXML
	private TextField password;

	//in app home, settings, search, and profile page
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
	private void initialize() {
	}

	//when user clicks new user button
	@FXML
	public void newUserClicked(ActionEvent event) throws IOException {
		//sets new stage for the new page
		Stage stage;
		Parent root;
		stage = (Stage) newUser.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newuserpage.fxml")); //new page

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// user clicks returning user button
	@FXML
	public void returningUserClicked(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) returningUser.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("returninguserpage.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//new student button clicked
	@FXML
	public void newStudentClicked(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) newStudent.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newstudent.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//new employer button clicked
	@FXML
	public void newEmployerClicked(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) newEmployer.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newemployer.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

 //continue student creation button clicked
	@FXML
	public void continueButtonClickedStudent(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
				//will add if statement to make sure username isn't already taken
				//will add if statements to check other fields as well
				//if user leaves fields blank, displays error to user
        if (enterFullName.getText().isEmpty() || enterUsername.getText().isEmpty() || enterPassword.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
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
        		Stage stage;
        		Parent root;
        		stage = (Stage) continueNewStudent.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("continuenewstudent.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

 // continue employer creation button clicked
	@FXML
	public void continueButtonClickedEmployer(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
        if (enterFullName.getText().isEmpty() || enterUsername.getText().isEmpty() || enterPassword.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }

        else if (enterUsername.getText().length() < 3 || enterUsername.getText().length() > 20) {
    				alert.setTitle("Error");
    				alert.setHeaderText(null);
    				alert.setContentText("Your username must be between 3 and 20 characters!");
    				alert.showAndWait();
    		}
				else if (!enterPassword.getText().equals(confirmPassword.getText())) {
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Passwords do not match!");
						alert.showAndWait();
				}
        else {
        		Stage stage;
        		Parent root;
        		stage = (Stage) continueNewEmployer.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("continuenewemployer.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

 	//finish student creation button clicked
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
						//if user chooses to calculate GPA
        		if (calculateGPA.isSelected()) {
							//add code for calculating GPA later
        			System.out.println("test");
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

				demoStudent.setUniversity(universityName.getSelectionModel().getSelectedItem().toString());
				demoStudent.setDegree(degree.getSelectionModel().getSelectedItem().toString());
				

	}

	//finish employer button clicked
	@FXML
	public void finishButtonClickedEmployer(ActionEvent event) throws IOException {

		Alert alert = new Alert(AlertType.ERROR);
        if (cityName.getText().isEmpty() || provinceName.getSelectionModel().isEmpty() || countryName.getSelectionModel().isEmpty() ||
        		companyName.getText().isEmpty() || field.getSelectionModel().isEmpty() || emailAddress.getText().isEmpty() ||
        		phoneNumber.getText().isEmpty() || lookingToHire.getSelectionModel().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }
				//checks if email address is in valid format
				//letters/digits followed by @ followed by letters/digits followed by . followed by letters
        else if (!emailAddress.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
		      "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Invalid email address!");
        		alert.showAndWait();
        }
				//checks if phone number is in the right format
				//both 000-000-0000 and 0000000000 work
				else if (!phoneNumber.getText().matches("(\\d{3}-){1,2}\\d{4}")) { //check for phone number. \\d = only digits allowed, {3} == three characters, etc.
          		alert.setTitle("Error");
          		alert.setHeaderText(null);
          		alert.setContentText("Invalid phone number!");
          		alert.showAndWait();
          }
        else {
        		Stage stage;
        		Parent root;
        		stage = (Stage) finishNewEmployer.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("home.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

 //back to menu back
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

  //back button in student sign up
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

	//back button in employer sign up
	@FXML
	public void backButtonClickedEmployer(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToEmployer.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newemployer.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//back button after choosing new user
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

	//sign in button for returning user, brings you into app
	@FXML
	public void signInButtonClicked(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
				//if the ser leaves fields empty
        if(username.getText().isEmpty() || password.getText().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Incorrect username and/or password!");
        		alert.showAndWait();
        }
				//will add another if statement to make sure username/password are in database
        else {
        		Stage stage;
        		Parent root;
        		stage = (Stage) signIn.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("home.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

	//change between different pages in app itself (home, settings, searcg, profile page)
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
