import java.util.Scanner;

public class TwoNumbers{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		double n1 = scanner.nextDouble();
		System.out.println("Enter the second number: ");
		double n2 = scanner.nextDouble();
		
		double sum = n1 + n2;
		double difference = Math.abs(n1-n2);
		double product = n1*n2;
		double quotient = n1/n2;
		
		System.out.println("Sum of two numbers is: " + sum);
		System.out.println("Difference of two numbers is: " + difference);
		System.out.println("Product of two numbers is: " + product);
		System.out.println("Quotient of two numbers is: " + quotient);
	}
}