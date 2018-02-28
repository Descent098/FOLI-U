import java.util.Scanner;

public class Menu{
  // public static Scanner mainclassinput = new Scanner(System.in);
  public Student s1 = new Student();
  public JohnDoe jd = new JohnDoe();
  public EmployerJohnDoe e = new EmployerJohnDoe();
  public Database db = new Database();
  public Employer ep = new Employer();
  public int employerCount = 0; //Count of the amount of employers (acts like UID)
  String currentCount;
public void createStudent(){
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
    System.out.println("1 for creating a new Student:");
    System.out.println("2 for creating an Employer: ");
    System.out.println("3 Search for a user: ");
    System.out.println("4 for creating and printing random users:");
    System.out.println("5 to exit program:");

    int choice = selection.nextInt();


    switch (choice){ //users choice of action with 3 cases
    case 1: createStudent(); //If they select 1 at the first menu create a new student and add to database
      db.database.put(s1.UID,s1);
      s1 = new Student();
            break;

    case 2: ep.setEmployerAttributes();
      currentCount = Integer.toString(employerCount);
      db.database.put(currentCount,ep);
      ep = new Employer(); //Resets Class after its creation
      employerCount += 1 ;
      break;

    case 3:db.searchUser();
      break;

    case 4: System.out.println("\nPlease select an option: ");
            System.out.println("1 for creating and printing a randomly generated student class ");
            System.out.println("2 for creating and printing a randomly generated employer class  ");
            System.out.println("3 for creating a database of random students: ");
            System.out.println("4 for creating a database of random Employers: ");

            int choice2Selection = choice2Selector.nextInt();

            switch (choice2Selection){ //users choice of what type of class to print
              case 1:jd = new JohnDoe(); //Resets Class after its creation
                  jd.randomUser();
                  jd.print_Vars();
                  db.database.put(jd.UID,jd);

                  break;
              case 2: e.randomUser();
                  e.print_Vars();
                  currentCount = Integer.toString(employerCount);
                  db.database.put(currentCount,e);
                  e = new EmployerJohnDoe(); //Resets Class after its creation
                  employerCount += 1 ;
                  break;
              case 3: db.createRandomStudents();
              break;

              case 4: employerCount = db.createRandomEmployers(employerCount);
              break;
      }
            break;
      case 5: System.exit(0);
              break;




    }

  }
}
