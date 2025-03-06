import java.util.Scanner;

public class Weight{

    private static int Weight;

    public static void main(String[] args) {
         
    Scanner sc = new Scanner(System.in);

    System.out.println(" Enter your Weight in pounds : ");

    double Weight = sc.nextDouble();

    System.out.println("Enter your height in inches : ");
     
     double Height = sc.nextDouble();

     Weight  = (Weight * 0.45359237) ;
        
        Height =  (Height * 0.0254);

        double BMI = Weight/ (Height*Height);

     System.out.println(" Your BMI is : " + BMI );

     


    
    
    }

}
