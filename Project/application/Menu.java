package application;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
// public static Scanner mainclassinput = new Scanner(System.in);
public Student s1 = new Student();
public JohnDoe jd = new JohnDoe();
public EmployerJohnDoe e = new EmployerJohnDoe();
public Database db = new Database();
public Employer ep = new Employer();
public FileIO f = new FileIO();
public int employerCount = 0;   //Count of the amount of employers (acts like UID)
String currentCount;
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


public void selectMenu(){
        /** Gives the user options to select from that call methods*/
        Scanner input = new Scanner(System.in);
        String sChoice = "";

        System.out.println("\nPlease select an option:");
        System.out.println("1 for creating a new Student:");
        System.out.println("2 for creating an Employer: ");
        System.out.println("3 Search for a user: ");
        System.out.println("4 for creating and printing random users:");
        System.out.println("5 Load database: ");
	      System.out.println("6 Search by 'first name':"); //will expand this to search by other criteria too
        System.out.println("7 print all names in db:");
        System.out.println("8 to exit program:");

        input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) { //users choice of action with 3 cases
        case 1: createStudent(); //If they select 1 at the first menu create a new student and add to database
                db.database.put(s1.getUID(),s1);
                s1 = new Student();
                break;

        case 2: ep.setEmployerAttributes();
                currentCount = Integer.toString(employerCount);
                db.database.put(currentCount,ep);
                ep = new Employer(); //Resets Class after its creation
                employerCount += 1;
                break;

        case 3: db.searchUser();
                break;

        case 4: System.out.println("\nPlease select an option: ");
                System.out.println("1 for creating a database of random students: ");
                System.out.println("2 for creating a database of random Employers: ");

                input = new Scanner(System.in);
                int choice2Selection = input.nextInt();

                switch (choice2Selection) { //users choice of what type of class to print

                case 1: db.createRandomStudents();
                System.out.println("Enter S to save: ");
                input = new Scanner(System.in);
                sChoice = input.nextLine();
                sChoice = sChoice.toUpperCase();
                if (sChoice.equals("S")) {
                  f.fileSave(db.getDatabase());
                }
                        break;

                case 2: employerCount = db.createRandomEmployers(employerCount);
                System.out.println("Enter S to save: ");
                input = new Scanner(System.in);
                sChoice = input.nextLine();
                sChoice = sChoice.toUpperCase();
                if (sChoice.equals("S")) {
                  f.fileSave(db.getDatabase());
                }
                        break;
                }
                break;

        case 5: db = new Database(f.fileLoad());
                break;


		case 6: System.out.println("Enter the 'first name' to search for: ");

				input = new Scanner(System.in);
				String name = input.nextLine();

				ArrayList<User> tempList = new ArrayList<User>();
				tempList = db.searchName(name); //finds the users with search method

				for (User user : tempList) { //iterate through arraylist
					user.printContactInfo(); //print each users info,
					//#NOTE: this method needs to be changed to work better with the GUI later
					//because the method always prints to the console, it should rather return the text
				}
				break;


        case 7: System.out.println(db.returnAllNames());
        break;

        case 8:
                System.out.println("Checking for save ...");
                if (f.exitCheck()) {
                    f.fileSave(db.getDatabase());
                } else {
                  System.exit(0);
                }

                break;

        }

}
} //end of class
