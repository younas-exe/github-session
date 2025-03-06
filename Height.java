import java.util.Scanner;

public class Height{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Num 1 : ");
        int Num1 = sc.nextInt();

        System.out.println("Enter Num 2 : ");
        int Num2 = sc.nextInt();

        System.out.println("Enter num 3 : ");
        int Num3 = sc.nextInt();

        int Average = (Num1 + Num2 + Num3)/3;

        System.out.println("Num 1 " + Num1 + "Num 2 " + Num2 + "Num 3 " + Num3 + "Average " + Average);
        
    }
}