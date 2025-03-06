import java.util.Scanner;
public class Pounds{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Pounds : ");

        double Pounds = sc.nextDouble();
        double kg =( 0.454* Pounds );
        
        System.out.println(kg);



    }
}

