import java.sql.*;
import java.util.Scanner;
public class App{
    public static void main(String[] args) {
       
    }
    //constructor
    public App() {
      
    }
    public void displayCandidates(){
        System.out.println("No. Candidates              Party Name");
        System.out.println("1.  Kalisa Henry         Republican Party");
        System.out.println("2.  Katumba Wamala       Constitutional Party");
        System.out.println("3.  Muwanguzi Soul       National Party");
        System.out.println("4.  Atwinne Melveen      Libertarian Party");
        System.out.println("5.  Madina Kylian        Republican Party");
    }
   
    public static void addVoter(String Name, String ID,int pollCenterId){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "INSERT INTO voters (name, id, PollCentreId) VALUES (?, ?, ?)";
        String sql2 = "UPDATE voters SET vote_status = 'False' WHERE id = ?";
        String sql3 = "UPDATE voters SET choice = 0 WHERE id = ?";
        
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, Name);
        statement.setString(2, ID);
        statement.setInt(3, pollCenterId);
        statement.execute();
        PreparedStatement statement2 = con.prepareStatement(sql2);
        statement2.setString(1, ID);
        statement2.execute();
        PreparedStatement statement3 = con.prepareStatement(sql3);
        statement3.setString(1, ID);
        statement3.execute();

        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String VoterVerification(String name, String Id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
            String sql = "SELECT * FROM voters WHERE name = ? AND id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, Id);
            ResultSet result = statement.executeQuery();
            int count = 0;
            while (result.next()){
                count = count + 1;
            }
            if (count == 1){
                return ("Login successful");
            }
            else if (count > 1){
                return "Duplicate user";
            }
            else{
                return "Login failed!! You need to be registered by the administer before you can vote";
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return Id;
        
    }
    public static String AdminVerification(String AdminName, String AdminId){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
            String sql = "SELECT * FROM Administrator WHERE AdminId = ? AND Name = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,AdminId);
            statement.setString(2, AdminName);
            ResultSet result = statement.executeQuery();
            int count = 0;
            while (result.next()){
                count = count + 1;
            }
            if (count == 1){
                return ("Login successful");
            }
            else if (count > 1){
                return "Duplicate admin";
            }
            else{
                return "Login failed";
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return AdminId;
        
    }
    public static void addCandidate(String Name, String ID,int partyId,int voterChoice){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "INSERT INTO Candidates (id,name,partyId,numberOfVotes,voterChoice) VALUES (?, ?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, ID);
        statement.setString(2, Name);
        statement.setInt(3,partyId);
        statement.setInt(4,0);
        statement.setInt(5, voterChoice);
        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void addAdmin(){
        System.out.println("-------------------------------------------");
        System.out.println("__________________Add Admin Page____________");
        System.out.println("-------------------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Admin name");
        String Name = input.nextLine();
        System.out.println("Enter new Admin ID");
        String ID = input.nextLine();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "INSERT INTO administrator (AdminId,Name) VALUES (?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, ID);
        statement.setString(2, Name);
        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void addParty(){
        System.out.println("-------------------------------------------");
        System.out.println("__________________Add Party Page____________");
        System.out.println("-------------------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Party ID");
        String ID = input.nextLine();
        System.out.println("Enter new Party name ");
        String Name = input.nextLine();
        System.out.println("Enter new Party Abbreviation");
        String Abb = input.nextLine();
        System.out.println("Enter new Party color");
        String color = input.nextLine();
        System.out.println("Enter new Party logo");
        String logo = input.nextLine();
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "INSERT INTO PoliticalParty (id,name,abbreviation,color,logo) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, ID);
        statement.setString(2, Name);
        statement.setString(3, Abb);
        statement.setString(4, color);
        statement.setString(5, logo);

        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addPollCenter(String Location, int Id, String AdminId){
    
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "INSERT INTO poll_centre (id,Location,AdminId) VALUES (?, ?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, Id);
        statement.setString(2, Location);
        statement.setString(3, AdminId);
        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void displayCandidate(int id ){
        
       try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "SELECT * FROM Candidates WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.println(result.getString("Name"));
        }
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
       }
    public void displayParty(int id ){
        
       try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "SELECT * FROM PoliticalParty WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.println(result.getString("name"));
        }
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    //get number of votes for a candidate
    public void getVotes(int id){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "SELECT * FROM candidates WHERE id = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.println(result.getInt("numberOfVotes"));

        }
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        }
    // adding votes to the candidate table by increamenting the votes by 1

    public void addVote(int id){
        //increment the number of votes by 1
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "UPDATE candidates set numberOfVotes = numberOfVotes + 1 WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);
        //statement.setInt(2, id);
        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    // returns the vote stauses of a voter
    public String voteStatus(String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
            String sql = "SELECT * FROM voters WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                return result.getString("vote_status");
            }
            con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        return "error";
    }

    public void updateVoterStatus(String id){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        //update the vote status of the voter to true
        String sql = "UPDATE voters SET vote_status = ? WHERE Id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "True");
        statement.setString(2, id);
        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
       }
    public  void setVoterChoice (int choice,String Id){
        //insert the choice of the voter into the database
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "UPDATE voters  SET choice = ? WHERE Id = ?";
        //UPDATE voters SET choice = 1 WHERE Id = "001";
        PreparedStatement statement = con.prepareStatement(sql);
        
        statement.setInt(1, choice);
        statement.setString(2, Id);
        statement.execute();
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }


       }
       //get the choice of the voter from the database
    public int getVoterChoice(String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
            String sql = "SELECT * FROM voters WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                return result.getInt("choice");
            }
            con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        return 0;
        }

    //create a method to get the number of votes, parties and candidates from the database with the order of number of votes from the greatest
    protected void getVotingDetailsOrdered(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "SELECT * FROM candidates ORDER BY numberOfVotes DESC";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.println(result.getString("Name") + " " + result.getInt("numberOfVotes"));
        }
        con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        }
         //get the candidate with the highest number of votes
        public static void getHighestVotedCandidate(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
        String sql = "SELECT * FROM candidates ORDER BY numberOfVotes DESC LIMIT 1";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()){
                System.out.println(result.getString("Name") + " " + result.getInt("numberOfVotes"));
        }
        con.close();
        }
        catch (Exception e) {
                System.out.println(e);
        }
            }
            // a class to sellect every candidate from the database
            public static void getAllCandidates(){
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
                String sql = "SELECT * FROM candidates";
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet result = statement.executeQuery();
                while (result.next()){
                    System.out.println(result.getString("Name") + " " + result.getInt("numberOfVotes"));
                }
                con.close();
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                }
                // a class to sellect every candidate from the database
                public static void getAllVoters(){
                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
                    String sql = "SELECT * FROM voters";
                    PreparedStatement statement = con.prepareStatement(sql);
                    ResultSet result = statement.executeQuery();
                    while (result.next()){
                        System.out.println(result.getString("Name") + " " + result.getString("Id") + " " + result.getString("vote_status"));
                    }
                    con.close();
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    }
                    // a class to sellect every candidate from the database
                    public static void getAllParties(){
                        try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
                        String sql = "SELECT * FROM parties";
                        PreparedStatement statement = con.prepareStatement(sql);
                        ResultSet result = statement.executeQuery();
                        while (result.next()){
                            System.out.println(result.getString("Name") + " " + result.getInt("numberOfVotes"));
                        }
                        con.close();
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                        }
                        // a class to sellect every candidate from the database
                        public static void getAllVotes(){
                            try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
                            String sql = "SELECT * FROM votes";
                            PreparedStatement statement = con.prepareStatement(sql);
                            ResultSet result = statement.executeQuery();
                            while (result.next()){
                                System.out.println(result.getString("Id") + " " + result.getInt("choice"));
                            }
                            con.close();
                            }
                            catch (Exception e) {
}
                        }
                    }
