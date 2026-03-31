import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = num;
        int reversedNum = 0;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNum = reversedNum * 10 + lastDigit;
            temp = temp / 10;
        }

        if (num == reversedNum) {
            System.out.println("The number is a palindrome");
        } else {
            System.out.println("The number is not a palindrome");
        }

        sc.close();
    }
}