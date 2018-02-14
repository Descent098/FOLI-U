import java.util.*;

public class EmployerJohnDoe extends Employer{
  public String fullName = createRandomName();
  public String companyName = createRandomCompany();
  public Boolean offeringJobs = true;
  public String email = createRandomEmail();

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
      String names[] = {"Nicola Racine","Synthia Mershon","Hank Carboni","Antonietta Chambers","Melda Kimmer","Aileen Agron","Burton Hemingway","Inge Fort","Kurtis Popham","Robbyn Hutto","Jerrold Berrios","Gena Moniz","Micha Erb","Conchita Holtzman","Hobert Cawley","Elissa Hogge","Towanda Merideth","Rubin Landis","Elouise Chance","Williams Losee","Lurlene Merrihew","Lacresha Mackey","Elodia Fischbach","Calvin Caouette","Richie Esterly","Agnus Collman","Drew Wolfe","Sona Orme","Fred Whelan", "Kitty Royals"};
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
