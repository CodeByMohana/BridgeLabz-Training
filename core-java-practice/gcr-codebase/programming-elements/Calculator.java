import java.util.Scanner;

public class Calculator {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the first number: ");
	        double num1 = sc.nextDouble();

	        System.out.print("Enter the second number: ");
	        double num2 = sc.nextDouble();

	        double add = num1 + num2;
	        double subtract = num1 - num2;
	        double multiply = num1 * num2;
	        double divide = num2 != 0 ? num1 / num2 : Double.NaN;  // Handle division by zero

	        System.out.printf("The addition, subtraction, multiplication, and division value of 2 numbers %.2f and %.2f is:\n", num1, num2);
	        System.out.printf("Addition = %.2f\n", add);
	        System.out.printf("Subtraction = %.2f\n", subtract);
	        System.out.printf("Multiplication = %.2f\n", multiply);
	        if (num2 != 0) {
	            System.out.printf("Division = %.2f\n", divide);
	        } else {
	            System.out.println("Division = Undefined (cannot divide by zero)");
	        }
	        sc.close();
	    }

}
