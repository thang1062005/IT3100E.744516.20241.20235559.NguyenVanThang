import java.util.*;
public class Sort_Sum_Avg_Array{
	public static void main(String[] args){
		int arr[];
		int n;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Length of the array is: ");
		n = scanner.nextInt();
		
		System.out.print("Array: ");
		arr = new int[n];
		int count = 0;
        while (count < n){
            arr[count++] = scanner.nextInt();// gan so ngau nhien cho arr[count]; count++
        }
		
		System.out.println("Before sorting: ");
		System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
		System.out.println("After sorting: ");
		System.out.println(Arrays.toString(arr));
		
		int sum = 0;
		for (int i=0; i<n; i++){
			sum += arr[i];
		}
		System.out.println("Sum of array is: " + sum);
		
		float Sum = (float) sum;
		System.out.println("Average of array is: " + Sum/n);
	}
}