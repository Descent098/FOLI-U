package application;

import java.util.*;

public class Program{

    public static void main(String[] args) {
      Scanner GUIorText = new Scanner(System.in);
      System.out.println("Gui(1) or Text Version (2)");
      int choice = GUIorText.nextInt();
      String[] q = new String[1];
      switch(choice){

        case 1: while(true){
          Main.main(q);
        }

        case 2:Menu m1 = new Menu();
          while (true){
            m1.selectMenu();
            break;

    }
  }
}
}
