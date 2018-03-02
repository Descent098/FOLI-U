package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Main extends Application { //main class

	Stage stage;

	AnchorPane mainPage, newUserPage, returningUserPage, newStudentPage, continueStudentPage, newEmployerPage,
	continueEmployerPage, homePage, searchPage, settingsPage, profilePage;
	//all the pages in app so far
	Scene newUserScene, returningUserScene, newStudentScene, continueStudentScene, newEmployerScene,
	continueEmployerScene, mainScene, homeScene, searchScene, settingsScene, profileScene;
	//all the scenes used to display pages
	Button newUser, returningUser, newStudent, continueNewStudent, finishNewStudent, newEmployer,
	continueNewEmployer, finishNewEmployer, backToMenu, backToStudent, backToEmployer, backToNewUser,
	signIn, home, search, settings, myProfile;
	//main buttons used in app
	Label title;
	//title
	String studentName, studentUsername, studentPassword, studentUni, studentDegree, studentYear,
	studentDOB;
	//strings for when the database is connected. not in use yet.

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;

		//these are the fxml files for the pages. they create the visuals/grahics for each page.
		mainPage = FXMLLoader.load(getClass().getResource("mainpage.fxml")); //connects to mainpage.fxml
		newUserPage = FXMLLoader.load(getClass().getResource("newuserpage.fxml")); //etc.
		returningUserPage = FXMLLoader.load(getClass().getResource("returninguserpage.fxml"));
		newStudentPage = FXMLLoader.load(getClass().getResource("newstudent.fxml"));
		newEmployerPage = FXMLLoader.load(getClass().getResource("newemployer.fxml"));
		continueStudentPage = FXMLLoader.load(getClass().getResource("continuenewstudent.fxml"));
		continueEmployerPage = FXMLLoader.load(getClass().getResource("continuenewemployer.fxml"));
		homePage = FXMLLoader.load(getClass().getResource("home.fxml"));
		searchPage = FXMLLoader.load(getClass().getResource("searchpage.fxml"));
		settingsPage = FXMLLoader.load(getClass().getResource("settingspage.fxml"));
		profilePage = FXMLLoader.load(getClass().getResource("profilepage.fxml"));

		newUser = new Button("    New User    "); //new user button on main page
		newUser.setLayoutX(135);
		newUser.setLayoutY(252);
		returningUser = new Button("Returning User"); //returning user button on main page
		returningUser.setLayoutX(135);
		returningUser.setLayoutY(309);
		newStudent = new Button(); //new student button on the new user sign up page. creates new student user.
		continueNewStudent = new Button(); //continues student user creation.
		finishNewStudent = new Button(); //finished student user creation.
		newEmployer = new Button(); //new employer button on the new user sign up page. creates new employer user.
		continueNewEmployer = new Button(); //continues new employer creation.
		finishNewEmployer = new Button(); //finishes new employer creation
		backToMenu = new Button(); //back buttons on new/returning user page
		backToNewUser = new Button(); //more back buttons for different stages of user creation
		backToStudent = new Button();
		backToEmployer = new Button();
		signIn = new Button(); //sign in button. brings you to the app after you log in successfully.
		home = new Button(); //takes you to the home page in app
		search = new Button(); //takes you to the search page in app
		settings = new Button(); //takes you to the settings page in app
		myProfile = new Button(); // takes you to the profile page in app
		newUser.setOnAction(e -> handleButtonAction(e)); //sets event handlers for each button
		returningUser.setOnAction(e -> handleButtonAction(e));
		newStudent.setOnAction(e -> handleButtonAction(e));
		continueNewStudent.setOnAction(e -> handleButtonAction(e));
		finishNewStudent.setOnAction(e -> handleButtonAction(e));
		newEmployer.setOnAction(e -> handleButtonAction(e));
		continueNewEmployer.setOnAction(e -> handleButtonAction(e));
		finishNewEmployer.setOnAction(e -> handleButtonAction(e));
		backToMenu.setOnAction(e -> handleButtonAction(e));
		backToNewUser.setOnAction(e -> handleButtonAction(e));
		backToStudent.setOnAction(e -> handleButtonAction(e));
		backToEmployer.setOnAction(e -> handleButtonAction(e));
		signIn.setOnAction(e -> handleButtonAction(e));
		home.setOnAction(e -> handleButtonAction(e));
		search.setOnAction(e -> handleButtonAction(e));
		myProfile.setOnAction(e -> handleButtonAction(e));


		newUserScene = new Scene(newUserPage, 375, 559); //sets scenes for each page
		returningUserScene = new Scene(returningUserPage, 375, 559);
		newStudentScene = new Scene(newStudentPage, 375, 559);
		continueStudentScene = new Scene(continueStudentPage, 375, 559);
		newEmployerScene = new Scene(newEmployerPage, 375, 559);
		continueEmployerScene = new Scene(continueEmployerPage, 375, 559);
		homeScene = new Scene(homePage, 375, 559);
		mainScene = new Scene(mainPage, 375, 559);
		searchScene = new Scene(searchPage, 375, 559);
		profileScene = new Scene(profilePage, 375, 559);

        primaryStage.setTitle("Foli-U"); //title of stage
        primaryStage.setScene(mainScene);
        primaryStage.show(); //displays stage/app
	}

	private void handleButtonAction(ActionEvent event) { //specifies when to go to each page
		if (event.getTarget() == newUser || event.getTarget() == backToNewUser)
			stage.setScene(newUserScene);
		else if (event.getTarget() == returningUser)
			stage.setScene(returningUserScene);
		else if (event.getTarget() == newStudent || event.getTarget() == backToStudent)
			stage.setScene(newStudentScene);
		else if (event.getTarget() == continueNewStudent)
			stage.setScene(continueStudentScene);
		else if (event.getTarget() == newEmployer || event.getTarget() == backToEmployer)
			stage.setScene(newEmployerScene);
		else if (event.getTarget() == continueNewEmployer)
			stage.setScene(continueEmployerScene);
		else if (event.getTarget() == backToMenu)
			stage.setScene(mainScene);
		else if (event.getTarget() == signIn || event.getTarget() == home ||
				event.getTarget() == finishNewStudent || event.getTarget() == finishNewEmployer)
			stage.setScene(homeScene);
		else if (event.getTarget() == search)
			stage.setScene(searchScene);
		else if (event.getTarget() == settings)
			stage.setScene(settingsScene);
		else if (event.getTarget() == myProfile)
			stage.setScene(profileScene);
	}

	public static void main(String[] args) { //launch app
		launch(args);
	}
}
