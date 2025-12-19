import java.util.Scanner;

public class UniversityDiscount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the fee: ");
		double fee = sc.nextDouble();
		System.out.print("Enter the Discount percent: ");
		double discountPercent = sc.nextDouble();
		double discount = (discountPercent / 100.0) * fee;
		System.out.println("The dicount amount is INR " + discount + " and final discounted fee is INR " + (fee - discount));
		sc.close();
	}
}
