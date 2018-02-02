import java.util.Scanner;

public class User{

  public String Full_name = "John Doe"; // enter VIa command line
  public String program_year = "4th";
  public String UID = "00000000"; //university ID number
  public String University = "U of C"; //Create a dropdown list of options
  public String degree = "CPSC";
  public double GPA = 3.4;
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

    int amount_of_Courses = 3; // the amount of courses determines the calculation
    if (amount_of_Courses == 3){
      double Course_1 = 3.7;
      double Course_2 = 4;
      double Course_3 = 2.7;
      double GPA = ((Course_1+Course_2+Course_3)/3);
      System.out.println("\nUsers GPA is: "+ GPA);
    }
  }

}
