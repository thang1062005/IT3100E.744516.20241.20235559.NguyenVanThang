import java.util.ArrayList;
import java.util.Scanner;

public class Sortarray {
    private ArrayList<Double> array;

    public Sortarray(ArrayList<Double> lis_par) {
        this.array = lis_par;
    }

    public ArrayList<Double> sort() {
        int length = array.size(); // Calculate length here
        for (int i = 0; i < length; i++) {
            int min_id = i;
            for (int j = i + 1; j < length; j++) {
                if (array.get(j) < array.get(min_id)) {
                    min_id = j;
                }
            }
            swapElements(i, min_id);
        }
        return array;
    }

    private void swapElements(int index1, int index2) {
        Double temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    public double sum() {
        double s = 0; 
        for (Double num : array) {
            s += num;
        }
        return s;
    }

    public double average() {
        return this.sum() / array.size(); 
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> array = new ArrayList<>(); 

        System.out.println("Enter double values (type 'exit' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break; }
            
            array.add(Double.parseDouble(input)); 
        }

    
        Sortarray sorter = new Sortarray(array);
        System.out.println("The sorted order: " + sorter.sort());
        System.out.println("The sum: " + sorter.sum());
        System.out.println("The average: " + sorter.average());
    
        scanner.close(); 
    }
}