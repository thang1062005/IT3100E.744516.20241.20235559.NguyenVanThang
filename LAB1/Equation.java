import java.util.Scanner;

class LinearEquation {
    private double a;
    private double b;

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void solve() {
        if (a == 0) {
            System.out.println("Invalid input: 'a' cannot be 0.");
        } else {
            double solution = -b / a;
            System.out.printf("The solution to the equation %.2fx + %.2f = 0 is: x = %.2f%n", a, b, solution);
        }
    }
}

class LinearSystem {
    private double a11, a12, b1, a21, a22, b2;

    public LinearSystem(double a11, double a12, double b1, double a21, double a22, double b2) {
        this.a11 = a11;
        this.a12 = a12;
        this.b1 = b1;
        this.a21 = a21;
        this.a22 = a22;
        this.b2 = b2;
    }

    public void solve() {
        double D = a11 * a22 - a12 * a21;
        double Dx = b1 * a22 - b2 * a12;
        double Dy = a11 * b2 - b1 * a21;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = Dx / D;
            double x2 = Dy / D;
            System.out.printf("The solution of the system is: x1 = %.2f, x2 = %.2f%n", x1, x2);
        }
    }
}

class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        if (a == 0) {
            System.out.println("Invalid input: 'a' cannot be 0.");
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("The roots are real and different: x1 = %.2f, x2 = %.2f%n", root1, root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("The root is real and double: x = %.2f%n", root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Select the type of equation to solve:");
        System.out.println("1. First-degree equation (ax + b = 0)");
        System.out.println("2. System of first-degree equations");
        System.out.println("3. Second-degree equation (ax^2 + bx + c = 0)");
        System.out.print("Enter your choice (1-3): ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // First-degree equation
                System.out.println("Solving a first-degree equation (ax + b = 0):");
                System.out.print("Enter a: ");
                double a = scanner.nextDouble();
                System.out.print("Enter b: ");
                double b = scanner.nextDouble();
                LinearEquation linearEquation = new LinearEquation(a, b);
                linearEquation.solve();
                break;

            case 2:
                // System of first-degree equations
                System.out.println("Solving a system of first-degree equations:");
                System.out.print("Enter a11: ");
                double a11 = scanner.nextDouble();
                System.out.print("Enter a12: ");
                double a12 = scanner.nextDouble();
                System.out.print("Enter b1: ");
                double b1 = scanner.nextDouble();
                System.out.print("Enter a21: ");
                double a21 = scanner.nextDouble();
                System.out.print("Enter a22: ");
                double a22 = scanner.nextDouble();
                System.out.print("Enter b2: ");
                double b2 = scanner.nextDouble();
                LinearSystem linearSystem = new LinearSystem(a11, a12, b1, a21, a22, b2);
                linearSystem.solve();
                break;

            case 3:
                // Second-degree equation
                System.out.println("Solving a second-degree equation (ax^2 + bx + c = 0):");
                System.out.print("Enter a: ");
                double a2 = scanner.nextDouble();
                System.out.print("Enter b: ");
                double b2eq = scanner.nextDouble();
                System.out.print("Enter c: ");
                double c = scanner.nextDouble();
                QuadraticEquation quadraticEquation = new QuadraticEquation(a2, b2eq, c);
                quadraticEquation.solve();
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }

        // Close the scanner
        scanner.close();
    }
}
