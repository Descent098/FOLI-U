import java.util.*;

@SuppressWarnings("unchecked")    //temporary use for mac compiling
/**class that holds all the database specific methods and initialization*/
public class Database{

  public HashMap<String, User> database = new HashMap();
  public String randomEmployerCount;

/** A method to create Random Students, and add them to the database*/
  public void createRandomStudents() {
  Scanner continuetoSearch = new Scanner(System.in); /*scaner that takes input as to whether
  or not you want to continue searching */

  int JohnDoeS = howManyRandos();
  for(int i=0; i<JohnDoeS; i++){
    JohnDoe temp = newJohnDoe();
    database.put(temp.UID, temp);
  }
}

/** A method to create Random Employers, and add them to the database*/
  public int createRandomEmployers(int count) {
  Scanner continuetoSearch = new Scanner(System.in); /*scaner that takes input as to whether
  or not you want to continue searching */

  int EmployerJohnDoeS = howManyRandos();
  for(int i=0; i<EmployerJohnDoeS; i++){
    randomEmployerCount = Integer.toString(count);
    EmployerJohnDoe temp = new EmployerJohnDoe();
    database.put(randomEmployerCount, temp);
    count += 1;

  }
  return count;
}

/** A method that takes user input and returns a string to be used to search
the database for the corresponding user */
public void searchUser(){
  System.out.println(database);
  Scanner searchUID = new Scanner(System.in);

  System.out.println("\nPlease enter the UID of the user you would like to find: ");
  String searchedUser = searchUID.nextLine();
  System.out.println("\nDatabase Returned: ");
  database.get(searchedUser).printContactInfo();

}


/** Creates a new random User from class JohnDoe*/
public JohnDoe newJohnDoe(){
  JohnDoe JoDo = new JohnDoe();
  return JoDo;
  }

  /** A method that returns user input as an int,
  used to select amount of random users to create*/
public int howManyRandos(){
  Scanner randos = new Scanner(System.in);
  System.out.println("\nHow Many randos?: ");
  return randos.nextInt();
  }
}
