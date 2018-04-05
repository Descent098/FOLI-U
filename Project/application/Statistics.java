package application;
import java.util.*;
import java.io.*;

public class Statistics{

  private HashMap <String,User> database;

public Statistics(HashMap<String,User> d){
  database = d;

}

public int countStudents(){
  int count = 0;
  for (String key : database.keySet()) {
    User tempUser = database.get(key); //just a temporary user to do checks with
      try{
      if (tempUser.getGPA() >= 0) { //if the user has a gpa
        count +=1;
      }
    }catch(Exception e){ //if not a student do nothing

    }
  }
  return count;
}
}
