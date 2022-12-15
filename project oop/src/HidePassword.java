import java.io.Console;
public class HidePassword {
    public static String getPassword(){
        char [] password;
        Console console;
        if((console = System.console())!= null){
            password = console.readPassword("Enter Your Password");
            System.out.println("Password entered");
            return new String (password);
        }else
        {
            System.out.println("Wrong Password");
        }
        return " ";
    }
}
