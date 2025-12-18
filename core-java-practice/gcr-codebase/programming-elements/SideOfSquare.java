import java.util.Scanner;

public class SideOfSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the perimeter of a square");
		int perimeter = sc.nextInt();
		int side = perimeter / 4;
		System.out.println("Side of a square for the given perimeter is: " + side);
	}
}
