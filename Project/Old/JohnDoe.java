import java.util.Scanner;

public class JohnDoe extends Student{

  public static String fullName = "John Doe"; // enter VIa command line
  public static int programYear = 4;
  public static String UID = "00000000"; //university ID number
  public static String university = "U of C"; //Create a dropdown list of options
  public static String degree = "CPSC";
  public static double GPA = 0;
  public static Scanner input = new Scanner(System.in);

  public void set_User_Attributes(){
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    /** A method to set a users attributes based on user input*/

    System.out.println("Name: ");
    fullName = input.nextLine();

    System.out.println("What year of your degree are you in?:  ");
    programYear = input.nextInt();

    System.out.println("What university are you at?: ");
    university = input2.nextLine();

    System.out.println("Please put in your 8 digit UID: ");
    UID = input3.nextLine();

    System.out.println("What degree are you in?: ");
    degree = input4.nextLine();

    System.out.println("Would You like to input or calculate your GPA? (1 for input 2 for calcuate): ");
    GPA = input2.nextInt();

  }


  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ fullName);
    System.out.println("\n\nUsers Name is: "+ fullName);
    System.out.println("\nUsers UID is: "+ UID);
    System.out.println("\nUsers University is: "+ university);
    System.out.println("\nUsers Program Year is: "+ programYear);
    System.out.println("\nUsers Degree is: "+ degree);
    System.out.println("\nUsers GPA is: "+ GPA);
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
