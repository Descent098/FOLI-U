import java.util.Scanner;

public class Main{
  // public static Scanner mainclassinput = new Scanner(System.in);
  public static Student s1 = new Student();

  public static void main(String[] args) {
    // System.out.println("Press 1 if you are a student or 2 if you are an employer. ");
    // System.out.println("Choice: ");
    // int choice =  mainclassinput.nextInt();
    // mainclassinput.close();
    //need an if statement for the slection made and then import the corresponding class
    selectMenu();
    print_Vars();

  }
  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ s1.full_name);
    System.out.println("\n\nUsers Name is: "+ s1.full_name);
    System.out.println("\nUsers UID is: "+ s1.UID);
    System.out.println("\nUsers University is: "+ s1.university);
    System.out.println("\nUsers Program Year is: "+ s1.program_year);
    System.out.println("\nUsers Degree is: "+ s1.degree);
    System.out.println("\nUsers GPA is: "+ s1.GPA);
  }

public static void createUser(){
  /** method to call all methods needed to create a user*/
  s1.set_User_Attributes();

  if (s1.GPA == 2){
    s1.calc_GPA();
}

  if (s1.GPA == 1){
    Scanner GPAInput = new Scanner(System.in);
    System.out.println("\nEnter your GPA: ");
    s1.GPA = GPAInput.nextDouble();
  }
}


  public static void selectMenu(){
    /** Gives the user options to select from that call methods*/
    Scanner selection = new Scanner(System.in);
    System.out.println("\nPlease select an option:");
    System.out.println("1 for creating a new user:");
    System.out.println("2 for printing a users attributes:");
    System.out.println("3 to exit program:");
    int choice = selection.nextInt();
    if (choice == 1){
      createUser();
    }
    if (choice == 2){
      print_Vars();
    }
    if (choice == 3){
      System.exit(0);
    }
  }
}
