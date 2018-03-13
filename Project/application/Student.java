package application;

import java.util.Scanner;

public class Student extends User{


  private int programYear;
  private String UID; //university ID number
  private String university; //Create a dropdown list of options
  private String degree;
  private double GPA;
  private String studentType;


  public void set_User_Attributes(){
    setContactInfo();
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    /** A method to set a users attributes based on user input*/


    System.out.println("\nWhat year of your degree are you in?:  ");
    programYear = input.nextInt();

    System.out.println("\nWhat university are you at?: ");
    university = input2.nextLine();

    System.out.println("\nPlease put in your 8 digit UID: ");
    UID = input3.nextLine();

    System.out.println("\nWhat degree are you in?: ");
    degree = input4.nextLine();

    System.out.println("\nWould You like to input or calculate your GPA? (1 for input 2 for calcuate): ");
    GPA = input2.nextInt();
    if (GPA == 1){
      System.out.println("\nPlease Enter your GPA: ");
      GPA = input4.nextDouble();
    }
    if (GPA == 2){
      calc_GPA();
    }

    System.out.println("\nAre you an (1)undergraduate student, (2)masters student, or (3)doctoral candidate?: ");
    int choice = input3.nextInt();

    switch(choice){
      case 1: studentType = "Undergraduate Student";
        break;
      case 2: studentType = "Masters Student";
        break;
      case 3: studentType = "Doctoral Candidate";
      break;

    }
  }

  public void calc_GPA(){
    /** A method to calculate a users GPA based on input */
    GPA = 0;
    Scanner input1 = new Scanner(System.in); //GPA Calculation
		System.out.println("Enter number of courses: ");
		int courseAmount = input1.nextInt();
		double weightTotal = 0;
		for (int i = 0; i < courseAmount; i++) {
		 System.out.println("Enter grade for course " + (i+1) + ": ");
		 double grade = 0;
		 grade = input1.nextDouble();
		 System.out.println("Enter weight for course " + (i+1) + ": ");
		 double weight = 0;
		 weight = input1.nextDouble();
		 GPA += (grade*weight);
		 weightTotal += weight;
		}
		GPA /= weightTotal;
		System.out.println("Your GPA is: " + GPA);
  }


  public void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: " + getFullName());

    printContactInfo();
    System.out.println("Users UID is: "+ getUID());
    System.out.println("Users University is: "+ getUniversity());
    System.out.println("User is a : "+ getStudentType());
    System.out.println("Users Program Year is: "+ getProgramYear());
    System.out.println("Users Degree is: "+ getDegree());
    System.out.println("Users GPA is: "+ getGPA());

  }

  /** Setter for UID*/
  public void setUID(String newUID){
    UID = newUID;
  }

  /** Getter for UID*/
  public String getUID(){
    String printedUID = new String(UID);
    return printedUID;
  }

  /** Setter for University*/
  public void setUniversity(String newUniversity){
    university = newUniversity;
  }

  /** Getter for University*/
  public String getUniversity(){
    String printedUniversity = new String(university);
    return printedUniversity;
  }

  /** Setter for StudentType*/
  public void setStudentType(String newStudentType){
    studentType = newStudentType;
  }

  /** Getter for University*/
  public String getStudentType(){
    String printedStudentType = new String(studentType);
    return printedStudentType;
  }

  /** Setter for ProgramYear*/
  public void setProgramYear(int newProgramYear){
    programYear = newProgramYear;
  }

  /** Getter for ProgramYear*/
  public int getProgramYear(){
    int printedProgramYear = new Integer(programYear);
    return printedProgramYear;
  }

  /** Setter for Degree*/
  public void setDegree(String newDegree){
    degree = newDegree;
  }

  /** Getter for Degree*/
  public String getDegree(){
    String printedDegree = new String(degree);
    return printedDegree;
  }

  /** Setter for GPA*/
  public void setGPA(Double newGPA){
    GPA = newGPA;
  }

  /** Getter for GPA*/
  public Double getGPA(){
    Double printedGPA = new Double(GPA);
    return printedGPA;
  }


}
