import random

def insertion_sort(arr):
    n = len(arr)
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
            print(f"Step {i}: {arr}")
        arr[j + 1] = key
        print(f"Step {i}: {arr}")

def print_array(arr):
    for i in arr:
        print(i, end=" ")
    print()

def generate_random_numbers(amount, num_range):
    return [random.randint(1, num_range) for _ in range(amount)]

def main():
    amount = int(input("Enter the amount of numbers to generate: "))
    num_range = int(input("Enter the range of numbers (up to what number): "))
    
    while True:
        arr = generate_random_numbers(amount, num_range)
        
        print("Generated array:")
        print_array(arr)

        choice = input("\nDo you want to:\n1. Sort the generated array\n2. Generate another set of random numbers\n3. End\nEnter your choice (1/2/3): ")
        if choice == '1':
            print("\nSorting process:")
            insertion_sort(arr)
            print("\nSorted array:")
            print_array(arr)
            break
        elif choice == '2':
            continue
        elif choice == '3':
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please enter 1, 2, or 3.")

if __name__ == "__main__":
    main()
