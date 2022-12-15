/**
 * Mains
 */
import java.util.*;
public class Mains {
    //Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //welcome the user to the e voting platform and ask them tospecify if they are a voter or an admin
        System.out.println("Welcome to the e-voting platform\n\n");
        System.out.println("Are you a voter or an admin? \n1. Voter \n2. Admin \n3. Exit\n\nPlease enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1){
            Voter voter = new Voter("","");
            voter.voterLogIn();
        }
        else if (choice == 2){
            Admin admin = new Admin();
            admin.adminLogIn();
            main(args);
        }
        else if (choice == 3){
            System.out.println("Thank you for using the e-voting platform");
            System.exit(0);
            main(null);
        }
        else{
            System.out.println("Invalid choice");
        }
    }
   
}