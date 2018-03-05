package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	Stage stage;
	AnchorPane mainPage, newUserPage, returningUserPage, newStudentPage, continueStudentPage, newEmployerPage,
	continueEmployerPage, homePage, searchPage, settingsPage, profilePage;
	Scene newUserScene, returningUserScene, newStudentScene, continueStudentScene, newEmployerScene,
	continueEmployerScene, mainScene, homeScene, searchScene, settingsScene, profileScene;
	Button newUser, returningUser, newStudent, continueNewStudent, finishNewStudent, newEmployer,
	continueNewEmployer, finishNewEmployer, backToMenu, backToStudent, backToEmployer, backToNewUser,
	signIn, home, search, settings, myProfile;
	Label title;
	String studentName, studentUsername, studentPassword, studentUni, studentDegree, studentYear, 
	studentDOB;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		
		mainPage = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
		newUserPage = FXMLLoader.load(getClass().getResource("newuserpage.fxml"));
		returningUserPage = FXMLLoader.load(getClass().getResource("returninguserpage.fxml"));
		newStudentPage = FXMLLoader.load(getClass().getResource("newstudent.fxml"));
		newEmployerPage = FXMLLoader.load(getClass().getResource("newemployer.fxml"));
		continueStudentPage = FXMLLoader.load(getClass().getResource("continuenewstudent.fxml"));
		continueEmployerPage = FXMLLoader.load(getClass().getResource("continuenewemployer.fxml"));
		homePage = FXMLLoader.load(getClass().getResource("home.fxml"));
		searchPage = FXMLLoader.load(getClass().getResource("searchpage.fxml"));
		settingsPage = FXMLLoader.load(getClass().getResource("settingspage.fxml"));
		profilePage = FXMLLoader.load(getClass().getResource("profilepage.fxml"));
		
		newUser = new Button("    New User    ");
		newUser.setLayoutX(135);
		newUser.setLayoutY(252);
		returningUser = new Button("Returning User");
		returningUser.setLayoutX(135);
		returningUser.setLayoutY(309);
		newStudent = new Button();
		continueNewStudent = new Button();
		finishNewStudent = new Button();
		newEmployer = new Button();
		continueNewEmployer = new Button();
		finishNewEmployer = new Button();
		backToMenu = new Button();
		backToNewUser = new Button();
		backToStudent = new Button();
		backToEmployer = new Button();
		signIn = new Button();
		home = new Button();
		search = new Button();
		myProfile = new Button();
		newUser.setOnAction(e -> handleButtonAction(e));
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

		
		newUserScene = new Scene(newUserPage, 375, 559);
		returningUserScene = new Scene(returningUserPage, 375, 559);
		newStudentScene = new Scene(newStudentPage, 375, 559);
		continueStudentScene = new Scene(continueStudentPage, 375, 559);
		newEmployerScene = new Scene(newEmployerPage, 375, 559);
		continueEmployerScene = new Scene(continueEmployerPage, 375, 559);
		homeScene = new Scene(homePage, 375, 559);
		mainScene = new Scene(mainPage, 375, 559);
		searchScene = new Scene(searchPage, 375, 559);
		profileScene = new Scene(profilePage, 375, 559);
		
        primaryStage.setTitle("Foli-U");
        primaryStage.setScene(mainScene);
        primaryStage.show();
	}

	private void handleButtonAction(ActionEvent event) {
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

	public static void main(String[] args) {
		launch(args);
	}
}
