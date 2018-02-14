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
    while (true){
      selectMenu();
    }


  }
  public static void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: "+ s1.fullName);
    System.out.println("\n\nUsers Name is: "+ s1.fullName);
    System.out.println("Users UID is: "+ s1.UID);
    System.out.println("Users University is: "+ s1.university);
    System.out.println("Users Program Year is: "+ s1.programYear);
    System.out.println("Users Degree is: "+ s1.degree);
    System.out.println("Users GPA is: "+ s1.GPA);
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
    Scanner choice2Selector = new Scanner(System.in);
    System.out.println("\nPlease select an option:");
    System.out.println("1 for creating a new user:");
    System.out.println("2 for printing a users attributes:");
    System.out.println("3 to exit program:");
    int choice = selection.nextInt();


    switch (choice){ //users choice of action with 3 cases
    case 1: createUser();
            break;

    case 2: System.out.println("\nPlease select an option: ");
            System.out.println("1 for printing a prefabbed student class ");
            System.out.println("2 for printing a prefabbed employer class  ");
            System.out.println("3 for printing the just created class (have to have created a class): ");
            int choice2Selection = choice2Selector.nextInt();

            switch (choice2Selection){ //users choice of what type of class to print
              case 1: JohnDoe.print_Vars();
                  break;
              case 2: Employer.print_Vars();
                  break;
              case 3: print_Vars();
              break;
      }
            break;
      case 3: System.exit(0);
              break;
    }

  }
}
