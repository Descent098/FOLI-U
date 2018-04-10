package users;
import java.util.*;
import java.io.*;

public class User implements Serializable{

  private String firstName = "";
  private String lastName = "";
  private String phoneNumber = "";
  private String email = "";
  private String city = "";
  private String province = "";
  private String country = "";


  //blank constructor
  public User() {

  }

  //copy constructor used by student and employer for common attributes
  // User(User oldUser) {
  //   firstName = oldUser.getFirstName();
  //   lastName = oldUser.getLastName();
  //   phoneNumber = oldUser.getPhoneNumber();
  //   email = oldUser.getEmail();
  //   city = oldUser.getCity();
  //   province = oldUser.getProvince();
  //   country = oldUser.getCountry();
  // }


  /**A method called to set up a Users Startup info initially, not a constructor because it's only used in text version*/
  public void setContactInfo(){
    Scanner input = new Scanner(System.in);
    int selection;

    System.out.println("Please enter your contact info: \n");

    System.out.println("\nPlease enter your first Name: ");
    input = new Scanner(System.in);
    this.firstName = input.nextLine();

    System.out.println("\nPlease enter your last Name: ");
    input = new Scanner(System.in);
    this.lastName = input.nextLine();

    System.out.println("\nPlease enter your Phone Number: ");
    input = new Scanner(System.in);
    this.phoneNumber = input.nextLine();

    System.out.println("\nPlease enter your Email: ");
    input = new Scanner(System.in);
    this.email = input.nextLine();

    System.out.println("\nPlease Select your City:");
    System.out.println("(1)Calgary \n(2)Edmonton \n(3)Lethbridge \n(4)Boston \n(5)Chicago \n(6)Vegas"); //List of Cities
    input = new Scanner(System.in);
    selection = input.nextInt();
    switch(selection){ //Assign a city based on User input

      case 1: this.city = "Calgary";
      break;

      case 2: this.city = "Edmonton";
      break;

      case 3: this.city = "Lethbridge";
      break;

      case 4: this.city = "Boston";
      break;

      case 5: this.city = "Chicago";
      break;

      case 6: this.city = "Vegas";
      break;


    }

    //Switch Statement to Assign Province based on City
    switch(this.city){

      case("Calgary"): this.province = "Alberta";
      System.out.println("\nProvince set to Alberta");
      break;

      case("Lethbridge"): this.province = "Alberta";
      System.out.println("\nProvince set to Alberta");
      break;

      case("Edmonton"): this.province = "Alberta";
      System.out.println("\nProvince set to Alberta");
      break;


      case("Boston"): this.province = "Massachusetts";
      System.out.println("\nState Set to Massachusetts");
      break;

      case("Chicago"): this.province = "Illinois";
      System.out.println("\nState Set to Illinois");
      break;

      case("Vegas"): this.province = "Nevada";
      System.out.println("\nState Set to Nevada");
      break;


    }

    //Sets country based on Province
    switch(this.province){

      case("Alberta"): this.country = "Canada";
      System.out.println("\nCountry Set to Canada");
      break;

      case("Illinios"): this.country = "USA";
      System.out.println("\nCountry Set to USA");
      break;

      case("Nevada"): this.country = "USA";
      System.out.println("\nCountry Set to USA");
      break;

      case("Massachusetts"): this.country = "USA";
      System.out.println("\nCountry Set to USA");
      break;

    }

  }

  /** A method to allow you to print all a users contact into*/
  public void printContactInfo(){
    System.out.println("\nName: " + firstName + " " + lastName);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Email: " + email);
    System.out.println("Country: " + country);
    System.out.println("City: " + city);
    System.out.println("Province: " + province);
  }


  /**The code below is for creating JohnDoe(random) Users*/

  public void randomUser(){
    createRandomFirstName();
    createRandomEmail();
    createRandomCountry();
    createRandomPhoneNumber();
    createRandomProvinceState();
    createRandomCity();
    createRandomLastName();
  }

  /** A method to create a random Name*/
  public void createRandomFirstName(){
    Random rand = new Random();
    String names[] = {"Nicola","Synthia","Hank","Antonietta","Melda","Aileen","Burton","Inge","Kurtis","Robbyn","Jerrold","Gena","Micha","Conchita","Hobert","Elissa","Towanda","Rubin","Elouise","Williams","Lurlene","Lacresha","Elodia","Calvin","Richie","Agnus","Drew","Sona","Fred", "Kitty", "Elon"};
	String randomFullName = (names[(rand.nextInt(31))]);
    setFirstName(randomFullName);
  }

  /** A method to create a random lastName*/
  public void createRandomLastName(){
    Random rand = new Random();
    String names[] = {"Racine","Mershon","Carboni","Chambers","Kimmer","Agron","Hemingway","Fort","Popham","Hutto","Berrios","Moniz","Erb","Holtzman","Cawley","Hogge","Merideth","Landis","Chance","Losee","Merrihew","Mackey","Fischbach" , "Caouette","Esterly","Collman","Wolfe","Orme","Whelan", "Royals"};
	String randomFullName = (names[(rand.nextInt(30))]);
    setLastName(randomFullName);
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


  /** Setter for FirstName*/
  public void setFirstName(String newName){
    firstName = newName;
  }

  /** Getter for FirstName*/
  public String getFirstName(){
    String printedFirstName = new String(firstName);
    return printedFirstName;
  }
  /*
  public StringProperty firstNameProperty() {
	  return firstNameGUI;
  }*/

  /** Setter for lastName*/
  public void setLastName(String newName){
    lastName = newName;
  }

  /** Getter for lastName*/
  public String getLastName(){
    String printedlastName = new String(lastName);
    return printedlastName;
  }
  /*
  public StringProperty lastNameProperty() {
	  return lastNameGUI;
  }
  */

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

  public Double getGPA(){ //Class will be overridden in student
    return 0.0;
  }

  public String getDegree(){ //Class will be overridden in student
    return "hello";
  }

  public String getStudentType(){ //Class will be overridden in student
    return "hello";
  }

  public String getUniversity(){ //Class will be overridden in student
    return "hello";
  }

  public String getCompanyName(){ //Class will be overridden in student
    return "hello";
  }

  public String getOfferingJobs(){ //Class will be overridden in student
    return "hello";
  }

  public String getDOB() {
	  return "hello";
  }

}
