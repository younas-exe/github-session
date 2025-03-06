import java.util.Scanner;
public class Activity2{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String Name =sc.nextLine();
        System.out.println("Enter your age : ");
        double age = sc.nextDouble();
        System.out.println("Enter your weight : ");
        double weight = sc.nextDouble();  
        System.out.println("Name:" + Name + " Age:" + age + " Weight:" + weight);

    }
}