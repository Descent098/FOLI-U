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

	//updates user database from input. not in use yet.
	//Student demoStudent;
	Student demoStudent = new Student();
	Employer demoEmployer = new Employer();


	@FXML
	private AnchorPane root;
	
	//user data from input
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
	

	private Main mainApp;
	
	@FXML
	private Boolean isStudent = true;
	

    public void initialize() {
        System.out.println("end controller");
    }

	public Controller() {
		System.out.println("new controller");
		System.out.println(demoStudent.getFirstName());
	}

	public void setMain(Main mainApp) {
		this.mainApp = mainApp;
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
		isStudent = true;
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
		isStudent = false;
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
