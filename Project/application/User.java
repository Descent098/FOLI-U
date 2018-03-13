package application;
import java.util.*;
import java.io.*;

public class User implements Serializable{

  private String fullName;
  private String phoneNumber;
  private String email;
  private String city;
  private String province;
  private String country;

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


  /**The code below is for creating JohnDoe(random) Users*/

  public void randomUser(){
    createRandomName();
    createRandomEmail();
    createRandomCountry();
    createRandomPhoneNumber();
    createRandomProvinceState();
    createRandomCity();

  }

  /** A method to create a random Name*/
  public void createRandomName(){
    Random rand = new Random();
    String names[] = {"Nicola Racine","Synthia Mershon","Hank Carboni","Antonietta Chambers","Melda Kimmer","Aileen Agron","Burton Hemingway","Inge Fort","Kurtis Popham","Robbyn Hutto","Jerrold Berrios","Gena Moniz","Micha Erb","Conchita Holtzman","Hobert Cawley","Elissa Hogge","Towanda Merideth","Rubin Landis","Elouise Chance","Williams Losee","Lurlene Merrihew","Lacresha Mackey","Elodia Fischbach","Calvin Caouette","Richie Esterly","Agnus Collman","Drew Wolfe","Sona Orme","Fred Whelan", "Kitty Royals"};
    String randomFullName = (names[(rand.nextInt(29))]);
    setFullName(randomFullName);
  }

  /** A method to create a random Company Name*/
  public void createRandomEmail(){
    Random rand = new Random();
    String names[] = {"mthurn@live.com", "fangorn@hotmail.com","euice@outlook.com" ,"rgarcia@optonline.net","mxiao@yahoo.com", "firstpr@att.net","webdragon@comcast.net", "jguyer@aol.com", "sakusha@yahoo.ca","crandall@sbcglobal.net","drezet@me.com", "miyop@icloud.com"};
    String randomEmail = (names[(rand.nextInt(11) + 1)]);
    setEmail(randomEmail);
  }

  /** A method to create a random Country Name*/
  public void createRandomCountry(){
    Random rand = new Random();
    String names[] = {"Canada", "United States","United Kingdom","Italy", "France"};
    String randomCountry = (names[(rand.nextInt(4) + 1)]);
    setCountry(randomCountry);
  }

  /** A method to create a random Phone number*/
  public void createRandomPhoneNumber(){
    Random rand = new Random();
    String names[] = {"(403)251-1234 ", "(403)679-1234","(403)382-1234","(403)765-1234", "(403)257-3124"};
    String randomPhoneNumber = (names[(rand.nextInt(4) + 1)]);
    setPhoneNumber(randomPhoneNumber);
  }

  /** A method to create a random Province/State*/
  public void createRandomProvinceState(){
    Random rand = new Random();
    String names[] = {"Alberta ", "California","New York","Ontario", "British Columbia", "Tuscany", "Sicily", "Occitanie", "Provence-Alpes-Côte d'Azur", "Brittany", "Staffordshire", "Warwickshire", "Worcestershire"};
    String randomProvinceState = (names[(rand.nextInt(8) + 1)]);
    setProvince(randomProvinceState);
  }

  /** A method to create a random City*/
  public void createRandomCity(){
    Random rand = new Random();
    String names[] = {"Calgary ", "Edmonton","Manhatten","Toronto", "Victoria", "Cortona", "Venice", "Rome", "Chamonix", "Nice", "Stoke on Trent", "Leeks", "Blurton", "Fenton"};
    String randomCity = (names[(rand.nextInt(13) + 1)]);
    setCity(randomCity);
  }

          //All setters and Getters are below


  /** Setter for FullName*/
  public void setFullName(String newName){
    fullName = newName;
  }

  /** Getter for FullName*/
  public String getFullName(){
    String printedFullName = new String(fullName);
    return printedFullName;
  }

  /** Setter for PhoneNumber*/
  public void setPhoneNumber(String newPhoneNumber){
    phoneNumber = newPhoneNumber;
  }

  /** Getter for PhoneNumber*/
  public String getPhoneNumber(){
    String printedPhoneNumber = new String(phoneNumber);
    return printedPhoneNumber;
  }

  /** Setter for Email*/
  public void setEmail(String newEmail){
    email = newEmail;
  }

  /** Getter for Email*/
  public String getEmail(){
    String printedEmail = new String(email);
    return printedEmail;
  }

  /** Setter for City*/
  public void setCity(String newCity){
    city = newCity;
  }

  /** Getter for City*/
  public String getCity(){
    String printedCity = new String(city);
    return printedCity;
  }

  /** Setter for Province*/
  public void setProvince(String newProvince){
    province = newProvince;
  }

  /** Getter for Province*/
  public String getProvince(){
    String printedProvince = new String(province);
    return printedProvince;
  }

  /** Setter for Country*/
  public void setCountry(String newCountry){
    country = newCountry;
  }

  /** Getter for Country*/
  public String getCountry(){
    String printedCountry = new String(country);
    return printedCountry;
  }


}
