public class PollCenter {
    //declare variables
    private String pollCenterName;
    private String pollCenterLocation;
    private String pollCenterPassword;
    private String pollCenterId;
    private String pollCenterStatus;
    private String pollCenterVoteCount;
    private String pollCenterVoteStatus;
    //constructor
    public PollCenter(String Name, String Id){
        //super(Name, Id);
        this.pollCenterName = Name;
        this.pollCenterId = Id;
    }   
    //methods
    public void viewVoteCount(){
        System.out.println("The vote count is: " + pollCenterVoteCount);
    }
   
}
