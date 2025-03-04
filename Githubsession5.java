import java.util.*;
public class NewFile{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = sc.nextInt();
        System.out.print("Enter power: ");
        int y = sc.nextInt();
        int b = (int)Math.pow(x,y); //WHY WE ARE TYPECASTING IT?
        System.out.print(b);
    }
}