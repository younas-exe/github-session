import java.util.*;
public class PassFailCal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks:");
        int marks = sc.nextInt();
        if(marks>50){
            System.out.println("Pass");
        } else if(marks==50) {
            System.out.println("passed but on marginn ");
            } 
        else{
            System.out.println("Fail");
            }
    }
}
