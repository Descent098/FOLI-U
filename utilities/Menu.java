package utilities;
import java.util.Scanner;
import users.Employer;
import users.Student;
import users.User;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**Menu for the text version*/
public class Menu {

private Student s1 = new Student();
private Database db = new Database();
private Employer ep = new Employer();
private FileIO f = new FileIO();
private int employerCount = 0;   //Count of the amount of employers (acts like UID)
private String currentCount; //Used to convert the employer count to a string

/**Method to create a student*/
public void createStudent(){
        /** method to call all methods needed to create a user*/
        s1.set_User_Attributes();

        if (s1.getGPA() == 2) {
                s1.calc_GPA();
        }

        if (s1.getGPA() == 1) {
                Scanner GPAInput = new Scanner(System.in);
                System.out.println("\nEnter your GPA: ");
                s1.setGPA(GPAInput.nextDouble());
        }
}

/**Method that contains the "main selection menu"; continues in an infinite loop of tasks unless user chooses to exit*/
public void selectMenu(){
        /** Gives the user options to select from that call methods*/
        Scanner input = new Scanner(System.in);
        String sChoice = "";


        System.out.println("\nPlease select an option:");
        System.out.println("1 For creating a new Student:");
        System.out.println("2 For creating an Employer: ");
        System.out.println("3 Search for a user: ");
        System.out.println("4 For creating and printing random users:");
        System.out.println("5 Load database: ");
        System.out.println("6 Search for multiple users: ");
        System.out.println("7 Generate Statistics: ");
        System.out.println("8 Exit program: ");

        input = new Scanner(System.in);
        int choice = validateInt(8,1);

        switch (choice) { //users choice of action with 9 cases
        case 1: createStudent(); //If they select 1 at the first menu create a new student and add to database
                db.database.put(s1.getUID(),s1);
                s1 = new Student();
                break;

        case 2: //Create a new Employer
                ep.setEmployerAttributes();
                currentCount = Integer.toString(employerCount);
                db.database.put(currentCount,ep);
                ep = new Employer(); //Resets Class after its creation
                employerCount += 1;
                break;

        case 3: //Search for a user by UID/ID
                db.searchUser();
                break;

        case 4: //Create random Users
                System.out.println("\nPlease select an option: ");
                System.out.println("1 for creating a database of random students: ");
                System.out.println("2 for creating a database of random Employers: ");

                input = new Scanner(System.in);
                int choice2Selection = validateInt(2,1);

                switch (choice2Selection) { //users choice of what type of class to print

                case 1: //Create Random Students
                        db.createRandomStudents();
                        f.fileSave(db.getDatabase()); //After creating the Students save to databse
                        break;

                case 2: //Create Random Employers
                        employerCount = db.createRandomEmployers(employerCount);
                        f.fileSave(db.getDatabase()); //After creating the employers save to databse
                        break;
                }
                break;

        case 5: db = new Database(f.fileLoad());
                break;


        case 6: //Searches of Multiple Users
                System.out.println("Enter 1 to search by first name: ");
                System.out.println("Enter 2 to search by last name: ");
                System.out.println("Enter 3 to search by major: ");
                System.out.println("Enter 4 to search by GPA: ");

                input = new Scanner(System.in);
                int searchBy = validateInt(4,1);
                ArrayList<User> tempList = new ArrayList<User>();
                if (searchBy == 1 || searchBy == 2 || searchBy == 3) {
                        if (searchBy == 1) {
                                System.out.println("Enter the first name to search for: ");
                                input = new Scanner(System.in);
                                String searchTerm = input.nextLine();
                                tempList = db.searchStr(searchTerm, searchBy); //finds the users with search method
                        } else if (searchBy == 2) {
                                System.out.println("Enter the last name to search for: ");
                                input = new Scanner(System.in);
                                String searchTerm = input.nextLine();
                                tempList = db.searchStr(searchTerm, searchBy); //finds the users with search method
                        } else if (searchBy == 3) {
                                System.out.println("Enter the major to search for \n(1)BIO \n(2)ENG  \n(3)MED \n(4)CPSC \n(5)COMM \n(6)PSYC \n(7)SOCI \n(8)CMF \n(9)LING");
                                input = new Scanner(System.in);
                                int decision = validateInt(9,1);
                                String searchTerm = "";


                                switch(decision) {

                                case 1: searchTerm = "BIO";
                                        break;

                                case 2: searchTerm = "ENG";
                                        break;

                                case 3: searchTerm = "MED";
                                        break;

                                case 4: searchTerm = "CPSC";
                                        break;

                                case 5: searchTerm = "COMM";
                                        break;

                                case 6: searchTerm = "PSYC";
                                        break;

                                case 7: searchTerm = "SOCI";
                                        break;

                                case 8: searchTerm = "CMF";
                                        break;

                                case 9: searchTerm = "LING";
                                        break;
                                }

                                tempList = db.searchStr(searchTerm, searchBy); //finds the users with search method
                        }
                        for (User user : tempList) { //iterate through arraylist
                                user.printContactInfo(); //print each users info,
                                //#NOTE: this method needs to be changed to work better with the GUI later
                                //because the method always prints to the console, it should rather return the text
                        }
                } else if (searchBy == 4) {
                        if (searchBy == 4) {
                                System.out.println("Enter the minimum GPA to search for: ");
                                input = new Scanner(System.in);
                                double searchTerm = input.nextDouble();
                                tempList = db.searchNum(searchTerm, searchBy); //finds the users with search method
                        }
                        for (User user : tempList) { //iterate through arraylist
                                user.printContactInfo(); //print each users info,
                                //#NOTE: this method needs to be changed to work better with the GUI later
                                //because the method always prints to the console, it should rather return the text
                        }
                }



                break;


        case 7: //Printing statistics
                Statistics textStats = new Statistics();
                DecimalFormat df = new DecimalFormat("#.##"); //Strips everything after the second decimal place for nice printing
                Scanner degreeChoice = new Scanner(System.in);
                int selectedChoice;

                //Calculates and prints information about the amount of Students, as well as percentage of the database that is Students
                System.out.println("There are: " + textStats.howManyStudents(db.getDatabase()) +  " Student(s) in the database");
                System.out.println("They Make up: %" + df.format(textStats.percentageofStudents(db.getDatabase())) +  " of the user(s) in the database\n\n");

                //Calculates and prints information about the amount of employers, as well as percentage of the database that is employers
                System.out.println("There are: " + textStats.howManyEmployers(db.getDatabase()) +  " Employer(s) in the database");
                System.out.println("They Make up: %" + df.format(textStats.percentageofEmployers(db.getDatabase())) +  " of the user(s) in the database\n\n");

                //Calculates and prints mean GPA of whole database + standard deviation of the GPA of the whole database
                System.out.println("The average GPA of all students is: " + df.format(textStats.overallMeanGPA(db.getDatabase())) + " \nStandard Deviation: " + df.format(textStats.GPAStandardDeviation(db.getDatabase())) + "\n");

                //Calculates and prints the amount of people in each degree
                System.out.println("Which Degree would you like information about?");
                System.out.println("(1)BIO \n(2)ENG  \n(3)MED \n(4)CPSC \n(5)COMM \n(6)PSYC \n(7)SOCI \n(8)CMF \n(9)LING");

                selectedChoice = validateInt(9,1);
                switch(selectedChoice) {
                case 1: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "BIO") +  " Students taking BIO in the database");
                        break;
                case 2: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "ENG") +  " Students taking ENG in the database");
                        break;
                case 3: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "MED") +  " Students taking MED in the database");
                        break;
                case 4: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "CPSC") +  " Students taking CPSC in the database");
                        break;
                case 5: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "COMM") +  " Students taking COMM in the database");
                        break;
                case 6: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "psyc") +  " Students taking PSYC in the database");
                        break;
                case 7: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "SOCI") +  " Students taking SOCI in the database");
                        break;
                case 8: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "CMF") +  " Students taking CMF in the database");
                        break;
                case 9: System.out.println("There are: " + textStats.howManyStudentsInDegree(db.getDatabase(), "LING") +  " Students taking LING in the database");
                        break;

                }



                break;

        case 8: //Exit text version
                System.out.println("Checking for save ...");
                if (f.exitCheck()) {
                        f.fileSave(db.getDatabase());
                } else {
                        System.out.println("Do you want to overwrite your current database? (Y/N) ");
                        input = new Scanner(System.in);
                        String overwrite = input.nextLine().toUpperCase();
                        if (overwrite.equals("Y")) {
                                f.fileSave(db.getDatabase());
                                System.exit(0);
                        } else {
                                System.exit(0);
                        }
                }

                break;

        }

