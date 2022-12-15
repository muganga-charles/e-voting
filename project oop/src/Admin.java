import java.util.*;
public class Admin extends App implements User {
    Scanner scanner = new Scanner(System.in);
    //add a constructor
    public Admin() {
        super();
    }
    public void displayAdminMenu(){
        System.out.println("Admin Menu");
        System.out.println("1. Add Candidate");
        System.out.println("2. Add Party");
        System.out.println("3. Add Voter");
        System.out.println("4. Add Admin");
        System.out.println("5. Add Poll Center");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
        
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
            System.out.println("-------------------------------------------");
        System.out.println("__________________Add Candidate Page____________");
        System.out.println("------------------------------------------------");
            System.out.println("Enter the name of the Candidate: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Enter the Candidate id number : ");
            String idNumber = scanner.nextLine();
            System.out.println("Enter the Party id number : ");
            int partyId = scanner.nextInt();
            System.out.println("Enter the Candidate voter choice id : ");
            int voterChoice = scanner.nextInt();
                super.addCandidate(name, idNumber,partyId,voterChoice);
                break;
             case 2:
                super.addParty();
                break;
            case 3:
                addVoter();
                break;
            case 4:
                super.addAdmin();
                System.out.println("Do you want to add another admin? (y/n)");
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = scanner1.nextLine();
                if(choice1.equals("y")){
                    super.addAdmin();
                }else{
                    displayAdminMenu();
                }
                break;
            case 5:
                addPollCenter();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
    
    public void addVoter(){
        System.out.println("-------------------------------------------");
        System.out.println("__________________Add Voter Page____________");
        System.out.println("-------------------------------------------");
        System.out.println("Enter the name of the voter: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter the voter's id number: ");
        String idNumber = scanner.nextLine();
        System.out.println("Enter the voter's Poll center Id: ");
        int address = scanner.nextInt();
        super.addVoter(name, idNumber, address);
        
        System.out.println("Do you want to add another voter? (y/n)");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if(choice.equals("y")){
            addVoter();
        }else{
            displayAdminMenu();
        }
    }
    
    public void addPollCenter(){
        System.out.println("-------------------------------------------------");
        System.out.println("__________________Add Poll Center Page____________");
        System.out.println("--------------------------------------------------");
        System.out.println("Enter the Id of the new Poll Center: ");
        int Id = scanner.nextInt();

        System.out.println("Enter the location of the new Poll Center: ");
        String Location = scanner.next();
        Location.isBlank();
        System.out.println("Enter the AdminId of the new Poll Center: ");
        String AdminId = scanner.next();

        super.addPollCenter(Location, Id, AdminId);
    }
    

    public void adminLogIn(){
        //allow admin to log in again if they enter the wrong password
        System.out.println("-------------------------------------------");
        System.out.println("__________________Admin LogIn Page____________");
        System.out.println("-------------------------------------------");
        boolean adminLogIn = false;
            while(!adminLogIn){
            System.out.println("Enter your name");
            //Scanner scanner = new Scanner(System.in);   
            String name = scanner.nextLine();
            String password = HidePassword.getPassword();
            String result = super.AdminVerification(name, password);
            System.out.println(result);
            if (result.equals("Login successful")){
                adminLogIn = true;
                displayAdminMenu();
            }
            else{
                System.out.println("Invalid name or password");
            }
        }

    }
    @Override
    public void vote() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void viewVoteCount() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Boolean viewVoteStatus() {
        // TODO Auto-generated method stub
        return null;
        
    }

}
