import java.util.Scanner;
import java.util.Random;
public class GuessNumber {
public static void main(String args[]) {
Random r= new Random();
int target = r.nextInt(100) + 1;
Scanner sc=new Scanner(System.in);
int guess;
System.out.println("Guess a number between 1 and 100:");
do {
guess = sc.nextInt();
if (guess < target) {
System.out.println("Too low Try again:");
} else if (guess > target) {
System.out.println("Too high Try again:");
}
} while (guess != target);
System.out.println("Correct! The number was " + target);
}
}