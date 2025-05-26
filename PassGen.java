import java.util.*;
public class PassGen {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random r = new Random();        
        System.out.print("Length: ");
        int len = sc.nextInt();        
        System.out.print("Types (1-lower, 2-upper, 3-nums, 4-spec): ");
        String types = sc.next();        
        String chars = "";
        if(types.contains("1")) chars += "abcdefghijklmnopqrstuvwxyz";
        if(types.contains("2")) chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(types.contains("3")) chars += "0123456789";
        if(types.contains("4")) chars += "!@#$%^&*";
        
        String pass = "";
        for(int i=0; i<len; i++) {
            pass += chars.charAt(r.nextInt(chars.length()));
        }
        
        System.out.println("Password: " + pass);
    }
}