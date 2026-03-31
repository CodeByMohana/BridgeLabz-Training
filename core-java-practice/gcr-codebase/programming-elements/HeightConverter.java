import java.util.Scanner;

public class HeightConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Height in cm : "); 
		double cm = sc.nextInt();
		double inch = cm / 2.54;
		double feet = inch / 12;
		System.out.println("Your Heught in cm is " + cm + " while in feet is " + feet + " and inches is " + inch);
		sc.close();
	}
}
