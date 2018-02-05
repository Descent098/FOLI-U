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
    s1.set_User_Attributes();
    s1.calc_GPA();
    print_Vars();

  }
  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ s1.Full_name);
    System.out.println("\n\nUsers Name is: "+ s1.Full_name);
    System.out.println("\nUsers UID is: "+ s1.UID);
    System.out.println("\nUsers University is: "+ s1.University);
    System.out.println("\nUsers Program Year is: "+ s1.program_year);
    System.out.println("\nUsers Degree is: "+ s1.degree);
    System.out.println("\nUsers GPA is: "+ s1.GPA);
  }
}
