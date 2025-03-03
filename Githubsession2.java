import java.util.*;
public class Githubsession2{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("The amount of cents you have= ");
    double cents = sc.nextDouble();
    int totalcents = (int) cents;

    int dollars = totalcents/100;

    int remainingCents = totalcents%100;
    


    int Fiftycents = remainingCents/50;
    remainingCents%=50;

    int twentyfivecents = remainingCents/25;
    remainingCents%=25;

    int tencents = remainingCents/10;
    remainingCents%=10 ;

    int fivecents = remainingCents/5;
    remainingCents%=5 ;


    System.out.println("You have $" + dollars + ", "  + Fiftycents + " 50-Cent coins and " + twentyfivecents + " 25-Cent coins." + " 10-cent coins "+ tencents + " 5-cent coins " + fivecents +   remainingCents + " cents remaining, ");
    }
   
}