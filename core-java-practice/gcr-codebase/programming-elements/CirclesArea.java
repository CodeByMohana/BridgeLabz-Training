import java.util.Scanner;

public class CirclesArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the radius of a circle: ");
		double radius = sc.nextInt();
		
		//Math.PI give the pie value(22/7)
		double area = Math.PI * radius * radius;
		
		System.out.println("Area of a circle for radius 'r': " + radius + " is : "+ area);
		
		sc.close();
		
	}

}
