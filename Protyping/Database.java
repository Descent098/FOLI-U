import java.util.*;

@SuppressWarnings("unchecked")    //temporary use for mac compiling
/**class that holds all the database specific methods and initialization*/
public class Database{

  public void createandSearchDatabase() {
  Scanner continuetoSearch = new Scanner(System.in);
  HashMap<String, User> database = new HashMap();
  int JohnDoeS = howManyRandos();
  for(int i=0; i<JohnDoeS; i++){
    JohnDoe temp = newJohnDoe();
    database.put(temp.UID, temp);
  }
  System.out.println(database);
  while (true){
  String searchedUser = searchUser();
  System.out.println("\nDatabase Returned: ");
  database.get(searchedUser).printContactInfo();
  System.out.println("\nWould you like to search again? (1 for no, 2 for yes): ");
  if (continuetoSearch.nextInt() == 1){
    break;
  }

}
 }

public String searchUser(){
  Scanner searchUID = new Scanner(System.in);
  System.out.println("\nPlease enter the UID of the user you would like to find: ");
  return searchUID.nextLine();

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
