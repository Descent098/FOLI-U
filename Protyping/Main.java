

public class Main{

  public static void main(String[] args) {

    print_Vars();

  }
  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ User.Full_name);
    System.out.println("\n\nUsers Name is: "+ User.Full_name);
    System.out.println("\nUsers UID is: "+ User.UID);
    System.out.println("\nUsers University is: "+ User.University);
    System.out.println("\nUsers Program Year is: "+ User.program_year);
    System.out.println("\nUsers Degree is: "+ User.degree);
    System.out.println("\nUsers GPA is: "+ User.GPA);
  }
}
