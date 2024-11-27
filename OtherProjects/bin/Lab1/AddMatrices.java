import java.util.Scanner;
public class AddMatrices{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of cols: ");
		int cols = scanner.nextInt();
		
		int[][] m1 = new int[rows][cols];
		int[][] m2 = new int[rows][cols];
		int[][] M = new int[rows][cols];
		
		for (int i=0; i<rows; i++){
			for (int j=0; j<cols; j++){
				m1[i][j] = scanner.nextInt();
			}
		}
		
		for (int i=0; i<rows; i++){
			for (int j=0; j<cols; j++){
				m2[i][j] = scanner.nextInt();
			}
		}
		
		for (int i=0; i<rows; i++){
			for (int j=0; j<cols; j++){
				M[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		System.out.println("Sum of two matrices is: ");
		for (int i=0; i<rows; i++){
			for (int j=0; j<cols; j++){
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
}