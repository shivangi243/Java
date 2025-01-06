import java.util.Scanner;

public class MinimumFinder {

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int number = scanner.nextInt();
        return number;
    }

    private static int[] readElements(int count) {
        Scanner scanner = new Scanner(System.in);
        int[] elements = new int[count];
        System.out.println("Enter " + count + " numbers:");
        for (int i = 0; i < count; i++) {
            elements[i] = scanner.nextInt();
        }
        return elements;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elements = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Read Integer (Number of Elements)");
            System.out.println("2. Read Elements");
            System.out.println("3. Find Minimum");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int count = readInteger();
                    elements = new int[count];
                    break;

                case 2:
                    if (elements == null) {
                        System.out.println("Please select option 1 first to define the number of elements.");
                    } else {
                        elements = readElements(elements.length);
                    }
                    break;

                case 3:
                    if (elements == null || elements.length == 0) {
                        System.out.println("Please enter elements first using option 2.");
                    } else {
                        int min = findMin(elements);
                        System.out.println("Minimum value: " + min);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}