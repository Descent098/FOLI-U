import java.io.*;
import java.util.Scanner;

public class FileIO {

  public Database d;

  public void fileCreateOrLoad() {
      Scanner input = new Scanner(System.in);
      File data;
      boolean createOrLoadFile = false;
      System.out.println("\nEnter 1 to create a file, and 2 to load a file.");
      int choice = input.nextInt();


      /*
      START OF FILE CREATION/LOAD FILE
      */
      String fileName = "dataFile";
      do{
        System.out.println("Enter name of the file: ");
        input = new Scanner(System.in);
        fileName = input.nextLine();
        data = new File(fileName + ".dat");

        if (choice == 1) {
          if (data.exists()) {
            System.out.println("Error, file name already exists. ");
          } else if (!data.exists()) {
            try {
              data.createNewFile();
              createOrLoadFile = true;
              System.out.println("File created. ");
            } catch (IOException e) {
              createOrLoadFile = false;
              System.out.println("File could not be created.");
              System.err.println("IOException:	" + e.getMessage());
            }
          }
        } else if (choice == 2) {
          if (!data.exists()) {
              System.out.println("Error, file does not exist.");
              createOrLoadFile = false;
          } else if (data.exists()) {
            try {
              FileInputStream in = new FileInputStream(data);
              ObjectInputStream readDatabase = new ObjectInputStream(in);

              d = (Database) readDatabase.readObject();
              readDatabase.close();
            } catch (FileNotFoundException e) {
              createOrLoadFile = false;
              System.out.println("Problem with input/output.");
              System.err.println("FileNotFoundException: " + e.getMessage());
            } catch (IOException e) {
              createOrLoadFile = false;
              System.out.println("File could not be found.");
              System.err.println("IOException: " + e.getMessage());
            } catch (ClassNotFoundException e) {
              createOrLoadFile = false;
              System.out.println("Class could not be used to cast object.");
              System.err.println("ClassNotFoundException: " + e.getMessage());
            }
          }

        }
      } while (createOrLoadFile != true);

      /*
      SAVING TO FILE SECTION
      */

      System.out.println("Enter S to save: ");
      input = new Scanner(System.in);
      String sChoice = input.nextLine();
      sChoice = sChoice.toUpperCase();
      if (sChoice.equals("S")) {
        try {
          FileOutputStream outClear = new FileOutputStream(data);
          outClear.write(("").getBytes());
          outClear.close();

          FileOutputStream out = new FileOutputStream(data);
          ObjectOutputStream writer = new ObjectOutputStream(out);

          writer.writeObject(d);

          writer.close();

        } catch (FileNotFoundException e) {
          System.out.println("File could not be found.");
          System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
          System.out.println("Problem with input/output.");
          System.err.println("IOException: " + e.getMessage());
        }
      }

  }

}
