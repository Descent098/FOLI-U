import java.util.Scanner;

public class User{

  public String fullName;
  public String phoneNumber;
  public String email;
  public String city;
  public String province;
  public String country;

  /**A method called to set up a Users Startup info initially*/
  public void setContactInfo(){
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    Scanner input5 = new Scanner(System.in);
    Scanner input6 = new Scanner(System.in);
    System.out.println("Please enter your contact info: \n");

    System.out.println("\nPlease enter your Name: ");
    this.fullName = input.nextLine();

    System.out.println("\nPlease enter your Phone Number: ");
    this.phoneNumber = input2.nextLine();

    System.out.println("\nPlease enter your Email: ");
    this.email = input3.nextLine();

    System.out.println("\nPlease enter your City: ");
    this.city = input4.nextLine();

    System.out.println("\nPlease enter your Province: ");
    this.province = input6.nextLine();

    System.out.println("\nPlease enter your Country: ");
    this.country = input5.nextLine();



  }

  /** A method to allow you to print all a users contact into*/
  public void printContactInfo(){
    System.out.println("\nName: " + fullName);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Email: " + email);
    System.out.println("Country: " + country);
    System.out.println("City: " + city);
    System.out.println("Province: " + province);
  }

}
