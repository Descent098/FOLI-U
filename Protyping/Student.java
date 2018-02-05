import java.util.Scanner;

public class Student{

  public String full_name = "John Doe"; // enter VIa command line
  public int program_year = 4;
  public String UID = "00000000"; //university ID number
  public String university = "U of C"; //Create a dropdown list of options
  public String degree = "CPSC";
  public double GPA = 0.0;
  // Scanners can only take 1 argument of each method, need 4 to take in all arguments


  public void set_User_Attributes(){
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    /** A method to set a users attributes based on user input*/

    System.out.println("Name: ");
    full_name = input.nextLine();

    System.out.println("What year of your degree are you in?:  ");
    program_year = input.nextInt();

    System.out.println("What university are you at?: ");
    university = input2.nextLine();

    System.out.println("Please put in your 8 digit UID: ");
    UID = input3.nextLine();

    System.out.println("What degree are you in?: ");
    degree = input4.nextLine();

    System.out.println("Would You like to input or calculate your GPA? (1 for input 2 for calcuate): ");
    GPA = input2.nextInt();

    input.close();
    input2.close();
    input3.close();
    input4.close();
  }

  public void calc_GPA(){
    /** A method to calculate a users GPA based on input */
    Scanner input1 = new Scanner(System.in); //GPA Calculation
		System.out.println("Enter number of courses: ");
		int courseAmount = input1.nextInt();
		double weightTotal = 0;
		for (int i = 0; i < courseAmount; i++) {
		 System.out.println("Enter grade for course " + (i+1) + ": ");
		 double grade = 0;
		 grade = input1.nextDouble();
		 System.out.println("Enter weight for course " + (i+1) + ": ");
		 double weight = 0;
		 weight = input1.nextDouble();
		 GPA += (grade*weight);
		 weightTotal += weight;
		}
		input1.close();
		GPA /= weightTotal;
		System.out.println("Your GPA is: " + GPA);
  }

}
