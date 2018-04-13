package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class PlaceNames {

		//provinces in canada
		public ObservableList<String> provinces = FXCollections.observableArrayList("Alberta", "British Columbia", "Saskatchewan", "Manitoba", "Ontario", "Quebec",
				"New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut");

		
		//states in the US
		public ObservableList<String> states = FXCollections.observableArrayList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
				"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
				"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska" ,"Nevada" ,"New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
				"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");


		//universities in alberta
		public ObservableList<String> albertaSchools = FXCollections.observableArrayList("University of Calgary", "Mount Royal University", "SAIT", "University of Alberta", "ACAD",
				"University of Alberta", "University of Lethbridge", "MacEwan University", "Athabasca University");

		//universities in BC
		public ObservableList<String> bcSchools = FXCollections.observableArrayList("University of British Columbia", "University of Victoria",
				"Simon Fraser University", "Douglas College");
		
		//universities in BC
		public ObservableList<String> saskSchools = FXCollections.observableArrayList("University of Saskatchewan", "University of Regina",
				"Saskathewan Polytechnic");
				
				
		//universities in BC
		public ObservableList<String> manitobaSchools = FXCollections.observableArrayList("University of Manitoba", "University of Winnipeg",
				"Brandon University");
				
				
		//universities in BC
		public ObservableList<String> ontarioSchools = FXCollections.observableArrayList("University of Western Ontario", "University of Toronto",
				"University of Waterloo", "York University", "Queen's University");
				
		public ObservableList<String> quebecSchools = FXCollections.observableArrayList("Université Laval", "McGill University",
				"Université du Québec", "Université de Montréal");
				
		public ObservableList<String> californiaSchools = FXCollections.observableArrayList("UC Los Angeles", "UC Berkeley",
				"UC San Diego", "Stanford University", "California Polytechnic", "University of Southern California");
				
		public ObservableList<String> newyorkSchools = FXCollections.observableArrayList("New York University", "Columbia University",
				"Fordham University", "St. John's University");
		
		public ObservableList<String> arizonaSchools = FXCollections.observableArrayList("University of Arizona", "University of Pheonix",
				"Midwestern University", "Central Arizona College");
				
		public ObservableList<String> floridaSchools = FXCollections.observableArrayList("University of Florida", "Florida State University",
				"University of Miami");
				

		//universities in Illinois
		public ObservableList<String> illinoisSchools = FXCollections.observableArrayList("University of Chicago", "Boston University");
		
		//universities in Nevada
		public ObservableList<String> nevadaSchools = FXCollections.observableArrayList("University of Vegas");
		
		//universities in Massachusetts
		public ObservableList<String> massachusettsSchools = FXCollections.observableArrayList("MIT");
		

}