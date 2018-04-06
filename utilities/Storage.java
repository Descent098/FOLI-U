package utilities;

/**
  * Storage acts as a utility class for the GUI. It allows us to save variable names to then use later
  * when the GUI's controller classes are reloaded. Through this we are able to retrieve a current student
  * or employer that was being worked on in a previous page or to know who to display in the profile page.
  */
public class Storage {

public static String UID;             //acts a a global variable for the GUI to manage which student to work with. This is
                                      //needed because the controller classes in the GUI are reloaded each time you open a
                                      //new page.
public static String employerName;    //acts as a global variable for the GUI to
                                      //manage which employer it is working with

} //end of class
