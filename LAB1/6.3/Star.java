import java.util.Scanner;

public class Star {
    int n;

    public Star(int n) {
        this.n = n;
    }

    public void rep() {
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i - 1)); // Print leading spaces
            System.out.println("*".repeat(2 * i + 1)); // Print stars
        }
    }    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // User input
        System.out.print("Enter the number of lines: ");
        int n = keyboard.nextInt();
        
        Star s = new Star(n);
        s.rep();
        
        keyboard.close(); // Close the scanner to prevent resource leaks
    }
}
