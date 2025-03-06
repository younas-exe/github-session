import java.util.Scanner;

public class NewFile{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a five-digit number: ");
        int number = scanner.nextInt();
        
        if (number < 10000 || number > 99999) {
            System.out.println("Error: Please enter a valid five-digit number.");
        } else {
            int digit1 = number % 10;
            int digit2 = (number / 10) % 10;
            int digit3 = (number / 100) % 10;
            int digit4 = (number / 1000) % 10;
            int digit5 = (number / 10000) % 10;
            
            int reversedNumber = digit1 * 10000 + digit2 * 1000 + digit3 * 100 + digit4 * 10 + digit5;
            
            System.out.println("Reversed number: " + reversedNumber);
        }
        
    }
}
