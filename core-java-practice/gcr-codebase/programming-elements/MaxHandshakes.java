import java.util.Scanner;

public class MaxHandshakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Students: ");
		int numberOfStudents = sc.nextInt();
		int possibleHandshakes = (numberOfStudents * (numberOfStudents - 1) ) / 2;
		System.out.println("Total number of possible handshakes: " + possibleHandshakes);
		
	}
}
