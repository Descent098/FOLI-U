import java.util.*;

public class JohnDoe extends Student{
  public int programYear = 4;
  public String UID = createRandomUIDNumber(); //university ID number
  public String university = "U of C"; //Create a dropdown list of options
  public String degree = "CPSC";
  public double GPA = 0;

  /** A method to create a random UID #*/
  public String createRandomUIDNumber(){
    Random rand = new Random();

    int n = (30000000 + rand.nextInt(900000) + 1);
    String randomUID = Integer.toString(n);
    return randomUID;
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
    System.out.println("Phone Numebr: "+ phoneNumber);
    System.out.println("Email Address: "+ email);
    System.out.println("Country: " + country);
    System.out.println("Province: " + province);
    System.out.println("City: " + city);
  }


}
