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
import users.Employer;
import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;


public class Controller {

	/*
	 * controller that starts up the app
	 * chooses new user or returning user
	 * 
	 */
	
	private FileIO f = new FileIO();
	private Database db = new Database(f.fileLoad()); //loads the current file each time this controller is used
	/**
	 * buttons used in controller
	 */
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
	private TextField email;


	/**
	 * method that takes user to new user page when "new user" button is clicked
	 * @param event
	 * @throws IOException
	 */
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

	/**
	 * method that takes user to returning user page
	 * @param event
	 * @throws IOException
	 */
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

	/**
	 * creates a new student user
	 * @param event
	 * @throws IOException
	 */
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

	/**
	 * creates a new employer user
	 * @param event
	 * @throws IOException
	 */
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
	
	/*
	 * back button that goes back to very first page
	 */
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


	//sign in button for returning user, brings you into app
	@FXML
	public void signInButtonClicked(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		//alert pop up box	
		//sign in with user email, looks through the database for the user email and loads up that user
        if(email.getText().isEmpty()) { //if email text field is empty
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please enter your email!");
        		alert.showAndWait();
        }
        //if email is not in the right format
        else if (!email.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid email address!");
			alert.showAndWait();
		}
        //if everything is correct, then it checks both student and employer database for corresponding user and loads up that info
        else {
        	HashMap<String, User> data = db.getDatabase();
			//Student tempStudent = new Student(data.get(Storage.UID));
			ArrayList<User> tempUser = db.searchEmail(email.getText());
			Student tempStudent = new Student();
			Employer tempEmployer = new Employer();
			
			if (tempUser.isEmpty()) {
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Invalid email!");
				alert.showAndWait();
				email.clear();
			}
			
			else if (tempUser.get(0).getEmail().equals(email.getText()) && tempUser.get(0) instanceof Student) {
				
				Student tempUserStudent = (Student)db.searchEmail(email.getText()).get(0);
				
				tempStudent.setFirstName(tempUserStudent.getFirstName());
				tempStudent.setLastName(tempUserStudent.getLastName());
				tempStudent.setUID(tempUserStudent.getUID());
				tempStudent.setCity(tempUserStudent.getCity());
				tempStudent.setProvince(tempUserStudent.getProvince());
				tempStudent.setCountry(tempUserStudent.getCountry());
				tempStudent.setUniversity(tempUserStudent.getUniversity());
				tempStudent.setDegree(tempUserStudent.getDegree());
				tempStudent.setStudentType(tempUserStudent.getStudentType());
				tempStudent.setProgramYear(tempUserStudent.getProgramYear());
				tempStudent.setPhoneNumber(tempUserStudent.getPhoneNumber());
				tempStudent.setEmail(tempUserStudent.getEmail());
				tempStudent.setGPA(tempUserStudent.getGPA());
				
				Storage.UID = (tempStudent.getUID());
				f.fileSave(db.getDatabase());
				
				Stage stage;
	        	Parent root;
	        	stage = (Stage) signIn.getScene().getWindow();
	        	root = FXMLLoader.load(getClass().getResource("home.fxml"));

	        	Scene scene = new Scene(root);
	        	stage.setScene(scene);
	        	stage.show();
			}
			else if (tempUser.get(0).getEmail().equals(email.getText()) && tempUser.get(0) instanceof Employer) {
				
				Employer tempUserEmployer = (Employer)db.searchEmail(email.getText()).get(0);
				
				tempEmployer.setFirstName(tempUserEmployer.getFirstName());
				tempEmployer.setLastName(tempUserEmployer.getLastName());
				tempEmployer.setCity(tempUserEmployer.getCity());
				tempEmployer.setProvince(tempUserEmployer.getProvince());
				tempEmployer.setCountry(tempUserEmployer.getCountry());
				tempEmployer.setCompanyName(tempUserEmployer.getCompanyName());
				tempEmployer.setOfferingJobs(tempUserEmployer.getOfferingJobs());
				tempEmployer.setPhoneNumber(tempUserEmployer.getPhoneNumber());
				tempEmployer.setEmail(tempUserEmployer.getEmail());
				
				Storage.employerName = (tempEmployer.getFirstName() + tempEmployer.getLastName());
				f.fileSave(db.getDatabase());
				
				Stage stage;
	        	Parent root;
	        	stage = (Stage) signIn.getScene().getWindow();
	        	root = FXMLLoader.load(getClass().getResource("homeemployer.fxml"));

	        	Scene scene = new Scene(root);
	        	stage.setScene(scene);
	        	stage.show();
			}
			else {
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Invalid email address!");
				alert.showAndWait();
			}
        }

	}
}
