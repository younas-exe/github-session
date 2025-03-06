import java.util.Scanner;

public class MonthlyPay{
    public static void main (String[] args){
	Scanner input = new Scanner(System.in);
	
	int basePay;
	int totalSales;
	int commissionRate;
	int daysAbsent;
	double commissionComp;
	int totalFine;
	double totalPay;
	
	System.out.println("What is the base pay of the employee? ");
	basePay = input.nextInt();

	
	System.out.println("How much rupees worth of sales did he do? ");
	totalSales = input.nextInt();

	
	System.out.println("What is his commission percentage? ");
	commissionRate = input.nextInt();

	
	System.out.println("How many days was he absent? ");
	daysAbsent = input.nextInt();

	
	commissionComp = (commissionRate / 100.0) * totalSales;

	
	totalFine = daysAbsent * 300;



	
	totalPay = basePay + commissionComp - totalFine;
	System.out.println("The total pay of the employee is " + totalPay);

	
	
        
    }
}