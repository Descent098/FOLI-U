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
	 * initialize method, automatically called after all FXML methods have finished running
	 */
    public void initialize() {
    }

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
		//alert popup box		
        if(email.getText().isEmpty()) { //if username and password fields are empty
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please enter your email!");
        		alert.showAndWait();
        }
        else if (!email.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid email address!");
			alert.showAndWait();
		}
        else {
//        	HashMap<String, User> data = db.getDatabase();
//			//Student tempStudent = new Student(data.get(Storage.UID));
//			Student tempStudent = (Student)data.get(Storage.UID); //?
//			Employer tempEmployer = (Employer)data.get(Storage.employerName);
//			
//			if (tempStudent.getEmail().equals(email.getText())) {
//				Stage stage;
//	        	Parent root;
//	        	stage = (Stage) signIn.getScene().getWindow();
//	        	root = FXMLLoader.load(getClass().getResource("home.fxml"));
//
//	        	Scene scene = new Scene(root);
//	        	stage.setScene(scene);
//	        	stage.show();
//			}
//			else if (tempEmployer.getEmail().equals(email.getText())) {
//				Stage stage;
//	        	Parent root;
//	        	stage = (Stage) signIn.getScene().getWindow();
//	        	root = FXMLLoader.load(getClass().getResource("homeemployer.fxml"));
//
//	        	Scene scene = new Scene(root);
//	        	stage.setScene(scene);
//	        	stage.show();
//			}
				Stage stage;
	        	Parent root;
	        	stage = (Stage) signIn.getScene().getWindow();
	        	root = FXMLLoader.load(getClass().getResource("home.fxml"));

	        	Scene scene = new Scene(root);
	        	stage.setScene(scene);
	        	stage.show();

        }

	}
}
