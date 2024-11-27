import java.util.*;

public class MonthDays {

    public static int getMonthNumber(String monthInput) {
        switch (monthInput) {
            case "1":
            case "Jan":
            case "Jan.":
            case "January":
                return 1;
            case "2":
            case "Feb":
            case "Feb.":
            case "February":
                return 2;
            case "3":
            case "Mar":
            case "Mar.":
            case "March":
                return 3;
            case "4":
            case "Apr":
            case "Apr.":
            case "April":
                return 4;
            case "5":
            case "May.":
            case "May":
                return 5;
            case "6":
            case "Jun":
            case "Jun.":
            case "June":
                return 6;
            case "7":
            case "Jul":
            case "July.":
            case "July":
                return 7;
            case "8":
            case "Aug":
            case "Aug.":
            case "August":
                return 8;
            case "9":
            case "Sep":
            case "Sept.":
            case "September":
                return 9;
            case "10":
            case "Oct":
            case "Oct.":
            case "October":
                return 10;
            case "11":
            case "Nov":
            case "Nov.":
            case "November":
                return 11;
            case "12":
            case "Dec":
            case "Dec.":
            case "December":
                return 12;
            default:
                System.out.println("Invalid month input, please try again.");
                return -1;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        int days;

        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
        }

        return days;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, year, days;

        do {
            System.out.print("Enter the month (1-12, Jan-Dec, January-December): ");
            String monthInput = input.nextLine().trim();
            month = getMonthNumber(monthInput);
        } while (month == -1);

        do {
            System.out.print("Enter the year (non-negative four-digit number): ");
            year = input.nextInt();
        } while (year < 0 || year > 9999);

        days = getDaysInMonth(month, year);

        System.out.printf("There are %d days in %s %d.\n", days, month, year);
    }

}
