import java.util.Scanner;

public class AreaOfTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base of a triangle in cm: ");
		int base = sc.nextInt();
		System.out.print("Enter the height of a triangle in cm: ");
		int height = sc.nextInt();
		int area = (base * height) / 2;
		System.out.println("Area of triangle for the base " + base + " and height " + height + " is: " + area);
		sc.close();
	}

}
