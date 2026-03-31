import java.util.Scanner;

public class FeetConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the distance in feet: ");
		int feet = sc.nextInt();
		int yards = feet / 3;
		int miles = yards / 1760;
		System.out.println(" The given feet " + feet + " while in yards is " + yards + " and miles is " + miles);
		sc.close();
	}
}
