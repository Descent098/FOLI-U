import java.util.*;

public class EmployerJohnDoe extends Employer{
  public String fullName = createRandomName();
  public String companyName = createRandomCompany();
  public Boolean offeringJobs = true;
  public String email = createRandomEmail();
  public String country = createRandomCountry();
  public String phoneNumber = createRandomPhoneNumber();



    /** A method to create a random Name*/
    public String createRandomName(){
      Random rand = new Random();
      String names[] = {"Nicola Racine","Synthia Mershon","Hank Carboni","Antonietta Chambers","Melda Kimmer","Aileen Agron","Burton Hemingway","Inge Fort","Kurtis Popham","Robbyn Hutto","Jerrold Berrios","Gena Moniz","Micha Erb","Conchita Holtzman","Hobert Cawley","Elissa Hogge","Towanda Merideth","Rubin Landis","Elouise Chance","Williams Losee","Lurlene Merrihew","Lacresha Mackey","Elodia Fischbach","Calvin Caouette","Richie Esterly","Agnus Collman","Drew Wolfe","Sona Orme","Fred Whelan", "Kitty Royals"};
      String randomFullName = (names[(rand.nextInt(29))]);
      return randomFullName;
    }

    /** A method to create a random Company Name*/
    public String createRandomCompany(){
      Random rand = new Random();
      String names[] = {"Driive","Google","Rosignol","Nike","Addidas","Audi","Tesla","Enmax","the futur","Coca-Cola","Mcdonalds","Taco Time","Blind Studios","Blizzard","Electronic Arts","Apple","American Eagle","Bootlegger","Walmart","Helly Hansen","University of Calgary","Bob's Burgers","Microsoft","North Face","Samsung","Sandisk","Intel","AMD","ASUS", "Gigabyte"};
      String randomCompany = (names[(rand.nextInt(29))]);
      return randomCompany;
    }

    /** A method to create a random Company Name*/
    public String createRandomEmail(){
      Random rand = new Random();
      String names[] = {"mthurn@live.com", "fangorn@hotmail.com","euice@outlook.com" ,"rgarcia@optonline.net","mxiao@yahoo.com", "firstpr@att.net","webdragon@comcast.net", "jguyer@aol.com", "sakusha@yahoo.ca","crandall@sbcglobal.net","drezet@me.com", "miyop@icloud.com"};
      String randomEmail = (names[(rand.nextInt(11) + 1)]);
      return randomEmail;
    }

    /** A method to create a random Country Name*/
    public String createRandomCountry(){
      Random rand = new Random();
      String names[] = {"Canada", "United States","United Kingdom","Italy", "France"};
      String randomCountry = (names[(rand.nextInt(4) + 1)]);
      return randomCountry;
    }

    /** A method to create a random Country Name*/
    public String createRandomPhoneNumber(){
      Random rand = new Random();
      String names[] = {"(403)251-1234 ", "(403)679-1234","(403)382-1234","(403)765-1234", "(403)257-3124"};
      String randomPhoneNumber = (names[(rand.nextInt(4) + 1)]);
      return randomPhoneNumber;
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
