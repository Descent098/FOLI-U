package utilities;

import java.util.HashMap;
import java.util.ArrayList;

import users.Employer;
import users.Student;
import users.User;

/**Has multiple methods to compute statistics of a database*/
public class Statistics {


/**Default Constructor*/
public Statistics() {
}

/** A method that returns the amount of Students as an int in a HashMap */
public int howManyStudents(HashMap<String, User> db){
								int count = 0;
								for (String key : db.keySet()) {
																if (db.get(key).getGPA()>0) { //only students will have a GPA above 0
																								count += 1;
																}
								}
								return count;
}

/**Method returns a double representing the percentage of the population that is students*/
public double percentageofStudents(HashMap<String, User> db){
								double populationCount = 0.0; //The count of all users
								double studentCount = 0.0; //Count of how many students are in the HashMap
								for (String key : db.keySet()) {
																populationCount += 1;
																if (db.get(key).getGPA()>0) { //only students will have a GPA above 0
																								studentCount += 1;
																}

								}
								if(studentCount == 0){
									return 0.0;
								}

								return (100*(studentCount/populationCount)); //Multiply by 100 to represent a percentage
}

/** A method that returns the amount of Employers as an int in a HashMap */
public int howManyEmployers(HashMap<String, User> db){
								int count = 0;
								for (String key : db.keySet()) {
																if (db.get(key).getGPA()==0.0) { //only Employers will have a GPA of 0
																								count += 1;
																}
								}

								return count;
}

/**Method returns a double representing the percentage of the population that is Employers*/
public double percentageofEmployers(HashMap<String, User> db){
								double populationCount = 0.0; //The count of all users
								double employerCount = 0.0; //Count of how many Employers are in the HashMap
								for (String key : db.keySet()) {
																populationCount += 1;
																if (db.get(key).getGPA()== 0.0) { //only students will have a GPA above 0
																								employerCount += 1;
																}

								}
								if(employerCount == 0){
									return 0.0;
								}

								return (100*(employerCount/populationCount)); //Multiply by 100 to represent a percentage
}


/** A method that returns the amount of Students have a specific Degree as an int in a HashMap */
public double howManyStudentsInDegree(HashMap<String, User> db, String degree){
								double count = 0;
								for (String key : db.keySet()) {
																if (db.get(key).getDegree().equals(degree)) { //only students that are in the degree type
																								count += 1;
																}
								}
								return count;
}

/**Method that returns a double representing the overall Mean GPA of all students in the passed HashMap*/
public double overallMeanGPA(HashMap<String, User> db){
								ArrayList<Double> GPAs = new ArrayList<Double>();
								double mean = 0.0; //Value of the mean of the GPA's
								double totalGPA = 0.0;//Value of all GPA's added together
								for (String key : db.keySet()) {
																if (db.get(key).getGPA() > 0.0) { //Only Students
																								GPAs.add(db.get(key).getGPA());

																}
													}
								for ( int i = 0 ; i < GPAs.size(); i++){
									totalGPA += GPAs.get(i);

								}
								if(totalGPA == 0.0){
									return 0.0;
								}
						mean = totalGPA/howManyStudents(db);
						return mean;
}

/**Method that returns a double representing the Mean GPA of all students in the given university in the passed HashMap*/
public double universityMeanGPA(HashMap<String, User> db, String university){
								ArrayList<Double> GPAs = new ArrayList<Double>();
								double mean = 0.0; //Value of the mean of the GPA's
								double totalGPA = 0.0;//Value of all GPA's added together
								double studentCount = 0.0;
								for (String key : db.keySet()) {
																if (db.get(key).getUniversity().equals(university)) { //only students that are in the University
																								GPAs.add(db.get(key).getGPA());
																								studentCount += 1;

																}
													}
								for ( int i = 0 ; i < GPAs.size(); i++){
									totalGPA += GPAs.get(i);

								}
						mean = totalGPA/studentCount;
						if(studentCount == 0.0){//if there are no students at the university
							return 0.0;
						}
						return mean;
}
/**
	*	Calculates the standard deviation of all student's GPA and returns import junit.framework.TestCase;
	* @param db				Hashmap of the Database
	*	@return Double	standard deviation of all student's GPA
	*/
public double GPAStandardDeviation(HashMap<String, User> db) {
							ArrayList<Double> GPAs = new ArrayList<Double>();
							double studentCount = 0.0;
							double summation = 0.0;
							double meanGPA = overallMeanGPA(db); //getting the mean GPA of students to use in the calculations, using another methods
							double temp; //just stores partial answers during calculation

							for (String key : db.keySet()) {	//iterate through the database and perform the summation calculcation
															if (db.get(key).getGPA() == 0.0) {	//if the GPA found is 0, then they are actually an employer! so skip them
																	break;
															} else {
																temp = ((db.get(key).getGPA()) - meanGPA);
																summation += Math.pow(temp,2); //square it
																studentCount++;
															}
							}
							//calculating the rest of the formula
							temp = summation/(studentCount);
							temp = Math.sqrt(temp); //sqaure rooting it

							return temp;

}




}
