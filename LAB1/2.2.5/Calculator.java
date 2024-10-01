import java.util.Scanner;

public class Calculator {
    private double num1;
    private double num2;

    // Hàm khởi tạo
    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sum() {
        return num1 + num2;
    }


    public double difference() {
        return num1 - num2;
    }


    public double product() {
        return num1 * num2;
    }

    public double quotient() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Invalid");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //nhập user
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // tạo instance calculator
        Calculator calculator = new Calculator(num1, num2);

        // rep
        System.out.printf("Sum: %.2f%n", calculator.sum());
        System.out.printf("Difference: %.2f%n", calculator.difference());
        System.out.printf("Product: %.2f%n", calculator.product());
        
        try {
            System.out.printf("Quotient: %.2f%n", calculator.quotient());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
