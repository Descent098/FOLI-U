import java.util.*;

@SuppressWarnings("unchecked")    //temporary use for mac compiling
/**class that holds all the database specific methods and initialization*/
public class Database{

  public static void main(String[] args) {
  HashMap<String, User> database = new HashMap();
  int JohnDoeS = howManyRandos();
  for(int i=0; i<JohnDoeS; i++){
    JohnDoe temp = newJohnDoe();
    database.put(temp.UID, temp);
  }
  System.out.println(database);
  while (true){
  String searchedUser = searchUser();
  System.out.println("Database Returned: ");
  database.get(searchedUser).printContactInfo();
}
 }

public static String searchUser(){
  Scanner searchUID = new Scanner(System.in);
  System.out.println("Please enter the UID of the user you would like to find: ");
  return searchUID.nextLine();

}
/** Creates a new random User from class JohnDoe*/
public static JohnDoe newJohnDoe(){
  JohnDoe JoDo = new JohnDoe();
  return JoDo;
  }

  /** A method that returns user input as an int,
  used to select amount of random users to create*/
public static int howManyRandos(){
  Scanner randos = new Scanner(System.in);
  System.out.println("How Many randos?: ");
  return randos.nextInt();
}
}
