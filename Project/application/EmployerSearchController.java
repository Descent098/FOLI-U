package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployerSearchController {
	
	//searching test
		@FXML
		private TextField searchBar;
		@FXML
		private TableView<EmployerJohnDoe> employerSearch;
		@FXML
		private TableColumn<EmployerJohnDoe, String> firstNameColumn;
		@FXML
		private TableColumn<EmployerJohnDoe, String> lastNameColumn;
		@FXML
		private TableColumn<EmployerJohnDoe, String> companyColumn;

		private ObservableList<EmployerJohnDoe> employerData = FXCollections.observableArrayList();
}