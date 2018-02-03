

public class Main{

  public static void main(String[] args) {

    print_Vars();

  }
  public static void print_Vars(){
    /** A method that prints a users atributes*/
    Student s1 = new Student();
    System.out.println("\nSearching database for: "+ s1.Full_name);
    System.out.println("\n\nUsers Name is: "+ s1.Full_name);
    System.out.println("\nUsers UID is: "+ s1.UID);
    System.out.println("\nUsers University is: "+ s1.University);
    System.out.println("\nUsers Program Year is: "+ s1.program_year);
    System.out.println("\nUsers Degree is: "+ s1.degree);
    System.out.println("\nUsers GPA is: "+ s1.GPA);
  }
}
