import java.util.Scanner;

public class Employer {

  public static String fullName = "John Doe";
  public static String companyName = "Google";
  public static Boolean offeringJobs = true;
  public static String phoneNumber = "0000000000";
  public static String emailAddress = "johndoe@hotmail.com";


  public void setEmployerAttributes() {
    Scanner input1 = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);

    System.out.println("Please enter your name: ");
    fullName = input1.nextLine();

    System.out.println("What is your company name: ");
    companyName = input2.nextLine();

    System.out.println("Is your company currently looking to hire?: ");
    offeringJobs = input1.nextBoolean();

    System.out.println("Phone number: ");
    phoneNumber = input3.nextLine();

    System.out.println("Email address:");
    emailAddress = input4.nextLine();

    }

    public static void print_Vars(){
      /** A method that prints a users atributes*/
      System.out.println("\nSearching database for: "+ fullName);
      System.out.println("\nUser Name: "+ fullName);
      System.out.println("User Company: "+ companyName);
      System.out.println("Offering Jobs: "+ offeringJobs);
      System.out.println("Phone Numebr: "+ phoneNumber);
      System.out.println("Email Address: "+ emailAddress);
    }
}
