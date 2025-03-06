import java.util.Scanner;
public class Assignment1{ 
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   
    int basepay;
    int totalsales;
    int commissionrate;
    int monthlybonus = 2000 ;
    int daysabsent;
    int loan;

    System.out.println(" Enter your base pay : ");
    basepay = sc.nextInt();
    System.out.println(" Enter total sales per month : ");
    totalsales = sc.nextInt();
    System.out.println(" Enter commissionrate : ");
    commissionrate = sc.nextInt();
    System.out.println(" Enter total days absent : ");
    daysabsent = sc.nextInt();
    System.out.println(" Enter the loan you took from the company : ");
    loan = sc.nextInt();
    int totalcomission = (totalsales * commissionrate );
    int absenteefine = daysabsent * 300 ;
    int totalpay = basepay + totalcomission + monthlybonus - absenteefine - loan ;

    System.out.println(" Deductions : " + (absenteefine + loan ));
    System.out.println(" Benefits : " + monthlybonus );


    System.out.println("Your totalpay is : " + totalpay);





}

}