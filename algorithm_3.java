import java.util.Scanner;
import java.util.Random;

public class algorithm_3 {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            System.out.print("Step " + i + ": ");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomNumbers(int amount, int numRange) {
        int[] arr = new int[amount];
        Random rand = new Random();
        for (int i = 0; i < amount; ++i) {
            arr[i] = rand.nextInt(numRange) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of numbers to generate: ");
        int amount = scanner.nextInt();
        System.out.print("Enter the range of numbers (up to what number): ");
        int numRange = scanner.nextInt();
        scanner.nextLine();

        int[] arr = generateRandomNumbers(amount, numRange);

        System.out.println("Generated array:");
        printArray(arr);

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nDo you want to:\n1. Sort the generated array\n2. Generate another set of random numbers\n3. End\nEnter your choice (1/2/3): ");
            int choice = 0;
            try {
                choice = input.nextInt();
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                input.nextLine();
                continue;
            }

            if (choice == 1) {
                System.out.println("\nSorting process:");
                insertionSort(arr);
                System.out.println("Sorted array:");
                printArray(arr);
                break;
            } else if (choice == 2) {
                arr = generateRandomNumbers(amount, numRange);
                System.out.println("\nGenerated array:");
                printArray(arr);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }
        input.close();
        scanner.close();
    }
}
