import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

public class JohnDoe extends Student implements Serializable{
  public int programYear;
  public String UID; //university ID number
  public String university; //Create a dropdown list of options
  public String degree;
  public double GPA;
  public String studentType;

  JohnDoe(){
    randomUser();
    createRandomUIDNumber();
    createRandomUniversity();
    createRandomDegree();
    createRandomYear();
    createRandomGPA();
    if (programYear < 5){
      studentType = "Undergraduate Student";
    }

    if (programYear > 5 && programYear < 8){
      studentType = "Masters Student";
    }

    if (programYear > 8){
      studentType = "Doctoral Candidate";
    }

  }
  /** A method to create a random UID #*/
  public void createRandomUIDNumber(){
    Random rand = new Random();

    int n = (30000000 + rand.nextInt(900000) + 1);
    String randomUID = Integer.toString(n);
    UID = randomUID;
  }

  /** A method to create a random University*/
  public void createRandomUniversity(){
    Random rand = new Random();
    String names[] = {"University of Calgary","University of Lethbridge","University of Alabama","University of Alberta","University of Toronto","University of Oregon","University of Portland","University of Staffordshire","University of Westminister","University of Kent","University of California","Massachusetts Institute of Technology","keele university","University of Milan","University of Turin","University of Bologna","Ca' Foscari University of Venice","University of Grenoble","University of British Columbia","Université Pierre et Marie Curie","Harvard University","McGill University","Princeton University","University of Chicago","University of Halifax","Stanford University","University of Pennsylvania","Mount Royal Collage","St. Mary's University", "Devry"};
    String randomUniversity = (names[(rand.nextInt(29))]);
    university = randomUniversity;
  }

  /** A method to create a random Year*/
  public void createRandomYear(){
    Random rand = new Random();
    int n = (rand.nextInt(7));
    programYear = n;
  }

  /** A method to create a random GPA #*/
  public void createRandomGPA(){
    double rangeMin = 2.0;
    double rangeMax = 4.0;
    Random rand = new Random();
    double n = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
    GPA = n;
  }

  /** A method to create a random University*/
  public void createRandomDegree(){
    Random rand = new Random();
    String names[] = {" CPSC","BIO", "MED", "ENG", "SOCI", "PSYC"};
    String randomDegree = (names[(rand.nextInt(5))]);
    degree = randomDegree;
  }


  public void printContactInfo(){
    /** A method that prints a users atributes*/
    DecimalFormat twoDecimals = new DecimalFormat(".##");
    System.out.println("\nSearching database for: "+ fullName);
    System.out.println("\n\nUsers Name is: "+ fullName);
    System.out.println("Users UID is: "+ UID);
    System.out.println("Users University is: "+ university);
    System.out.println("Users Program Year is: "+ programYear);
    System.out.println("User is a : "+ studentType);
    System.out.println("Users Degree is: "+ degree);
    System.out.println("Users GPA is: "+ twoDecimals.format(GPA));
    System.out.println("Phone Numebr: "+ phoneNumber);
    System.out.println("Email Address: "+ email);
    System.out.println("Country: " + country);
    System.out.println("Province: " + province);
    System.out.println("City: " + city);
  }


}
