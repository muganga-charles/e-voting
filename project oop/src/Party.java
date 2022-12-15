public class Party {
    //declare variables
    private String partyName;
    private String partyPassword;
    private String idNumber;
    private String partyVoteCount;
    
    //constructor
    public Party(String Name, String Id){
        this.partyName = Name;
        this.idNumber = Id;
    }
    //getters
    public String getName(){
        return partyName;
    }
    public String getPassword(){
        return partyPassword;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public String getVoteCount(){
        return partyVoteCount;
    }
    //setters
    public void setName(String name){
        this.partyName = name;
    }
    public void setid(String id){
        this.idNumber = id;
    }
    public void setVoteCount(String voteCount){
        this.partyVoteCount = voteCount;
    }
    

}
