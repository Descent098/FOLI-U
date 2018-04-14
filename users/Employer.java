package users;
import java.util.Scanner;
import java.io.*;

/**
  * Employer is the child of User, and containts unique methods and attributes for a company. Represents
  * all employers in the database.
  */
public class Employer extends User implements Serializable {

private String companyName = "Google";
private String offeringJobs = "Yes";

/** Blank constructor */
public Employer() {

}

/** Sets up a new employers attributes in the text UI */
public void setEmployerAttributes() {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        setContactInfo(); //calls the super class's method to set common traits of a user
        System.out.println("\nWhat is your company name: ");
        companyName = input2.nextLine();

        System.out.println("Is your company currently looking to hire?: ('Yes' or 'No')");
        offeringJobs = input1.nextLine();

}

/** Prints employers set_User_Attributes */
@Override
public void printContactInfo(){
        super.printContactInfo();
        System.out.println("User Company: "+ getCompanyName());
        System.out.println("Offering Jobs: "+ getOfferingJobs());
}

/** getter for offeringJobs*/
public String getOfferingJobs(){
        String printedOfferingJobs = new String(offeringJobs);
        return printedOfferingJobs;
}

/** getter for CompanyName*/
public String getCompanyName(){
        String printedCompanyName = new String(companyName);
        return printedCompanyName;
}

/** setter for OfferingJobs */
public void setOfferingJobs(String newOfferingJobs){
        offeringJobs = newOfferingJobs;

}

/** setter for CompanyName*/
public void setCompanyName(String newCompanyName){
        companyName = newCompanyName;
}

} //end of class
