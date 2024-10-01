import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // nhập hàng
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        // nhập cột
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrixA = new int[rows][columns];
        int[][] matrixB = new int[rows][columns];
        int[][] sumMatrix = new int[rows][columns];

        System.out.println("Enter elements of the first matrix:");
        // mỗi dòng nhập 1 số
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of the second matrix:");
        // mỗi dòng nhập 1 số
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
