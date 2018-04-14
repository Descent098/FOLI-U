package application;

import java.io.IOException;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.collections.ListChangeListener;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.stage.Popup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
//import utilityUsers.JohnDoe;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class StudentSearchController {

/**
 * controller that controls searchemployer.fxml (for employers to search for students in database)
 * searches for students in the database and can display their information to the user
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

//variables for search bar/page
@FXML
private TextField searchBar;
@FXML
private TableView<Student> studentList;
@FXML
private TableColumn<Student, String> firstNameColumn;
@FXML
private TableColumn<Student, String> lastNameColumn;
@FXML
private TableColumn<Student, String> degreeColumn;
@FXML
private TableColumn<Student, String> idColumn;


//list of students with and without filtered results
private ObservableList<Student> studentData = FXCollections.observableArrayList();
private ObservableList<Student> filteredStudents = FXCollections.observableArrayList();

//allows user to search by name, degree, or UID
@FXML
private RadioButton searchByName;
@FXML
private RadioButton searchByDegree;
@FXML
private RadioButton searchByID;

//toggle group for radiobuttons, so that only one is allowed to be selected at a time
@FXML
private ToggleGroup toggleGroup = new ToggleGroup();

//loading the file to use for the page
private FileIO f = new FileIO();
private Database db = new Database(f.fileLoad());

/**
 * called at beginning of controller instance, temporarily adding random users to database to display
 * can search students by name, degree, and university ID number
 */
public StudentSearchController() {

								for (User s : (db.getDatabase()).values()) {
																if (s instanceof Student) {
																								System.out.println("Found a student!"+ s.getFirstName());
																								studentData.add((Student)s);
																}

								}

								filteredStudents.addAll(studentData);

								studentData.addListener(new ListChangeListener<Student>() {
																								@Override
																								public void onChanged(ListChangeListener.Change<? extends Student> change) {
																																updateFilteredStudents();
																								}
																});
}

/**
 * automatically called at the end of controller instance
 * sets table to display all students' information
 */
@FXML
private void initialize() {
								firstNameColumn.setCellValueFactory(
																new PropertyValueFactory<Student, String>("firstName"));
								lastNameColumn.setCellValueFactory(
																new PropertyValueFactory<Student, String>("lastName"));
								degreeColumn.setCellValueFactory(
																new PropertyValueFactory<Student, String>("degree"));
								idColumn.setCellValueFactory(
																new PropertyValueFactory<Student, String>("UID"));

								// add filtered data to the table
								studentList.setItems(filteredStudents);

								//if changes are made in search bar text field, will update which students are shown
								searchBar.textProperty().addListener(new ChangeListener<String>() {
																								@Override
																								public void changed(ObservableValue<? extends String> observable,
																																												String oldValue, String newValue) {

																																updateFilteredStudents();
																								}
																});

								//if student is selected by user, popup window will show up displaying student info
								studentList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
																								@Override
																								public void changed(ObservableValue<? extends Student> observable,Student oldValue, Student newValue){
																																if(newValue!=null) {
																																								Alert alert = new Alert(AlertType.INFORMATION);
																																								alert.setTitle("Student Information");
																																								alert.setHeaderText(null);
																																								alert.setContentText("Name: " + newValue.getFirstName() + " " + newValue.getLastName() + '\n' +
																																																													"UID: " + newValue.getUID() + '\n' + "University: " + newValue.getUniversity() +
																																																													'\n' + "Degree: " + newValue.getDegree() + '\n' + "Degree Type: " + newValue.getStudentType() + '\n' +
																																																													"GPA: " + Math.round(newValue.getGPA() * 100.0)/100.0 + '\n' + "Phone Number: " + newValue.getPhoneNumber() +
																																																													'\n' + "Email Address: " + newValue.getEmail() +
																																																													'\n' + "Country: " + newValue.getCountry() + '\n' + "Province: " + newValue.getProvince() + '\n' +
																																																													"City: " + newValue.getCity());

																																								alert.showAndWait();
																																}

																								}
																});
}

//updates filtered students, if student into matches input in search bar, updates
private void updateFilteredStudents() {
								filteredStudents.clear();

								for (Student s : studentData) {
																if (matchesSearch(s)) {
																								filteredStudents.add(s);
																}
								}

								// must re-sort table after items changed
								reapplyTableSortOrder();
}

/*
 * if the student information matches input in search bar
 */
private boolean matchesSearch(Student student) {
								String filterSearch = searchBar.getText();
								if (filterSearch == null || filterSearch.isEmpty()) {
																//nothing in search bar, displays all student info
																return true;
								}

								String lowerCaseFilterSearch = filterSearch.toLowerCase();

								searchByName.setToggleGroup(toggleGroup);
								searchByDegree.setToggleGroup(toggleGroup);
								searchByID.setToggleGroup(toggleGroup);


								//if search by name is selected, only search by student names
								if (searchByName.isSelected()) {
																if (student.getFirstName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
																								return true;
																}
																else if (student.getLastName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
																								return true;
																}
								}
								//same for degree + ID
								if (searchByDegree.isSelected()) {
																if (student.getDegree().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
																								return true;
																}
								}
								if (searchByID.isSelected()) {
																if (student.getUID().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
																								return true;
																}
								}

								return false; //does not match
}

//clears table and rearranges it whenever updated
private void reapplyTableSortOrder() {
								ArrayList<TableColumn<Student, ?> > sortOrder = new ArrayList<>(studentList.getSortOrder());
								studentList.getSortOrder().clear();
								studentList.getSortOrder().addAll(sortOrder);
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
