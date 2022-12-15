import java.util.*;
public class Voter extends App implements User {
    Scanner scanner = new Scanner(System.in);
    //declare variables
    private String voterName;
    private String voterPassword;
    private String idNumber;
    private String address;
    private int age;
    private String vote;
    private String voteStatus;
    private int voteCount;
    private int Mycandidate;
    //constructor
    public Voter(String Name, String Id){
        super();
        this.voterName = Name;
        this.idNumber = Id;
    }
   
    //getters
    public String getName(){
        return voterPassword;
    }
    public int getMyCandidate(){
        return Mycandidate;
    }
    public String getPassword(){
        return voterPassword;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public String getAddress(){
        return address;
    }
    public int getAge(){
        return age;
    }
    public String getVote(){
        return vote;
    }
    public String getVoteStatus(){
        return voteStatus;
    }
    public int getVoteCount(){
        return voteCount;
    }
    //setters
    public void setName(String name){
        this.voterName = name;
    }
    public void setid(String id){
        this.idNumber = id;
    }
    public void setMyCandidate(int myCandidateChoice){
        this.Mycandidate = myCandidateChoice;
    }

    public void setPassword(String password){
        this.voterPassword = password;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setVote(String vote){
        this.vote = vote;
    }
    public void setVoteStatus(String status){
        status = super.voteStatus(getPassword());
        this.voteStatus = status;
    }
    public void setVoteCount(int CandidateId){
        this.voteCount = CandidateId;
    }
    
    
    //methods
    public void voterLogIn(){
        System.out.println("\n----------------------------------------------");
        System.out.println("Log in");
        System.out.print("Enter your name : ");   
        String name = scanner.nextLine();
        while(name.isBlank()){
            System.out.println("Enter your name");
            name = scanner.nextLine();
        }
        setName(name);
        String password = HidePassword.getPassword();
        setPassword(password);
        String result = super.VoterVerification(name, password);
        System.out.println(result);
        if (result == "Login successful"){
            displayVoterMenu();
        }
        else{
            voterLogIn();
        }
        
    }
    public void displayVoterMenu(){
        System.out.println("-------------------------------------------");
        System.out.println("Welcome back, " + voterName);
        System.out.println("-------------------------------------------");
        System.out.println("___Menu___");
        System.out.println("1. Vote \n2. View vote status \n3. View vote count \n4. Results \n5. Log out \n\n\nEnter your choice : ");
        //Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1){
            if (viewVoteStatus() == true){
                System.out.println("You have already voted");
                displayVoterMenu();
            }
            else{
                super.displayCandidates();
                vote();
            }
        }
        else if (choice == 2){
            displayStatus();
            displayVoterMenu();
        }
        else if (choice == 3){
            viewVoteCount();
            displayVoterMenu();
        }
        else if (choice == 4){
            Clerk.releaseResults(false);
            displayVoterMenu();
        }
        else if (choice == 5){
            //exit
            System.out.println("Thank you for using our system");
            logOut();
            
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    public void vote(){
        //Display candidates and their parties.
        //System.out.println(viewVoteStatus());

        if ( getVoteStatus() == "True"){
            System.out.println("You have already voted");
            displayVoterMenu();
        }
        else{
            
    
        String id = getPassword();
        System.out.println("\n\nEnter your vote here:");
        int vote = scanner.nextInt();
        setVoteCount(vote);
        
        if (vote == 1){
            super.updateVoterStatus(getPassword());
            super.setVoterChoice(1,getPassword());
            super.addVote(200);
            System.out.print("You voted for "); super.displayCandidate(200);
        }
        else if (vote == 2){
            super.updateVoterStatus(getPassword());
            super.setVoterChoice(2,getPassword());
            super.addVote(201);
            System.out.print("You voted for "); super.displayCandidate(201);
            
        }
        else if (vote == 3){
            super.setVoterChoice(3,getPassword());
            super.updateVoterStatus(getPassword());
            super.addVote(202);
            System.out.print("You voted for "); super.displayCandidate(202);
            
        }
        else if (vote == 4){
            super.setVoterChoice(4,getIdNumber());
            super.updateVoterStatus(getPassword());
            //setV
            super.addVote(203);
            System.out.print("You voted for "); super.displayCandidate(203);
            
        }
        else if (vote ==5){
            super.updateVoterStatus(getPassword());
            super.setVoterChoice(5,getPassword());
            super.addVote(204);
            System.out.print("You voted for "); super.displayCandidate(204);
        }
        else{
            super.updateVoterStatus(id);
        }
        setVoteStatus("True");
        System.out.println("\nThank you for voting");

        displayVoterMenu();
    }
    }
    public Boolean viewVoteStatus(){
        voteStatus = super.voteStatus(getPassword());
        Boolean status = voteStatus.equals("True");
        return status;
    }
    public void displayStatus(){
        if (viewVoteStatus() == true){
            System.out.println("You have voted");
        }
        else{
            System.out.println("You have not voted");
        }
    }

    public void viewVoteCount(){
        
        int candidateId = super.getVoterChoice(getPassword());
        
        if (candidateId == 1){
            
            System.out.print("Candidate has total of :"); super.getVotes(200); 
        
        }
        else if (candidateId == 2){
            System.out.print("Candidate has total of :"); super.getVotes(201);
        }
        else if (candidateId == 3){
            System.out.print("Candidate has total of :"); super.getVotes(202);
        }
        else if (candidateId == 4){
            System.out.print("Candidate has total of :"); super.getVotes(203);
        }
        else if (candidateId == 5){
            System.out.print("Candidate has total of :"); super.getVotes(204);
        }

        else{
            System.out.println("You have not voted");
        }
        System.out.println("--------------------------------------------\n");
        displayVoterMenu();
    }
    public void logOut(){
        System.exit(0);
    }

}
