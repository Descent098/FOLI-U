public class User{

  private static String Full_name = "John Doe"; // enter VIa command line
  private static String UID = "00000000"; //university ID number
  private static String University = "U of C"; //Create a dropdown list of options
  private static String program_year = "4th";
  private static String degree = "CPSC";
  private static double GPA = 3.4;

  public static void main(String[] args) {
    System.out.print("Welcome to Foli-U please enter your information\n");
    print_Vars();
  }

  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ Full_name);
    System.out.println("\n\nUsers Name is: "+ Full_name);
    System.out.println("\nUsers UID is: "+ UID);
    System.out.println("\nUsers University is: "+ University);
    System.out.println("\nUsers Program Year is: "+ program_year);
    System.out.println("\nUsers Degree is: "+ degree);
    System.out.println("\nUsers GPA is: "+ GPA);
  }

  public static void set_User_Attributes(){
    /** A method to set a users attributes based on user input*/

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

  public static void calc_GPA(){
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
