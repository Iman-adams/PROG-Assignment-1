import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series seriesManager = new Series();
        boolean exitApplication = false;

        // Will launch menu by asking you to enter a specific number
        System.out.println("LATEST SERIES - 2025");
        System.out.println("**************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String start = scanner.nextLine();

        // If user does not enter "1" then the application will not exit
        if (!start.equals("1")) {
            System.out.println("Exiting application...");
            return;
        }

        // I inserted my while loop menu into chatgpt to use my code to help removed the infinite loop I accidentally made
        while (!exitApplication) {
            // This is the display menu
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            // Use switch case to handle user choice
            switch (choice) {
                case "1":
                    seriesManager.CaptureSeries(scanner);
                    break;
                case "2":
                    seriesManager.SearchSeries(scanner);
                    break;
                case "3":
                    seriesManager.UpdateSeries(scanner);
                    break;
                case "4":
                    seriesManager.DeleteSeries(scanner);
                    break;
                case "5":
                    seriesManager.SeriesReport();
                    break;
                case "6":
                    System.out.println("Exiting application...");
                    exitApplication = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}