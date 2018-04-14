package utilities;
import java.util.*;

import users.Employer;
import users.Student;
import users.User;

import java.io.*;

@SuppressWarnings("unchecked")    //temporary use for compiling

/**
  * Class that holds all the database specific methods and initialization. Has a hashmap that Stores
  * all students and employers together and allows it to be saved easily by writing the one object to a file.
  * Also contains methods to generate random students and employers for testing.
  */
public class Database implements Serializable {

public HashMap<String, User> database = new HashMap<String, User>();
public String randomEmployerCount;
public FileIO f = new FileIO();

/**Default Constructor for Database*/
public Database() {

}

/**Copy Constructor for Database*/
public Database(HashMap<String, User> db) {
        database = db;
}
/** A method to create Random Students, and add them to the database*/
public void createRandomStudents() {
        Scanner continuetoSearch = new Scanner(System.in); /*Scanner that takes input as to whether
                                                              or not you want to continue searching */

        int JohnDoeS = howManyRandos(); //Based on return generate number of students
        for(int i=0; i<JohnDoeS; i++) {
                Student temp = RandomUserFactory.generateRandomStudent();
                database.put(temp.getUID(), temp);
        }
}

/** A method to create Random Employers, and add them to the database
  * @param count  passing in the employer number
  * @return int   updated employer number, so the next custom made employer has an accurate ID
  */
public int createRandomEmployers(int count) {
        Scanner continuetoSearch = new Scanner(System.in); /*Scanner that takes input as to whether
                                                              or not you want to continue searching */

        int EmployerJohnDoeS = howManyRandos(); //Based on return generate number of Employers
        for(int i=0; i<EmployerJohnDoeS; i++) {
                randomEmployerCount = Integer.toString(count);
                Employer temp = RandomUserFactory.generateRandomEmployer();
                database.put(randomEmployerCount, temp);
                count += 1;
        }
        return count;
}

/** A method that takes user input and returns a string to be used to search
   the database for the corresponding user */
public void searchUser(){
        System.out.println(database);
        Scanner searchUID = new Scanner(System.in);
        System.out.println("\nPlease enter the UID of the user you would like to find: ");
        String searchedUser = searchUID.nextLine();
        try{ //if no user is returned print message in line 67


                System.out.println("\nDatabase Returned: ");
                database.get(searchedUser).printContactInfo();

        }catch(Exception e) {
                System.out.println("User Not found");
        }

}

/** A method that returns user input as an int, used to select amount of random users to create
  * @return int   a valid number of random users to create
  */
public int howManyRandos(){
        Scanner randos = new Scanner(System.in);
        System.out.println("\nHow Many randos?: ");
        boolean validInput = false; //Used to validate if a valid input is given
        int numberToValidate = 0;
        do {

                randos = new Scanner(System.in);
                try{
                        numberToValidate = randos.nextInt();

                }catch(Exception e) { //if the input is not a number
                        validInput = false;
                        System.out.println("Invalid input please try again");
                        randos = new Scanner(System.in);
                }
                if (numberToValidate >0) { //if the number is larger than 0
                        validInput = true;
                        randos = new Scanner(System.in);
                }
        } while(validInput == false);
        return numberToValidate;
}

/** A method that returns the Database instance's HashMap
  * @return HashMap  the hashmap containing all created students and employers
  */
public HashMap<String, User> getDatabase() {
        return database;
}



/** Searches the database for a certainn trait of the user and returns them
  * @param name              search criteria
  * @return ArrayList<User>  list of users found to match the search criteria
  */
public ArrayList<User> searchStr(String searchTerm, int searchBy) {
        ArrayList<User> nameList = new ArrayList<User>(); //make an arrayList to return

        //Iterate through database and get an arraylist of the keys with the right name
        for (String key : database.keySet()) {
                User tempUser = database.get(key); //just a temporary user to do checks with
                if (searchBy == 1) {
                        if (tempUser.getFirstName().equals(searchTerm)) { //if first name matches the search criteria...
                                nameList.add(tempUser);
                        }
                } else if (searchBy == 2) {
                        if (tempUser.getLastName().equals(searchTerm)) { //if last name matches the search criteria...
                                nameList.add(tempUser);
                        }
                } else if (searchBy == 3) {
                        if (tempUser.getDegree().equals(searchTerm)) { //if the degree matches the search criteria...
                                System.out.println("Found: "+tempUser.getFirstName());
                                nameList.add(tempUser);
                        }
                }
        }
        return nameList;
} //end of method

/** A method that searches the database for a specific double based on input
  * @param searchTerm   minimum GPA to search students with
  * @param searchBy     to enable the search
  * @return ArrayList   collection of matching students with a high enough GPA
  */
public ArrayList<User> searchNum(double searchTerm, int searchBy) {
        ArrayList<User> nameList = new ArrayList<User>();
        for (String key : database.keySet()) {
                User tempUser = database.get(key); //just a temporary user to do checks with
                if (searchBy == 4) {
                        if (tempUser.getGPA() >= searchTerm) { //if the GPA matches the search criteria...
                                nameList.add(tempUser);
                        }
                }
        }
        return nameList;
}

/** A method that searches the database for a specific email
  * @param searchTerm   Email to search for
  * @return ArrayList   collection of matching users with the email
  */
public ArrayList<User> searchEmail(String searchTerm) {
        ArrayList<User> user = new ArrayList<User>();
        for (String key : database.keySet()) {
                User tempUser = database.get(key); //just a temporary user to do checks with
                if (tempUser.getEmail().equals(searchTerm)) {
                        user.add(tempUser);
                }
        }
        return user;
}



} //end of class
