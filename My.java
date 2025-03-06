import java.util.Scanner;

public class My {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of hours you have worked: ");

        int hours = input.nextInt();
        double wage = hours * 2000;

        System.out.println("Your wage for today is: " + wage + " Rs.");
    }
} 