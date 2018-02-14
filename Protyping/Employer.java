import java.util.Scanner;

public class Employer extends User{

  public String companyName = "Google";
  public Boolean offeringJobs = true;

  public void setEmployerAttributes() {
    Scanner input1 = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    setContactInfo();
    System.out.println("What is your company name: ");
    companyName = input2.nextLine();

    System.out.println("Is your company currently looking to hire?: ");
    offeringJobs = input1.nextBoolean();

    }

    public void print_Vars(){
      /** A method that prints a users atributes*/
      System.out.println("\nSearching database for: "+ fullName);
      System.out.println("\nUser Name: "+ fullName);
      System.out.println("User Company: "+ companyName);
      System.out.println("Offering Jobs: "+ offeringJobs);
      System.out.println("Phone Numebr: "+ phoneNumber);
      System.out.println("Email Address: "+ email);
      System.out.println("Country: " + country);
      System.out.println("Province: " + province);
      System.out.println("City: " + city);
    }
}
