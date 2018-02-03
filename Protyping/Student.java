import java.util.Scanner;

public class Student{

  public String Full_name = "John Doe"; // enter VIa command line
  public String program_year = "4th";
  public String UID = "00000000"; //university ID number
  public String University = "U of C"; //Create a dropdown list of options
  public String degree = "CPSC";
  public double GPA = 0;
  public Scanner input = new Scanner(System.in);

  public void set_User_Attributes(){
    /** A method to set a users attributes based on user input*/

    System.out.println("Press 1 if you are a student or 2 if you are an employer. ");
    System.out.println("Choice: ");
    int choice = input.nextInt();
    System.out.println("Name: ");
    String name = input.nextLine();

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
		 System.out.println("Your GPA is: " + gpa);
  }

}
