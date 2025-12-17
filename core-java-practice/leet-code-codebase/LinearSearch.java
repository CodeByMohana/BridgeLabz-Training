import java.util.Scanner;

public class LinearSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of elements: ");
		int size = sc.nextInt();

		int[] values = new int[size];

		System.out.println("Enter the numbers: ");
		for (int i = 0; i < size; i++) {
			values[i] = sc.nextInt();
		}

		System.out.print("Enter number to search: ");
		int search = sc.nextInt();

		boolean found = false;

		for (int i = 0; i < size; i++) {
			if (values[i] == search) {
				System.out.println("Element found at position: " + (i + 1));
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Element not found");
		}

		sc.close();
	}
}
