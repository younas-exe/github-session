import java.util.*;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Random rand = new Random(); // Now correctly refers to java.util.Random
        int rand1 = rand.nextInt(50, 100);
        System.out.println("Random number: " + rand1);
    }
}
