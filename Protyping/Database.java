import java.util.*;

@SuppressWarnings("unchecked")    //temporary use for mac compiling
/**class that holds all the database specific methods and initialization*/
public class Database{

  public HashMap<String, User> database = new HashMap();

/** A method to create users, and add them to the database*/
  public void createandSearchDatabase() {
  Scanner continuetoSearch = new Scanner(System.in); /*scaner that takes input as to whether
  or not you want to continue searching */

  int JohnDoeS = howManyRandos();
  for(int i=0; i<JohnDoeS; i++){
    JohnDoe temp = newJohnDoe();
    database.put(temp.UID, temp);
  }
  System.out.println(database);
  while (true){
    searchUser();
    if (continuetoSearch.nextInt() == 1){
      break;
    }
}
 }
/** A method that takes user input and returns a string to be used to search
the database for the corresponding user */
public void searchUser(){
  Scanner searchUID = new Scanner(System.in);

  System.out.println("\nPlease enter the UID of the user you would like to find: ");
  String searchedUser = searchUID.nextLine();
  System.out.println("\nDatabase Returned: ");
  database.get(searchedUser).printContactInfo();
  System.out.println("\nWould you like to search again? (1 for no, 2 for yes): ");
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
