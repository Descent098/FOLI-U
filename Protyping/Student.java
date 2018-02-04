import java.util.Scanner;

public class Student{

  public String full_name = "John Doe"; // enter VIa command line
  public int program_year = 4;
  public String uID = "00000000"; //university ID number
  public String university = "U of C"; //Create a dropdown list of options
  public String degree = "CPSC";
  public double GPA = 0;

  Student() {
    full_name = "";
    program_year = 0;
    uID = "";
    university = "";
    degree = "";
    GPA = 0;
  }

  public void set_User_Attributes(){
    /** A method to set a users attributes based on user input*/

    System.out.println("Name: ");
    Full_name = input.nextLine();

    System.out.println("What year of your degree are you in>:  ");
    program_year = input.nextLine();

    System.out.println("Please put in your 8 digit UID: ");
    UID = input.nextLine();

    System.out.println("What university are you at?: ");
    University = input.nextLine();

    System.out.println("What degree are you in?: ");
    degree = input.nextLine();

    System.out.println("What is your gpa? (usually this would be a choice to calculate or input): ");
    GPA = input.nextInt();

    //This is all sudo code for the time being


    /*
    Full_name = userinput
    UID = userinput
    University = userinput
    program_year = userinpit
    degree = userinput

    //Need to have an option to have GPA calculated or entered
    GPA = user input */
  }

  public void calc_GPA(){
    /** A method to calculate a users GPA based on input */
    Scanner input = new Scanner(System.in);
		 /** A method to calculate a users GPA based on input */
		 System.out.println("Enter number of courses: ");
		 int courseAmount = input.nextInt();
		 double weightTotal = 0;
		 for (int i = 0; i < courseAmount; i++) {
			 System.out.println("Enter grade for course " + (i+1) + ": ");
			 double grade = 0;
			 grade = input.nextDouble();
			 System.out.println("Enter weight for course " + (i+1) + ": ");
			 double weight = 0;
			 weight = input.nextDouble();
			 GPA += (grade*weight);
			 weightTotal += weight;
		 }
		 input.close();
		 GPA /= weightTotal;
		 System.out.println("Your GPA is: " + GPA);
  }

}
