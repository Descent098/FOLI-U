package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
import utilityUsers.JohnDoe;
import utilities.Statistics;

public class EmployerHomeController {

	/**
	 * controller for the student home page
	 * takes user info from database and displays it here in charts
	 * statistics of all users
	 */
	

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
	PieChart percentageOfStudents;
	@FXML
	CategoryAxis xAxis = new CategoryAxis();
	@FXML
	NumberAxis yAxis = new NumberAxis();
	@FXML
	BarChart<?, ?> numberOfStudents;
	@FXML
	private PieChart studentsPerDegree;



	//loading the file, and grabbing the current student out of it to use
	private FileIO f = new FileIO();
	private Database db = new Database(f.fileLoad());
	//HashMap<String, User> data = db.getDatabase();
	Student tempStudent = (Student)((db.getDatabase()).get(Storage.UID)); //retrieve the student from the hashmap within the database class while casting it
	private Statistics stats = new Statistics();



	@FXML
	public void initialize() {
		//pie chart displays the percentage of employers and students
		 ObservableList<PieChart.Data> studentsPercentage =
		            FXCollections.observableArrayList(
		            new PieChart.Data("Students", stats.percentageofStudents(db.getDatabase())),
		            new PieChart.Data("Employers", stats.percentageofEmployers(db.getDatabase())));

		 percentageOfStudents.setData(studentsPercentage);
		 

		 ObservableList<PieChart.Data> studentsDegree =
		            FXCollections.observableArrayList(
		            new PieChart.Data("BIO", stats.howManyStudentsInDegree(db.getDatabase(), "BIO")),
				    new PieChart.Data("CPSC", stats.howManyStudentsInDegree(db.getDatabase(), "CPSC")),
				    new PieChart.Data("ENG", stats.howManyStudentsInDegree(db.getDatabase(), "ENG")),
				    new PieChart.Data("MED", stats.howManyStudentsInDegree(db.getDatabase(), "MED")),
				    new PieChart.Data("COM", stats.howManyStudentsInDegree(db.getDatabase(), "COM")),
				    new PieChart.Data("SOCI", stats.howManyStudentsInDegree(db.getDatabase(), "SOCI")),
				    new PieChart.Data("PSYC", stats.howManyStudentsInDegree(db.getDatabase(), "PSYC")),
				    new PieChart.Data("CMF", stats.howManyStudentsInDegree(db.getDatabase(), "CMF")),
				    new PieChart.Data("LING", stats.howManyStudentsInDegree(db.getDatabase(), "LING")));
		            

		 studentsPerDegree.setData(studentsDegree);

	}
	


	public void changePage(ActionEvent event) throws IOException {
		//if home button clicked or if no button specified (default home)
		if (event.getTarget() == home || event.getTarget() == null) {
			Stage stage;
			Parent root;
    			stage = (Stage) home.getScene().getWindow();
    			root = FXMLLoader.load(getClass().getResource("homeemployer.fxml"));

    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
		}
		//if search button clicked
		else if (event.getTarget() == search) {
			Stage stage;
			Parent root;
			stage = (Stage) search.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("searchemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		//if settings button clicked
		}
		else if (event.getTarget() == settings) {
			Stage stage;
			Parent root;
			stage = (Stage) settings.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("settingsemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		//if profile button clicked
		else if (event.getTarget() == myProfile) {
			Stage stage;
			Parent root;
			stage = (Stage) myProfile.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("profileemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
}
