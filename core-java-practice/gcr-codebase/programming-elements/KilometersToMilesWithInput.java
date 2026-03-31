
import java.util.Scanner;

public class KilometersToMilesWithInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter kilometers: ");
		double km = sc.nextInt();
		double miles = km / 1.6;
		System.out.println("The total miles is " + miles + " for the given " + km + " km" );
		sc.close();
	}
}
