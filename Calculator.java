import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter First number:");
        double n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();

        System.out.print("Enter Your Choice:");
        System.out.println("Enter 1 For Addition (+) ");
        System.out.println("Enter 2 For Subtraction(-)");
        System.out.println("Enter 3 For Multiplication (*)");
        System.out.println("Enter 4 For Division(/)");
        System.out.println("Your Choice"); 
        int choice = sc.nextInt();
        double result;
        
        switch (choice) {
            case 1:
                result = n1 + n2;
                break;
            case 2:
                result = n1 - n2;
                break;
            case 3:
                result = n1 * n2;
                break;
            case 4:
                result = n1 / n2;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }
        
        System.out.println("Result: " + result);
    }
}