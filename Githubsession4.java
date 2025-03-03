import java.util.Scanner;
public class Githubsession4{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter one edge : ");

        int edge = input.nextInt();
        int surfaceArea = edge * edge ;
        int TotalSurfaceArea = 6 * surfaceArea ;
        int volumeCube = edge * edge * edge ;

        System.out.println("Surface Area : " + surfaceArea);
        System.out.println("Total Surface Area : " + TotalSurfaceArea);
        System.out.println("Volume of the cube : " + volumeCube);
        

    }

}