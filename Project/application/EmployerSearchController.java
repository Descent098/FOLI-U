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

public class EmployerSearchController {

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
	private TableView<Employer> employerSearch;
	@FXML
	private TableColumn<Employer, String> firstNameColumn;
	@FXML
	private TableColumn<Employer, String> lastNameColumn;
	@FXML
	private TableColumn<Employer, String> companyColumn;

	private ObservableList<Employer> employerData = FXCollections.observableArrayList();
	/*
	public EmployerSearchController() {
		employerData.add(new Employer("Jane", "Doe"));
		employerData.add(new Employer("Suzy", "Brown"));
		employerData.add(new Employer("Edward", "White"));
		employerData.add(new Employer("Bob", "Green"));
	}
	*/
	@FXML
	private void initialize() {
		/*
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        companyColumn.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
        */
        FilteredList<Employer> filteredEmployers = new FilteredList<>(employerData, p -> false);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredEmployers.setPredicate(employer -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                		System.out.println("empty");
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (employer.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                else if (employer.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                else if (employer.getCompanyName().toLowerCase().contains(lowerCaseFilter)) {
                		return true;
                }
                return false; // Does not match.
            });
        });

        SortedList<Employer> sortedEmployers = new SortedList<>(filteredEmployers);

        sortedEmployers.comparatorProperty().bind(employerSearch.comparatorProperty());

        employerSearch.setItems(employerData);
	}

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
