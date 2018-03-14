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

	AnchorPane mainPage;
	Scene mainScene;

	Student demoStudent;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();

		mainPage = loader.load(getClass().getResource("mainpage.fxml")); //connects to mainpage.fxml

		mainScene = new Scene(mainPage, 375, 559);


        primaryStage.setTitle("Foli-U"); //title of stage
        primaryStage.setScene(mainScene);
        primaryStage.show(); //displays stage/app
	}


	public static void main(String[] args) { //launch app
		launch(args);
	}
}