<<<<<<< HEAD
}
/**Method to validate int selections for the text version*/
public int validateInt(int max, int min){

        boolean validInput = false; //Used to validate if a valid input is given
        Scanner userInput = new Scanner(System.in);
        int numberToValidate = 0;
        do {

                userInput = new Scanner(System.in);
                try{
                        numberToValidate = userInput.nextInt();

                }catch(Exception e) { //if the input is not a number
                        validInput = false;
                        userInput = new Scanner(System.in);
                }
                if (numberToValidate > max || numberToValidate < min) { //if the number is out of range
                        System.out.println("Please enter a value between " + min + "-" + max);
                        userInput = new Scanner(System.in);
                }
                if (numberToValidate <= max && numberToValidate >= min) { //if the number is in range
                        validInput = true;
                        userInput = new Scanner(System.in);
                }
        } while(validInput == false);

        return numberToValidate;
=======
      }
/**Method to validate int selections for the text version*/
public int validateInt(int max, int min){

  boolean validInput = false; //Used to validate if a valid input is given
  Scanner userInput = new Scanner(System.in);
  int numberToValidate = 0;
  do{

    userInput = new Scanner(System.in);
    try{
    numberToValidate = userInput.nextInt();

  }catch(Exception e){ //if the input is not a number
    validInput = false;
    userInput = new Scanner(System.in);
  }
    if (numberToValidate > max || numberToValidate < min){ //if the number is out of range
      System.out.println("Please enter a value between " + min + "-" + max);
      userInput = new Scanner(System.in);
    }
    if (numberToValidate <= max && numberToValidate >= min){ //if the number is in range
      validInput = true;
      userInput = new Scanner(System.in);
    }
  }while(validInput == false);

  return numberToValidate;
>>>>>>> 40be4568d815ebdd5496bce0f3434ea4621ccf11
}
} //end of class
