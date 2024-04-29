using System;

public class Program
{
    static void InsertionSort(int[] arr)
    {
        int n = arr.Length;
        for (int i = 1; i < n; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
                Console.Write("Step " + i + ": ");
                PrintArray(arr);
            }
            arr[j + 1] = key;
            Console.Write("Step " + i + ": ");
            PrintArray(arr);
        }
    }

    static void PrintArray(int[] arr)
    {
        foreach (int num in arr)
        {
            Console.Write(num + " ");
        }
        Console.WriteLine();
    }

    static int[] GenerateRandomNumbers(int amount, int numRange)
    {
        Random random = new Random();
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++)
        {
            numbers[i] = random.Next(1, numRange + 1);
        }
        return numbers;
    }

    public static void Main(string[] args)
    {
        Console.Write("Enter the amount of numbers to generate: ");
        int amount = Convert.ToInt32(Console.ReadLine());
        Console.Write("Enter the range of numbers (up to what number): ");
        int numRange = Convert.ToInt32(Console.ReadLine());

        while (true)
        {
            int[] arr = GenerateRandomNumbers(amount, numRange);

            Console.WriteLine("Generated array:");
            PrintArray(arr);

            Console.Write("\nDo you want to:\n1. Sort the generated array\n2. Generate another set of random numbers\n3. End\nEnter your choice (1/2/3): ");
            string choice = Console.ReadLine();
            if (choice == "1")
            {
                Console.WriteLine("\nSorting process:");
                InsertionSort(arr);
                Console.WriteLine("\nSorted array:");
                PrintArray(arr);
                break;
            }
            else if (choice == "2")
            {
                continue;
            }
            else if (choice == "3")
            {
                Console.WriteLine("Exiting...");
                break;
            }
            else
            {
                Console.WriteLine("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
