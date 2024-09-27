import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaysInMonth {

    // A map to hold month names and their corresponding numbers
    private static final Map<String, Integer> monthMap = new HashMap<>();

    static {
        monthMap.put("January", 1);
        monthMap.put("Jan.", 1);
        monthMap.put("Jan", 1);
        monthMap.put("1", 1);
        
        monthMap.put("February", 2);
        monthMap.put("Feb.", 2);
        monthMap.put("Feb", 2);
        monthMap.put("2", 2);
        
        monthMap.put("March", 3);
        monthMap.put("Mar.", 3);
        monthMap.put("Mar", 3);
        monthMap.put("3", 3);
        
        monthMap.put("April", 4);
        monthMap.put("Apr.", 4);
        monthMap.put("Apr", 4);
        monthMap.put("4", 4);
        
        monthMap.put("May", 5);
        monthMap.put("5", 5);
        
        monthMap.put("June", 6);
        monthMap.put("Jun.", 6);
        monthMap.put("Jun", 6);
        monthMap.put("6", 6);
        
        monthMap.put("July", 7);
        monthMap.put("Jul.", 7);
        monthMap.put("Jul", 7);
        monthMap.put("7", 7);
        
        monthMap.put("August", 8);
        monthMap.put("Aug.", 8);
        monthMap.put("Aug", 8);
        monthMap.put("8", 8);
        
        monthMap.put("September", 9);
        monthMap.put("Sep.", 9);
        monthMap.put("Sep", 9);
        monthMap.put("9", 9);
        
        monthMap.put("October", 10);
        monthMap.put("Oct.", 10);
        monthMap.put("Oct", 10);
        monthMap.put("10", 10);
        
        monthMap.put("November", 11);
        monthMap.put("Nov.", 11);
        monthMap.put("Nov", 11);
        monthMap.put("11", 11);
        
        monthMap.put("December", 12);
        monthMap.put("Dec.", 12);
        monthMap.put("Dec", 12);
        monthMap.put("12", 12);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput;
        int year;

        while (true) {
            System.out.print("Enter month (name, abbreviation, or number): ");
            monthInput = scanner.nextLine().trim();
            Integer month = monthMap.get(monthInput);

            if (month != null) {
                System.out.print("Enter year (non-negative integer): ");
                if (scanner.hasNextInt()) {
                    year = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline

                    if (year >= 0) {
                        int days = getDaysInMonth(month, year);
                        System.out.println("Number of days in " + monthInput + " " + year + ": " + days);
                        break;  // Exit loop after valid input
                    } else {
                        System.out.println("Year must be a non-negative integer. Please try again.");
                    }
                } else {
                    System.out.println("Invalid year input. Please enter a valid year.");
                    scanner.next();  // Consume invalid input
                }
            } else {
                System.out.println("Invalid month input. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to determine if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to return the number of days in a month for a given year
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                return 31;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                return 30;
            case 2: // February
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0; // Should never reach here
        }
    }
}
