package application;

import java.io.IOException;
import java.lang.reflect.Array;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.ArrayList;
import java.util.*;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.TextAlignment;


public class NewStudentController {

private FileIO f = new FileIO();
private Database db = new Database(f.fileLoad()); //loads the current file each time this controller is used


/**
 * controller that controls all pages that create a new student
 * will save info and add to database
 */

/**
 * text fields that take in user input
 * this is all the student info that we will need added to database
 */
@FXML
private TextField enterFirstName;
@FXML
private TextField enterLastName;
@FXML
private TextField enterUID;
@FXML
private Button continueNewStudent;
@FXML
private TextField emailAddress;
@FXML
private TextField phoneNumber;
@FXML
private TextField cityName;
@FXML
private ComboBox<String> provinceName;
@FXML
private ComboBox<String> countryName;

//continue new student
@FXML
private ComboBox<String> universityName;
@FXML
private ComboBox<String> degree;
@FXML
private ComboBox<String> degreeType;
@FXML
private ComboBox<String> yearOfStudy;
@FXML
private Button finishNewStudent;
@FXML
private RadioButton calculateGPA;
@FXML
private RadioButton dontCalculateGPA;
@FXML
private ToggleGroup gpaGroup;

//back buttons
@FXML
private Button backToMenu;
@FXML
private Button backToNewUser;
@FXML
private Button backToStudent;

@FXML
PlaceNames places = new PlaceNames();


@FXML
public void initialize() {
								System.out.println("student controller");
}

/**
 * button to continue student creation
 * @param event
 * @throws IOException
 */
@FXML
public void continueButtonClickedStudent(ActionEvent event) throws IOException {
								Alert alert = new Alert(AlertType.ERROR);
								//gets the text from user input and checks to make sure it's valid
								if (enterFirstName.getText().isEmpty() || enterLastName.getText().isEmpty() || enterUID.getText().isEmpty() ||
												emailAddress.getText().isEmpty() || phoneNumber.getText().isEmpty()) {
																alert.setTitle("Error");
																alert.setHeaderText(null);
																alert.setContentText("Please fill in all fields!");
																alert.showAndWait();
								}
								else if (!enterUID.getText().matches("[0-9]+") || enterUID.getText().length() != 8) {
																alert.setTitle("Error");
																alert.setHeaderText(null);
																alert.setContentText("Invalid UID!");
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
								//continues onto next page
								else {
																/* Creates a temporary student object and saves the entered info to it, then they are saved to
																the hashmap in database. This database object is then saved to a file.*/
																Student tempStudent = new Student();
																tempStudent.setFirstName(enterFirstName.getText());
																tempStudent.setLastName(enterLastName.getText());
																tempStudent.setUID(enterUID.getText());
																tempStudent.setPhoneNumber(phoneNumber.getText());
																tempStudent.setEmail(emailAddress.getText());
																(db.getDatabase()).put(tempStudent.getUID(), tempStudent);

																Storage.UID = (tempStudent.getUID());
																System.out.println("UID before:"+ Storage.UID);

																f.fileSave(db.getDatabase()); //saves the hashmap to the file

																Stage stage;
																Parent root;
																stage = (Stage) continueNewStudent.getScene().getWindow();
																root = FXMLLoader.load(getClass().getResource("continuenewstudent.fxml"));

																Scene scene = new Scene(root);
																stage.setScene(scene);
																stage.show();
								}

}

/*
 * changes the province/state combobox depending on whether user chooses canada or usa
 * @param event
 * @throws IOException
 */
@FXML
public void changeCountry(ActionEvent event) throws IOException {
								if (countryName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Canada")) {
																provinceName.setItems(places.provinces);
								}
								if (countryName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("USA")) {
																provinceName.setItems(places.states);
								}
}

/**
 * changes university list to match province/state chosen
 * @param event
 * @throws IOException
 */
@FXML
public void changeProvince(ActionEvent event) throws IOException {
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Alberta")) {
																universityName.setItems(places.albertaSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("British Columbia")) {
																universityName.setItems(places.bcSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Nevada")) {
																universityName.setItems(places.nevadaSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Illinois")) {
																universityName.setItems(places.illinoisSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Massachusetts")) {
																universityName.setItems(places.massachusettsSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Saskatchewan")) {
																universityName.setItems(places.saskSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Manitoba")) {
																universityName.setItems(places.manitobaSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Ontario")) {
																universityName.setItems(places.ontarioSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Quebec")) {
																universityName.setItems(places.quebecSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("California")) {
																universityName.setItems(places.californiaSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("New York")) {
																universityName.setItems(places.newyorkSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Arizona")) {
																universityName.setItems(places.arizonaSchools);
								}
								if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Florida")) {
																universityName.setItems(places.floridaSchools);
								}

}
/** finishes student creation
	* @param event
	* @throws IOException
	*/
@FXML
public void finishButtonClickedStudent(ActionEvent event) throws IOException {

								Alert alert = new Alert(AlertType.ERROR);
								TextInputDialog gpa = new TextInputDialog();
								//if user user leaves fields blank
								if (cityName.getText().isEmpty() || provinceName.getSelectionModel().isEmpty() || countryName.getSelectionModel().isEmpty() ||
												universityName.getSelectionModel().isEmpty() || degree.getSelectionModel().isEmpty() || degreeType.getSelectionModel().isEmpty()
												|| yearOfStudy.getSelectionModel().isEmpty()) {
																alert.setTitle("Error");
																alert.setHeaderText(null);
																alert.setContentText("Please fill in all fields!");
																alert.showAndWait();
								}
								else {

																//if user chooses to calculate GPA
																if (calculateGPA.isSelected()) {
																								//opens new window
																								GridPane grid = new GridPane();
																								grid.setHgap(10);
																								grid.setVgap(10);
																								grid.setPadding(new Insets(20, 150, 10, 10));

																								//text field that takes input for number of classes
																								//will create the correct amount of new text fields corresponding to user input
																								TextField numOfCourses = new TextField();
																								numOfCourses.setPromptText("0");
																								Button numCoursesButton = new Button("Enter");

																								grid.add(new Label("Enter number of courses: "), 0, 0);
																								grid.add(numOfCourses, 1, 0);
																								grid.add(numCoursesButton, 2, 0);

																								gpa.getDialogPane().setContent(grid);
																								gpa.setTitle("GPA Calculator");

																								//array lists that will include the text fields for each course
																								ArrayList<TextField> course = new ArrayList<TextField>();
																								ArrayList<TextField> weightForCourse = new ArrayList<TextField>();

																								//iterate through the number of courses and make a grade text field and a weight text field for each one
																								numCoursesButton.setOnAction((ActionEvent)->{
																																								for (int i = 0; i < Integer.parseInt(numOfCourses.getText()); i++) {
																																																TextField courseNumber = new TextField();
																																								        //creates grade text field
																																																courseNumber.setPromptText("Grade for class");
																																																TextField weightNumber = new TextField();
																																																weightNumber.setPromptText("Weight for class");
																																								        //creates weight text field
																																																grid.add(new Label("Class" + " " + (i + 1)), 0, i + 1);
																																								        //adds text fields to corresponding array list for easy access later
																																																course.add(courseNumber);
																																																weightForCourse.add(weightNumber);
																																																grid.add(courseNumber, 1, i + 1);
																																																grid.add(weightNumber, 2, i + 1);
																																																gpa.getDialogPane().setContent(grid);
																																																gpa.getDialogPane().getScene().getWindow().sizeToScene();
																																								}
																																});

																								//once GPA calculating page is finished being generated
																								Optional<String> result = gpa.showAndWait();
																								if (result.isPresent()) {
																																double studentGPA = 0.0;
																																double weightTotal = 0.0;
																																//gets info from each text field
																																for (int i = 0; i < course.size(); i++) {
																																								double grade = Double.parseDouble(course.get(i).getText());
																																								double weight = Double.parseDouble(weightForCourse.get(i).getText());
																																								//math from Student.java
																																								//calculates GPA
																																								studentGPA += (grade*weight);
																																								weightTotal += weight;
																																}
																																studentGPA /= weightTotal;
																																//rounds GPA to 2 decimal places
																																double roundedGPA = Math.round(studentGPA * 100.0) / 100.0;

																								}

																}
																//sign up is completed
																//saving information from the second page
																HashMap<String, User> data = db.getDatabase();
																Student tempStudent = (Student)data.get(Storage.UID);
																tempStudent.setCity(cityName.getText());
																tempStudent.setProvince(provinceName.getSelectionModel().getSelectedItem().toString());
																tempStudent.setCountry(countryName.getSelectionModel().getSelectedItem().toString());
																tempStudent.setUniversity(universityName.getSelectionModel().getSelectedItem().toString());
																tempStudent.setDegree(degree.getSelectionModel().getSelectedItem().toString());
																tempStudent.setStudentType(degreeType.getSelectionModel().getSelectedItem().toString());
																String year = (yearOfStudy.getSelectionModel().getSelectedItem().toString());
																tempStudent.setProgramYear(Integer.parseInt(year));
																tempStudent.setGPA(0.0);

																f.fileSave(db.getDatabase());

																Stage stage;
																Parent root;
																stage = (Stage) finishNewStudent.getScene().getWindow();
																root = FXMLLoader.load(getClass().getResource("home.fxml"));

																Scene scene = new Scene(root);
																stage.setScene(scene);
																stage.show();

								}

}

/**
 	* back to new user page
 	* @param event
 	* @throws IOException
 	*/
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

/**
 	* back to main page
 	* @param event
 	* @throws IOException
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

/**
 	* back to previous page in student creation
 	* @param event
 	* @throws IOException
 	*/
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

} //end of class
