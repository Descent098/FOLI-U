import java.util.Scanner;

public class Menu{
  // public static Scanner mainclassinput = new Scanner(System.in);
  public Student s1 = new Student();
  public JohnDoe jd = new JohnDoe();
  public EmployerJohnDoe e = new EmployerJohnDoe();

public void createUser(){
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


  public void selectMenu(){
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
              case 1: jd.print_Vars();
                  break;
              case 2: e.print_Vars();
                  break;
              case 3: s1.print_Vars();
              break;
      }
            break;
      case 3: System.exit(0);
              break;
    }

  }
}
