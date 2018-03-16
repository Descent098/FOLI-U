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

public class StudentSearchController {

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

	//searching test
	@FXML
	private TextField searchBar;
	@FXML
	private TableView<JohnDoe> studentList;
	@FXML
	private TableColumn<JohnDoe, String> firstNameColumn;
	@FXML
	private TableColumn<JohnDoe, String> lastNameColumn;
	@FXML
	private TableColumn<JohnDoe, String> degreeColumn;
	@FXML
	private TableColumn<JohnDoe, String> idColumn;


	private ObservableList<JohnDoe> studentData = FXCollections.observableArrayList();
	private ObservableList<JohnDoe> filteredStudents = FXCollections.observableArrayList();
	
	@FXML
	private CheckBox searchByName;
	@FXML
	private CheckBox searchByDegree;
	@FXML
	private CheckBox searchByID;

	public StudentSearchController() {
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());
		studentData.add(new JohnDoe());

		
		filteredStudents.addAll(studentData);
		
		studentData.addListener(new ListChangeListener<JohnDoe>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends JohnDoe> change) {
                updateFilteredStudents();
            }
        });
	}
	
	@FXML
	private void initialize() {
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<JohnDoe, String>("firstName"));
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<JohnDoe, String>("lastName"));
        degreeColumn.setCellValueFactory(
                new PropertyValueFactory<JohnDoe, String>("degree"));
        idColumn.setCellValueFactory(
                new PropertyValueFactory<JohnDoe, String>("UID"));

        // Add filtered data to the table
        studentList.setItems(filteredStudents);

        // Listen for text changes in the filter text field
        searchBar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                updateFilteredStudents();
            }
        });
	}
	
	private void updateFilteredStudents() {
        filteredStudents.clear();

        for (JohnDoe s : studentData) {
            if (matchesSearch(s)) {
                filteredStudents.add(s);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }
	
	private boolean matchesSearch(JohnDoe student) {
        String filterSearch = searchBar.getText();
        if (filterSearch == null || filterSearch.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterSearch = filterSearch.toLowerCase();
        
        if (searchByName.isSelected()) {
        		if (student.getFirstName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
                return true;
            } 
            else if (student.getLastName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
                return true;
            }
        }
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

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<JohnDoe, ?>> sortOrder = new ArrayList<>(studentList.getSortOrder());
        studentList.getSortOrder().clear();
        studentList.getSortOrder().addAll(sortOrder);
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
			root = FXMLLoader.load(getClass().getResource("profileemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}


}
