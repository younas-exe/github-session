import java.util.Scanner;
public class Githubsession3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter total minutes : ");
        int minutes = input.nextInt();
        int hours = 0;
        while(minutes >= 60){
            minutes = minutes-60;
            hours++;
        }
        System.out.println(hours + "hr" + minutes + " mins");
        // else{
        //     System.out.println(minutes + " mins");
        // }
        

    }
}