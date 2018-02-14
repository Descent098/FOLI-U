import java.util.*;

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


  //The code below is for creating JohnDoe(random) Users

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
    fullName = randomFullName;
  }

  /** A method to create a random Company Name*/
  public void createRandomEmail(){
    Random rand = new Random();
    String names[] = {"mthurn@live.com", "fangorn@hotmail.com","euice@outlook.com" ,"rgarcia@optonline.net","mxiao@yahoo.com", "firstpr@att.net","webdragon@comcast.net", "jguyer@aol.com", "sakusha@yahoo.ca","crandall@sbcglobal.net","drezet@me.com", "miyop@icloud.com"};
    String randomEmail = (names[(rand.nextInt(11) + 1)]);
    email =  randomEmail;
  }

  /** A method to create a random Country Name*/
  public void createRandomCountry(){
    Random rand = new Random();
    String names[] = {"Canada", "United States","United Kingdom","Italy", "France"};
    String randomCountry = (names[(rand.nextInt(4) + 1)]);
    country =  randomCountry;
  }

  /** A method to create a random Country Name*/
  public void createRandomPhoneNumber(){
    Random rand = new Random();
    String names[] = {"(403)251-1234 ", "(403)679-1234","(403)382-1234","(403)765-1234", "(403)257-3124"};
    String randomPhoneNumber = (names[(rand.nextInt(4) + 1)]);
    phoneNumber = randomPhoneNumber;
  }

  public void createRandomProvinceState(){
    Random rand = new Random();
    String names[] = {"Alberta ", "California","New York","Ontario", "British Columbia", "Tuscany", "Sicily", "Emilia-Romagna", "Occitanie", "Provence-Alpes-Côte d'Azur", "Brittany", "Staffordshire", "Warwickshire", "Worcestershire"};
    String randomProvinceState = (names[(rand.nextInt(8) + 1)]);
    province =  randomProvinceState;
  }

  public void createRandomCity(){
    Random rand = new Random();
    String names[] = {"Alberta ", "California","New York","Ontario", "British Columbia", "Tuscany", "Sicily", "	Emilia-Romagna", "Occitanie", "Provence-Alpes-Côte d'Azur", "Brittany", "Staffordshire", "Warwickshire", "Worcestershire"};
    String randomCity = (names[(rand.nextInt(8) + 1)]);
    city =  randomCity;
  }



}
