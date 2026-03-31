import java.util.Scanner;

public class TotalPriceCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the price of each unit: ");
		int unitPrice = sc.nextInt();
		System.out.print("Enter the total quantity of units: ");
		int quantity = sc.nextInt();
		int totalPrice = unitPrice * quantity;
		System.out.println("The total purchase price is INR " + totalPrice +" if the quantity " + quantity + " and unit price is INR " + unitPrice);
		sc.close();
		
	}
}
