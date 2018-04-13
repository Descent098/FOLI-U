package application;

import java.awt.List;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
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
import javafx.util.Pair;
import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import utilities.Statistics;

public class StudentHomeController {

	/**
	 * controller for the student home page home.fxml
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

	//pie charts displaying information from statistics
	@FXML
	PieChart percentageOfStudents;
	@FXML
	private PieChart studentsPerDegree;
	@FXML
	private GridPane uniAverages;
	@FXML
	private Label gpaAverage;
	@FXML
	private Label uniOne;
	@FXML
	private Label uniTwo;
	@FXML
	private Label uniThree;
	@FXML
	private Label uniFour;
	@FXML
	private Label uniFive;
	@FXML
	private Label uniSix;
	@FXML
	ArrayList<String> universities = new ArrayList<String>();
	@FXML
	ArrayList<Double> universityGPAs = new ArrayList<Double>();
	@FXML
	HashMap<String, Double> pairs = new HashMap<String, Double>();
	@FXML
	ArrayList<String> list = new ArrayList<String>();
	DecimalFormat format = new DecimalFormat("##.00");


	//loading the file, and grabbing the current student out of it to use
	private FileIO f = new FileIO();
	private Database db = new Database(f.fileLoad());
	//HashMap<String, User> data = db.getDatabase();
	Student tempStudent = (Student)((db.getDatabase()).get(Storage.UID)); //retrieve the student from the hashmap within the database class while casting it
	private Statistics stats = new Statistics();



	/*
	 * initializes graphs for statistics
	 * called first every time an instance of controller is created
	 */
	@FXML
	public void initialize() {
		
		double roundedGPA = Math.round(stats.overallMeanGPA(db.getDatabase()) * 100.0) / 100.0;
		
		gpaAverage.setText(Double.toString(roundedGPA));
		//pie chart for percentage of students and employers in database
		ObservableList<PieChart.Data> studentsPercentage =
	            FXCollections.observableArrayList(
	            new PieChart.Data("Students", stats.percentageofStudents(db.getDatabase())),
	            new PieChart.Data("Employers", stats.percentageofEmployers(db.getDatabase())));

				percentageOfStudents.setData(studentsPercentage);
	 
		 
		 //pie chart for percentage of students in each degree
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

		 universities.add("University of Calgary");
		 universities.add("University of Lethbridge");
		 universities.add("SAIT");
		 universities.add("Mount Royal University");
		 universities.add("Athabasca University");
		 universities.add("University of Chicago");
		 universities.add("Boston University");
		 universities.add("University of Vegas");
		 universities.add("MIT");
		 
		 for (int i = 0; i < universities.size(); i++) {
			 universityGPAs.add(stats.universityMeanGPA(db.getDatabase(), universities.get(i)));
			 System.out.println(universityGPAs.get(i));
			 pairs.put(universities.get(i), universityGPAs.get(i));
		 }
		 
		 Object[] a = pairs.entrySet().toArray();
		 Arrays.sort(a, new Comparator() {
		     public int compare(Object o1, Object o2) {
		         return ((Map.Entry<String, Double>) o2).getValue()
		                    .compareTo(((Map.Entry<String, Double>) o1).getValue());
		     }
		 });

	     for (Object e : a) {
			    list.add((((Map.Entry<String, Double>) e).getKey() + " : "
			            + ((format.format(((Map.Entry<String, Double>) e).getValue())))));
		 }
	     
	     uniOne.setText("#1. " + list.get(0));
	     uniTwo.setText("#2. " + list.get(1));
	     uniThree.setText("#3. " + list.get(2));
	     uniFour.setText("#4. " + list.get(3));
	     uniFive.setText("#5. " + list.get(4));
	     uniSix.setText("#6. " + list.get(5));

	}
	

	/*
	 * changes pages in main application
	 */
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

