
import java.util.Scanner;

public class FlourPack {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false; //this is to check if all the parameters are non-negative or not 
        }

        int maxBigBagsUsed = Math.min(goal / 5, bigCount); // we can use as many big bags as possible without exceeding the goal
        int remainingWeight = goal - (maxBigBagsUsed * 5);

        return remainingWeight <= smallCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of big bags (5kg each):");
        int bigCount = scanner.nextInt();

        System.out.println("Enter the number of small bags (1kg each):");
        int smallCount = scanner.nextInt();

        System.out.println("Enter the goal weight (kg):");
        int goal = scanner.nextInt();

        if (canPack(bigCount, smallCount, goal)) {
            System.out.println("Yes, it's possible to pack the goal weight.");
        } else {
            System.out.println("No, it's not possible to pack the goal weight.");
        }

        scanner.close();
    }
}
