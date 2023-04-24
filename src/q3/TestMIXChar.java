package q3;

import java.util.Scanner;

/**
 * The drives class of MIXChar and Message.
 * @author echo
 * @version 1.0
 */
public class TestMIXChar {
    
  
    /**
     * This is the main method (entry point) that gets called by the JVM.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        for (int i = 1; i > 0; i++) {
            System.out.println("Please enter a message in MIXChar: ");
            String input = scan.nextLine();
            try { 
                Message msg = new Message(input);
                System.out.println("The resulting long[] of the message: " 
                    + msg.toLongs());
                System.out.println("The java string corresponding "
                        + "to the message : " + msg);
                break;
            } catch (NullPointerException e) {
                System.out.println("Try again!");
            }
        }
        scan.close();

    }
}
