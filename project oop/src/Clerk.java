import java.util.Scanner;
public class Clerk extends App{

    private Boolean release = false;
    public Clerk() {
        super();
    }
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        //clerk.displayClerkMenu();
        clerk.viewStands();
    }
    public void displayClerkMenu(){
        System.out.println("Clerk Menu");
        System.out.println("1. View Stands");
        System.out.println("2. Release Results");
        System.out.println("3. Logout");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                viewStands();
                break;
            case 2:
                System.out.println("Are you sure you want to release the results? (y/n)");
                String choices = scanner.nextLine();
                if(choices.equals("y")){
                    release = true;
                    System.out.println("Results released");
                }
                else{
                    System.out.println("Results not released");
                }
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    protected void viewStands(){
        super.getVotingDetailsOrdered();
    }
    
    public static void releaseResults(Boolean release){
        if (release == true){

            System.out.println("The winner is: "); getHighestVotedCandidate();
        }
        else{
            System.out.println("Results are not yet released");
        }
        
    }
    
}
