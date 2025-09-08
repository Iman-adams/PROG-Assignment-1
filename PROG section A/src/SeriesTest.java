import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.Assert.*;

public class SeriesTest {

    private Series seriesManager;
    private ByteArrayInputStream inputStream;

    @Before
    public void setUp() {
        seriesManager = new Series();
    }

    private void provideInput(String data) {
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void testCaptureSeries_Success() {
        // Arrange
        String input = "101\nExtreme Sports\n12\n10\n";
        provideInput(input);
        Scanner scanner = new Scanner(System.in);

        // Act
        seriesManager.CaptureSeries(scanner);

        // Assert
        SeriesModel capturedSeries = seriesManager.findSeriesById("101");
        assertNotNull("Series should be captured", capturedSeries);
        assertEquals("Extreme Sports", capturedSeries.getSeriesName());
        assertEquals(12, capturedSeries.getSeriesAge());
        assertEquals(10, capturedSeries.getSeriesNumberOfEpisodes());
    }

    @Test
    public void testSearchSeries_Found() {
        // Arrange
        String input = "202\nTest Series\n10\n5\n";
        provideInput(input);
        Scanner scanner = new Scanner(System.in);
        seriesManager.CaptureSeries(scanner);

        // Act
        // Re-simulate scanner for search
        provideInput("202\n");
        scanner = new Scanner(System.in);

        seriesManager.SearchSeries(scanner);

        // Assert
        // We can't easily assert console output, so we verify the underlying data model
        SeriesModel foundSeries = seriesManager.findSeriesById("202");
        assertNotNull("Series should be found", foundSeries);
    }

    @Test
    public void testSearchSeries_NotFound() {
        // Arrange
        String input = "303\nNotFound Series\n8\n2\n";
        provideInput(input);
        Scanner scanner = new Scanner(System.in);
        seriesManager.CaptureSeries(scanner);

        // Act
        provideInput("999\n"); // Searching for non-existent ID
        scanner = new Scanner(System.in);

        seriesManager.SearchSeries(scanner);

        // Assert
        SeriesModel notFoundSeries = seriesManager.findSeriesById("999");
        assertNull("Series should not be found", notFoundSeries);
    }

    @Test
    public void testUpdateSeries_Success() {
        // Arrange
        String captureInput = "404\nOld Name\n10\n5\n";
        provideInput(captureInput);
        Scanner scanner = new Scanner(System.in);
        seriesManager.CaptureSeries(scanner);

        // Act
        String updateInput = "404\nNew Name\n15\n20\n";
        provideInput(updateInput);
        scanner = new Scanner(System.in);
        seriesManager.UpdateSeries(scanner);

        // Assert
        SeriesModel updatedSeries = seriesManager.findSeriesById("404");
        assertNotNull("Series to update should exist", updatedSeries);
        assertEquals("New Name", updatedSeries.getSeriesName());
        assertEquals(15, updatedSeries.getSeriesAge());
        assertEquals(20, updatedSeries.getSeriesNumberOfEpisodes());
    }

    @Test
    public void testDeleteSeries_Success() {
        // Arrange
        String captureInput = "505\nDelete Me\n7\n3\n";
        provideInput(captureInput);
        Scanner scanner = new Scanner(System.in);
        seriesManager.CaptureSeries(scanner);

        // Act
        String deleteInput = "505\ny\n";
        provideInput(deleteInput);
        scanner = new Scanner(System.in);
        seriesManager.DeleteSeries(scanner);

        // Assert
        SeriesModel deletedSeries = seriesManager.findSeriesById("505");
        assertNull("Series should be deleted", deletedSeries);
    }

    @Test
    public void testAgeValidation_InvalidAge() {
        // Arrange
        String input = "606\nTest Invalid Age\n1\n10\n"; // Age 1 is invalid
        provideInput(input);
        Scanner scanner = new Scanner(System.in);

        // Act & Assert
        try {
            seriesManager.CaptureSeries(scanner);
        } catch (Exception e) {
            fail("Should not throw an exception on invalid input, but loop for new input.");
        }

        // This test is tricky since the method loops. We test the state after the call.
        // It's better to test a helper method, but since the logic is in CaptureSeries,
        // we can check if the series was NOT added due to the infinite loop.
        SeriesModel series = seriesManager.findSeriesById("606");
        assertNull("Series should not be added with invalid age", series);
    }
}