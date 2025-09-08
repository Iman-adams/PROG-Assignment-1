import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList; // A list that will store all the series objects

    // Constructor that creates an empty list of series
    public Series() {
        this.seriesList = new ArrayList<>();
    }

    public void CaptureSeries(Scanner scanner) {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("**********************************");
        System.out.print("Enter the series id: "); // Get the series ID
        String seriesId = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();

        // Get and validate the age restriction
        int seriesAge = 0;
        boolean ageValid = false;
        while (!ageValid) {
            System.out.print("Enter the series age restriction (2-18): ");
            String ageInput = scanner.nextLine();
            if (isNumeric(ageInput)) {
                seriesAge = Integer.parseInt(ageInput);
                if (seriesAge >= 2 && seriesAge <= 18) {
                    ageValid = true;
                }
                else {
                    System.out.println("You have entered an invalid age restriction. Please re-enter the series age >>");
                }
            }
            else {
                System.out.println("You have entered an incorrect series age. Please re-enter the series age >>");
            }
        }

        // Get and validate the number of episodes
        System.out.print("Enter the number of episodes: ");
        int numberOfEpisodes = 0;
        boolean episodesValid = false;
        while (!episodesValid) {
            String episodesInput = scanner.nextLine();
            if (isNumeric(episodesInput)) {
                numberOfEpisodes = Integer.parseInt(episodesInput);
                episodesValid = true;
            }
            else {
                System.out.println("Invalid input. Please enter a number for the number of episodes: ");
            }
        }

        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, numberOfEpisodes);
        seriesList.add(newSeries);
        System.out.println("Series processed successfully!!!");
    }

    public void SearchSeries(Scanner scanner) {
        System.out.println("\nSEARCH FOR A SERIES");
        System.out.println("**********************************");
        System.out.print("Enter the series id to search: ");
        String seriesId = scanner.nextLine();

        SeriesModel foundSeries = findSeriesById(seriesId);
        if (foundSeries != null) {
            System.out.println(foundSeries.toString());
        }
        else {
            System.out.println("Series with Series Id: " + seriesId + " was not found!");
        }
    }

    public void UpdateSeries(Scanner scanner) {
        System.out.println("\nUPDATE A SERIES");
        System.out.println("**********************************");
        System.out.print("Enter the series id to update: ");
        String seriesId = scanner.nextLine();

        SeriesModel seriesToUpdate = findSeriesById(seriesId);
        if (seriesToUpdate != null) {
            System.out.print("Enter the new series name: ");
            seriesToUpdate.setSeriesName(scanner.nextLine());

            int newAge = 0;
            boolean ageValid = false;
            while (!ageValid) {
                System.out.print("Enter the new age restriction: ");
                String ageInput = scanner.nextLine();
                if (isNumeric(ageInput)) {
                    newAge = Integer.parseInt(ageInput);
                    if (newAge >= 2 && newAge <= 18) {
                        seriesToUpdate.setSeriesAge(newAge);
                        ageValid = true;
                    }
                    else {
                        System.out.println("You have entered an invalid age restriction. Please re-enter the series age >>");
                    }
                }
                else {
                    System.out.println("You have entered an incorrect series age. Please re-enter the series age >>");
                }
            }

            System.out.print("Enter the new number of episodes: ");
            int newEpisodes = 0;
            boolean episodesValid = false;
            while (!episodesValid) {
                String episodesInput = scanner.nextLine();
                if (isNumeric(episodesInput)) {
                    newEpisodes = Integer.parseInt(episodesInput);
                    seriesToUpdate.setSeriesNumberOfEpisodes(newEpisodes);
                    episodesValid = true;
                }
                else {
                    System.out.println("Invalid input. Please enter a number for the new number of episodes: ");
                }
            }
            System.out.println("Series updated successfully!");
        }
        else {
            System.out.println("Series with Series Id: " + seriesId + " was not found!");
        }
    }

    public void DeleteSeries(Scanner scanner) {
        System.out.println("\nDELETE A SERIES");
        System.out.println("**********************************");
        System.out.print("Enter the series id to delete: ");
        String seriesId = scanner.nextLine();

        SeriesModel seriesToDelete = findSeriesById(seriesId);
        if (seriesToDelete != null) {
            // Confirm if you want to delete
            System.out.print("Are you sure you want to delete series " + seriesId + " from the system? Yes (y) or No (n). ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                seriesList.remove(seriesToDelete);
                System.out.println("Series with Series Id: " + seriesId + " WAS deleted!");
            }
            else {
                System.out.println("Deletion cancelled.");
            }
        }
    }

    public void SeriesReport() {
        System.out.println("\nSERIES REPORT - 2025");
        System.out.println("**********************************");
        if (seriesList.isEmpty()) {
            System.out.println("No series to display.");
        }
        else {
            for (int i = 0; i < seriesList.size(); i++) {
                System.out.println(String.format("Series %d", i + 1));
                System.out.println("----------------------------------");
                System.out.println("SERIES ID: " + seriesList.get(i).getSeriesId());
                System.out.println("SERIES NAME: " + seriesList.get(i).getSeriesName());
                System.out.println("SERIES AGE RESTRICTION: " + seriesList.get(i).getSeriesAge());
                System.out.println("NUMBER OF EPISODES: " + seriesList.get(i).getSeriesNumberOfEpisodes());
                System.out.println("----------------------------------");
            }
        }
    }

    SeriesModel findSeriesById(String seriesId) {
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(seriesId)) {
                return series;
            }
        }
        return null;
    }

    // Helper method to check if a string is a number
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}