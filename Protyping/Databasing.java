import java.util.*;


public class Databasing{

  public static void main(String[] args) {
  HashMap<String, User> database = new HashMap();

  for(int i=1; i<11; i++){
    JohnDoe temp = newJohnDoe();
    database.put(temp.UID, temp);
  }
  System.out.println(database);
 }

public static JohnDoe newJohnDoe(){
  JohnDoe jd = new JohnDoe();
  return jd;
}
}
