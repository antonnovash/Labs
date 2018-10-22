package Lab_6;

import java.io.File;
import java.util.*;

public class Magazine {
    public static void main(String args[]) {
        try {
           System.out.println("RECORD CAR");
           WorkWithFile workWithFile = new WorkWithFile("Magazine.dat");
           workWithFile.appendToFileFromTxtFile("D:\\3_semester\\Lab_6\\src\\Lab_6\\Input.txt");

            System.out.println("What do you want to do?");
            System.out.println("1. Append record to file.");
            System.out.println("2. Print file.");
            System.out.println("3. Delete file.");
            System.out.println("***************************");
            System.out.print("Your choice: ");

            Scanner input = new Scanner(System.in);
            int userChoice = input.nextInt();
            System.out.println();

            switch (userChoice) {
                case 1:
                    System.out.println("Enter Record: ");
                    Scanner in=new Scanner(System.in);
                    String string = in.nextLine();
                    workWithFile.appendToFile(new Record(string));

                    System.out.println("After appending, .dat file: ");
                    workWithFile.printFile();
                    break;
                case 2:
                    workWithFile.printFile();
                    workWithFile.deleteFile();
                    break;
                case 3:
                    workWithFile.deleteFile();
                    System.out.println("File was deleted.");
                    break;
                default:
                    System.out.println("Incorrect input.");
                    break;
            }
        }
        catch ( Exception e ) {
            System.err.println( "Run/time error: " + e );
            System.exit(1);
        }
        System.out.println( "Magazine finished..." );
        System.exit(0);
    }
}
