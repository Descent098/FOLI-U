import java.util.*;
import java.io.*;

public class EmployerJohnDoe extends Employer implements Serializable{
  public String companyName = createRandomCompany();
  public Boolean offeringJobs = true;

  EmployerJohnDoe(){
    randomUser();
    createRandomCompany();
  }
    /** A method to create a random Company Name*/
    public String createRandomCompany(){
      Random rand = new Random();
      String names[] = {"Driive","Google","Rosignol","Nike","Addidas","Audi","Tesla","Enmax","the futur","Coca-Cola","Mcdonalds","Taco Time","Blind Studios","Blizzard","Electronic Arts","Apple","American Eagle","Bootlegger","Walmart","Helly Hansen","University of Calgary","Bob's Burgers","Microsoft","North Face","Samsung","Sandisk","Intel","AMD","ASUS", "Gigabyte"};
      String randomCompany = (names[(rand.nextInt(29))]);
      return randomCompany;
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
