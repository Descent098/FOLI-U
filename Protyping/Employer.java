import java.util.Scanner;

public class Employer {

  public String fullName = "Mr. John Doe";
  public String companyName = "Google";
  public Boolean offeringJobs = true;
  public String phoneNumber = "0000000000";
  public String emailAddress = "johndoe@hotmail.com";


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
}
