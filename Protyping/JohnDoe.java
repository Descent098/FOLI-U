import java.util.Scanner;

public class JohnDoe extends Student{

  public static String full_name = "John Doe"; // enter VIa command line
  public static String program_year = "4th";
  public static String UID = "00000000"; //university ID number
  public static String university = "U of C"; //Create a dropdown list of options
  public static String degree = "CPSC";
  public static double GPA = 0;
  public static Scanner input = new Scanner(System.in);

  public void set_User_Attributes(){
    /** A method to set a users attributes based on user input*/


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
  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ full_name);
    System.out.println("\n\nUsers Name is: "+ full_name);
    System.out.println("\nUsers UID is: "+ UID);
    System.out.println("\nUsers University is: "+ university);
    System.out.println("\nUsers Program Year is: "+ program_year);
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
