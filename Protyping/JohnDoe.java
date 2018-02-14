import java.util.*;

public class JohnDoe extends Student{
  public String fullName = createRandomName(); // enter VIa command line
  public int programYear = 4;
  public String UID = createRandomUIDNumber(); //university ID number
  public String university = "U of C"; //Create a dropdown list of options
  public String degree = "CPSC";
  public double GPA = 0;
  public Scanner input = new Scanner(System.in);

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
  /** A method to create a random UID #*/
  public String createRandomUIDNumber(){
    Random rand = new Random();

    int n = (30000000 + rand.nextInt(900000) + 1);
    String randomUID = Integer.toString(n);
    return randomUID;
  }

  /** A method to create a random Name*/
  public String createRandomName(){
    Random rand = new Random();
    String names[] = {"Nicola Racine","Synthia Mershon","Hank Carboni","Antonietta Chambers","Melda Kimmer","Aileen Agron","Burton Hemingway","Inge Fort","Kurtis Popham","Robbyn Hutto","Jerrold Berrios","Gena Moniz","Micha Erb","Conchita Holtzman","Hobert Cawley","Elissa Hogge","Towanda Merideth","Rubin Landis","Elouise Chance","Williams Losee","Lurlene Merrihew","Lacresha Mackey","Elodia Fischbach","Calvin Caouette","Richie Esterly","Agnus Collman","Drew Wolfe","Sona Orme","Fred Whelan", "Kitty Royals"};
    String randomFullName = (names[(rand.nextInt(29))]);
    return randomFullName;
  }


  public void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ fullName);
    System.out.println("\n\nUsers Name is: "+ fullName);
    System.out.println("\nUsers UID is: "+ UID);
    System.out.println("\nUsers University is: "+ university);
    System.out.println("\nUsers Program Year is: "+ programYear);
    System.out.println("\nUsers Degree is: "+ degree);
    System.out.println("\nUsers GPA is: "+ GPA);
  }


}
