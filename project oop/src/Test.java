import java.sql.*;
public class Test {
    public static void main(String[] args) {
        try {
            // String database = "hospital_management";
            // String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + database + ";DriverID=22;READONLY=true}";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elections", "root", "");
            //here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from voters");
            while (rs.next())
                System.out.println(rs.getString(1));
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
