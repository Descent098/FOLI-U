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
	private TableView<EmployerJohnDoe> employerList;
	@FXML
	private TableColumn<EmployerJohnDoe, String> firstNameColumn;
	@FXML
	private TableColumn<EmployerJohnDoe, String> lastNameColumn;
	@FXML
	private TableColumn<EmployerJohnDoe, String> companyColumn;

	private ObservableList<EmployerJohnDoe> employerData = FXCollections.observableArrayList();
	private ObservableList<EmployerJohnDoe> filteredEmployers = FXCollections.observableArrayList();

	public EmployerSearchController() {
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		
		filteredEmployers.addAll(employerData);
		
		employerData.addListener(new ListChangeListener<EmployerJohnDoe>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends EmployerJohnDoe> change) {
                updateFilteredEmployers();
            }
        });
	}
	
	@FXML
	private void initialize() {
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<EmployerJohnDoe, String>("firstName"));
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<EmployerJohnDoe, String>("lastName"));
        companyColumn.setCellValueFactory(
                new PropertyValueFactory<EmployerJohnDoe, String>("companyName"));

        // Add filtered data to the table
        employerList.setItems(filteredEmployers);

        // Listen for text changes in the filter text field
        searchBar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                updateFilteredEmployers();
            }
        });
	}
	
	private void updateFilteredEmployers() {
        filteredEmployers.clear();

        for (EmployerJohnDoe e : employerData) {
            if (matchesSearch(e)) {
                filteredEmployers.add(e);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }
	
	private boolean matchesSearch(EmployerJohnDoe employer) {
        String filterSearch = searchBar.getText();
        if (filterSearch == null || filterSearch.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterSearch = filterSearch.toLowerCase();

        if (employer.getFirstName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
            return true;
        } 
        else if (employer.getLastName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<EmployerJohnDoe, ?>> sortOrder = new ArrayList<>(employerList.getSortOrder());
        employerList.getSortOrder().clear();
        employerList.getSortOrder().addAll(sortOrder);
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
